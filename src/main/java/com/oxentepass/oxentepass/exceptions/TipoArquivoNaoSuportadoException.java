package com.oxentepass.oxentepass.exceptions;

public class TipoArquivoNaoSuportadoException extends RuntimeException {
    
    //Cod. HTTP: 415
    //Envio de arquivo (imagem) com tipo não esperado
    public TipoArquivoNaoSuportadoException (String mensagem) {
        super(mensagem);
    }
}