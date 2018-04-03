package com.tupobi.practicemvp.article.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tupobi.practicemvp.R;
import com.tupobi.practicemvp.article.model.bean.GankArticle;
import com.tupobi.practicemvp.article.presenter.GetArticlePresenterImpl;
import com.tupobi.practicemvp.article.presenter.IGetArticlePresenter;
import com.tupobi.practicemvp.article.view.adapter.RvGankArticleAdapter;
import com.tupobi.practicemvp.databinding.AtyMainBinding;
import com.tupobi.practicemvp.utils.LogUtil;
import com.tupobi.practicemvp.utils.ToastUtil;

public class AtyMain extends AppCompatActivity implements IGetArticleView{

    private AtyMainBinding mBinding;
    private RecyclerView mRvGankArticle;
    private IGetArticlePresenter mIGetArticlePresenter;
    private RvGankArticleAdapter mRvGankArticleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AtyMainBinding binding = DataBindingUtil.setContentView(this, R.layout.aty_main);
        mBinding = binding;
        mIGetArticlePresenter = new GetArticlePresenterImpl(this);
        initView(binding);
    }

    private void initView(AtyMainBinding binding) {
        mRvGankArticle = binding.rvGankArticle;
        binding.btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIGetArticlePresenter.getGankArticle();
            }
        });

        mRvGankArticle.setLayoutManager(new LinearLayoutManager(AtyMain.this));
        mRvGankArticleAdapter = new RvGankArticleAdapter(AtyMain.this, null);
        mRvGankArticle.setAdapter(mRvGankArticleAdapter);
    }

    @Override
    public void showArticle(GankArticle gankArticle) {
        mRvGankArticleAdapter.setGankArticle(gankArticle);
        mRvGankArticleAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSuccessMsg() {
        ToastUtil.showShort(AtyMain.this, "得到数据成功！");
    }

    @Override
    public void showFailedMsg(Throwable throwable) {
        ToastUtil.showShort(AtyMain.this, "得到数据失败！");
        LogUtil.e("得到数据失败：" + throwable.getMessage());
    }

    @Override
    public void showLoadingProgress() {
        mBinding.pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingProgress() {
        mBinding.pbLoading.setVisibility(View.GONE);
    }
}
