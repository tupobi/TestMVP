package com.tupobi.practicemvp.article.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tupobi.practicemvp.R;
import com.tupobi.practicemvp.article.model.bean.GankArticle;

/**
 * Created by Administrator on 2018/4/3/003.
 */

public class RvGankArticleAdapter extends RecyclerView.Adapter<RvGankArticleAdapter.GankArticleViewHolder>{
    private Context mContext;
    private GankArticle mGankArticle;

    public RvGankArticleAdapter(Context context, GankArticle gankArticle) {
        mContext = context;
        mGankArticle = gankArticle;
    }

    public void setGankArticle(GankArticle gankArticle) {
        mGankArticle = gankArticle;
    }

    @Override
    public GankArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GankArticleViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_of_rv_gank_article, parent, false));
    }

    @Override
    public void onBindViewHolder(GankArticleViewHolder holder, int position) {
        holder.mTvDes.setText(mGankArticle.getResults().get(position).getDesc());
        holder.mTvUrl.setText(mGankArticle.getResults().get(position).getUrl());
        holder.mTvDate.setText(mGankArticle.getResults().get(position).getCreatedAt());
    }

    @Override
    public int getItemCount() {
        return mGankArticle == null ? 0 : mGankArticle.getResults().size();
    }


    class GankArticleViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvDes, mTvUrl, mTvDate;

        public GankArticleViewHolder(View itemView) {
            super(itemView);

            mTvDes = itemView.findViewById(R.id.tv_des);
            mTvUrl = itemView.findViewById(R.id.tv_url);
            mTvDate = itemView.findViewById(R.id.tv_date);
        }
    }

}
