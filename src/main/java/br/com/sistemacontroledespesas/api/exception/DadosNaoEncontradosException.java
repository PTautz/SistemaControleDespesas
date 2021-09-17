package br.com.sistemacontroledespesas.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Marcação de exceção genérica
//Precisa Tratar ver/pesquisar @ExceptionHandler
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DadosNaoEncontradosException extends Exception{
    public DadosNaoEncontradosException(String message) {
        super(message);
    }
}
