package com.example.proyectoalexisandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectoalexisandroid.BaseDatos.BBDD;
import com.example.proyectoalexisandroid.Data.FicheroAllJugadores;
import com.example.proyectoalexisandroid.Data.Helper;
import com.example.proyectoalexisandroid.Data.Jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La clase GetJugadorRandom utilizada para la obtención de
 * fichas de jugadores para posteriormente añadirlas a la
 * lista de mis jugadores obtenidos.
 *
 * @author Alexis Aquino Miranda
 * @version v1.0
 */
public class GetJugadorRandom extends AppCompatActivity {
    Button btnComprarToken;
    Button btnObtenerJugador;
    TextView cantidadTokens;
    TextView nombreObtenido;
    ImageView imagenJugador;
    FloatingActionButton atras;

    public ArrayList<Jugador> getMisJugadores() {
        return misJugadores;
    }

    public static ArrayList<Jugador> misJugadores = new ArrayList<>();
    static int tokenActual = CompraToken.unidadToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_jugador_random);

        btnObtenerJugador = findViewById(R.id.btnGetPlayer);
        nombreObtenido = findViewById(R.id.NombreObtenido);
        atras = findViewById(R.id.getAtras);
        btnComprarToken = findViewById(R.id.btnObtenerToken);
        cantidadTokens = findViewById(R.id.CantidadTokens);
        imagenJugador = findViewById(R.id.imagenPlayer);
        cantidadTokens.setText(String.valueOf(CompraToken.unidadToken));

        eventos();


    }

    /**
     * obtener un jugador aleatorio y agregarlo a la base de datos de 'mis jugadores'
     */
    void getJugadores() {
        BBDD datos = new BBDD(getApplicationContext());
        List<Jugador> listaDeMisJugadores = datos.getMyPlayers();//mis jugadores
        List<Jugador> listaJugadores = datos.getAllPlayers();//todos los jugadores


        Random r = new Random();
        /**
         * FALTA QUE EL RANDOM SEA LA LONGITUD DE LA LISTA QUE DEVUELVE LA BBDD
         */
        int value = r.nextInt(11);//longitud de la lista de jugadores disponibles

        Jugador obtenido = listaJugadores.get(value);

        if (listaDeMisJugadores.contains(obtenido)) {
            System.out.println("obtiene yaaaaa");
        }
        if (listaDeMisJugadores.size() > 0) {
            boolean contiene = false;
            for (Jugador a : listaDeMisJugadores) {
                System.out.println(obtenido.getNombre() == a.getNombre() && a.getApellido() == obtenido.getApellido());
                if (obtenido.getNombre() == a.getNombre() && a.getApellido() == obtenido.getApellido()) {

                    System.out.println("son iguales");
                    contiene = true;
                    System.out.println(contiene);
                    break;
                }
            }
            if (contiene == false) {
                System.out.println("se esta agregando al jugador a la lista");
                datos.addMisJugadores(obtenido);
            }

        } else if (listaDeMisJugadores.size() == 0) {
            System.out.println("se esta agregando al jugador a la lista");
            datos.addMisJugadores(obtenido);
        }

        String uri = "@drawable/" + obtenido.getImagen();
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable imagen = ContextCompat.getDrawable(getApplicationContext(), imageResource);
        imagenJugador.setImageDrawable(imagen);
        nombreObtenido.setText(obtenido.getNombre() + "  " + obtenido.getApellido());

        System.out.println("el jugador obtenido aleatroio es = \n" + obtenido.toString());


    }

    /**
     * método que comprueba si tienes tokens disponibles para que
     * avise al usuario de realizar la compra.
     */
    void sinToken() {

        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);

        dialogo.setTitle("Información");
        dialogo.setMessage("Te has quedado sin tokens \n ¿Deseas comprar?");
        dialogo.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                System.out.println("se va a comprar");
                Intent myIntent = new Intent(GetJugadorRandom.this, CompraToken.class);
                startActivity(myIntent);
                dialog.cancel();
            }
        });
        dialogo.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dialogo.create();

        dialogo.show();
    }

    /**
     * Eventos es un método en donde gestiona los eventos de los botones que contiene el layout.
     * <ul> <li> botón volver atrás</li>
     * <li> botón comprar tokens </li>
     * <li> botón obtener jugador random </li>
     * </ul>
     */
    private void eventos() {
        //evento de volver una ventana atrás
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(GetJugadorRandom.this, Home.class);
                startActivity(myIntent);
            }
        });
        //evento de abrir la ventana para comprar tokens
        btnComprarToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(GetJugadorRandom.this, CompraToken.class);
                startActivity(myIntent);
            }
        });
        //evento para obtener jugadores random
        // si tiene tokens realiza la acción en caso contrario te avisa que no hay tokens
        btnObtenerJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CompraToken.unidadToken == 0) {
                    sinToken();
                } else {
                    getJugadores();
                    CompraToken.unidadToken--;
                    cantidadTokens.setText(String.valueOf(CompraToken.unidadToken));
                }
            }
        });
    }
}