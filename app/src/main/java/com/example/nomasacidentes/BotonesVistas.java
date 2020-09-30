package com.example.nomasacidentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BotonesVistas extends AppCompatActivity {

    Button btnInDatos, btnFormulario, btnSolicitud ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botones_vistas);

        btnInDatos = findViewById(R.id.btnInDatos);
        btnFormulario = findViewById(R.id.btnFormulario);
        btnSolicitud = findViewById(R.id.btnSolicitud);

        btnInDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent datos=new Intent(BotonesVistas.this,DatosEmpresa.class);
                BotonesVistas.this.startActivity(datos);
            }
        });

        btnFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Formulario=new Intent(BotonesVistas.this,formulario.class);
                BotonesVistas.this.startActivity(Formulario);
            }
        });

        btnSolicitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Solicitud=new Intent(BotonesVistas.this,SolicitudServicios.class);
                BotonesVistas.this.startActivity(Solicitud);
            }
        });
    }
}