package com.apiGeneratorCurriculum.model;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Miguel Castro
 */
@Data
public class FormacaoAcademica {
    
    @NotBlank(message = "Nome do curso é obrigatório.")
    @Length(min = 10, max = 60, message = "Nome do curso requer no mínimo {min} e no máximo {max} caracteres.")
    private String nome_curso;
    
    @NotNull(message = "Data início é obrigatório.")
    private Date data_inicio;
    
    private Date data_fim;
    
    @NotBlank(message = "Nome da instituição é obrigatório.")
    @Length(min = 5, max = 60, message = "Nome da instituição requer no mínimo {min} e no máximo {max} caracteres.")
    private String nome_instituicao;
}
