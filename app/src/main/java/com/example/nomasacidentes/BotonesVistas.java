package com.example.nomasacidentes;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class BotonesVistas extends Fragment implements View.OnClickListener{

    Button btnInDatos, btnFormulario, btnSolicitud, btnHorario,btnListMejoras ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_botones_vistas, container, false);

        Button ListMejora=(Button) rootView.findViewById(R.id.btnListMejora);
        Button btnIngreso=(Button) rootView.findViewById(R.id.btnInDatos);
        Button btnForm=(Button) rootView.findViewById(R.id.btnFormulario);
        Button btnSolicitud=(Button) rootView.findViewById(R.id.btnSolicitud);
        Button btnHorario=(Button) rootView.findViewById(R.id.btnHorario);


       ListMejora.setOnClickListener(this);
       btnIngreso.setOnClickListener(this);
       btnForm.setOnClickListener(this);
        btnSolicitud.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnListMejora:
                ListMejora();
                break;
            case R.id.btnInDatos:
                btnIngreso();
                break;
        }

    }

    public void replaceFragment(Fragment someFragment) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public void ListMejora()
    {

        Fragment fragment = null;
        fragment = new SolicitudMejora();
        replaceFragment(fragment);

    }



    public void btnIngreso()
    {

        Fragment fragment = null;
        fragment = new SelectAsesoria();
        replaceFragment(fragment);


    }


}

