package module.liuhao.common.preference.common;


import module.liuhao.common.preference.utils.ShareUtils;

public class ShareLong extends GetSetter<Long> {
    private String key;
    private ShareUtils sp;

    public ShareLong(ShareUtils prefer, String key, long defValue) {
        super(defValue);
        this.key = key;
        sp = prefer;
    }

    @Override
    protected Long onInit(Long defValue) {
        return sp.getLong(key, defValue);
    }

    @Override
    protected void onChange(Long newValue) {
        sp.putLong(key, newValue);
    }
}