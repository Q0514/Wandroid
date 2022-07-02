package com.practice.androidapp.mvp.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.practice.androidapp.R;
import com.practice.androidapp.beans.Home;
import com.practice.androidapp.beans.Navigation;


public class ChildNavigationAdapter extends BaseQuickAdapter<Navigation, BaseViewHolder> {

    private TagClickListener tagClickListener;

    public ChildNavigationAdapter() {
        super(R.layout.item_child_navigation);

//        addData(new System());
//        addData(new System());
//        addData(new System());
//        addData(new System());
//        addData(new System());
//        addData(new System());
//        addData(new System());
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, Navigation navigation) {
        holder.setText(R.id.tv_name, navigation.getName());
        TagAdapter tagAdapter = new TagAdapter();
        RecyclerView tagRecyclerView = holder.getView(R.id.recycler_view);

        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
//        flexboxLayoutManager
        tagRecyclerView.setLayoutManager(flexboxLayoutManager);
        tagRecyclerView.setAdapter(tagAdapter);
        tagAdapter.setList(navigation.getArticles());
        tagAdapter.setOnItemClickListener((adapter, view, position) -> {
            if (tagClickListener != null) {
                tagClickListener.onItemClick(position,tagAdapter.getItem(position),navigation);
            }
        });


    }

    public void setTagClickListener(TagClickListener tagClickListener) {
        this.tagClickListener = tagClickListener;
    }

    public interface TagClickListener {
        void onItemClick(int childPosition, Home item, Navigation parent);
    }


    private static class TagAdapter extends BaseQuickAdapter<Home, BaseViewHolder> {
        public TagAdapter() {
            super(R.layout.item_tag);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder baseViewHolder, Home home) {
            baseViewHolder.setText(R.id.tv_tag, home.getTitle());
        }
    }

}
