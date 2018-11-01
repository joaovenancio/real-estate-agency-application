package io.github.joaovenancio.aplicacaoconstrutora.activitys.ajudantes;

import android.widget.EditText;

import io.github.joaovenancio.aplicacaoconstrutora.R;
import io.github.joaovenancio.aplicacaoconstrutora.activitys.FormularioImovelActivity;
import io.github.joaovenancio.aplicacaoconstrutora.modelos.Imovel;

public class AjudanteImovel {
    //Aatributos:
    private EditText campoNome;
    private EditText campoArea;
    private EditText campoNumeroDeQuartos;
    private EditText campoEndereco;
    private EditText campoCep;
    private EditText campoDataDeEntrega;
    private EditText campoValor;
    private EditText campoPrazoFinanciamento;
    private EditText campoUrlPlanta;
    private EditText campoUrlVideoYoutube;
    private EditText campoLatitude;
    private EditText campolongitude;
    private EditText campoTituloMaps;

    //Construtor:
    public AjudanteImovel(FormularioImovelActivity formularioImovel) {
        this.campoNome = formularioImovel.findViewById(R.id.formulario_imovel_nome_empreendimento);
        this.campoArea = formularioImovel.findViewById(R.id.formulario_imovel_area);
        this.campoNumeroDeQuartos = formularioImovel.findViewById(R.id.formulario_imovel_numero_quartos);
        this.campoEndereco = formularioImovel.findViewById(R.id.formulario_imovel_endereco);
        this.campoCep = formularioImovel.findViewById(R.id.formulario_imovel_cep);
        this.campoDataDeEntrega = formularioImovel.findViewById(R.id.formulario_imovel_dataDeEntrega);
        this.campoValor = formularioImovel.findViewById(R.id.formulario_imovel_valor);
        this.campoPrazoFinanciamento = formularioImovel.findViewById(R.id.formulario_imovel_prazo_financiamento);
        this.campoUrlPlanta = formularioImovel.findViewById(R.id.formulario_imovel_url_planta);
        this.campoUrlVideoYoutube = formularioImovel.findViewById(R.id.formulario_imovel_url_video_youtube);
        this.campoLatitude = formularioImovel.findViewById(R.id.formulario_imovel_latitude_maps);
        this.campolongitude = formularioImovel.findViewById(R.id.formulario_imovel_longitude_maps);
        this.campoTituloMaps = formularioImovel.findViewById(R.id.formulario_imovel_titulo_maps);
    }

    //Metodos:
    public Imovel recuperarImovel () {
        Imovel imovel = new Imovel();

        imovel.setNome(this.campoNome.getText().toString());
        imovel.setArea(Double.valueOf(this.campoArea.getText().toString()));
        imovel.setNumeroDeQuartos(Integer.valueOf(this.campoNumeroDeQuartos.getText().toString()));
        imovel.setEndereco(this.campoEndereco.getText().toString());
        imovel.setCep(this.campoCep.getText().toString());
        imovel.setDataDeEntrega(this.campoDataDeEntrega.getText().toString());
        imovel.setValor(Double.valueOf(this.campoValor.getText().toString()));
        imovel.setPrazoFinanciamento(Integer.valueOf(this.campoPrazoFinanciamento.getText().toString()));
        imovel.setUrlPlanta(this.campoUrlPlanta.getText().toString());
        imovel.setUrlVideoYoutube(this.campoUrlVideoYoutube.getText().toString());
        imovel.setLatitude(Double.valueOf(this.campoLatitude.getText().toString()));
        imovel.setLongitude(Double.valueOf(this.campolongitude.getText().toString()));
        imovel.setTituloMaps(this.campoTituloMaps.getText().toString());

        return imovel;
    }
}
