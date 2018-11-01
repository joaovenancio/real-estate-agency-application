package io.github.joaovenancio.aplicacaoconstrutora.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import io.github.joaovenancio.aplicacaoconstrutora.R;
import io.github.joaovenancio.aplicacaoconstrutora.daos.ImovelDAO;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Imovel;

public class ListaImovelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imovel);

        //Botao para voltar:
        Button botaoVoltar = findViewById(R.id.lista_imovel_botao_voltar);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }

    private void carregarLista() {
        ImovelDAO dao = new ImovelDAO(this);
        List<Imovel> imoveis = dao.recuperarImoveis();
        dao.close();

        ListView listaImoveis = this.findViewById(R.id.lista_imovel);
        ArrayAdapter adaptador = new ArrayAdapter<Imovel>(this, android.R.layout.simple_list_item_1, imoveis);
        listaImoveis.setAdapter(adaptador);
    }
}
