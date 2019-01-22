package module.liuhao.common.preference;

import android.content.Context;
import android.content.SharedPreferences;

import module.liuhao.common.preference.common.ShareBoolean;
import module.liuhao.common.preference.common.ShareInt;
import module.liuhao.common.preference.common.ShareLong;
import module.liuhao.common.preference.common.ShareString;
import module.liuhao.common.preference.utils.DevicesUtils;
import module.liuhao.common.preference.utils.ShareUtils;

/**
 * 共享ShareReference
 */

public class Share {
    private static final String SP_NAME = "common.share.reference";
    public static ShareUtils sp = new ShareUtils();
    public static String imei = "";

    /**
     * 初始化, 在Application中调用
     */
    public static void init(Context context) {
        sp.init(context, SP_NAME);
        Share.imei = DevicesUtils.getIMEI(context);
    }

    public static void clear() {
        Share.token.set("");
        Share.userId.set(0L);
        Share.isRunning.set(false);
        Share.point.set(0);
    }

    public static ShareLong userId = getLong("userId");                               //  钢镚

    public static ShareInt point = getInt("point", -1);        //  1:已登录;

    public static ShareBoolean isRunning = getBoolean("isRunning");                      //  是否正在运行

    public static ShareString token = getString("token");                             //


    private static ShareLong getLong(String key) {
        return getLong(key, 0);
    }

    private static ShareLong getLong(String key, long defaultValue) {
        return new ShareLong(sp, key, defaultValue);
    }

    private static ShareInt getInt(String key, int defaultValue) {
        return new ShareInt(sp, key, defaultValue);
    }

    private static ShareString getString(String key) {
        return getString(key, "");
    }

    private static ShareString getString(String key, String defaultValue) {
        return new ShareString(sp, key, defaultValue);
    }

    private static ShareBoolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    private static ShareBoolean getBoolean(String key, boolean defaultValue) {
        return new ShareBoolean(sp, key, defaultValue);
    }

    SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        }
    };
}
