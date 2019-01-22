package module.liuhao.common.preference.common;


import module.liuhao.common.preference.utils.ShareUtils;

public class ShareBoolean extends GetSetter<Boolean> {
    private String key;
    private ShareUtils sp;

    public ShareBoolean(ShareUtils prefer, String key, boolean defValue) {
        super(defValue);
        this.key = key;
        sp = prefer;
    }

    @Override
    protected Boolean onInit(Boolean defValue) {
        return sp.getBool(key, defValue);
    }

    @Override
    protected void onChange(Boolean newValue) {
        sp.putBool(key, newValue);
    }
}