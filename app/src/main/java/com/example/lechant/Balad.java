package com.example.lechant;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Balad extends Fragment {

    private Button btnRegion,btnAbtBal;
    private TextView tvDescBal,tvTittleBal;

    public Balad() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_balad, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvDescBal = view.findViewById(R.id.tv_desc_balad);
        tvTittleBal = view.findViewById(R.id.tv_tittle_balad);

        btnAbtBal = view.findViewById(R.id.btn_about_balad);
        btnRegion = view.findViewById(R.id.btn_region);
    }
}