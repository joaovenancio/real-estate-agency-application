package io.github.joaovenancio.aplicacaoconstrutora.controladores;

import io.github.joaovenancio.aplicacaoconstrutora.ComponentePersistencia.IPersistencia;

public class ControladorGeral {
    //Atributos:
    private static ControladorGeral instancia;
    private ControladorImovel controladorImovel;
    private ControladorNoticia controladorNoticia;
    private IPersistencia componentePersistencia;

    //Construtor:
    private ControladorGeral() {
        this.controladorImovel = new ControladorImovel();
        this.controladorNoticia = new ControladorNoticia();
        this.componentePersistencia =
        this.instancia = this;
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
