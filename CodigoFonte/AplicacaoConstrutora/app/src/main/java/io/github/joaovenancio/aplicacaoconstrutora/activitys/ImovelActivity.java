package io.github.joaovenancio.aplicacaoconstrutora.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import io.github.joaovenancio.aplicacaoconstrutora.R;
import io.github.joaovenancio.aplicacaoconstrutora.activitys.ajudantes.AjudanteMostrarImovel;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Imovel;

public class ImovelActivity extends AppCompatActivity {

    AjudanteMostrarImovel ajudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imovel);

        this.ajudante = new AjudanteMostrarImovel(this);

        //Recuperar o imovel:
        Intent intent = getIntent();
        Imovel imovel = (Imovel) intent.getSerializableExtra("imovel");

        //Mostrar os dados na view:
        this.ajudante.definirConteudo(imovel);
        //Mostrar a imagem na view:
        //ImageView imagem = findViewById(R.id.imovel_planta);
        //Picasso.get().setIndicatorsEnabled(true);
        //Picasso.get().setLoggingEnabled(true);
        //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(imagem);

        //Configurar o botao de voltar:
        Button botaoVoltar = findViewById(R.id.imovel_botao_voltar);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
