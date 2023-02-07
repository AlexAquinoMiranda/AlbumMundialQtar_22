package com.example.proyectoalexisandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * La clase Home es una clase de ventana principal de la aplicación,
 * en donde tiene tres botones que serían las principales funcionalidades
 * las cuales serían:
 * <ul><li>botón Lista de mis jugadores </li>
 * <li> botón lista de todos los jugadores</li>
 * <li>botón obtener jugadores</li></ul>
 * @author Alexis Aquino Miranda
 * @version v1.0
 */
public class Home extends AppCompatActivity {
    Button btnLista;
    Button btnMiLista;
    Button btnGetJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnGetJugador = findViewById(R.id.btnObtenerJugador);
        btnMiLista = findViewById(R.id.btnListMyPlayers);
        btnLista = findViewById(R.id.btnListPlayers);
        // btnLista = findViewById(R.id.btnListMyPlayers);


        btnMiLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Home.this, MisJugadores.class);
                startActivity(myIntent);
            }
        });
        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Home.this, ListaJugadores.class);
                startActivity(myIntent);
            }
        });
        btnGetJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Home.this, GetJugadorRandom.class);
                startActivity(myIntent);
            }
        });

    }
}