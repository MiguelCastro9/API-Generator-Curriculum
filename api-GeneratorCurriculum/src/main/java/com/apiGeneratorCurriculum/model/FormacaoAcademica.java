package com.apiGeneratorCurriculum.model;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Miguel Castro
 */
@Data
public class FormacaoAcademica {
    
    private String nome_curso;
    
    private Date data_inicio;
    
    private Date data_fim;
    
    private String nome_instituicao;
}
