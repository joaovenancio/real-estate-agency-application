package io.github.joaovenancio.aplicacaoconstrutora.ComponentePersistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author joaov
 */
public class ControladorPersistencia implements IPersistencia {
    //Atributos:
    static ControladorPersistencia instancia;
    
    //Construtor
    /**
     * Instancia o controlador para salvar os dados.
     */
    ControladorPersistencia() {
        this.instancia = this;
    }
    
    //Metodos
    /**
     * Recebe um dado e um nome de arquivo. Salva o Objeto dado em um arquivo com esse nome.
     * 
     * @param dado - Objeto que vai ser armazenado.
     * @param nomeDoArquivo - String com o nome do arquivo para guardar os Objetos.
     * @return true se conseguir gravar o dado no arquivo desejado || false se deu erro na gravacao.
     */
    @Override
    public boolean persistir(Object dado, String nomeDoArquivo) {
        try {
            //Cria um caminho do stream  de dados para um arquivo:
            FileOutputStream caminhoArquivo = new FileOutputStream(nomeDoArquivo);
            //Abre um fluxo para transmitir um objeto:
            ObjectOutputStream fluxoSaidaObjeto = new ObjectOutputStream (caminhoArquivo);
            
            //Grava o objeto no arquivo desejado:
            fluxoSaidaObjeto.writeObject(dado);
            
            //Usar o metodo flush para enviar todos os dados do Buffer, assegurando que o objeto inteiro vai ser enviado:
            fluxoSaidaObjeto.flush();
            caminhoArquivo.flush();
            
            //Fehcar o canal de envio e liberar o arquivo:
            fluxoSaidaObjeto.close();
            caminhoArquivo.flush();
            
            //Liberar o espaço na memoria:
            fluxoSaidaObjeto = null;
            caminhoArquivo = null;

        } catch (FileNotFoundException ex) { //Informa o problema
            System.out.println(ex);
            return false;
        } catch (IOException ex) { //Informa o problema
            System.out.println(ex);
            return false;
        }

        return true;
        
    }

    /**
     * Carrega um objeto por um arquivo atraves da serializacao.
     * 
     * @param dadoCarregar - Referencia do objeto que vai ser carregado.
     * @param nomeDoArquivo - Nome do Arquivo para ser carregado o objeto.
     */
    @Override
    public Object carregar (String nomeDoArquivo) {
        try {
            //Criar um objeto para passar como referencia o nome do Arquivo desejado
            FileInputStream caminhoArquivo = new FileInputStream(nomeDoArquivo);
            //Abrir um fluxo para recuperar os dados do aqruivo:
            ObjectInputStream fluxoEntradaObjeto = new ObjectInputStream(caminhoArquivo);
            
            //Recuperar o Objeto:
            Object dadoCarregar =  fluxoEntradaObjeto.readObject();
            
            //Fehcar o canal de recebimento e liberar o arquivo:
            fluxoEntradaObjeto.close();
            caminhoArquivo.close();
            
            //Liberar memoria:
            fluxoEntradaObjeto = null;
            caminhoArquivo = null;
            
            return dadoCarregar;
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        
        return null;
    }
    
    
    /**
     * Retorna uma instancia dessa classe.
     * 
     * @return ControladorSalvaDados.
     */
    public static ControladorPersistencia getInstance() {
        if (ControladorPersistencia.instancia == null) {
            ControladorPersistencia.instancia = new ControladorPersistencia();
        }
        
        return ControladorPersistencia.instancia;
        
    }  
}
