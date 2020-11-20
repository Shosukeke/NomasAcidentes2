package com.example.nomasacidentes;


import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import android.content.Context;
import android.content.SharedPreferences;

import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.Gravity;



import com.example.nomasacidentes.model.Mejora;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SolicitudMejora extends Fragment implements View.OnClickListener {

    EditText txtNombreMejora;
    EditText txtDescripcionMejora;
    EditText txtEstadoMejora;
    EditText txtAutorMejora;
    EditText txtEmpresaMejora;
    Button btnGuardarMejora;
    Button btnCandelar;
    Button btnListarMejoras;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_solicitud_mejora, container, false);

        txtNombreMejora = (EditText) view.findViewById(R.id.txtNombreMejora);
        txtDescripcionMejora = (EditText) view.findViewById(R.id.txtDescripcionMejora);
//        cargarSpinner();
        txtEstadoMejora = (EditText) view.findViewById(R.id.txtEstadoMejora);
        txtAutorMejora = (EditText) view.findViewById(R.id.txtAutorMejora);
        txtEmpresaMejora = (EditText) view.findViewById(R.id.txtEmpresaMejora);

        Button btnGuardarMejora = (Button) view.findViewById(R.id.btnGuardarMejora);
        Button btnListarMejoras = (Button) view.findViewById(R.id.btnListarMejoras);

        btnGuardarMejora.setOnClickListener(this);
        btnListarMejoras.setOnClickListener(this);
        return view;
    }

