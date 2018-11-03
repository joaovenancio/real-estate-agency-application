package io.github.joaovenancio.aplicacaoconstrutora.activitys.ajudantes;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import io.github.joaovenancio.aplicacaoconstrutora.R;
import io.github.joaovenancio.aplicacaoconstrutora.activitys.ImovelActivity;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Imovel;
import io.github.joaovenancio.aplicacaoconstrutora.youtube.ChaveDesenvolvedor;

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
    private YouTubePlayerView playerYoutube;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

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
        this.playerYoutube = imovelActivity.findViewById(R.id.imovel_player_youtube);
    }


    //Metodos:
    public void definirConteudo(Imovel imovel) {

        this.campoNome.setText(imovel.getNome());
        System.out.println(imovel.getArea());
        this.campoArea.setText(String.valueOf((int) imovel.getArea()));
        this.campoNumeroDeQuartos.setText(String.valueOf(imovel.getNumeroDeQuartos()));
        this.campoEndereco.setText(imovel.getEndereco());
        this.campoCep.setText(imovel.getCep());
        this.campoDataDeEntrega.setText(imovel.getDataDeEntrega());
        this.campoValor.setText(String.valueOf((int) imovel.getValor()));
        this.campoPrazoFinanciamento.setText(String.valueOf(imovel.getPrazoFinanciamento()));
        Picasso.get().load(imovel.getUrlPlanta()).into(this.campoImagemPlanta);
        //Iniciar o video:
        this.onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo(imovel.getUrlVideoYoutube());
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                System.out.println("YOUTUBE: Houve erro em mostrar o vídeo.");
            }
        };

        playerYoutube.initialize(ChaveDesenvolvedor.CAHVE_DESENVOLVEDOR,onInitializedListener);
    }
}
