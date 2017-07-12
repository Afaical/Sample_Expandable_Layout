package com.example.abdelfaical.youtubeapi;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;

/**
 * Created by AbdelFaical on 7/12/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemHolder> {

    private Context context;
    private ArrayList<String> list = new ArrayList<>();

    public MyAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ItemHolder holder, int position) {
        String text = list.get(position);

        if (holder.expandableLayout.isExpanded()){
            holder.expandableLayout.toggle();
        }

        holder.tv_title.setText(text);
        holder.lyt_parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.expandableLayout.isExpanded()){
                    holder.expandableLayout.toggle();
                } else {
                    holder.textView.setText(context.getResources().getString(R.string.long_text));
                    holder.expandableLayout.toggle();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list.size() > 0)
            return list.size();
        return 0;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private TextView tv_title;
        private CardView lyt_parent;
        private ExpandableRelativeLayout expandableLayout;

        public ItemHolder(View itemView) {
            super(itemView);

            textView = (TextView)itemView.findViewById(R.id.text);
            tv_title = (TextView)itemView.findViewById(R.id.tv_title);
            lyt_parent = (CardView) itemView.findViewById(R.id.lyt_parent);
            expandableLayout = (ExpandableRelativeLayout) itemView.findViewById(R.id.expandableLayout);
        }
    }
}
