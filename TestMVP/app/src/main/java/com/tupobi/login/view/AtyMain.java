package com.tupobi.login.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.tupobi.R;
import com.tupobi.databinding.AtyMainBinding;
import com.tupobi.login.presenter.ILoginPresenter;
import com.tupobi.login.presenter.LoginPresenterImpl;

public class AtyMain extends AppCompatActivity implements ILoginView{
    private AtyMainBinding mBinding;

    private ILoginPresenter mILoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AtyMainBinding binding = DataBindingUtil.setContentView(this, R.layout.aty_main);
        mBinding = binding;
        mILoginPresenter = new LoginPresenterImpl(this);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mILoginPresenter.login();
            }
        });
    }

    @Override
    public String getUserName() {
        return mBinding.etUserName.getText().toString().trim();
    }

    @Override
    public String getUserPassword() {
        return mBinding.etUserPassword.getText().toString().trim();
    }

    @Override
    public void showSuccessMsg() {
        Toast.makeText(this, "登录成功！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedMsg() {
        Toast.makeText(this, "登录失败！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mBinding.pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mBinding.pbLoading.setVisibility(View.GONE);
    }
}
