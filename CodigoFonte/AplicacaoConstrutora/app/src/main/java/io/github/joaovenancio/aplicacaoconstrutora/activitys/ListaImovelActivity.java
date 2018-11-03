package io.github.joaovenancio.aplicacaoconstrutora.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import io.github.joaovenancio.aplicacaoconstrutora.R;
import io.github.joaovenancio.aplicacaoconstrutora.daos.ImovelDAO;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Imovel;

public class ListaImovelActivity extends AppCompatActivity {

    private ListView listaImoveis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_imovel);

        listaImoveis = findViewById(R.id.lista_imovel);

        //Colocar um tratador de cliques na lista:
        listaImoveis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int posicao, long id) {
                Imovel imovel = (Imovel) lista.getItemAtPosition(posicao);
                //Criar uma intent para a activity que mostra os dados dos imoveis:
                Intent mostrarDadosDoImovel = new Intent(ListaImovelActivity.this, ImovelActivity.class);
                mostrarDadosDoImovel.putExtra("imovel",imovel);
                //Mandar o pedido de execucao para o android:
                ListaImovelActivity.this.startActivity(mostrarDadosDoImovel);
            }
        });

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

        ArrayAdapter adaptador = new ArrayAdapter<Imovel>(this, android.R.layout.simple_list_item_1, imoveis);
        listaImoveis.setAdapter(adaptador);
    }
}
