package com.example.mims_apps.Base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mims_apps.R;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    private P presenter;
    private Context context = getActivity();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), container, false);
        if (presenter == null) {
            presenter = add();
            presenter.attch(this);
        }
        initView(inflate);
        initData();
        return inflate;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }

    protected abstract void initView(View inflate);

    protected abstract void initData();

    protected abstract P add();

    protected abstract int getLayoutId();
}
