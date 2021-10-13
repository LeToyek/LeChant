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


public class DialogeFragmentDj extends DialogFragment {

    private OnOptionDialogueListener onOptionDialogueListener;

    public DialogeFragmentDj() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dialoge_dj, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RadioGroup rgOptionHb = view.findViewById(R.id.rg_option_dj);
        RadioButton rbDjBlyatman = view.findViewById(R.id.rb_blyatman);
        RadioButton rbRVB = view.findViewById(R.id.rb_rvb);
        RadioButton rbGopnik = view.findViewById(R.id.rb_gopnik);
        RadioButton rbStalin = view.findViewById(R.id.rb_stalin);
        Button btnCloseHb = view.findViewById(R.id.btn_close_hb);
        Button btnChooseHb = view.findViewById(R.id.btn_choose_hb);

        btnChooseHb.setOnClickListener(va -> {
            int checkRadioButton = rgOptionHb.getCheckedRadioButtonId();
            if (checkRadioButton != -1){
                String Dj = null;
                if (checkRadioButton == R.id.rb_blyatman){
                    Dj = rbDjBlyatman.getText().toString();
                }else if(checkRadioButton == R.id.rb_rvb){
                    Dj = rbRVB.getText().toString();
                }else if(checkRadioButton == R.id.rb_gopnik){
                    Dj = rbGopnik.getText().toString();
                }else if(checkRadioButton == R.id.rb_stalin){
                    Dj = rbStalin.getText().toString();
                }if(onOptionDialogueListener != null){
                    onOptionDialogueListener.onOptionChoosen(Dj);
                }
                getDialog().dismiss();
            }else{
                btnCloseHb.setOnClickListener(v -> getDialog().cancel());
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Fragment fragment = new Fragment();

        if (fragment instanceof HardBass){
            HardBass hardBass = (HardBass) fragment;
            this.onOptionDialogueListener = hardBass.optionDialogueListener;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.onOptionDialogueListener = null;
    }

    interface OnOptionDialogueListener{
        void onOptionChoosen(String text);
    }
}