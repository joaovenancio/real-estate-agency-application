/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.joaovenancio.aplicacaoconstrutora.ComponentePersistencia;

/**
 *
 * @author joaov
 */
public interface IPersistencia {
    //Metodos:
    public boolean persistir (Object dado, String nomeDoArquivo);
    
    public Object carregar (String nomeDoArquivo);

    public static ControladorPersistencia getInstance() {
        if (ControladorPersistencia.instancia == null) {
            ControladorPersistencia.instancia = new ControladorPersistencia();
        }

        return ControladorPersistencia.instancia;

    }

}
