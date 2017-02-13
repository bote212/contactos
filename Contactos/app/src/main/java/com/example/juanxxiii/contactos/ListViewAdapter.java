package com.example.juanxxiii.contactos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bote on 10/02/2017.
 */

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<Contacto> alContactos;
    private Context context;
    private LayoutInflater layoutInflater;

    public ListViewAdapter(ArrayList<Contacto> alContactos, Context context) {
        this.alContactos = alContactos;
        this.context = context;
    }

    @Override
    public int getCount() {
        return alContactos.size();
    }

    @Override
    public Object getItem(int i) {
        return alContactos;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vista = layoutInflater.inflate(R.layout.layaout_contacto, viewGroup, false);
        ImageView imagen = (ImageView) vista.findViewById(R.id.iv_contacto_main);
        TextView apellido = (TextView) vista.findViewById(R.id.tv_apellido_main);
        TextView nombre = (TextView) vista.findViewById(R.id.tv_nombre_main);
        TextView telefono = (TextView) vista.findViewById(R.id.tv_telefono_main);

        nombre.setText(alContactos.get(i).getNombre());
        apellido.setText(alContactos.get(i).getApellidos());
        telefono.setText(alContactos.get(i).getTelefono());
        return vista;
    }
}
