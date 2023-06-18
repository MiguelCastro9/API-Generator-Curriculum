package com.apiGeneratorCurriculum.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 *
 * @author Miguel Castro
 */
@Data
@Schema(name = "Experiência Profissional - response")
public class ExperienciaProfissionalResponse {
    
    private String nome_empresa;
    
    private String cargo;
    
    private String data_inicio;
    
    private String data_fim;
    
    private String descricao_cargo;
}
