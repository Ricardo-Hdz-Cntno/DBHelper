package com.example.usuario.bdhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AgregarMiembro extends AppCompatActivity implements OnClickListener {
    EditText et;
    Button btnAgregar;
    SQLControlador dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_miembro);
        et = (EditText) findViewById(R.id.et_miembro_id);
        btnAgregar = (Button) findViewById(R.id.btnAgregarId);
        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAgregarId:
                String name = et.getText().toString();
                dbconeccion.insertarDatos(name);
                Intent main = new Intent(AgregarMiembro.this, MainActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;
            default:
                break;
        }
    }
}
