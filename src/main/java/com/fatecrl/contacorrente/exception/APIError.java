package com.fatecrl.contacorrente.exception;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
//import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class APIError {
    //@Setter(AccessLevel.NONE)
    private int status;
    private LocalDateTime dataHora;
    private String path;
    private String mensagem;
    private List<ErrorField> campos;
}
  
