package com.apiGeneratorCurriculum.model;

import lombok.Data;

/**
 *
 * @author Miguel Castro
 */
@Data
public class ExperienciaProfissional {
    
    private String nome_empresa;
    
    private String cargo;
    
    private String data_inicio;
    
    private String data_fim;
    
    private String descricao_cargo;
}
