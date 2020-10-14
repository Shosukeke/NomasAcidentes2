package com.example.nomasacidentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.sql.*;
import java.text.BreakIterator;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_ingresar=(Button)findViewById(R.id.btn_ingresar);
        final EditText pUser =(EditText)findViewById(R.id.txtuser) ;
        final String user2="seba";
        final String userRecibido = getIntent().getStringExtra("pUser");
        String passRecibido = getIntent().getStringExtra("pPassword");
        final TextView msj2 = findViewById(R.id.msj2);
        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* if (userRecibido.toString()==user2.toString())
                {
                    msj2.setText("Bienvenido al sistema usuario "+userRecibido);
                }else {
                    msj2.setText("Las credenciales ingresadas son incorrectas");}*/
                Intent login=new Intent(MainActivity.this, BotonesVistas.class);
                MainActivity.this.startActivity(login);
                finish();




            }
        });
    }
}