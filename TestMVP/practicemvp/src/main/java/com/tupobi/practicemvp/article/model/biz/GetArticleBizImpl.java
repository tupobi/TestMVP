package com.tupobi.practicemvp.article.model.biz;

import com.tupobi.practicemvp.article.model.bean.GankArticle;
import com.tupobi.practicemvp.utils.http.RetrofitFactory;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Administrator on 2018/4/3/003.
 */

public class GetArticleBizImpl implements IGetArticleBiz {
    private CallbackGetArticle mCallbackGetArticle;

    @Override
    public void getArticle(final CallbackGetArticle callbackGetArticle) {
        mCallbackGetArticle = callbackGetArticle;

        RetrofitFactory.getInstence().API().getGankArticle(
                "Android",
                10,
                1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GankArticle>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GankArticle gankArticle) {
                        callbackGetArticle.onSuccess(gankArticle);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callbackGetArticle.onFailed(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
