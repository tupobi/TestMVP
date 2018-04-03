package com.tupobi.login.view;

/**
 * Created by Administrator on 2018/4/2/002.
 */

public interface ILoginView {
    public String getUserName();

    public String getUserPassword();

    public void showSuccessMsg();

    public void showFailedMsg();

    public void showLoading();

    public void hideLoading();
}
