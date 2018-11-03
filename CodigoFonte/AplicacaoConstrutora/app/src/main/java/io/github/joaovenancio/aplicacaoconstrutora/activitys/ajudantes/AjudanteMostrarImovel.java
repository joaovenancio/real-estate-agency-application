package io.github.joaovenancio.aplicacaoconstrutora.activitys.ajudantes;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.joaovenancio.aplicacaoconstrutora.R;
import io.github.joaovenancio.aplicacaoconstrutora.activitys.ImovelActivity;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Imovel;

public class AjudanteMostrarImovel {
    //Atributos:
    private TextView campoNome;
    private TextView campoArea;
    private TextView campoNumeroDeQuartos;
    private TextView campoEndereco;
    private TextView campoCep;
    private TextView campoDataDeEntrega;
    private TextView campoValor;
    private TextView campoPrazoFinanciamento;
    private ImageView campoImagemPlanta;

    private ImovelActivity imovelActivity;

    //Construtor:
    public AjudanteMostrarImovel(ImovelActivity imovelActivity) {
        this.campoNome = imovelActivity.findViewById(R.id.imovel_nome);
        this.campoArea = imovelActivity.findViewById(R.id.imovel_area);
        this.campoNumeroDeQuartos = imovelActivity.findViewById(R.id.imovel_numero_quartos);
        this.campoEndereco = imovelActivity.findViewById(R.id.imovel_endereco);
        this.campoCep = imovelActivity.findViewById(R.id.imovel_cep);
        this.campoDataDeEntrega = imovelActivity.findViewById(R.id.imovel_data_entrega);
        this.campoValor = imovelActivity.findViewById(R.id.imovel_valor);
        this.campoPrazoFinanciamento = imovelActivity.findViewById(R.id.imovel_prazo_financiamento);
        this.campoImagemPlanta = imovelActivity.findViewById(R.id.imovel_planta);
    }


    //Metodos:
    public void definirConteudo(Imovel imovel) {
        this.campoNome.setText(imovel.getNome());
        this.campoArea.setText(String.valueOf((int) imovel.getArea()));
        this.campoNumeroDeQuartos.setText(String.valueOf(imovel.getNumeroDeQuartos()));
        this.campoEndereco.setText(imovel.getEndereco());
        this.campoCep.setText(imovel.getCep());
        this.campoDataDeEntrega.setText(imovel.getDataDeEntrega());
        this.campoValor.setText(String.valueOf((int) imovel.getValor()));
        this.campoPrazoFinanciamento.setText(String.valueOf(imovel.getPrazoFinanciamento()));

    }
}
