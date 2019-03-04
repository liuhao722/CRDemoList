package com.liuhao.cr.view;

import android.content.Context;
import android.widget.Toast;

import com.liuhao.cr.base.BaseApplication;

/**
 * 自己的Toast
 */
public class MyToast {

    private Context mContext;

    private static MyToast myInstance;

    public MyToast(Context con) {
        this.mContext = con;
    }

    public static MyToast ins() {
        if (myInstance == null) {
            myInstance = new MyToast(BaseApplication.ins().getApplicationContext());
        }
        return myInstance;
    }

    public void showToastShort(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    public void showToastShort(int resMsg) {
        Toast.makeText(mContext, mContext.getResources().getString(resMsg), Toast.LENGTH_SHORT).show();
    }

    public void showToastLong(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_LONG).show();
    }

    public void showToastLong(int resMsg) {
        Toast.makeText(mContext, mContext.getResources().getString(resMsg), Toast.LENGTH_LONG).show();
    }

}
