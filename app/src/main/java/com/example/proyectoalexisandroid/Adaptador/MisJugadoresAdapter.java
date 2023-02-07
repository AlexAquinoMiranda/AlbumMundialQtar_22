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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectoalexisandroid.Data.Jugador;
import com.example.proyectoalexisandroid.R;

import java.util.ArrayList;

/**
 * MisJugadoresAdapter  es una clase utilizada de adaptador para posteriormente
 * visuzalizarla en un RecyclerView de mis jugadores
 *
 * @author Alexis Aquino Miranda
 * @version v1.0
 */
public class MisJugadoresAdapter extends RecyclerView.Adapter<MisJugadoresAdapter.JugadorViewHolder> {

    ArrayList<Jugador> listaJugadores;
    Context contexto;

    public MisJugadoresAdapter(ArrayList<Jugador> j, Context c) {
        this.contexto = c;
        this.listaJugadores = j;

    }

    @NonNull
    @Override
    public JugadorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listmyjugadores, null, false);
        return new JugadorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JugadorViewHolder holder, int position) {
        Jugador ale = listaJugadores.get(position);
        Log.i("---", listaJugadores.get(position).toString());
        holder.viewNombre.setText(listaJugadores.get(position).getNombre() + " " + listaJugadores.get(position).getApellido());
        holder.textDorsal.setText("Dorsal: " + listaJugadores.get(position).getDorsal());//falta implementar
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
        TextView textDorsal;
        ImageView imagenJugador;
        ImageView imagenPais;
        FloatingActionButton btnLike;

        public JugadorViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.textNameMiJugador);
            imagenJugador = itemView.findViewById(R.id.imgMiJugador);
            textDorsal = itemView.findViewById(R.id.textDorsal);
            imagenPais = itemView.findViewById(R.id.imgMiBandera);
            btnLike = itemView.findViewById(R.id.btnMeGusta);
        }
    }
}
