package io.github.joaovenancio.aplicacaoconstrutora.modelos;

public class Imovel {
    //Atributos:
    private Long id;
    private double area;
    private int numeroDeQuartos;
    private String endereco;
    private String cep;
    private String dataDeEntrega;
    private double valor;
    private int prazoFinanciamento;
    private String urlPlanta;
    private String urlVideoYoutube;
    private double latitude;
    private double longitude;
    private String tituloMaps;

    //Construtor:
    public Imovel() {
        this.area = 0d;
        this.numeroDeQuartos = 0;
        this.endereco = "";
        this.cep = "";
        this.dataDeEntrega = "xx/xx/xxxx";
        this.valor = 0d;
        this.prazoFinanciamento = 0;
        this.urlPlanta = "";
        this.urlVideoYoutube = "";
        this.longitude = 37.234332396d;
        this.latitude = -115.80666344d;
        this.tituloMaps = "Area 51";
    }

    //Metodos:
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNumeroDeQuartos() {
        return numeroDeQuartos;
    }

    public void setNumeroDeQuartos(int numeroDeQuartos) {
        this.numeroDeQuartos = numeroDeQuartos;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getDataDeEntrega() {
        return dataDeEntrega;
    }

    public void setDataDeEntrega(String dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public void setPrazoFinanciamento(int prazoFinanciamento) {
        this.prazoFinanciamento = prazoFinanciamento;
    }

    public String getUrlPlanta() {
        return urlPlanta;
    }

    public void setUrlPlanta(String urlPlanta) {
        this.urlPlanta = urlPlanta;
    }

    public String getUrlVideoYoutube() {
        return urlVideoYoutube;
    }

    public void setUrlVideoYoutube(String urlVideoYoutube) {
        this.urlVideoYoutube = urlVideoYoutube;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTituloMaps() {
        return tituloMaps;
    }

    public void setTituloMaps(String tituloMaps) {
        this.tituloMaps = tituloMaps;
    }
}
