package io.github.joaovenancio.aplicacaoconstrutora.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.Collections;
import java.util.List;

import io.github.joaovenancio.aplicacaoconstrutora.R;
import io.github.joaovenancio.aplicacaoconstrutora.adapters.NoticiaAdapter;
import io.github.joaovenancio.aplicacaoconstrutora.daos.NoticiaDAO;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Noticia;

public class NoticiaActivity extends AppCompatActivity {

    private ListView listaNoticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noticia);

        //Configurar o botao de voltar:
        Button botaoVoltar = findViewById(R.id.noticia_voltar);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        this.listaNoticias = this.findViewById(R.id.lista_noticia);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.carregarLista();
    }

    private void mostrarUltimaNoticia() {
        NoticiaDAO dao = new NoticiaDAO(this);
        List<Noticia> noticias = dao.buscaNoticias();
        dao.close();

        //Achar a ultima noticia:
        Noticia noticia;
        noticia = noticias.get(noticias.size()-1); //Achar a ultima publicada

        //Pegar os campos da view e definir seu conteudo:
        //TextView texto = findViewById(R.id.noticia_texto);
        //texto.setText(noticia.getTexto());
        //TextView data = findViewById(R.id.noticia_data);
        //data.setText(noticia.getData());
    }

    private void carregarLista() {
        NoticiaDAO dao = new NoticiaDAO(this);
        List<Noticia> noticias = dao.buscaNoticias();
        dao.close();
        Collections.reverse(noticias); //Reverter a ordem das noticias, para mostrar a ultima adicionada como primeira

        NoticiaAdapter adaptador = new NoticiaAdapter(this, noticias);
        listaNoticias.setAdapter(adaptador);
    }
}
