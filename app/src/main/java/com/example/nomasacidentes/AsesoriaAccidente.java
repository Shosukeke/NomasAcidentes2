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

import com.example.nomasacidentes.model.AseAccidente;
import com.example.nomasacidentes.model.solicitudesCbox;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AsesoriaAccidente extends Fragment  implements View.OnClickListener {

    EditText Edreg_tituloA;
    Spinner Edreg_SoliA;
    EditText Edreg_TipoA;
    EditText Edreg_invoA;
    EditText Edreg_infoA;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.asesoria_accidente, container, false);

        Edreg_tituloA = (EditText) rootView.findViewById(R.id.txt_tituloA);
        addItemsOnSpinner();
        Edreg_SoliA = (Spinner) rootView.findViewById(R.id.spi_soliA);
        Edreg_TipoA = (EditText) rootView.findViewById(R.id.txt_tipoA);
        Edreg_invoA = (EditText) rootView.findViewById(R.id.txt_invoA);
        Edreg_infoA = (EditText) rootView.findViewById(R.id.txt_infoA);
        Button regAcciBtn = (Button) rootView.findViewById(R.id.btn_regAcci);

        regAcciBtn.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_regAcci:
                RegAcciButtonClick();
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



                        if (SoliList.get(i).getEstado() == false && SoliList.get(i).getTipo().equals("Asesoria por Accidenete") ) {

                            lista.add(SoliList.get(i).getId()+","+SoliList.get(i).getTitulo());

                        }
                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, lista);
                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                        Edreg_SoliA.setAdapter(spinnerArrayAdapter);


                    }

                }




            }

            @Override
            public void onFailure(Call<List<solicitudesCbox>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }





    public void RegAcciButtonClick() {
        String selec = (String) Edreg_SoliA.getSelectedItem();
        int posicionPunto = selec.indexOf(',');
        String sHastaPrimerPunto = selec.substring(0,posicionPunto);
        int value = Integer.parseInt(sHastaPrimerPunto.trim());

        String str_reg_titulo = Edreg_tituloA.getText().toString();
        Integer str_reg_soli = value;
        String str_reg_tipacc = Edreg_TipoA.getText().toString();
        String str_reg_involucados = Edreg_invoA.getText().toString();
        String str_reg_info = Edreg_infoA.getText().toString();



        AseAccidente AcciModel = new AseAccidente(

                str_reg_titulo,
                str_reg_soli,
                str_reg_tipacc,
                str_reg_involucados,
                str_reg_info

        );


        if (!IsEmptyEditTextAcci()){
            if (InternetUtil.isInternetOnline(getActivity())){
                RegisterInServer(AcciModel);

            }

        }


    }

    public void RegisterInServer(AseAccidente AcciModel){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        PostApi postApi= retrofit.create(PostApi.class);
        Call<AseAccidente> call = postApi.registrationAcc(AcciModel);

        call.enqueue(new Callback<AseAccidente>() {
            @Override
            public void onResponse(Call<AseAccidente> call, Response<AseAccidente> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        SharedPreferences preferences = getActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor prefLoginEdit = preferences.edit();
                        prefLoginEdit.putBoolean("registrar",true);
                        prefLoginEdit.commit();

                        Toast.makeText(getContext(), "Asesoria por Accidente realizada exitosamente", Toast.LENGTH_SHORT).show();
                        limpieza();

                    }

                }else {
                    Toast.makeText(getContext(), "Error!! puede que ya se haya creado una una asesoria anexada a esa solicitud.Pruebe recargando la Ventana", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<AseAccidente> call, Throwable t)  {
                Log.d("fail", "fail");
            }
        });
    }

    private Boolean IsEmptyEditTextAcci(){


        if(Edreg_tituloA.getText().toString().isEmpty() ||
                Edreg_TipoA.getText().toString().isEmpty() ||
                Edreg_invoA.getText().toString().isEmpty()){

            Toast toast = Toast.makeText(getActivity(),"Campos vacios", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();


            return true;
        }else{
            return false;
        }

    }
    private void limpieza(){
        Edreg_tituloA.setText("");
        Edreg_TipoA.setText("");
        Edreg_infoA.setText("");
        Edreg_invoA.setText("");


    }
}