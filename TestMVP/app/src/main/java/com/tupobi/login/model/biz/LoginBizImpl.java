package com.tupobi.login.model.biz;

import android.os.Handler;
import android.os.Message;

/**
 * Created by Administrator on 2018/4/2/002.
 */

public class LoginBizImpl implements ILoginBiz {

    private static int sCount;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    mCallbackCheck.onSuccess();
                    break;
                case 2:
                    mCallbackCheck.onFailed();
                    break;
                default:
                    break;
            }
        }
    };

    private CallbackCheck mCallbackCheck;

    @Override
    public void login(String userName, String userPassword, CallbackCheck callbackCheck) {
        this.mCallbackCheck = callbackCheck;
        if (sCount++ % 2 == 0) {
            mHandler.sendEmptyMessageDelayed(1, 2000);
        } else {
            mHandler.sendEmptyMessageDelayed(2, 2000);
        }
    }


}
