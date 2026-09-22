package com.example.kike;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class MenuPrincipal extends AppCompatActivity {

    private LinearLayout botonCarro, botonInicio, botonPerfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        botonCarro = findViewById(R.id.botonCarro);
        botonInicio = findViewById(R.id.botoninicio);
        botonPerfil = findViewById(R.id.botonperfil);

        if (savedInstanceState == null){
            remplazarFragmento(new Principal());
        }

        botonInicio.setOnClickListener(v -> remplazarFragmento(new Principal()));
        botonCarro.setOnClickListener(v -> remplazarFragmento(new Carrito()));
        botonPerfil.setOnClickListener(v->remplazarFragmento(new Perfil()));

    }

    private void remplazarFragmento(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedorprincipal, fragment)
                .commit();
    }
}