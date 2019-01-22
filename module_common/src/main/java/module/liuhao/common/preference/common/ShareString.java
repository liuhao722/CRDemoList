package module.liuhao.common.preference.common;


import module.liuhao.common.preference.utils.EncryptUtils;
import module.liuhao.common.preference.utils.ShareUtils;

public class ShareString extends GetSetter<String> {
    private String key;
    private ShareUtils sp;

    public ShareString(ShareUtils prefer, String key, String defValue) {
        super(defValue);
        this.key = key;
        sp = prefer;
    }

    @Override
    protected String onInit(String defValue) {
        if (!key.equals("lockPattern") && !key.equals("lockPattern2")) {
            return EncryptUtils.aesDecrypt(sp.getString(key, defValue));
        }
        return sp.getString(key, defValue);

    }

    @Override
    protected void onChange(String newValue) {
        if (!key.equals("lockPattern") && !key.equals("lockPattern2")) {
            newValue = EncryptUtils.aesEncrypt(newValue);
        }
        sp.putString(key, newValue);

    }
}