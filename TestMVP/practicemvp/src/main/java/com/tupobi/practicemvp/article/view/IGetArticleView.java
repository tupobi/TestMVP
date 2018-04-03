package com.tupobi.practicemvp.article.view;

import com.tupobi.practicemvp.article.model.bean.GankArticle;

/**
 * Created by Administrator on 2018/4/2/002.
 */

public interface IGetArticleView {
    public void showArticle(GankArticle gankArticle);

    public void showSuccessMsg();

    public void showFailedMsg(Throwable throwable);

    public void showLoadingProgress();

    public void hideLoadingProgress();
}
