package com.tupobi.login.presenter;

import com.tupobi.login.model.biz.ILoginBiz;
import com.tupobi.login.model.biz.LoginBizImpl;
import com.tupobi.login.view.ILoginView;

/**
 * Created by Administrator on 2018/4/2/002.
 */

public class LoginPresenterImpl implements ILoginPresenter {
    private ILoginBiz mILoginBiz;
    private ILoginView mILoginView;

    public LoginPresenterImpl(ILoginView ILoginView) {
        mILoginView = ILoginView;
        mILoginBiz = new LoginBizImpl();
    }

    @Override
    public void login() {
        mILoginView.showLoading();

        mILoginBiz.login(mILoginView.getUserName(), mILoginView.getUserPassword(), new ILoginBiz.CallbackCheck() {
            @Override
            public void onSuccess() {
                mILoginView.hideLoading();
                mILoginView.showSuccessMsg();
            }

            @Override
            public void onFailed() {
                mILoginView.hideLoading();
                mILoginView.showFailedMsg();
            }
        });
    }
}
