package com.apiGeneratorCurriculum.response;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Miguel Castro
 */
@Data
@Schema(name = "Formação Acadêmica - response")
public class FormacaoAcademicaResponse {
    
    @NotBlank(message = "Nome do curso é obrigatório.")
    @Length(min = 10, max = 60, message = "Nome do curso requer no mínimo {min} e no máximo {max} caracteres.")
    private String nome_curso;
    
    @NotNull(message = "Data início é obrigatório.")
    private String data_inicio;
    
    private String data_fim;
    
    @NotBlank(message = "Nome da instituição é obrigatório.")
    @Length(min = 5, max = 60, message = "Nome da instituição requer no mínimo {min} e no máximo {max} caracteres.")
    private String nome_instituicao;
}
