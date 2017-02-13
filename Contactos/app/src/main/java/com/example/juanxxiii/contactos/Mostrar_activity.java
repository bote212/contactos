package com.example.juanxxiii.contactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Mostrar_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_contacto,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_add_menu:
                Intent it = new Intent(this, Guardar_activity.class);
                startActivity(it);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

   /* ******
    //ImageView imagen;
    Button addContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //imagen = (ImageView) findViewById(R.id.image);
        addContact = (Button) findViewById(R.id.b_add);

      /*  imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i, "Selecciona una imagen para el perfil"), 1);
            }
        });*/
    }

    /*public void onActicityResult(int reqCode, int resCode, Intent data){
        if (resCode == RESULT_OK){
            if(reqCode == 1){
                imagen.setImageURI(data.getData());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }



    public void pantalla(View view){
        Intent it = new Intent(this,Mostrar_activity.class);
        startActivity(it);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.id_add_menu:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void openSaveActivity(View view){
        Intent it = new Intent(this, Guardar_activity.class);
        startActivity(it);
    }

*******
* **/

