package com.example.mims_apps.Base;

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {
    private V iView;
    private M imodel;

    public void attch(V v) {
        iView = v;
        imodel = setIModel();
    }

    public void destroy() {
        iView = null;
        imodel = null;
    }

    protected abstract M setIModel();

}
