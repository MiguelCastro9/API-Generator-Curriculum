package com.apiGeneratorCurriculum.model;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Miguel Castro
 */
@Data
public class Curriculum {

    @NotBlank(message = "Nome é obrigatório.")
    @Length(min = 3, max = 40, message = "Nome requer no mínimo {min} e no máximo {max} caracteres.")
    private String nome_completo;

    private String cargo_atual;

    @NotBlank(message = "Estado é obrigatório.")
    @Length(min = 3, max = 20, message = "Estado requer no mínimo {min} e no máximo {max} caracteres.")
    private String estado;

    @NotBlank(message = "País é obrigatório.")
    @Length(min = 3, max = 20, message = "País requer no mínimo {min} e no máximo {max} caracteres.")
    private String pais;

    @NotBlank(message = "Número de contato é obrigatório.")
    @Length(min = 10, max = 20, message = "Número de contato requer no mínimo {min} e no máximo {max} caracteres.")
    private String numero_contato;

    @NotBlank(message = "E-mail de contato é obrigatório.")
    @Length(min = 3, max = 60, message = "E-mail de contato requer no mínimo {min} e no máximo {max} caracteres.")
    private String email_contato;

    @Size(max = 10, message = "A lista de links de contato deve ter no máximo {max} links.")
    private List<String> links_contato;

    @NotBlank(message = "Objetivo profissional é obrigatório.")
    @Length(min = 10, max = 60, message = "Objetivo profissional requer no mínimo {min} e no máximo {max} caracteres.")
    private String objetivo_profissional;

    @Size(max = 10, message = "A lista de experiências deve ter no máximo {max} experiências")
    private List<ExperienciaProfissional> experiencias_profissionais;

    @NotEmpty(message = "A lista de conhecimentos não pode estar vazia.")
    @Size(min = 1, max = 50, message = "A lista requer no mínimo {min} e no máximo {max} conhecimentos e experiências.")
    private List<@NotBlank @Length(min = 3, max = 20, message = "Cada item requer no mínimo {min} e no máximo {max} caracteres.") String> conhecimentos;

    @Valid
    @Size(max = 10, message = "A lista de formações deve ter no máximo {max} formações")
    private List<FormacaoAcademica> formacoes_academicas;

    @Size(max = 10, message = "A lista de idiomas deve ter no máximo {max} idiomas")
    private List<Idiomas> idiomas;
}
