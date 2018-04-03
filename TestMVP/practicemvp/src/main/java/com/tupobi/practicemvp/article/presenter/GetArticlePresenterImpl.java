package com.tupobi.practicemvp.article.presenter;

import com.tupobi.practicemvp.article.model.bean.GankArticle;
import com.tupobi.practicemvp.article.model.biz.GetArticleBizImpl;
import com.tupobi.practicemvp.article.model.biz.IGetArticleBiz;
import com.tupobi.practicemvp.article.view.IGetArticleView;
import com.tupobi.practicemvp.utils.LogUtil;

/**
 * Created by Administrator on 2018/4/3/003.
 */

public class GetArticlePresenterImpl implements IGetArticlePresenter {
    private IGetArticleBiz mIGetArticleBiz;
    private IGetArticleView mIGetArticleView;

    public GetArticlePresenterImpl(IGetArticleView IGetArticleView) {
        mIGetArticleView = IGetArticleView;
        mIGetArticleBiz = new GetArticleBizImpl();
    }

    @Override
    public void getGankArticle() {
        mIGetArticleView.showLoadingProgress();
        mIGetArticleBiz.getArticle(new IGetArticleBiz.CallbackGetArticle() {
            @Override
            public void onSuccess(GankArticle gankArticle) {
                mIGetArticleView.showSuccessMsg();
                mIGetArticleView.hideLoadingProgress();

                LogUtil.e("presenter得到数据：" + gankArticle.toString());
                mIGetArticleView.showArticle(gankArticle);
            }

            @Override
            public void onFailed(Throwable throwable) {
                mIGetArticleView.showFailedMsg(throwable);
                mIGetArticleView.hideLoadingProgress();
            }
        });

    }

}
