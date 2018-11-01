package io.github.joaovenancio.aplicacaoconstrutora.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.github.joaovenancio.aplicacaoconstrutora.R;
import io.github.joaovenancio.aplicacaoconstrutora.activitys.ajudantes.AjudanteImovel;
import io.github.joaovenancio.aplicacaoconstrutora.daos.ImovelDAO;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Imovel;

public class FormularioImovelActivity extends AppCompatActivity {

    private AjudanteImovel ajudante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_imovel);

        //Instanciar o ajudante:
        this.ajudante = new AjudanteImovel(this);

        //Configurar o botao para cadastrar o imovel:
        Button botaoCadastrarImovel = findViewById(R.id.formulario_imovel_botao_cadastrar);
        botaoCadastrarImovel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Criar os objetos com os dados e recuperar ele:
                Imovel imovel = ajudante.recuperarImovel();

                //Guardar o imovel:
                ImovelDAO dao = new ImovelDAO(FormularioImovelActivity.this);
                dao.insere(imovel);
                dao.close();

                //Avisar sobre o sucesso:
                Toast.makeText(FormularioImovelActivity.this, "Imóvel " + imovel.getNome() + " salvo!", Toast.LENGTH_SHORT).show();
                finish(); //Terminar essa activity
            }
        });

    }
}
