package io.github.joaovenancio.aplicacaoconstrutora;

import android.widget.EditText;

import io.github.joaovenancio.aplicacaoconstrutora.activitys.FormularioNoticiaActivity;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Noticia;

public class AjudanteNoticia {

    private final EditText campoTexto;
    private final EditText campoData;

    public AjudanteNoticia(FormularioNoticiaActivity formularioNoticia) {
        this.campoTexto = formularioNoticia.findViewById(R.id.formulario_noticia_texto);

        this.campoData = formularioNoticia.findViewById(R.id.formulario_noticia_data);

    }

    public Noticia recuperarNoticia() {
        Noticia noticia = new Noticia();
        noticia.setTexto(this.campoTexto.getText().toString());
        noticia.setData(this.campoData.getText().toString());

        return noticia;
    }
}
