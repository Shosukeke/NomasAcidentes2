package com.example.nomasacidentes;



import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;

import com.example.nomasacidentes.model.Item;

import java.util.ArrayList;

public class formulario extends AppCompatActivity {
    TextView txt_pregunta;
    Button btn_cumple,btn_Nocumple,btn_guardar;
    Preguntas mPreguntas;
    ArrayList<Item> listaPreguntas;
    int preguntasLength;
    int preguntaActual=0;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        textView.setMovementMethod(new ScrollingMovementMethod());

        txt_pregunta=(TextView)findViewById(R.id.txt_pregunta);
        btn_cumple=(Button)findViewById(R.id.btn_cumple);
        btn_Nocumple=(Button)findViewById(R.id.btn_noCumple);
        btn_guardar=(Button)findViewById(R.id.btn_guardar);


        mPreguntas = new Preguntas();
        preguntasLength=mPreguntas.mPreguntas.length;
        listaPreguntas=new ArrayList<>();
        for (int i=0;i<preguntasLength;i++)
        {
            listaPreguntas.add(new Item(mPreguntas.getmPreguntas(i)));
        }

        setPregunta(preguntaActual);
        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_cumple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preguntaActual++;
                if (preguntaActual<preguntasLength){
                    setPregunta(preguntaActual);
                }else{
                    txt_pregunta.setText("No hay mas preguntas");
                }

            }
        });
        btn_Nocumple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preguntaActual++;
                if (preguntaActual<preguntasLength){
                    setPregunta(preguntaActual);
                }else{
                    txt_pregunta.setText("No hay mas preguntas");
                }

            }
        });

    }
    private  void  setPregunta(int number){
        txt_pregunta.setText(listaPreguntas.get(number).getPregunta());

    }

    }