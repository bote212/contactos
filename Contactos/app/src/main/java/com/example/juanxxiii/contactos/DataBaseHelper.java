package com.example.juanxxiii.contactos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by juanxxiii on 26/01/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ContactosDB";
    private static final String[] COLUMNAS = {"id", "nombre", "apellidos", "email", "telefono", "direccion"};

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLA_AGENDA = "CREATE TABLE agenda (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, apellidos TEXT," +
                " email TEXT, telefono TEXT, direccion TEXT)";
        db.execSQL(CREATE_TABLA_AGENDA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS books");
        this.onCreate(db);
    }

    public void addContact(Contacto nc) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", nc.getNombre());
        values.put("apellidos", nc.getApellidos());
        values.put("email", nc.getEmail());
        values.put("telefono", nc.getTelefono());
        values.put("direccion", nc.getDireccion());
        db.insert("agenda", null, values);
        db.close();
    }

    public Contacto getContact(int id) throws Exception {
        String nombre = null;
        String email = null;
        String telefono = null;
        String apellidos = null;
        String direccion = null;
        Contacto c = null;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM agenda WHERE id = ?", new String[] {String.valueOf(id)});
        cursor.moveToFirst();
        nombre = cursor.getString(1);
        email = cursor.getString(2);
        telefono = cursor.getString(3);
        c = new Contacto(nombre, apellidos, email, telefono, direccion);
        return c;
    }

    public ArrayList llenar_lv(){
        ArrayList<Contacto> contacto = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        String q = "Select * from agenda";
        Cursor cursor = db.rawQuery(q, null);
        if(cursor.moveToFirst()){
            do{
                String nombre = cursor.getString(1);
                String apellido = cursor.getString(2);
                String telefono = cursor.getString(3);
                contacto.add(new Contacto(nombre, apellido, telefono));
            }while (cursor.moveToNext());
        }
        return contacto;
    }


}
