package com.example.proyectoalexisandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * La clase DatosTarjeta es una ventana en donde simula una compra
 * y se rellena los datos de las tarjetas para realizar dicha acción.
 *
 * @author Alexis Aquino Miranda
 * @version v1.0
 */
public class DatosTarjeta extends AppCompatActivity {
    Button btnCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_tarjeta);
        btnCompra = findViewById(R.id.buttonAceptPago);
        eventos();


    }

    /**
     * eventos es un método que gestiona las acciónes que van a realizar
     * cada botón, entrada del usuario para comprobar si los datos están
     * rellenos o no.
     */
    void eventos() {
        btnCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(DatosTarjeta.this, GetJugadorRandom.class);
                startActivity(myIntent);
            }
        });
    }
}