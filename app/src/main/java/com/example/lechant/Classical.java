package com.example.lechant;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Classical extends Fragment {

    public TextView tvBalad, tvBalDes;
    public Button btnAbout, btnMusicien, btnMusic;

    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_DESCRIPTION = "extra_description";

    private String description;

    public Classical() {
        // Required empty public constructor
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_musicien, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvBalad = view.findViewById(R.id.tv_balad);
        tvBalDes = view.findViewById(R.id.tv_desc_bal);

        btnAbout = view.findViewById(R.id.btn_about);

        btnMusic = view.findViewById(R.id.btn_music);

        btnMusicien = view.findViewById(R.id.btn_musicien);
        btnMusicien.setOnClickListener(v -> {
            DialogueFragmentMusicien dialogueFragmentMusicien = new DialogueFragmentMusicien();
            FragmentManager fragmentManager = getChildFragmentManager();
            dialogueFragmentMusicien.show(fragmentManager, DialogueFragmentMusicien.class.getSimpleName());
        });
        if (savedInstanceState != null) {
            String descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION);
            setDescription(descFromBundle);
        }
        if (getArguments() != null) {
            String categoryName = getArguments().getString(EXTRA_NAME);
            tvBalad.setText(categoryName);
            tvBalDes.setText(getDescription());
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(EXTRA_DESCRIPTION, getDescription());
    }

    DialogueFragmentMusicien.OnOptionDialogueListener optionDialogueListener = new DialogueFragmentMusicien.OnOptionDialogueListener() {
        @Override
        public void onOptionChoosen(String text) {
            Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
        }
    };
}