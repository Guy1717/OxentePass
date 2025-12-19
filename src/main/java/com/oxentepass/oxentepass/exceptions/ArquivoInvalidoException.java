package com.oxentepass.oxentepass.exceptions;

public class ArquivoInvalidoException extends RuntimeException {
    
    //Cod. HTTP: 400
    //Envio de arquivo (imagem) inválido
    //Por razões de: arquivo vazio e tamanho acima do esperado
    public ArquivoInvalidoException (String mensagem) {
        super(mensagem);
    }
}
