package io.github.joaovenancio.aplicacaoconstrutora.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
