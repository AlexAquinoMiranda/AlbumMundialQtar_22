package com.example.proyectoalexisandroid.Adaptador;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectoalexisandroid.Data.Jugador;
import com.example.proyectoalexisandroid.R;

import java.util.ArrayList;

/**
 * JugadorAdapter es una clase utilizada de adaptador para posteriormente
 * visuzalizarla en un RecyclerView de todos los jugadores disponibles.
 *
 * @author Alexis Aquino Miranda
 * @version v1.0
 */
public class JugadorAdapter extends RecyclerView.Adapter<JugadorAdapter.JugadorViewHolder> {
    ArrayList<Jugador> listaJugadores;
    Context contexto;

    public JugadorAdapter(ArrayList<Jugador> listaJugadores, Context con) {
        this.listaJugadores = listaJugadores;
        this.contexto = con;
        Log.i("---", "Constructorr");
    }

    @NonNull
    @Override
    public JugadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.targetdejugador, null, false);
        return new JugadorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JugadorViewHolder holder, int position) {
        Log.i("---", "Entrooooo on biiind");
        holder.viewNombre.setText(listaJugadores.get(position).getNombre() + "\n" + listaJugadores.get(position).getApellido());
        //para mostrar la foto del jugador
        String uri = "@drawable/" + listaJugadores.get(position).getImagen();
        int imageResource = this.contexto.getResources().getIdentifier(uri, null, this.contexto.getPackageName());
        Drawable imagen = ContextCompat.getDrawable(this.contexto.getApplicationContext(), imageResource);
        holder.imagenJugador.setImageDrawable(imagen);

        //para mostrar la foto del pais.
        String uris = "@drawable/" + listaJugadores.get(position).getPais();
        int imageResources = this.contexto.getResources().getIdentifier(uris, null, this.contexto.getPackageName());
        Drawable imagens = ContextCompat.getDrawable(this.contexto.getApplicationContext(), imageResources);
        holder.imagenPais.setImageDrawable(imagens);

        Jugador ale = listaJugadores.get(position);

        if (ale.isLike()) {
            holder.btnLike.setImageResource(R.drawable.like);
        } else {
            holder.btnLike.setImageResource(R.drawable.dislike);
        }
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("---", ale.toString());
                if (ale.isLike()) {
                    holder.btnLike.setImageResource(R.drawable.dislike);
                    ale.setLike(false);
                } else {
                    holder.btnLike.setImageResource(R.drawable.like);
                    ale.setLike(true);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.listaJugadores.size();
    }

    public class JugadorViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre;
        ImageView imagenJugador;
        ImageView imagenPais;
        FloatingActionButton btnLike;

        public JugadorViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.nombreDelJugador);
            imagenJugador = itemView.findViewById(R.id.imagenDelJugador);
            imagenPais = itemView.findViewById(R.id.imagenDelPais);
            btnLike = itemView.findViewById(R.id.botonLike);
        }
    }
}
