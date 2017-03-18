package com.materialdesigndemo.www.materialdesigndemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MaterialDesignFragment extends Fragment {
    public static final String TAG = "text";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String s = getArguments().getString(TAG);
    }

    public MaterialDesignFragment() {
        // Required empty public constructor
    }
    public static MaterialDesignFragment newInstance(String string){
       Bundle args = new Bundle();
        args.putString(TAG,string);
        MaterialDesignFragment fragment = new MaterialDesignFragment();
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_material_design, container, false);
    }

}
