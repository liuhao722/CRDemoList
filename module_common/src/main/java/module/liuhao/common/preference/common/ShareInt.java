package module.liuhao.common.preference.common;


import module.liuhao.common.preference.utils.ShareUtils;

public class ShareInt extends GetSetter<Integer> {
    private String key;
    private ShareUtils sp;

    public ShareInt(ShareUtils prefer, String key, int defValue) {
        super(defValue);
        this.key = key;
        sp = prefer;
    }

    @Override
    protected Integer onInit(Integer defValue) {
        return sp.getInt(key, defValue);
    }

    @Override
    protected void onChange(Integer newValue) {
        sp.putInt(key, newValue);
    }
}