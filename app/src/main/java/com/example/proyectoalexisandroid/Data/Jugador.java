package com.example.proyectoalexisandroid.Data;

/**
 * Jugador es la clase que utilizamos como objeto en esta aplicación
 * en donde vamos a visualizar sus datos durante toda la aplicación.
 */
public class Jugador {
    private String nombre;
    private String apellido;
    private String imagen;
    private String pais;
    private boolean like;
    private int dorsal;


    /**
     * Constructor por defecto {vacío}
     */
    public Jugador() {
    }

    /**
     * Constructor con todos los datos del objeto
     * @param nombre
     * @param apellido
     * @param imagen
     * @param pais
     * @param like
     * @param dorsal
     */
    public Jugador(String nombre, String apellido, String imagen, String pais, boolean like, int dorsal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen = imagen;
        this.pais = pais;
        this.like = like;
        this.dorsal = dorsal;
    }
    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    /**
     * @return @drawable/foto.
     */
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * método que realiza parseo de una ruta y lo muestra en jugadores obtenidos.
     *
     * @return "@drawable/nombreImagen
     */
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return nombre + "\n" + apellido + "\n" + imagen + "\n" + pais
                + "\n" + String.valueOf(like) + "\n" + dorsal+"\n";
    }
}
