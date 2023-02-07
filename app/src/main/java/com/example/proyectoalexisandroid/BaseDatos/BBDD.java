package com.example.proyectoalexisandroid.BaseDatos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.proyectoalexisandroid.Data.Jugador;

import java.util.ArrayList;

/**
 * BBDD es una clase utilzada para crear la base de datos
 * y crear todas las tablas necesarias para funcionar la aplicación
 *
 * @author Alexis Aquino Miranda
 * @version v1.0
 */
public class BBDD extends SQLiteOpenHelper {
    public static int version = 1;

    public static String nombreBase = "Mundial";
    public static String nombreTable = "jugadores";

    Context context;

    public BBDD(@Nullable Context context) {
        super(context, nombreBase, null, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //creación de tabla de todos los jugadores
        db.execSQL("create table " + nombreTable + "( " + "nombre TEXT NOT NULL," + "apellido TEXT NOT NULL," +
                "imagen TEXT NOT NULL,"
                + "pais TEXT NOT NULL,"
                + "MeGusta TEXT NOT NULL," +
                "dorsal INTEGER NOT NULL)");
        //creación de tabla de mis jugadores
        db.execSQL("create table misJugadores " + "( " + "nombre TEXT NOT NULL," + "apellido TEXT NOT NULL," +
                "imagen TEXT NOT NULL,"
                + "pais TEXT NOT NULL,"
                + "MeGusta TEXT NOT NULL," +
                "dorsal INTEGER NOT NULL)");

        System.out.println("creado");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table " + nombreTable + ";");
        db.execSQL("drop table  misJugadores ;");
    }

    /**
     * método que inserta todos los datos en la base de datos {de todos los jugadores del mudial.}
     */
    public void insertarDatosJugador(Jugador player) {
        SQLiteDatabase bd;
        BBDD adminBD = new BBDD(context);
        bd = adminBD.getWritableDatabase();

        String meGusta = String.valueOf(player.isLike());

        bd.execSQL("INSERT INTO JUGADORES" + " VALUES('" + player.getNombre() + "','"
                + player.getApellido() + "','" + player.getImagen() + "','"
                + player.getPais() + "','" + meGusta + "', " + player.getDorsal() + ");");
    }

    /**
     * añadir dato a la tabla de mis jugadores
     *
     * @param player
     */
    public void addMisJugadores(Jugador player) {
        SQLiteDatabase bd;
        BBDD adminBD = new BBDD(context);
        bd = adminBD.getWritableDatabase();

        String meGusta = String.valueOf(player.isLike());

        bd.execSQL("INSERT INTO MISJUGADORES VALUES('" + player.getNombre() + "','"
                + player.getApellido() + "','" + player.getImagen() + "','"
                + player.getPais() + "','" + meGusta + "', " + player.getDorsal() + ");");
    }


    /**
     * Método en donde obtengo mis jugadores que he obtenido
     * para posteriomente visualizarlo en la lista de MIS JUGADORES
     *
     * @return Lista de todos los jugadores que he obtenido.
     */
    public ArrayList<Jugador> getMyPlayers() {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        SQLiteDatabase bd;
        Jugador obtenido = null;
        BBDD adminBD = new BBDD(context);
        bd = adminBD.getWritableDatabase();

        Cursor fila = bd.rawQuery("SELECT * FROM  misJugadores", null);

        if (fila.getCount() > 0) {
            fila.moveToFirst();
            for (int i = 0; i < fila.getCount(); i++) {
                String name = fila.getString(0);
                String lastName = fila.getString(1);
                String imagen = fila.getString(2);
                String pais = fila.getString(3);
                String meGusta = fila.getString(4);
                int dorsal = fila.getInt(5);
                obtenido = new Jugador(name, lastName, imagen, pais, Boolean.parseBoolean(meGusta), dorsal);
                listaJugadores.add(obtenido);
                System.out.println(obtenido.toString());
                fila.moveToNext();
            }
        }
        return listaJugadores;
    }

    /**
     * método que retorna todos los datos que tengo de todos los jugadores
     *
     * @return lista de todos los jugadores disponibles
     */
    public ArrayList<Jugador> getAllPlayers() {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        SQLiteDatabase bd;
        Jugador obtenido = null;
        BBDD adminBD = new BBDD(context);
        bd = adminBD.getWritableDatabase();

        Cursor fila = bd.rawQuery("SELECT * FROM " + nombreTable, null);

        if (fila.getCount() > 0) {
            fila.moveToFirst();
            for (int i = 0; i < fila.getCount(); i++) {
                String name = fila.getString(0);
                String lastName = fila.getString(1);
                String imagen = fila.getString(2);
                String pais = fila.getString(3);
                String meGusta = fila.getString(4);
                int dorsal = fila.getInt(5);
                obtenido = new Jugador(name, lastName, imagen, pais, Boolean.parseBoolean(meGusta), dorsal);
                listaJugadores.add(obtenido);
                obtenido.toString();
                fila.moveToNext();
            }
        }
        return listaJugadores;
    }


}
