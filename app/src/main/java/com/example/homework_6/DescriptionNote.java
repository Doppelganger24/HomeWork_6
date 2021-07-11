package com.example.homework_6;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DescriptionNote extends Fragment {


   private int index;
   public static final String KEY_INDEX = "index";

    public DescriptionNote() {
    }



    public static DescriptionNote newInstance(int index) {
        DescriptionNote fragment = new DescriptionNote();
        Bundle args = new Bundle();
        args.putInt(KEY_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(KEY_INDEX);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description_note, container, false);
        TextView textView = view.findViewById(R.id.description_note);
        String [] text = (getResources().getStringArray(R.array.description_note));
        textView.setText(text [index]);
        return view;
    }
}