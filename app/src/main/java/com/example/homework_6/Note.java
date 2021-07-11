package com.example.homework_6;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class Note extends Fragment {


    public Note() {
        // Required empty public constructor
    }
       @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_description_of, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createTextViewList((LinearLayout) view);
    }

    private void createTextViewList(LinearLayout view) {
        LinearLayout linearLayout = view;
        String [] zone_notes = getResources().getStringArray(R.array.zone_of_notes);
        for (int i = 0; i < zone_notes.length; i++) {
            TextView textView = new TextView(getContext());
            textView.setText(zone_notes[i]);
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(),DescriptionNotePort.class);
                    intent.putExtra (DescriptionNote.KEY_INDEX, finalI);
                    startActivity(intent);
                }
            });
            textView.setTextSize(30);
            linearLayout.addView(textView);

        }
    }
}