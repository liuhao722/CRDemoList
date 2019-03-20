package com.liuhao.cr;

import android.support.annotation.StringRes;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;

import com.liuhao.cr.base.BaseActivity;
import com.liuhao.cr.base.adapter.BaseRecyclerAdapter;
import com.liuhao.cr.base.adapter.SmartViewHolder;
import com.liuhao.cr.databinding.ActivityTestRefreshListBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2019/3/19 --> 4:01 PM
 * Description: TestRefreshActivity 简述：
 */
public class TestRefreshActivity extends BaseActivity<ActivityTestRefreshListBinding> implements AdapterView.OnItemClickListener {
    private static final String TAG = "TestRefreshActivity";

    @Override
    protected int setLayoutId() {
        return R.layout.activity_test_refresh_list;
    }

    float tempY = 0;

    @Override
    protected void initListener() {

        binding.rvList.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        tempY = event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int rvListTop = binding.rvList.getTop();
                        Log.e(TAG, "\n-----------------------------------------------------rvListTop:\t" + rvListTop);

                        if (rvListTop >= 500) {
                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) binding.rvList.getLayoutParams();
                            layoutParams.topMargin = 500;
                            binding.rvList.setLayoutParams(layoutParams);
                            return false;
                        }


                        float realY;
                        if (tempY == 0) {
                            tempY = event.getRawY();
                            realY = 0;
//                            return false;
                        } else {
                            realY = event.getRawY() - tempY;
                            tempY = event.getRawY();
                        }

                        Log.e(TAG, "\n-----------------------------------------------------rvListTop:\t" + rvListTop + "\trealYt:" + realY);
                        RecyclerView.LayoutManager manager = binding.rvList.getLayoutManager();
                        if (manager != null && manager instanceof LinearLayoutManager) {
                            int position = ((LinearLayoutManager) manager).findFirstVisibleItemPosition();
                            int top = 0;
                            if (position == 0) {
                                View firstView = manager.getChildAt(0);
                                top = firstView.getTop();
                                Log.e(TAG, "\n-----------\tposition:\t" + position + "\ttop\t:" + top);
                                if (top == 0) {
                                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) binding.rvList.getLayoutParams();
                                    int marginTop = (int) (rvListTop + realY);
                                    if (marginTop <= 0) {
                                        return false;
                                    }
                                    layoutParams.topMargin = marginTop;
                                    binding.rvList.setLayoutParams(layoutParams);
                                } else {
                                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) binding.rvList.getLayoutParams();
                                    int marginTop = (int) (rvListTop + realY);
                                    if (marginTop <= 0) {
                                        return false;
                                    }
                                    layoutParams.topMargin = marginTop;
                                    binding.rvList.setLayoutParams(layoutParams);
                                }
                            }
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        tempY = 0;
                        break;
                }

                return false;
            }
        });
        binding.rvList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int rvListTop = binding.rvList.getTop();
//                Log.e(TAG, "\n-----------------------------------------------------onScrolled-1:\t" + ":\t" + dy + ":\t" + rvListTop);
                if (rvListTop <= 0) {

                    return;
                }
                RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
                if (manager != null && manager instanceof LinearLayoutManager) {
                    View firstView = manager.getChildAt(0);
                    int firstViewTop = firstView.getTop();
//                    Log.e(TAG, "\n____|||____onScrolled-2:\t" + dx + ":\t" + dy + ":\t" + firstViewTop);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) binding.rvList.getLayoutParams();
                    int marginTop = rvListTop + firstViewTop;
                    if (marginTop <= 0) {
                        marginTop = 0;
                    }
                    layoutParams.topMargin = marginTop;
                    binding.rvList.setLayoutParams(layoutParams);

                    //下拉的时候

                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e(TAG, "onItemClick:\t" + position + ":\t" + id);
    }

    private enum Item {
        A1(R.string.item_style_content_translation_off),
        B2(R.string.item_style_content_translation_on),
        C3(R.string.item_style_theme_orange_abstract),
        D4(R.string.item_style_theme_red_abstract),
        E5(R.string.item_style_theme_green_abstract),
        F6(R.string.item_style_theme_blue_abstract),
        G7(R.string.item_style_content_translation_off),
        H8(R.string.item_style_content_translation_on),
        I9(R.string.item_style_theme_orange_abstract),
        J10(R.string.item_style_theme_red_abstract),
        K11(R.string.item_style_theme_green_abstract),
        L12(R.string.item_style_theme_blue_abstract),;
        public int nameId;

        Item(@StringRes int nameId) {
            this.nameId = nameId;
        }
    }

    @Override
    protected void initView() {
        binding.rvList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvList.addItemDecoration(new DividerItemDecoration(this, VERTICAL));
        binding.rvList.setItemAnimator(new DefaultItemAnimator());
        List<Item> items = new ArrayList<>();
        items.addAll(Arrays.asList(Item.values()));
        binding.rvList.setAdapter(new BaseRecyclerAdapter<Item>(items, R.layout.rv_list_item, this) {
            @Override
            protected void onBindViewHolder(SmartViewHolder holder, Item model, int position) {
                holder.text(R.id.tv_title, model.name());
//                holder.text(R.id.tv_title, model.nameId);
                holder.textColorId(R.id.tv_title, R.color.colorTextAssistant);
            }
        });
    }
}
