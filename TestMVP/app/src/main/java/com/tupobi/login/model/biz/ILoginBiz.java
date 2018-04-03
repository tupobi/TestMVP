package com.tupobi.login.model.biz;

/**
 * Created by Administrator on 2018/4/2/002.
 */

public interface ILoginBiz {

    public void login(String userName, String userPassword, CallbackCheck callbackCheck);

    public interface CallbackCheck {
        public void onSuccess();

        public void onFailed();
    }

}
