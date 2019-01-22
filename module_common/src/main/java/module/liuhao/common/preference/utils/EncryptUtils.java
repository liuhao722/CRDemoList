package module.liuhao.common.preference.utils;


import android.text.TextUtils;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 加密解密工具类
 */
public class EncryptUtils {
    /************************************************* AES(秘钥必须为16位的倍数) **************************************************/

    private static final String AES_BASE_KEY = "FG_2017_ly_3.0t%";
    private static final String IV_STRING = "FinUpGroup_2017%";
    private static final String charset = "UTF-8";

    public static String aesEncryptString(String content) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return aesEncryptString(content, AES_BASE_KEY);
    }

    public static String aesDecryptString(String content) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return aesDecryptString(content, AES_BASE_KEY);
    }

    public static String aesEncryptString(String content, String key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        byte[] contentBytes = content.getBytes(charset);
        byte[] keyBytes = key.getBytes(charset);
        byte[] encryptedBytes = aesEncryptBytes(contentBytes, keyBytes);
        return Base64.encodeToString(encryptedBytes, Base64.NO_WRAP);
    }

    public static String aesDecryptString(String content, String key) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        byte[] encryptedBytes = Base64.decode(content, Base64.NO_WRAP);
        byte[] keyBytes = key.getBytes(charset);
        byte[] decryptedBytes = aesDecryptBytes(encryptedBytes, keyBytes);
        return new String(decryptedBytes, charset);
    }

    public static byte[] aesEncryptBytes(byte[] contentBytes, byte[] keyBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return cipherOperation(contentBytes, keyBytes, Cipher.ENCRYPT_MODE);
    }

    public static byte[] aesDecryptBytes(byte[] contentBytes, byte[] keyBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        return cipherOperation(contentBytes, keyBytes, Cipher.DECRYPT_MODE);
    }

    private static byte[] cipherOperation(byte[] contentBytes, byte[] keyBytes, int mode) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

        byte[] initParam = IV_STRING.getBytes(charset);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(mode, secretKey, ivParameterSpec);

        return cipher.doFinal(contentBytes);
    }

    /**
     * aes加密字符串
     *
     * @param defValue
     * @return
     */
    public static String aesEncrypt(String defValue) {
        if (!TextUtils.isEmpty(defValue) && !TextUtils.isEmpty(defValue.trim())) {
            try {
                defValue = EncryptUtils.aesEncryptString(defValue);
//				defValue = EncryptUtils.stringToHexString(EncryptUtils.aesEncryptString(defValue));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return defValue;
    }

    /**
     * aes解密
     *
     * @param newValue
     * @return
     */
    public static String aesDecrypt(String newValue) {
        if (!TextUtils.isEmpty(newValue) && !TextUtils.isEmpty(newValue.trim())) {
            try {
                newValue = EncryptUtils.aesDecryptString(newValue);
//				newValue = EncryptUtils.aesDecryptString(EncryptUtils.hexStringToString(newValue));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return newValue;
    }
}
