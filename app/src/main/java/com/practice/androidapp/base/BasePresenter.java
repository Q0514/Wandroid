package com.practice.androidapp.base;

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> implements IPresenter<V> {

    private V view;

    private M model;

    public BasePresenter(M model) {
        this.model = model;
    }

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    protected V getView() {
        return view;
    }

    protected M getModel() {
        return model;
    }

}