//    private void addItemsOnSpinner() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(PostApi.API_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        PostApi postApi = retrofit.create(PostApi.class);
//
//        Call<List<Mejora>> call = postApi.getMejoras();
//
//        call.enqueue(new Callback<List<Mejora>>() {
//            @Override
//            public void onResponse(Call<List<Mejora>> call, Response<List<Mejora>> response) {
//                List<Mejora> ListMejora = response.body();
//
//                if (ListMejora != null && ListMejora.size() > 0) {
//                    List<String> lista;
//                    lista = new ArrayList<>();
//                    for (int i = 0; i < ListMejora.size(); i++) {
//
////cargar en duro los estados del spinner
//
//                        if (ListMejora.get(i).getValidacionmejora() !=null &&  ListMejora.get(i).getValidacionmejora() != "") {
//                            lista.add(ListMejora.get(i).getValidacionmejora());
//
//
//
//                        }
//                        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item,lista);
//                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        spiEstado.setAdapter(spinnerArrayAdapter);
//
//                    }
//
//                }
//
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Mejora>> call, Throwable t) {
////                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        call.enqueue(new Callback<List<Mejora>>() {
//            @Override
//            public void onResponse(Call<List<Mejora>> call, Response<List<Mejora>> response) {
//                List<Mejora> ListMejora = response.body();
//
//                if (ListMejora != null && ListMejora.size() > 0) {
//                    List<Integer> lista;
//                    lista = new ArrayList<>();
//                    for (int i = 0; i < ListMejora.size(); i++) {
//
//
//
//                        if (ListMejora.get(i).getAutor() == 0 || ListMejora.get(i).getAutor() == 0 ) {
//                            lista.add(ListMejora.get(i).getAutor());
//
//
//
//                        }
////                        ArrayAdapter<Integer> spinnerArrayAdapter = new ArrayAdapter<Integer>(getActivity(), android.R.layout.simple_dropdown_item_1line,lista);
////                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////                        spiAutor.setAdapter(spinnerArrayAdapter);
//
//                    }
//
//                }
//
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Mejora>> call, Throwable t) {
////                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        call.enqueue(new Callback<List<Mejora>>() {
//            @Override
//            public void onResponse(Call<List<Mejora>> call, Response<List<Mejora>> response) {
//                List<Mejora> ListMejora = response.body();
//
//                if (ListMejora != null && ListMejora.size() > 0) {
//                    List<Integer> lista;
//                    lista = new ArrayList<>();
//                    for (int i = 0; i < ListMejora.size(); i++) {
//
//
//
//                        if (ListMejora.get(i).getEmpresa() == 0 || ListMejora.get(i).getEmpresa() == 1  ) {
//                            lista.add(ListMejora.get(i).getEmpresa());
//
//
//
//                        }
////                        ArrayAdapter<Integer> spinnerArrayAdapter = new ArrayAdapter<Integer>(getActivity(), android.R.layout.simple_dropdown_item_1line,lista);
////                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////                        spiEmpresa.setAdapter(spinnerArrayAdapter);
//
//                    }
//
//                }
//
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Mejora>> call, Throwable t) {
////                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnGuardarMejora:
                RegistrarMejoraClick();
                break;
            case R.id.btnListarMejoras:
                ListarMejoras();
                break;

        }
    }
    public void replaceFragment(Fragment someFragment) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    public void ListarMejoras()
    {
        Fragment fragment = null;
        fragment = new ListarMejoras();
        replaceFragment(fragment);

    }


    public void RegistrarMejoraClick() {
//        String selec = (String) spiEstado.getSelectedItem();


//        String selec2 = (String) spiAutor.getSelectedItem();
//        int posicionPunto2 = selec2.indexOf(',');
//        String sHastaPrimerPunto2 = selec2.substring(0,posicionPunto2);
//        int value2 = Integer.parseInt(sHastaPrimerPunto2.trim());

//        String selec3 = (String) spiEstado.getSelectedItem();
//        int posicionPunto = selec3.indexOf(',');
//        String sHastaPrimerPunto = selec3.substring(0,posicionPunto);
//        int value3 = Integer.parseInt(sHastaPrimerPunto.trim());

        String nombremejo = txtNombreMejora.getText().toString();

        String descripcionmejo = txtDescripcionMejora.getText().toString();
        String validacionmejora = txtEstadoMejora.getText().toString();;
       Integer autor =  Integer.parseInt(txtAutorMejora.getText().toString());
        Integer empresa = Integer.parseInt(txtEmpresaMejora.getText().toString());




        Mejora MejoraModel = new Mejora(

                nombremejo,
                descripcionmejo,
                validacionmejora,
                autor,
                empresa

        );


        if (!IsEmptyEditTextAcci()){
            if (InternetUtil.isInternetOnline(getActivity())){
                RegisterInServer(MejoraModel);

            }

        }


    }

    private void RegisterInServer(Mejora MejoraModel) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PostApi.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        PostApi postApi= retrofit.create(PostApi.class);
        Call<Mejora> call = postApi.registrarMejora(MejoraModel);

        call.enqueue(new Callback<Mejora>() {
            @Override
            public void onResponse(Call<Mejora> call, Response<Mejora> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        SharedPreferences preferences = getActivity().getSharedPreferences("myPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor prefLoginEdit = preferences.edit();
                        prefLoginEdit.putBoolean("registrar",true);
                        prefLoginEdit.commit();

                        Toast.makeText(getContext(), "Asesoria por Accidente realizada exitosamente", Toast.LENGTH_SHORT).show();
//                        limpieza();

                    }

                }else {
                    Toast.makeText(getContext(), "Error!! puede que ya se haya creado una una asesoria anexada a esa solicitud.Pruebe recargando la Ventana", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Mejora> call, Throwable t)  {
                Log.d("fail", "fail");
            }
        });
    }



    private boolean IsEmptyEditTextAcci() {
        if(txtNombreMejora.getText().toString().isEmpty() ||
                txtDescripcionMejora.getText().toString().isEmpty()){

            Toast toast = Toast.makeText(getActivity(),"Campos vacios", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();


            return true;
        }else{
            return false;
        }
    }




//    public  void cargarSpinner(){
//
//        List<String> estado;
//        estado = new ArrayList<>();
//
//        estado.add("En proceso");
//        estado.add("Validada");
//
//
//                            ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,estado);
//                        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                        spiEstado.setAdapter(spinnerArrayAdapter);
//    }
}