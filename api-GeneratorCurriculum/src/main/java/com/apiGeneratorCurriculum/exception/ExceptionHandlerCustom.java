package com.apiGeneratorCurriculum.exception;

import com.itextpdf.text.BadElementException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Miguel Castro
 */
@ControllerAdvice
public class ExceptionHandlerCustom extends ResponseEntityExceptionHandler {

    private List<MensagemException> gerarListaDeMensagens(BindingResult bindingResult) {

        List<MensagemException> mensagem = new ArrayList<>();

        bindingResult.getFieldErrors().forEach(erro -> {
            String mensagemUsuario = erro.getDefaultMessage();
            String mensagemDesenvolvedor = erro.toString();
            mensagem.add(new MensagemException(mensagemUsuario, mensagemDesenvolvedor));
        });
        return mensagem;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        List<MensagemException> mensagem = gerarListaDeMensagens(ex.getBindingResult());
        return handleExceptionInternal(ex, mensagem, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(IOException.class)
    protected ResponseEntity<Object> handleIOException(IOException ex, WebRequest request) {
        MensagemException mensagem = new MensagemException("Erro de E/S durante a exportação do PDF", ex.getMessage());
        return handleExceptionInternal(ex, mensagem, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(BadElementException.class)
    protected ResponseEntity<Object> handleBadElementException(BadElementException ex, WebRequest request) {
        MensagemException mensagem = new MensagemException("Erro durante a criação do PDF", ex.getMessage());
        return handleExceptionInternal(ex, mensagem, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
