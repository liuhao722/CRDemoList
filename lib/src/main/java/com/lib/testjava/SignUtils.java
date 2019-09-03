package com.lib.testjava;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by LiuHao on 2017/11/29.
 */

public class SignUtils {

    static boolean isEmpty(String content) {
        if (content == null) return true;
        if (content.equals("") || content.length() == 0 || content.trim().length() == 0)
            return true;
        return false;
    }

    public static String byteToHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            hexString.append(hex.toUpperCase());
        }
        return hexString.toString();
    }

    public static final String PING_BACK_SIGN_KEY = "EFGVGYYT77050";

    /**
     * 生成PingBack签名
     */
    public static String generatePingBackSign(Map<String, Object> map) {
        StringBuilder stringBuilder = new StringBuilder();

        StringBuilder builder = new StringBuilder(256);

        if (map.containsKey("parameter")) {
            map.remove("parameter");
        }

        Iterator<String> iterator = map.keySet().iterator();
        List<String> keys = new ArrayList<>();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (isEmpty(map.get(key) == null ? "" : map.get(key).toString().trim()))
                continue;   //  空值过滤

            keys.add(key);
        }

        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Object value = map.get(key);
            sb.append(key).append(value);

            stringBuilder.append(key + ":" + value).append("\n");
        }
        builder.append(PING_BACK_SIGN_KEY).append(sb.toString()).append(PING_BACK_SIGN_KEY);

//        XLog.i(stringBuilder.toString());
        return byteToHexString(DigestUtils.md5(builder.toString()));
    }

    public static void main(String[] args) {
        Map mapRoot = new HashMap();
            Map map = new HashMap();
            map.put("appKey", "dayanxiang");
            map.put("appVersion", "5.0.5.0");
            map.put("model", "vivo X20A");
            map.put("os", "android");
            map.put("logType", "app");
            map.put("deviceId", "U(af928111-6562-4052-af6f-c5efd955c51c)");
            map.put("androidId", "3cb22e126dae5d26");
            map.put("userId", 0);
            map.put("sessionId", "cf551244-c7df-4a12-af47-794b56667e3e");
            map.put("time", 1567427813195L);
            map.put("event", "impression");
            map.put("pageId", "1");

            mapRoot.put("pingBackList", map);

        mapRoot.put("mobileType", "ANDROID");
        mapRoot.put("sessionId", "cf551244-c7df-4a12-af47-794b56667e3e");
        mapRoot.put("type", "ANDROID");
        mapRoot.put("version", "5.0.5.0");
        mapRoot.put("deviceToken", "3cb22e126dae5d26");

        String signStr = generatePingBackSign(mapRoot);
        System.err.println("signStr:" + signStr);
    }
}