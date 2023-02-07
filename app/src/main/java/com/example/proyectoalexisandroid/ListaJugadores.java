package com.example.proyectoalexisandroid;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.proyectoalexisandroid.Adaptador.JugadorAdapter;
import com.example.proyectoalexisandroid.BaseDatos.BBDD;
import com.example.proyectoalexisandroid.Data.FicheroAllJugadores;
import com.example.proyectoalexisandroid.Data.Helper;
import com.example.proyectoalexisandroid.Data.Jugador;

import java.util.ArrayList;

/**
 * ListaJugadores es una clase que contiene los datos de todos los
 * jugadores favoritos del mundial en donde posteriormente se va a
 * visualizar en un RecyclerView del cual los datos se recogen de
 * una clase java de apoyo llamada BBDD en donde tiene el método
 * getAllPlayers para posteriormente pasarlo al Adapter.
 * @author: Alexis Aquino Miranda
 * @version v1.0
 */
public class ListaJugadores extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton atras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_jugadores);

        atras = findViewById(R.id.listaAtras);
        //evento de botón que te lleva una ventana anterior
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ListaJugadores.this, Home.class);
                startActivity(myIntent);
            }
        });
        recyclerView = findViewById(R.id.recicler);

        //recycler en donde le pasamos el tipo de layout que va a procesar
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //instancia de bbdd en donde contiene el listado de todos los jugadores
        BBDD bd = new BBDD(this);
        //instanica de Adapter en donde le mando el ArrayList de todos los jugadores
        JugadorAdapter adapter = new JugadorAdapter(bd.getAllPlayers(), this);
        recyclerView.setAdapter(adapter);

    }
}