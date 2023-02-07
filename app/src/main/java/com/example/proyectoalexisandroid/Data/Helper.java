package com.example.proyectoalexisandroid.Data;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    public FicheroAllJugadores getFichero() {
        return fichero;
    }

    public static FicheroAllJugadores fichero;

    public void rellenoJugadores() {
        fichero = new FicheroAllJugadores();
        int dorsal = 1;
        fichero.addJugador(new Jugador("Leandro", "Parédez", "leoparedez", "argentina", false, dorsal));
        fichero.addJugador(new Jugador("Leo", "Messi", "messi", "argentina", false, dorsal));
        fichero.addJugador(new Jugador("Killiam", "Mbappé", "mbappe", "france", false, dorsal));
        fichero.addJugador(new Jugador("Cristiano", "Ronaldo", "cristiano", "france", false, dorsal));
        fichero.addJugador(new Jugador("Neymar", "Jr", "neymar", "brazil", false, dorsal));
        fichero.addJugador(new Jugador("Vinnicius", "Jr", "vini", "brazil", false, dorsal));
        fichero.addJugador(new Jugador("Emiliano", "Martínez", "emilio", "argentina", false, dorsal));
        fichero.addJugador(new Jugador("Julián", "Álvarez", "julian", "argentina", false, dorsal));
        fichero.addJugador(new Jugador("Antoine", "Griezman", "griezman", "france", false, dorsal));
        fichero.addJugador(new Jugador("Robert", "Lewandowski", "robert", "brazil", false, dorsal));
        fichero.addJugador(new Jugador("Luka", "Modrich", "luka", "croatia", false, dorsal));
        fichero.addJugador(new Jugador("Luis", "Suarez", "suarez", "croatia", false, dorsal));
        Log.i("----", "Cargando datos de juagdores");

        System.out.println(fichero.findId(1).toString());
    }

    public Jugador obtenerJugador(int i) {
        return this.fichero.findId(i);
    }

    /**
     * insertarTodoJugador es un método que contiene un arrayList de todos los jugadores que va a formar parte
     * mi aplicación.
     * @return lista de todos los jugadores de mi app
     */
    public ArrayList<Jugador> insertarTodoJugador() {
        ArrayList<Jugador> fichero = new ArrayList<>();
        fichero.add(new Jugador("Leandro", "Parédez", "leoparedez", "argentina", false, 8));
        fichero.add(new Jugador("Leo", "Messi", "messi", "argentina", false, 10));
        fichero.add(new Jugador("Killiam", "Mbappé", "mbappe", "france", false, 10));
        fichero.add(new Jugador("Cristiano", "Ronaldo", "cristiano", "portugal", false, 7));
        fichero.add(new Jugador("Neymar", "Jr", "neymar", "brazil", false, 10));
        fichero.add(new Jugador("Vinnicius", "Jr", "vini", "brazil", false, 7));
        fichero.add(new Jugador("Emiliano", "Martínez", "emilio", "argentina", false, 23));
        fichero.add(new Jugador("Julián", "Álvarez", "julian", "argentina", false, 9));
        fichero.add(new Jugador("Antoine", "Griezman", "griezman", "france", false, 8));
        fichero.add(new Jugador("Robert", "Lewandowski", "robert", "polonia", false, 9));
        fichero.add(new Jugador("Luka", "Modrich", "luka", "croatia", false, 10));
        fichero.add(new Jugador("Luis", "Suarez", "suarez", "uruguay", false, 9));

        return fichero;
    }
}
