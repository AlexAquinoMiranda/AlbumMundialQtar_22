package com.example.proyectoalexisandroid;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * La clase CompraToken es una vista en donde se va a realizar
 * la compra de tokens la cuál dispones de botones como:
 * <ul> <li> boton más: para aumentar la unidad</li>
 * <li> botón menos: para disminuir la unidad </li></ul>
 */
public class CompraToken extends AppCompatActivity {
    Button btnCompra;
    public static int unidadToken = 0;
    FloatingActionButton btnMas;
    FloatingActionButton btnMenos;

    TextView tokenComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra_token);
        btnCompra = findViewById(R.id.btnCompraConfirmada);
        tokenComprar = findViewById(R.id.cantidadTokenCompra);
        btnMas = findViewById(R.id.btnMas);
        btnMenos = findViewById(R.id.btnMenos);

        eventos();

    }

    /**
     * Eventos es un método en donde se gestionan los eventos de onclick de todos
     * los botones correspondientes a la vista de esta clase
     * <ul><li>
     *     btnMás -> en donde aumentamos el valor de unidad de tokes disponibles.
     * </li>
     * <li>
     *      btnMenos -> en donde disminuimos el valor de unidad de tokens disponbles.
     * </li>
     * <li>
     *     tokenComprar -> en donde mostramos la unidad de tokens que vamos a comprar.
     * </li></ul>
     */
    void eventos() {
        btnCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(CompraToken.this, DatosTarjeta.class);
                startActivity(myIntent);
            }
        });
        btnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unidadToken++;
                tokenComprar.setText(String.valueOf(unidadToken));
            }
        });
        btnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (unidadToken > 0) {
                    unidadToken--;
                }
                tokenComprar.setText(String.valueOf(unidadToken));
            }
        });
    }
}