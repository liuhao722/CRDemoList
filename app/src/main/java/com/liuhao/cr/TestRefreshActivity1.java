package com.liuhao.cr;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.liaoinstan.springview.container.DefaultHeader;
import com.liuhao.cr.base.BaseActivity;
import com.liuhao.cr.base.BaseConfig;
import com.liuhao.cr.databinding.ActivityTestRefreshList1Binding;
import com.liuhao.cr.helper.AdapterHelper;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2019/3/19 --> 4:01 PM
 * Description: TestRefreshActivity 简述：
 */
public class TestRefreshActivity1 extends BaseActivity<ActivityTestRefreshList1Binding> implements AdapterView.OnItemClickListener {
    private static final String TAG = "TestRefreshActivity1";
    View firstView;
    int minHeight;
    int maxHeight;

    @Override
    protected int setLayoutId() {
        minHeight = (int) (120 * BaseConfig.getDensity(this));
        maxHeight = (int) (240 * BaseConfig.getDensity(this));
        return R.layout.activity_test_refresh_list_1;
    }

    float tempY = 0;
    int findFirstCompletelyVisibleItemPosition, findFirstVisibleItemPosition, firstViewTop;

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            gestureDetector.onTouchEvent(event);
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    tempY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    float realY;
                    if (tempY == 0) {
                        tempY = event.getRawY();
                        realY = 0;
                    } else {
                        realY = event.getRawY() - tempY;
                        tempY = event.getRawY();
                    }
                    boolean pull = realY > 0;
                    if (firstView == null) {
                        initFirst();
                    }
                    firstViewTop = firstView.getTop();

                    log(
                            "MOVE:" +
                                    "\t--tempY--:" + tempY +
                                    "\t--realY--:" + realY +
//                                    "\t----\t" + findFirstCompletelyVisibleItemPosition +
//                                    "\t----\t" + findFirstVisibleItemPosition +
                                    "\t--firstViewTop--:" + firstViewTop +
                                    "\t--Height--:" + firstView.getHeight() +
//                                    "\t--maxHeight--:" + maxHeight +
                                    (pull ? "\t--pull--" : "\t--push--")
                            , false);


                    if (findFirstCompletelyVisibleItemPosition == 0 && findFirstVisibleItemPosition == 0) {//springViewScroll
                        boolean open = true;
                        if (firstView.getHeight() >= maxHeight) {
                            if (pull) {
                                setHeight(maxHeight);
                                log("--||--1-false", open);
                                return false;
                            } else {
                                setHeight((int) (firstView.getHeight() + realY));
                                log("--||--2-false", open);
                                return false;
                            }
                        } else if (firstView.getHeight() < minHeight) {
                            setHeight(minHeight);
                            log("--||--3-true", open);
                            return false;
                        } else {
                            setHeight((int) (firstView.getHeight() + realY));
                            log("--||--4-true", open);
                            return true;
                        }
                    } else {
                        boolean open = false;
                        if (firstView.getHeight() >= maxHeight) {
                            setHeight(maxHeight);
                            log("--------1-false", open);
                            return false;
                        } else if (firstView.getHeight() < minHeight) {
                            setHeight(minHeight);
                            log("--------2-false", open);
                            return false;
                        } else {
                            setHeight((int) (firstView.getHeight() + realY));
                            log("--------3-true", open);
                            return false;
                        }
                    }
                case MotionEvent.ACTION_UP:
                    tempY = 0;
                    boolean open = true;
                    LinearLayoutManager manager = (LinearLayoutManager) binding.rvList.getLayoutManager();
                    findFirstVisibleItemPosition = manager.findFirstVisibleItemPosition();
                    log("4-1:\t" + findFirstVisibleItemPosition, open);
                    if (findFirstVisibleItemPosition != 0) {
                        log("4-2:\t" + findFirstVisibleItemPosition, open);
                        setHeight(minHeight);
                    }
                    break;
            }
            return false;
        }
    };

    @Override
    protected void initListener() {
        binding.rvList.setOnTouchListener(onTouchListener);
        binding.svRoot.setOnTouchListener(onTouchListener);
        binding.rvList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                initFirst();
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                log("----onScrolled----\t:dx\t" + dx + "\t dy:\t" + dy, false);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }

    GestureDetector gestureDetector;

    @Override
    protected void initView() {
        AdapterHelper.initView(this, binding.rvList);
        binding.svRoot.setHeader(new DefaultHeader(this));
        boolean open = false;
        gestureDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                log("onDown", open);
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                log("onShowPress", open);
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                log("onSingleTapUp", open);
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                log("onScroll:\t" + e2.getRawY() + "\t" + distanceY, open);
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                log("onLongPress", open);
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                log("onFling:\t" + velocityX + "\t" + velocityY, open);
                return false;
            }
        });

    }

    public void initFirst() {
        LinearLayoutManager manager = (LinearLayoutManager) binding.rvList.getLayoutManager();
        findFirstCompletelyVisibleItemPosition = manager.findFirstCompletelyVisibleItemPosition();
        findFirstVisibleItemPosition = manager.findFirstVisibleItemPosition();
        synchronized (this) {
            if (findFirstVisibleItemPosition == 0) {
                RecyclerView.ViewHolder firstViewHolder = binding.rvList.findViewHolderForAdapterPosition(0);
                firstView = firstViewHolder.itemView;
//                    firstView = manager.getChildAt(0);
                firstView.setBackgroundColor(Color.parseColor("#BBCC44"));
            }
        }
    }

    public void log(String message, boolean open) {
        if (open)
            Log.e(TAG, message);
    }

    void setHeight(int height) {
        ViewGroup.LayoutParams firstViewLayoutParams = firstView.getLayoutParams();
        firstViewLayoutParams.height = height;
        firstView.setLayoutParams(firstViewLayoutParams);
    }
}
