/*
 * Created by Aditya on 10/4/17 5:01 PM
 * Copyright (c) 2017 All rights reserved.
 *
 * Last modified 10/4/17 4:42 PM
 */

package com.githubapi.repositoryList.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.githubapi.R;
import com.githubapi.repositoryLanguage.model.Item;

import java.util.List;

/**
 * Created by Aditya on 09/04/17.
 */

public class RepositoryListAdapter extends BaseAdapter {

    private List<Item> mItemList;
    private LayoutInflater mInflater;

    RepositoryListAdapter(List<Item> listItems, LayoutInflater inflater) {
        mItemList = listItems;
        mInflater = inflater;
    }

    @Override
    public int getCount() {
        int size = mItemList == null ? 0 : mItemList.size();
        return size;
    }

    @Override
    public Item getItem(int position) {
        return mItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(mInflater.getContext()).inflate(R.layout.repositiory_list_item, null);
            viewHolder.repoItem = (TextView) view.findViewById(R.id.listItem);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.repoItem.setText(mItemList.get(position).getName());

        return view;
    }

    public void addToRepo(List<Item> listItem) {
        mItemList.addAll(listItem);
        notifyDataSetChanged();
    }


    static class ViewHolder {
        TextView repoItem;
    }
}
