package com.example.nomasacidentes;




public class Preguntas {
       public String mPreguntas[]={

           "¿La empresa constantemente les recuerda las normas de seguridad?",
            "¿Existen diferentes tipos de seguridad en las diferentes areas de trabajo?",
            "¿La empresa imparte constantes capacitaciones de seguirdad?",
            "¿la información que brinda es suficiente?",
            "¿Se revisa que los trabajadores porten el equipo de seguiridad adecuado?",
            "¿Cuenta con elequipo de segurdad adecuado por parte de la empresa?",
            "¿Cuales son los accidentes más comunes en tu área?",
            "¿Existen algún protocolo a seguir en caso de un percance en la empresa?",
            "¿que zona es más suseptible a un accidente?",
            "¿Han sufrido algún accidente?",
            "¿Cuál fue lacause que origino el accidente? "

    };

    public String mRespuestas[]={
            "Cumple"
    };


    public String getmPreguntas(int number){
        return mPreguntas[number];

    };
    public String getmRespuesta(int number){
        return mRespuestas[number];

    };




}
