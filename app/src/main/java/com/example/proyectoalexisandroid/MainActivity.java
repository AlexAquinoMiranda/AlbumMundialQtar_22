package com.example.proyectoalexisandroid;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.proyectoalexisandroid.BaseDatos.BBDD;
import com.example.proyectoalexisandroid.Data.FicheroAllJugadores;
import com.example.proyectoalexisandroid.Data.Helper;
import com.example.proyectoalexisandroid.Data.Jugador;

import java.io.File;
import java.io.IOException;

/**
 * La clase MainActivity en donde es la primera pantalla que carga al iniciar
 * la aplicación y inicia la base de datos, en donde si no existe las tablas y los datos
 * los debe de insertar
 *
 * @author Alexis Aquino Miranda
 * @version v1.0
 */
public class MainActivity extends AppCompatActivity {
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagen = findViewById(R.id.imageView2);

        Toast.makeText(MainActivity.this, "Click en la imagen para continuar.", Toast.LENGTH_LONG).show();
        Toast.makeText(MainActivity.this, "Click en la imagen para continuar.", Toast.LENGTH_LONG).show();


        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Home.class);
                startActivity(myIntent);
                event();
                crearbd();
                //insert();

            }
        });


    }

    /**
     * Insert es un método que crea una instancia de la base de datos
     * en donde debe comprobar si ya existe la base de datos y las tablas
     * en caso contrario los crea y rellena.
     */
    void insert() {
        BBDD bd = new BBDD(getApplicationContext());
        SQLiteDatabase base = bd.getWritableDatabase();
        Helper help = new Helper();
        for (Jugador player : help.insertarTodoJugador()) {
            bd.insertarDatosJugador(player);
        }
    }

    /**
     * método que realiza instancia de la base de datos,
     * comprueba si no es nula y devuelve un toast informando de la situación
     */
    private void crearbd() {
        BBDD bd = new BBDD(getApplicationContext());
        SQLiteDatabase base = bd.getWritableDatabase();
        Helper help = new Helper();
        if (base != null) {
            Toast.makeText(MainActivity.this, "se ha creado la BBDD  de 4 tablas", Toast.LENGTH_LONG).show();
            //  base.execSQL("DROP TABLE IF EXISTS jugadores");
        } else {
            Toast.makeText(MainActivity.this, "no se ha podido  crear la BBDD :c", Toast.LENGTH_SHORT).show();
        }

    }


    /**
     * método utilizado para crear ficheros, en caso de que el fichero no existe, lo crea y rellena la lista de jugadoress
     * FALTA RELLENAR LSO FICHEROS
     *
     * @deprecated ELIMINAR ESTE METODOO
     */
    void event() {
        File f = new File("/data/user/0/com.example.proyectoalexisandroid/misJugadores.txt");
        File fil = new File("/data/user/0/com.example.proyectoalexisandroid/ficheroJugadores.txt");
        try {
            if (f.exists()) {
                System.out.println("el fichero de 'mis jugadores' ya existe");
            } else {
                f.createNewFile();
                //rellenar el fichero.
            }
            if (fil.exists()) {
                System.out.println("el fichero de todos los jugadores ya existe.");
            } else {
                fil.createNewFile();
                //rellenar el fichero
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}