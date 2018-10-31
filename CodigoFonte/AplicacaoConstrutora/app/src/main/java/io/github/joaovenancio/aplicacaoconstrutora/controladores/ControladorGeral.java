package io.github.joaovenancio.aplicacaoconstrutora.controladores;


public class ControladorGeral {
    //Atributos:
    private static ControladorGeral instancia;
    private ControladorImovel controladorImovel;
    private ControladorNoticia controladorNoticia;

    //Construtor:
    private ControladorGeral() {
        this.controladorImovel = new ControladorImovel();
        this.controladorNoticia = new ControladorNoticia();
        instancia = this;
    }

    //Metodos:
    /**
     * Retorna uma instancia desta classe.
     *
     * @return ControladorGeral - Uma instancia dessa classe.
     */
    public static ControladorGeral getInstance() {
        if (instancia == null) {
            instancia = new ControladorGeral();
        }

        return instancia;

    }

}
