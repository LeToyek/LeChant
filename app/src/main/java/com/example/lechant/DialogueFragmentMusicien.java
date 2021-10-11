package com.example.lechant;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class DialogueFragmentMusicien extends DialogFragment {

    private Button btnChoose,btnClose;
    private RadioGroup rgOptions;
    private RadioButton rbMozzart,rbBeethoven,rbVivaldi,rbChopin;
    private OnOptionDialogueListener optionDialogueListener;


    public DialogueFragmentMusicien() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialogue_musicien, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rgOptions = view.findViewById(R.id.rg_option);
        btnChoose = view.findViewById(R.id.btn_choose);
        btnClose = view.findViewById(R.id.btn_close);
        rbBeethoven = view.findViewById(R.id.rb_beethoven);
        rbChopin = view.findViewById(R.id.rb_chopin);
        rbMozzart = view.findViewById(R.id.rb_mozzart);
        rbVivaldi = view.findViewById(R.id.rb_vivaldi);


        btnChoose.setOnClickListener(v -> {
            int checkRadioButton = rgOptions.getCheckedRadioButtonId();
            if(checkRadioButton != -1){
                String musicien = null;
                if(checkRadioButton == R.id.rb_beethoven){
                    musicien = rbBeethoven.getText().toString().trim();
                }else if(checkRadioButton == R.id.rb_vivaldi){
                    musicien = rbVivaldi.getText().toString().trim();
                }else if(checkRadioButton == R.id.rb_mozzart){
                    musicien = rbMozzart.getText().toString().trim();
                }else if(checkRadioButton == R.id.rb_chopin){
                    musicien = rbChopin.getText().toString().trim();
                }
                if (optionDialogueListener != null){
                    optionDialogueListener.onOptionChoosen(musicien);
                }
                getDialog().dismiss();
            }
        });
        btnClose.setOnClickListener(v -> getDialog().cancel());
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Fragment fragment = getParentFragment();

        if (fragment instanceof Classical){
            Classical classical = (Classical) fragment;
            this.optionDialogueListener = classical.optionDialogueListener;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.optionDialogueListener = null;
    }
    interface OnOptionDialogueListener{
        void onOptionChoosen(String text);
    }
}