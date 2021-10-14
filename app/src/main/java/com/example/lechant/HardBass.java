package com.example.lechant;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class HardBass extends Fragment {


    public HardBass() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hard_bass, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnDj = view.findViewById(R.id.btn_dj);
        btnDj.setOnClickListener(v -> {
            DialogeFragmentDj dialogeFragmentDj = new DialogeFragmentDj();
            FragmentManager fragmentManager = getChildFragmentManager();
            dialogeFragmentDj.show(fragmentManager,DialogeFragmentDj.class.getSimpleName());
        });

        Button btnAbtHb = view.findViewById(R.id.btn_about_hb);
        btnAbtHb.setOnClickListener(v -> {
            Intent abtHbIntent = new Intent(getActivity(),AboutHardBass.class);
            startActivity(abtHbIntent);
        });
    }
    DialogeFragmentDj.OnOptionDialogueListener optionDialogueListener = new DialogeFragmentDj.OnOptionDialogueListener() {
        @Override
        public void onOptionChoosen(String text) {
            Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
        }
    };
}