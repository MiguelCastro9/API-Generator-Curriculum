package com.apiGeneratorCurriculum.model;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Miguel Castro
 */
@Data
public class ExperienciaProfissional {
    
    private String nome_empresa;
    
    private String cargo;
    
    private Date data_inicio;
    
    private Date data_fim;
    
    private String descricao_cargo;
}
