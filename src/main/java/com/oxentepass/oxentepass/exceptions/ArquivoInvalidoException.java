package com.oxentepass.oxentepass.exceptions;

public class ArquivoInvalidoException extends RuntimeException {
    
    //Cod. HTTP: 400
    //Envio de arquivo (imagem) inválido 
    public ArquivoInvalidoException (String mensagem) {
        super(mensagem);
    }
}
