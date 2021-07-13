package com.example.homework_6;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;


public class NoteFragment extends Fragment {

    private boolean isLandscape;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
        if (isLandscape) {
            ShowNoteDescription((((MainActivity) requireActivity()).currentNote));
        }
    }

    private void ShowNoteDescription(Note currentNote) {
        DescriptionNoteFragment descriptionNoteFragment = DescriptionNoteFragment.newInstance(currentNote);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_land, descriptionNoteFragment).commit();
    }

    public NoteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createTextViewList((LinearLayout) view);
    }

    private void createTextViewList(LinearLayout view) {
        LinearLayout linearLayout = view;
        String[] zone_notes = getResources().getStringArray(R.array.zone_of_notes);
        for (int i = 0; i < zone_notes.length; i++) {
            TextView textView = new TextView(getContext());
            textView.setText(zone_notes[i]);
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) getActivity()).currentNote = new Note(finalI);
                    ShowNoteDescription(((MainActivity) getActivity()).currentNote);
                }

            });
            textView.setTextSize(30);
            linearLayout.addView(textView);

        }
    }
}