package io.github.joaovenancio.aplicacaoconstrutora.modelos;

public class Noticia {
    //Atributos:
    private Long id;
    private String texto;
    private String data; //String para manter facilitado a implementacao

    //Construtor:
    public Noticia() {
        this.texto = "";
        this.data = "xx/xx/xx";
    }

    public Noticia(String texto, String data) {
        this.texto = texto;
        this.data = data;
    }

    //Metodos:
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
