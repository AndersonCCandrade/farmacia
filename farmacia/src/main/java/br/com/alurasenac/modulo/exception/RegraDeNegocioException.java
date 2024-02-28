package br.com.alurasenac.modulo.exception;

public class RegraDeNegocioException extends RuntimeException{
    public RegraDeNegocioException(String mensagem) {
        super(mensagem);
    }
}
