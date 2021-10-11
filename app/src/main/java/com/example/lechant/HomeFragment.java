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


public class HomeFragment extends Fragment implements View.OnClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Button btnClassical = view.findViewById(R.id.btn_classical);
        btnClassical.setOnClickListener(this);

        Button btnBalad = view.findViewById(R.id.btn_balad);
        btnBalad.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_classical){
            Classical classical = new Classical();
            Bundle mBundle = new Bundle();
            mBundle.putString(Classical.EXTRA_NAME,"La musique de Classique");
            String description = "Classical music is such Brain supporting  music genre, this type of music is perfect to listen when you study.";

            classical.setArguments(mBundle);
            classical.setDescription(description);

            FragmentManager fragmentManager = getParentFragmentManager();
            if(fragmentManager != null){
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container, classical, Classical.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        }else if(view.getId() == R.id.btn_balad){
            Balad balad = new Balad();

            FragmentManager fragmentManager = getParentFragmentManager();
            if(fragmentManager != null){
                fragmentManager
                        .beginTransaction()
                        .replace(R.id.frame_container,balad,Balad.class.getSimpleName())
                        .addToBackStack(null)
                        .commit();
            }
        }
    }
}