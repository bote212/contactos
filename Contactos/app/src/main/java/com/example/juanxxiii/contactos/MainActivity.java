package com.example.juanxxiii.contactos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Contacto con;
    DataBaseHelper dbh;
    EditText nombre;
    String nombreContacto;
    String apellidoContacto;
    EditText apellido;
    ListView lv;
    ListViewAdapter adaptador;
    ArrayList<Contacto> alContacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //nombre = (EditText) findViewById(R.id.ETNombre);
        //apellido = (EditText) findViewById(R.id.ETApellido);
        lv = (ListView) findViewById(R.id.lvContactos);
        alContacto = new ArrayList<>();

        dbh = new DataBaseHelper(this);
        cargarLista();


        /*try {
            con = dbh.getContact(3);
           /* nombreContacto = con.getNombre();
            apellidoContacto = con.getApellidos();
            nombre.setText(nombreContacto);
            apellido.setText(apellidoContacto);

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*dbh = new DataBaseHelper(getApplicationContext());
        lista = dbh.llenar_lv();*/
    }

    protected void onUpdate(Bundle savedInstanceState){

    }

    public void openSaveActivity(View view){
        Intent it = new Intent(this, Guardar_activity.class);
        startActivity(it);
    }

    public void cargarLista(){
        alContacto = dbh.llenar_lv();
        adaptador = new ListViewAdapter(alContacto, this);
        lv.setAdapter(adaptador);
    }
}
