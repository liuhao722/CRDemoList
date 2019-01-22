package module.liuhao.common.preference.common;

import module.liuhao.common.preference.utils.DevicesUtils;

public class GetSetter<T> extends Getter<T> {

    public GetSetter(T defValue) {
        super(defValue);
    }

    protected void onChange(T newValue) {

    }

    public void set(T value) {
        inited = true;
        if (!DevicesUtils.equal(this.value, value)) {
            this.value = value;
            onChange(this.value);
        }
    }
}