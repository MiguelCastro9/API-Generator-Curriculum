package com.apiGeneratorCurriculum.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 *
 * @author Miguel Castro
 */
@Data
@Schema(name = "Idiomas - response")
public class IdiomasResponse {
    
    private String nome_idioma;
    
    private Integer nivel_conversacao;
    
    private Integer nivel_escrita_leitura;
}
