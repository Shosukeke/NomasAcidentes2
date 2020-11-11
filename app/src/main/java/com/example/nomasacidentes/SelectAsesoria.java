package com.example.nomasacidentes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SelectAsesoria extends Fragment implements View.OnClickListener   {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.select_asesorias, container, false);

        Button B_fis=(Button) rootView.findViewById(R.id.btnFis);
        Button B_acci=(Button) rootView.findViewById(R.id.btnAcci);

        B_fis.setOnClickListener(this);
        B_acci.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFis:
                FisButtonClick();
                break;
            case R.id.btnAcci:
                AcciButtonClick();
                break;
        }
    }

    public void replaceFragment(Fragment someFragment) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public void FisButtonClick()
    {

        Fragment fragment = null;
        fragment = new AsesoriaFiscalizacion();
        replaceFragment(fragment);

    }



    public void AcciButtonClick()
    {

        Fragment fragment = null;
        fragment = new AsesoriaAccidente();
        replaceFragment(fragment);


    }
}