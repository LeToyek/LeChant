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
import android.widget.TextView;


public class Balad extends Fragment{

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
        btnRegion.setOnClickListener(v -> {
            FragmentManager fragmentManager = getParentFragmentManager();
            ReigonBalad regBalad = new ReigonBalad();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container,regBalad,ReigonBalad.class.getSimpleName())
                    .addToBackStack(null)
                    .commit();
        });

        btnAbtBal.setOnClickListener(v ->{
            Intent abtBal = new Intent(getActivity(),AboutBalad.class);
            startActivity(abtBal);
        });
    }
}