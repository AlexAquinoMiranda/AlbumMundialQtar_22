package com.example.proyectoalexisandroid.Data;

import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * falta crear una lista en donde tenga a todos los jugadores
 * yyyy, una lista llamada 'mis jugadores' en donde voy a ir
 * agregando los que he conseguido
 */
public class FicheroAllJugadores {

    private ArrayList<Jugador> jugadores = new ArrayList<>();

    /**
     * lista de los jugadores que he obtenido...
     *
     * @return
     */
    public ArrayList<Jugador> getMisjugadores() {
        return Misjugadores;
    }

    private ArrayList<Jugador> Misjugadores = new ArrayList<>();

    /**
     * lista de todos los jugadores que tengo.
     *
     * @return lista de todos los jugadores
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void addJugador(Jugador player) {
        this.jugadores.add(player);
    }

    /**
     * añadir jugadores a mi lista de jugadores obtenidas, las cuales voy a almacenar
     *
     * @param player player is lista de mis  jugadores
     */
    public void addMisJugador(Jugador player) {
        this.Misjugadores.add(player);
    }

    /**
     * eliminar un jugador
     * @param player
     */
    public void delete(Jugador player) {
        this.jugadores.remove(this.jugadores.lastIndexOf(player));
    }


    public ArrayList<Jugador> allPlayer() {
        return this.jugadores;

    }

    public Jugador findId(int id) {
        return this.jugadores.get(id);
    }
    void clear() {

    }

    /**
     * metodo que escribe lo que hay en la lista en el fichero.(mis jugadores)
     */
    public void guardarDatoMisJugadores() {
        File file = null;
        FileWriter writer = null;
        try {
            file = new File("/data/user/0/com.example.proyectoalexisandroid/misJugadores.txt");
            System.out.println(file.exists() + " <- exite y se puede escribir -> " + file.canWrite() + "\n" + file.getAbsolutePath());
            writer = new FileWriter(file);
            System.out.println("escribiemdp ");
            Log.i("----info---", "estoy escribiendo");
            writer.append(this.jugadores.size() + "\n");
            for (Jugador a : this.jugadores) {
                writer.append(a.toString());
                System.out.println(a.toString());
            }
            this.jugadores.clear();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    System.out.println("cerramdo");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * metodo que escribe lo que hay en la lista en el fichero.
     */
    public void escribirFichero() {
        File file = null;
        FileWriter writer = null;
        try {
            file = new File("/data/user/0/com.example.proyectoalexisandroid/ficheroJugadores.txt");
            System.out.println(file.exists() + " <- exite y se puede escribir -> " + file.canWrite() + "\n" + file.getAbsolutePath());
            writer = new FileWriter(file);
            System.out.println("escribiemdp ");
            Log.i("----info---", "estoy escribiendo");
            writer.append(this.jugadores.size() + "\n");
            for (Jugador a : this.jugadores) {
                writer.append(a.toString());
                System.out.println(a.toString());
            }
            this.jugadores.clear();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    System.out.println("cerramdo");
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * leo el fichero y lo cargo a mi lista de mis jugadores
     */
    public void cargarMisJugadores() {
        File fichero = null;
        FileReader fr = null;
        BufferedReader buffer = null;
        String nombre;
        String apellido;
        String imagen;
        String pais;
        boolean like;
        int dorsal;
        try {
            fichero = new File("/data/user/0/com.example.proyectoalexisandroid/misJugadores.txt");
            fr = new FileReader(fichero);
            buffer = new BufferedReader(fr);
            String primeraLinea = buffer.readLine();

            //System.out.println("la cantidad de objeto es = " + primeraLinea);
            // int value = Integer.parseInt(primeraLinea);//
            // cantidad de objetos que tengo
            /**
             * si funcina la cantidad lo debo de poner en el for.
             */
            if(primeraLinea != null) {
                for (int i = 0; i < 8; i++) {
                    nombre = buffer.readLine();
                    apellido = buffer.readLine();
                    imagen = buffer.readLine();
                    pais = buffer.readLine();
                    like = Boolean.parseBoolean(buffer.readLine());
                    dorsal = Integer.valueOf(buffer.readLine());


                    this.Misjugadores.add(new Jugador(nombre, apellido, imagen, pais, like, dorsal));
                }
            }
            Log.i("---", this.jugadores.size() + "  ---- es la cantidad de jugadores");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
                if (fr != null) {
                    fr.close();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }

    /**
     * metodo que carga mi lista de jugadores desde el fichero
     */
    public void load() {
        File fichero = null;
        FileReader fr = null;
        BufferedReader buffer = null;
        String nombre;
        String apellido;
        String imagen;
        String pais;
        boolean like;
        int dorsal;
        try {
            fichero = new File("/data/user/0/com.example.proyectoalexisandroid/ficheroJugadores.txt");
            ///data/user/0/com.example.proyectoalexisandroid

            fr = new FileReader(fichero);
            buffer = new BufferedReader(fr);
            String primeraLinea = buffer.readLine();
            System.out.println(primeraLinea);
            // int value = Integer.parseInt(primeraLinea);//cantidad de objetos que tengo
            for (int i = 0; i < 8; i++) {
                nombre = buffer.readLine();
                apellido = buffer.readLine();
                imagen = buffer.readLine();
                pais = buffer.readLine();
                like = Boolean.parseBoolean(buffer.readLine());
                dorsal = Integer.valueOf(buffer.readLine());


                this.jugadores.add(new Jugador(nombre, apellido, imagen, pais, like, dorsal));
            }
            Log.i("---", this.jugadores.size() + "  ---- es la cantidad de jugadores");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
                if (fr != null) {
                    fr.close();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
