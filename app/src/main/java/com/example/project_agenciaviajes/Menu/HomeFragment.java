package com.example.project_agenciaviajes.Menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project_agenciaviajes.Packs.SeepackFragment;
import com.example.project_agenciaviajes.R;

public class HomeFragment extends Fragment {

    TextView Seepack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button buttonverpack = (Button) view.findViewById(R.id.box_verpaquetes);
        buttonverpack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment selectedFragment = null;
                selectedFragment = new SeepackFragment();

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
            }
        });
        return view;
    }
}