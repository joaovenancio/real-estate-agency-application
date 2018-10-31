package io.github.joaovenancio.aplicacaoconstrutora.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.github.joaovenancio.aplicacaoconstrutora.AjudanteNoticia;
import io.github.joaovenancio.aplicacaoconstrutora.R;
import io.github.joaovenancio.aplicacaoconstrutora.daos.NoticiaDAO;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Noticia;

public class FormularioNoticiaActivity extends AppCompatActivity {

    private AjudanteNoticia ajudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_noticia);

        //Criar um ajudante, para conseguir ter referencia aos campos de texto e jah me entregar o objeto feito:
        this.ajudante = new AjudanteNoticia(this);

        Button botaoCadastrar = findViewById(R.id.formulario_noticia_botao_cadastrar);
        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pedir para o ajudante capturar os dados e me passar o objeto feito:
                Noticia noticia = ajudante.recuperarNoticia();

                //Persistir a noticia:
                NoticiaDAO dao = new NoticiaDAO(FormularioNoticiaActivity.this);
                dao.insere(noticia);
                dao.close();

                //Cria um toast (um aviso)
                Toast.makeText(FormularioNoticiaActivity.this, "Noticia do dia " + noticia.getData() + " salva!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
