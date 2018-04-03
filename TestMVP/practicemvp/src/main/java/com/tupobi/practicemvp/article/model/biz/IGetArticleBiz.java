package com.tupobi.practicemvp.article.model.biz;

import com.tupobi.practicemvp.article.model.bean.GankArticle;

/**
 * Created by Administrator on 2018/4/2/002.
 */

public interface IGetArticleBiz {
    public void getArticle(CallbackGetArticle callbackGetArticle);

    public interface CallbackGetArticle {
        public void onSuccess(GankArticle gankArticle);

        public void onFailed(Throwable throwable);
    }
}
