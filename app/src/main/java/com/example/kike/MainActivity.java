package com.example.kike;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText CAJA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        CAJA=this.findViewById(R.id.CAJA);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //Login
    public void Login (View view){
        Intent obj=new Intent(this,MenuPrincipal.class);
        this.startActivity(obj);
    }
    /* public void Login (View view){
        Intent obj=new Intent(this,PantallaDos.class);
        String usuario = CAJA.getText().toString();
        obj.putExtra("USUARIO", usuario);
        this.startActivity(obj);
        this.finish();
    }*/

}