package com.liuhao.cr.helper;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AdapterView;

import com.liuhao.cr.R;
import com.liuhao.cr.TestRefreshActivity1;
import com.liuhao.cr.base.adapter.BaseRecyclerAdapter;
import com.liuhao.cr.base.adapter.SmartViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * Author:  LiuHao
 * Email:   114650501@qq.com
 * TIME:    2019/3/20 --> 2:22 PM
 * Description: AdapterHelper 简述：
 */
public class AdapterHelper {
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
        K12(R.string.item_style_theme_green_abstract),
        K13(R.string.item_style_theme_green_abstract),
        K14(R.string.item_style_theme_green_abstract),
        K15(R.string.item_style_theme_green_abstract),
        K16(R.string.item_style_theme_green_abstract),
        K17(R.string.item_style_theme_green_abstract),
        K18(R.string.item_style_theme_green_abstract),
        K19(R.string.item_style_theme_green_abstract),
        K20(R.string.item_style_theme_green_abstract),
        K21(R.string.item_style_theme_green_abstract),
        K22(R.string.item_style_theme_green_abstract),
        K23(R.string.item_style_theme_green_abstract),
        K24(R.string.item_style_theme_green_abstract),
        K25(R.string.item_style_theme_green_abstract),
        K26(R.string.item_style_theme_green_abstract),
        K27(R.string.item_style_theme_green_abstract),
        K28(R.string.item_style_theme_green_abstract),
        K29(R.string.item_style_theme_green_abstract),
        K30(R.string.item_style_theme_green_abstract),
        L31(R.string.item_style_theme_blue_abstract);
        public int nameId;

        Item(@StringRes int nameId) {
            this.nameId = nameId;
        }
    }

    public static void initView(Context context, RecyclerView rvList) {
        rvList.setLayoutManager(new LinearLayoutManager(context));
        rvList.addItemDecoration(new DividerItemDecoration(context, VERTICAL));
        rvList.setItemAnimator(new DefaultItemAnimator());
        List<Item> items = new ArrayList<>();
        items.addAll(Arrays.asList(Item.values()));
        rvList.setAdapter(new BaseRecyclerAdapter<Item>(items, R.layout.rv_list_item, (AdapterView.OnItemClickListener) context) {
            @Override
            protected void onBindViewHolder(SmartViewHolder holder, Item model, int position) {
                if (position == 0) {
                    holder.visible(R.id.iv_1);
                } else {
                    holder.gone(R.id.iv_1);
                }

                holder.text(R.id.tv_title, model.name());
                holder.textColorId(R.id.tv_title, R.color.colorTextAssistant);
            }
        });
    }
}
