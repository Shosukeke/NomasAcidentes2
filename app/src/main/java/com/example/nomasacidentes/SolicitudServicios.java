package com.example.nomasacidentes;

//import androidx.appcompat.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
/*
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
*/
public class SolicitudServicios extends AppCompatActivity {

    Button btnCancelar;
    TextView txtRut;
    TextView editTxtFecha;
    TextView editTextHora;

 /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_servicios);
         final TextView txtRut = (TextView) findViewById(R.id.txtRut);
        final TextView editTxtFecha = (TextView) findViewById(R.id.editTxtFecha);
        final TextView editTextHora = (TextView) findViewById(R.id.editTextHora);

        RequestQueue queue = Volley.newRequestQueue(this);

        String url="https://run.mocky.io/v3/aa4e3757-11af-43ce-b56d-d2d88464e5a7";



        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                definicion de variable "Key" con valor "eventos" ya que el atributo en el objeto Json se llama "Eventos". Revisar Movky
                String key = "servicios";
                JSONArray servicios =null;

                try {
                    servicios=response.getJSONArray(key);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                for (int i=0; i<servicios.length();i++){

                    try {
                        JSONObject servicio =servicios.getJSONObject(i);
                        String rutEmpre = servicio.getString("rutEmpre");
                        String tipoServ = servicio.getString("tipoServ");
                        String fechaServ = servicio.getString("fechaServ");
                        String hora = servicio.getString("hora");

                        txtRut.setText(rutEmpre);
                        editTxtFecha.setText(fechaServ);
                        editTextHora.setText(hora);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txtRut.setText("No Funca: ");
            }
        });
        queue.add(jsonObjectRequest);









        Spinner spinner = findViewById(R.id.spinnerTipoServicio);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.combo_servicios, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        btnCancelar = findViewById(R.id.btnCancelar1);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
    */

}

