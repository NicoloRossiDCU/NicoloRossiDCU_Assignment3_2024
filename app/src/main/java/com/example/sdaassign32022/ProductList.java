package com.example.sdaassign32022;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/*
 * A simple {@link Fragment} subclass.
 * @author Chris Coughlan 2019
 */
public class ProductList extends Fragment  implements DesignViewAdapter.OnItemListener  {

    private static final String TAG = "RecyclerViewActivity";
    private ArrayList<TShirtDesignAdapter> mTShirtDesign = new ArrayList<>();

    public ProductList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_product_list, container, false);
        // Create an ArrayList of AndroidFlavor objects
        mTShirtDesign.add(new TShirtDesignAdapter("Human Android", "M-L-XL", R.drawable.android));
        mTShirtDesign.add(new TShirtDesignAdapter("Angry pepper", "M-L-XL-XXL", R.drawable.angry_pepper));
        mTShirtDesign.add(new TShirtDesignAdapter("Modern Art", "XS-M-L-XL", R.drawable.face_art));
        mTShirtDesign.add(new TShirtDesignAdapter("Metal gorillas", "S-M-L-XL", R.drawable.gorillas_metal));
        mTShirtDesign.add(new TShirtDesignAdapter("Face Hand illusion", "M-L-XL", R.drawable.hand_face));
        mTShirtDesign.add(new TShirtDesignAdapter("Metal Guy", "M-L-XL", R.drawable.metal_guy));
        mTShirtDesign.add(new TShirtDesignAdapter("Surrealist", "S-M-XL", R.drawable.time_sea));
        mTShirtDesign.add(new TShirtDesignAdapter("Zombie", "M-L-XL", R.drawable.zombie));

        //start it with the view
        Log.d(TAG, "Starting recycler view");
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView_view);
        DesignViewAdapter recyclerViewAdapter = new DesignViewAdapter(getContext(), mTShirtDesign, this);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }

    @Override
    public void onItemClick(int position) {
        // getting the item that was clicked thanks to its position in the list
        TShirtDesignAdapter clickedItem = mTShirtDesign.get(position);
        showToast(this.getView(), clickedItem);
    }

    public void showToast(View view, TShirtDesignAdapter clickedItem )
    {
        CharSequence text = clickedItem.getStyleName();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText( this.getContext(), text, duration);
        toast.show();
    }
}
