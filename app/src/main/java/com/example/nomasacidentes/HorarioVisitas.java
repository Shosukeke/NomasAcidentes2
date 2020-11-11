package com.example.nomasacidentes;

import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
/*
import androidx.appcompat.app.AppCompatActivity;

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

public class HorarioVisitas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_visitas);

        final TextView txtHorario = (TextView) findViewById(R.id.txtHorario);
        final TextView txtHora = (TextView) findViewById(R.id.txtHora);
        /*
        RequestQueue queue = Volley.newRequestQueue(this);
//      Url del mock de prueba (Mocky es la API utilizada)
//      Se utilizo este mock de prueba ya que el restFramework se encuentra en produccion
        String url = "https://run.mocky.io/v3/a48c78bf-6ea6-4517-8b3b-d3a84fdfbf95";
//      Request de Json para obtener datos
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
//                definicion de variable "Key" con valor "eventos" ya que el atributo en el objeto Json se llama "Eventos". Revisar Movky
                String key = "eventos";
                JSONArray eventos = null;

                try {
//                    el motodo usado es getJsonArray porque el tipo de dato de "eventos" es un Array
                    eventos = response.getJSONArray(key);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < eventos.length(); i++) {
                    try {
//                      la variable "evento" obtiene el valor del Array en la posicion i contenido en objeto Json"Eventos"
                        JSONObject evento = eventos.getJSONObject(i);
//                        se asigna el valor del atributo "titulo" del ObjetoJson("evento") al String "titulo"
                        String titulo = evento.getString("titulo");
//                        se asigna el valor del atributo "titulo" del ObjetoJson("evento") al String "titulo"
                        String hora = evento.getString("inicio");

                        txtHorario.setText(titulo);
                        txtHora.setText(hora);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                txtHorario.setText("No Funca: ");
            }
        });
        queue.add(jsonObjectRequest);
        /*
         */
    }


}

