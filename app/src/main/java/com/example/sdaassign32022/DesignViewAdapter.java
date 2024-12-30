package com.example.sdaassign32022;
/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/*
 * @author Chris Coughlan 2019
 */
public class DesignViewAdapter extends RecyclerView.Adapter<DesignViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private Context mNewContext;

    //add array for each item\
    private ArrayList<TShirtDesignAdapter> mDesigns;

    // here creating the onItemListener to pass it to each view holder
    private OnItemListener mOnItemListener;

    DesignViewAdapter(Context mNewContext, ArrayList<TShirtDesignAdapter> mdesigns, OnItemListener mOnItemListener) {
        this.mNewContext = mNewContext;
        this.mDesigns = mdesigns;
        this.mOnItemListener = mOnItemListener;

    }

    //declare methods
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_list_item, viewGroup, false);
        return new ViewHolder(view, this.mOnItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder: was called");

        viewHolder.imageText.setText(mDesigns.get(position).getAvailableSize());
        viewHolder.versionText.setText(mDesigns.get(position).getStyleName());
        viewHolder.imageItem.setImageResource(mDesigns.get(position).getImageResourceId());

    }

    @Override
    public int getItemCount() {
        return mDesigns.size();
    }

    //viewholder class
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageItem;
        TextView imageText;
        TextView versionText;
        RelativeLayout itemParentLayout;

        OnItemListener onItemListener;

        ViewHolder(@NonNull View itemView , OnItemListener onItemListener) {
            super(itemView);

            //grab the image, the text and the layout id's
            imageItem = itemView.findViewById(R.id.imageItem);
            imageText = itemView.findViewById(R.id.flavorText);
            versionText = itemView.findViewById(R.id.flavorVers);
            itemParentLayout = itemView.findViewById(R.id.listItemLayout);

            this.onItemListener = onItemListener;
            // set the listener to the itemView
            itemView.setOnClickListener(this);
        }


        // this will be called when a click happens on the view holder
        @Override
        public void onClick(View view) {
            // calling method onItemClick of the interface we injected with the position
            onItemListener.onItemClick(getAdapterPosition());
        }
    }

    // interface that will be used in the activity where we want to do something with the
    // clicked item. This interface contains a method that will be defined in the recycler adapter
    // activity.
    // This interface will also be passed to the constructor so we can use its method when we detect a click
    public interface OnItemListener {
        void onItemClick(int position);
    }
}
