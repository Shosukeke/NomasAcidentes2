package com.example.nomasacidentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SolicitudServicios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_servicios);
        Spinner spinner = findViewById(R.id.spinnerTipoServicio);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.combo_servicios, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

    }
}