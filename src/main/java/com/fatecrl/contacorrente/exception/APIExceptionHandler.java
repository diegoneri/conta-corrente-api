package com.fatecrl.contacorrente.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;

public class APIExceptionHandler extends ResponseEntityExceptionHandler{

    @Nullable
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
          MethodArgumentNotValidException ex
        , HttpHeaders headers
        , HttpStatusCode status
        , WebRequest request){
        
        APIError apiError = new APIError();
        apiError.setStatus(status.value());
        apiError.setDataHora(LocalDateTime.now()); 
        apiError.setPath(request.getContextPath());
        apiError.setMensagem("Um ou mais campos estão inválidos");  
        apiError.setCampos(recuperaListaDeCampos(ex)); 
        return super.handleExceptionInternal(ex, apiError, headers, status, request);
    }

    private List<ErrorField> recuperaListaDeCampos(MethodArgumentNotValidException ex){
        List<ErrorField> listaErros = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            ErrorField field = new ErrorField(error.getField()
                                            , error.getDefaultMessage());
            listaErros.add(field);
        });
        return listaErros;
    }
}
