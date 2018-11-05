package io.github.joaovenancio.aplicacaoconstrutora.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import io.github.joaovenancio.aplicacaoconstrutora.R;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Noticia;

public class NoticiaAdapter extends ArrayAdapter<Noticia> {

    public NoticiaAdapter(@NonNull Context context, List<Noticia> noticias) {
        super(context,0,noticias);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Noticia noticia = this.getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_noticia, parent, false);
        }
        // Lookup view for data population
        TextView campoTexto = convertView.findViewById(R.id.noticia_texto);
        TextView campoData = convertView.findViewById(R.id.noticia_data);
        // Populate the data into the template view using the data object
        campoTexto.setText(noticia.getTexto());
        campoData.setText(noticia.getData());
        // Return the completed view to render on screen
        return convertView;
    }
}
