package com.michael.multiplescontroles;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final RadioGroup rg;
        Button btn1;
        final CheckBox chk1,chk2;
        final EditText editText;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rg = (RadioGroup) findViewById(R.id.radioGroupOpcionesCurso);
        btn1 = (Button) findViewById(R.id.btnCalcular);
        chk1 = (CheckBox) findViewById(R.id.checkBoxDescuento5);
        chk2 = (CheckBox) findViewById(R.id.checkBoxDescuento10);
        editText = (EditText) findViewById(R.id.editTextNombre);

        chk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OcultarTeclado(v);
            }
        });
        chk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OcultarTeclado(v);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int precio=0;
                String curso="",nombre = "";
                nombre = editText.getText().toString();
                double dscto1=0,dscto2=0,dsctf=0,total=0;
                if(rg.getCheckedRadioButtonId()==R.id.radioButtonOpcionPhp){
                    precio=300;
                    curso="Php";
                }else if(rg.getCheckedRadioButtonId()==R.id.radioButtonOpcionSql){
                    precio=500;
                    curso="Sql";
                }else if(rg.getCheckedRadioButtonId()==R.id.radioButtonOpcionMySql){
                    precio=500;
                    curso="MySql";
                }
                if(chk1.isChecked()){
                    dscto1=precio*0.05;
                }
                if(chk2.isChecked()){
                    dscto2=precio*0.1;
                }
                dsctf=dscto1+dscto2;
                total=precio-dsctf;

                Toast.makeText(getApplicationContext(), "curso: "+curso+"\n Precio: "+precio+"\n Dscto: "+dsctf+"\n total: "+total, Toast.LENGTH_LONG).show();

                String textoNombre, textoPrecio,textoDescuento1,textoDescuento2,textoCurso;
                textoNombre = nombre.toString();
                textoPrecio = String.valueOf(precio);
                textoDescuento1 = String.valueOf(dscto1);
                textoDescuento2 = String.valueOf(dscto2);
                textoCurso = curso.toString();

                Intent i = new Intent(getApplicationContext(), actividad2.class);
                i.putExtra("nombre", textoNombre);
                i.putExtra("precio", textoPrecio);
                i.putExtra("descuento1", textoDescuento1);
                i.putExtra("descuento2", textoDescuento2);
                i.putExtra("curso", textoCurso);
                startActivity(i);
            }
        });
    }
    private void OcultarTeclado(View view){
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
