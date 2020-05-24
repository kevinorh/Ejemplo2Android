package com.michael.multiplescontroles;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class actividad2 extends AppCompatActivity {
    TextView nombre, precio, descuento1, descuento2, curso;
    Button btnVolver;
    ImageView imagenCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nombre = (TextView) findViewById(R.id.textViewNombre);
        precio = (TextView) findViewById(R.id.textViewPrecio);
        descuento1 = (TextView) findViewById(R.id.textViewDescuento1);
        descuento2 = (TextView) findViewById(R.id.textViewDescuento2);
        curso = (TextView) findViewById(R.id.textViewCurso);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        imagenCurso = (ImageView) findViewById(R.id.imageViewCurso);

        Intent i = getIntent();
        nombre.setText("Nombre: "+ i.getStringExtra("nombre"));
        precio.setText("Precio: "+i.getStringExtra("precio"));
        descuento1.setText("Dscto 1: "+i.getStringExtra("descuento1"));
        descuento2.setText("Dscto 2: "+i.getStringExtra("descuento2"));

        String nuevoCurso = "";
        nuevoCurso = i.getStringExtra("curso");

        curso.setText("Curso: "+nuevoCurso);
        int foto = 0;

        switch (nuevoCurso){
            case "Php":
                foto = R.drawable.php;
                break;
            case "Sql":
                foto = R.drawable.sql;
                break;
            case "MySql":
                foto = R.drawable.mysql;
                break;
            default: break;
        }
        if(foto != 0){
            imagenCurso.setImageResource(foto);
        }
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
