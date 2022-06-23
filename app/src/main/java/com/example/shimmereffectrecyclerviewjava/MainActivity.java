package com.example.shimmereffectrecyclerviewjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    LinearLayout llContenedor, llCargando;
    RecyclerView rvUsuarios;
    AdaptadorUsuarios adaptador;

    List<Usuario> listaUsuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llContenedor = findViewById(R.id.llContenedor);
        llCargando = findViewById(R.id.llCargando);
        rvUsuarios = findViewById(R.id.rvUsuarios);
        rvUsuarios.setLayoutManager(new GridLayoutManager(this, 1));

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                llCargando.setVisibility(View.GONE);
                llContenedor.setVisibility(View.VISIBLE);

                listaUsuarios.add(new Usuario("Sergio Peralta", "Developer"));
                listaUsuarios.add(new Usuario("Juan Perez", "Finanzas"));
                listaUsuarios.add(new Usuario("Laura Lopez", "Recursos Humanos"));

                adaptador = new AdaptadorUsuarios(getApplicationContext(), listaUsuarios);
                rvUsuarios.setAdapter(adaptador);

            }
        }, 5000);

    }
}