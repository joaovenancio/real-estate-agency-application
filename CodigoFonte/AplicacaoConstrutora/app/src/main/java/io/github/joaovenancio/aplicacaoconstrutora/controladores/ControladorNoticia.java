package io.github.joaovenancio.aplicacaoconstrutora.controladores;

import io.github.joaovenancio.aplicacaoconstrutora.daos.NoticiaDAO;

class ControladorNoticia {
    //Atributos:
    private NoticiaDAO dao;

    //Construtor:
    public ControladorNoticia() {

    }

    //Metodos:
    public NoticiaDAO getDao() {
        return dao;
    }
}
