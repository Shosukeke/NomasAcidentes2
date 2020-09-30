package com.example.nomasacidentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SolicitudServicios extends AppCompatActivity {

    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_servicios);
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
}