package com.apiGeneratorCurriculum.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Miguel Castro
 */
@Data
@AllArgsConstructor
public class MensagemException {

    private String mensagemUsuario;
    private String mensagemDesenvolvedor;
}
