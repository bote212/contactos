package com.example.juanxxiii.contactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.juanxxiii.contactos.R.id.b_save;

public class Guardar_activity extends AppCompatActivity {

    EditText name;
    EditText apellidos;
    EditText telefono;
    EditText email;
    EditText direccion;
    Button bSave;
    Contacto contacto;
    DataBaseHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_activity);

        name = (EditText) findViewById(R.id.et_name);
        apellidos = (EditText) findViewById(R.id.et_Apellidos);
        telefono = (EditText) findViewById(R.id.et_phone);
        email = (EditText) findViewById(R.id.et_email);
        direccion = (EditText) findViewById(R.id.et_Direction);
        bSave = (Button) findViewById(b_save);
        dbh =  new DataBaseHelper(this);



        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacto = new Contacto(name.getText().toString(),apellidos.getText().toString()
                        ,telefono.getText().toString(),email.getText().toString(),direccion.getText().toString());
                try{
                    dbh.addContact(contacto);
                    Toast t = Toast.makeText(getApplicationContext(), "Contacto guardado", Toast.LENGTH_LONG);
                    t.show();
                }catch (Exception ex){
                    Toast t = Toast.makeText(getApplicationContext(), "Error en guardar el contacto", Toast.LENGTH_LONG);
                    t.show();
                }

            }
        });

    }

}
