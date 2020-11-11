package com.example.nomasacidentes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.nomasacidentes.model.Fiscalizacion;
import com.example.nomasacidentes.model.solicitudesCbox;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AsesoriaFiscalizacion extends Fragment implements View.OnClickListener {

    EditText Edreg_nombre;
    Spinner Edreg_soli;
    EditText Edreg_fiscalizador;
    EditText Edreg_diligencias;
    EditText Edreg_informacion;
    EditText Edreg_descripcion;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.asesoria_fiscalizacion, container, false);
        Edreg_nombre = (EditText) rootView.findViewById(R.id.txt_nombre);
        addItemsOnSpinner();
        Edreg_soli = (Spinner) rootView.findViewById(R.id.spi_solicitud);

        Edreg_fiscalizador = (EditText) rootView.findViewById(R.id.txt_fiscalizador);
        Edreg_diligencias = (EditText) rootView.findViewById(R.id.txt_diligencia);
        Edreg_informacion = (EditText) rootView.findViewById(R.id.txt_info);
        Edreg_descripcion = (EditText) rootView.findViewById(R.id.txt_descripcion);
        Button regFisBtn = (Button) rootView.findViewById(R.id.btn_reg_aseFis);

        regFisBtn.setOnClickListener(this);
        return rootView;
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_reg_aseFis:
                RegFisButtonClick();
                break;

        }

    }

    public void addItemsOnSpinner() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi = retrofit.create(PostApi.class);

        Call<List<solicitudesCbox>> call = postApi.getSoliFiList();

        call.enqueue(new Callback<List<solicitudesCbox>>() {
            @Override
            public void onResponse(Call<List<solicitudesCbox>> call, Response<List<solicitudesCbox>> response) {
                List<solicitudesCbox> SoliList = response.body();

                if (SoliList != null && SoliList.size() > 0) {
                    List<String> lista;
                    lista = new ArrayList<>();
                    for (int i = 0; i < SoliList.size(); i++) {



                       if (SoliList.get(i).getEstado() == false && SoliList.get(i).getTipo().equals("Asesoria por Fiscalizacion") ) {

                           lista.add(SoliList.get(i).getId()+","+SoliList.get(i).getTitulo());

                       }
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, lista);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        Edreg_soli.setAdapter(spinnerArrayAdapter);


                    }

                }




            }

            @Override
            public void onFailure(Call<List<solicitudesCbox>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void RegFisButtonClick() {
        String selec = (String) Edreg_soli.getSelectedItem();
        int posicionPunto = selec.indexOf(',');
        String sHastaPrimerPunto = selec.substring(0,posicionPunto);
        int value = Integer.parseInt(sHastaPrimerPunto.trim());
        
        String str_reg_nombre = Edreg_nombre.getText().toString();
        Integer str_reg_soli = value;
        String str_reg_fiscalizacion = Edreg_fiscalizador.getText().toString();
        String str_reg_diligencias = Edreg_diligencias.getText().toString();
        String str_reg_informacion = Edreg_informacion.getText().toString();
        String str_reg_descipcion = Edreg_descripcion.getText().toString();


        Fiscalizacion FisModel = new Fiscalizacion(
                str_reg_nombre,
                str_reg_soli,
                str_reg_fiscalizacion,
                str_reg_diligencias,
                str_reg_informacion,
                str_reg_descipcion

        );


        if (!IsEmptyEditTextFis()) {

            if (InternetUtil.isInternetOnline(getActivity())) {
                RegisterInServer(FisModel);
            }

        }


    }

    @Override
    public void onResume() {

        super.onResume();
        this.onCreate(null);
    }

    public void RegisterInServer(Fiscalizacion FisModel) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PostApi postApi = retrofit.create(PostApi.class);
        Call<Fiscalizacion> call = postApi.registrationFis(FisModel);

        call.enqueue(new Callback<Fiscalizacion>() {
            @Override
            public void onResponse(Call<Fiscalizacion> call, Response<Fiscalizacion> response) {

                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        SharedPreferences preferences = getActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor prefLoginEdit = preferences.edit();
                        prefLoginEdit.putBoolean("registration", true);
                        prefLoginEdit.commit();

                        Toast.makeText(getContext(), "Asesoria por Fiscalizacion realizada exitosamente", Toast.LENGTH_SHORT).show();
                        onResume();

                        limpieza();


                    }
                } else {
                    Toast.makeText(getContext(), "Error!! puede que ya se haya creado una una asesoria anexada a esa solicitud.Pruebe recargando la Ventana", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Fiscalizacion> call, Throwable t) {
                Log.d("fail", "fail");
            }
        });

    }
    private Boolean IsEmptyEditTextFis(){


        if(Edreg_nombre.getText().toString().isEmpty() ||
                Edreg_nombre.getText().toString().isEmpty() ||
                Edreg_fiscalizador.getText().toString().isEmpty() ||
                Edreg_diligencias.getText().toString().isEmpty() ||
                Edreg_informacion.getText().toString().isEmpty() ||
                Edreg_descripcion.getText().toString().isEmpty()){

            Toast toast = Toast.makeText(getActivity(),"Campos vacios", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();


            return true;
        }else{
            return false;
        }

    }
    private void limpieza(){
        Edreg_nombre.setText("");
        Edreg_fiscalizador.setText("");
        Edreg_diligencias.setText("");
        Edreg_informacion.setText("");
        Edreg_descripcion.setText("");

    }
}