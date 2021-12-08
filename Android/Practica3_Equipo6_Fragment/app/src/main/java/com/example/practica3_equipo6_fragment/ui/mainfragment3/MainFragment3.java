package com.example.practica3_equipo6_fragment.ui.mainfragment3;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.practica3_equipo6_fragment.Fragment1;
import com.example.practica3_equipo6_fragment.Fragment2;
import com.example.practica3_equipo6_fragment.Fragment3;
import com.example.practica3_equipo6_fragment.Fragment4;
import com.example.practica3_equipo6_fragment.Fragment5;
import com.example.practica3_equipo6_fragment.R;

public class MainFragment3 extends Fragment {

    private MainFragment3ViewModel mViewModel;
    Button boton, boton1, boton2, boton3,boton4;

    public static MainFragment3 newInstance() {
        return new MainFragment3();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View vista= inflater.inflate(R.layout.main_fragment3_fragment, container, false);
        boton = vista.findViewById(R.id.btmostrar31);
        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                Fragment1 fragmento1 = Fragment1.newInstance("", "", 3);
                View vieww = fragmento1.onCreateView(inflater, container, savedInstanceState);
                transaction.replace(R.id.linearLayoutReemplazar3, fragmento1);
                transaction.commit();

            }
        });
        boton1 = vista.findViewById(R.id.btmostrar32);
        boton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                Fragment2 fracmento2 = Fragment2.newInstance("", "", 3);
                View view = fracmento2.onCreateView(inflater, container, savedInstanceState);
                transaction.replace(R.id.linearLayoutReemplazar3, fracmento2);
                transaction.commit();
            }

        });

        boton2 = vista.findViewById(R.id.btmostrar33);
        boton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                Fragment3 fracmento3 = Fragment3.newInstance("", "", 3);
                View view = fracmento3.onCreateView(inflater, container, savedInstanceState);
                transaction.replace(R.id.linearLayoutReemplazar3, fracmento3);
                transaction.commit();
            }

        });

        boton3 = vista.findViewById(R.id.btmostrar34);
        boton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                Fragment4 fracmento4 = Fragment4.newInstance("", "", 3);
                View view = fracmento4.onCreateView(inflater, container, savedInstanceState);
                transaction.replace(R.id.linearLayoutReemplazar3, fracmento4);
                transaction.commit();
            }
        });

        boton4 = vista.findViewById(R.id.btmostrar35);
        boton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                Fragment5 fracmento5 = Fragment5.newInstance("", "", 3);
                View view = fracmento5.onCreateView(inflater, container, savedInstanceState);
                transaction.replace(R.id.linearLayoutReemplazar3, fracmento5);
                transaction.commit();
            }
        });
        return vista;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainFragment3ViewModel.class);
        // TODO: Use the ViewModel
    }

}