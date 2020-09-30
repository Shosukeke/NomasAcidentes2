package com.example.nomasacidentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import java.sql.*;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_ingresar=(Button)findViewById(R.id.btn_ingresar);
        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* try {
                    ConnectOra conn =new ConnectOra("10.0.2.2","orcl","Portafolio","SEBA","qwerty");

                }catch (Exception e){}*/
                Intent login=new Intent(MainActivity.this,GestionVista.class);
                MainActivity.this.startActivity(login);
                finish();

            }
        });
    }
}