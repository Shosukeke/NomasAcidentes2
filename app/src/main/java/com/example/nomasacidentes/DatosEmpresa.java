package com.example.nomasacidentes;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;


public class DatosEmpresa extends AppCompatActivity {
    Button btnCancelar;
    Button btnGuardar;
    TextView txtNomEmpresa;
    TextView txtRutEmpresa;
    TextView txtCorreo;
    TextView txtTelefono;
    TextView txtDireccion;
    TextView txtRubro;

    String nombreEmpre;
    String empresa;
    String correo;
    String telefono;
    String direccion;
    String rubro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_empresa);
        btnCancelar = findViewById(R.id.btnCancelar1);
        btnGuardar = findViewById(R.id.btnGuardar);

        final TextView txtNomEmpresa = findViewById(R.id.txtNomEmpresa);
        final TextView txtRutEmpresa = findViewById(R.id.txtRutEmpresa);
        final TextView txtCorreo = findViewById(R.id.txtCorreo);
        final TextView txtTelefono = findViewById(R.id.txtTelefono);
        final TextView txtDireccion = findViewById(R.id.txtDireccion);
        final TextView txtRubro = findViewById(R.id.txtRubro);
        final RequestQueue queue = Volley.newRequestQueue(this);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        btnGuardar.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {


                                              nombreEmpre = txtNomEmpresa.getText().toString();
                                              empresa = txtRutEmpresa.getText().toString();
                                              correo = txtCorreo.getText().toString();
                                              telefono = txtTelefono.getText().toString();
                                              direccion = txtDireccion.getText().toString();
                                              rubro = txtRubro.getText().toString();

                                              JSONObject jsonBody = new JSONObject();
                                              try {
                                                  jsonBody.put("nombre_empre", nombreEmpre);
                                                  jsonBody.put("direccion_empre", direccion);
                                                  jsonBody.put("correo_empre", correo);
                                                  jsonBody.put("rubro_empre", rubro);
                                                  jsonBody.put("fono_empre", telefono);
                                                  jsonBody.put("user", 2);
                                              } catch (JSONException e) {
                                                  e.printStackTrace();
                                              }

                                              final String mRequestBody = jsonBody.toString();
                                              String url = "https://fffac35e011d.ngrok.io/api/Empresas/";

                                              StringRequest postEmpresaRequest = new StringRequest(
                                                      Request.Method.POST,
                                                      url,
                                                      new Response.Listener<String>() {
                                                          @Override
                                                          public void onResponse(String response) {
                                                              Log.i("LOG_RESPONSE", response);
                                                          }
                                                      }, new Response.ErrorListener() {
                                                  @Override
                                                  public void onErrorResponse(VolleyError error) {
                                                      Log.e("LOG_RESPONSE", error.toString());
                                                  }
                                              }) {
                                                  @Override
                                                  public String getBodyContentType() {
                                                      return "application/json; charset=utf-8";
                                                  }

                                                  @Override
                                                  public byte[] getBody() throws AuthFailureError {
                                                      try {
                                                          return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                                                      } catch (UnsupportedEncodingException uee) {
                                                          VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", mRequestBody, "utf-8");
                                                          return null;
                                                      }
                                                  }

                                                  @Override
                                                  protected Response<String> parseNetworkResponse(NetworkResponse response) {
                                                      String responseString = "";
                                                      if (response != null) {
                                                          responseString = String.valueOf(response.statusCode);
                                                      }
                                                      return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                                                  }
                                              };
                                              queue.add(postEmpresaRequest);

                                          }
                                      }
        );


    }
}