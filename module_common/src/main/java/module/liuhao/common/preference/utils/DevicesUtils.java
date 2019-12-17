package module.liuhao.common.preference.utils;

import android.content.Context;

/**
 * 工具类
 */
public class DevicesUtils {

    public static boolean equal(Object o1, Object o2) {
        if (o1 == o2) {
            return true;
        }
        if (o1 == null) {
            return false;
        }
        return o1.equals(o2);
    }

    public static String mDeviceId;

    /**
     * 获取deviceId
     */
//    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String getIMEI(Context con) {
//        if (!TextUtils.isEmpty(mDeviceId)) {
//            return mDeviceId;
//        }
//        try {
//            TelephonyManager tm = (TelephonyManager) con.getSystemService(Context.TELEPHONY_SERVICE);
//            mDeviceId = tm != null ? tm.getDeviceId() : null;
//        } catch (Exception e) {
//            mDeviceId = System.currentTimeMillis() +
//                    "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length()
//                    % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length()
//                    % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10
//                    + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10
//                    + Build.TYPE.length() % 10 + Build.USER.length() % 10;
//        }
//        if (TextUtils.isEmpty(mDeviceId)) {
//            mDeviceId =
//                    System.currentTimeMillis() + "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length()
//                            % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length()
//                            % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10
//                            + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10
//                            + Build.TYPE.length() % 10 + Build.USER.length() % 10;
//        }
//        return mDeviceId;
        return null;
    }
}
