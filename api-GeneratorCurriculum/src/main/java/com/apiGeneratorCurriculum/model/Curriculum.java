package com.apiGeneratorCurriculum.model;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Miguel Castro
 */
@Data
public class Curriculum {
    
    private String nome_completo;
    
    private String estado;
    
    private String pais;
    
    private String numero_contato;
    
    private String email_contato;
    
    private List<String> links_contato;
    
    private String objetivo_profissional;
    
    private List<ExperienciaProfissional> experiencias_profissionais;
    
    private List<String> conhecimentos;
    
    private List<FormacaoAcademica> formacoes_academicas;
    
    private List<Idiomas> idiomas;
}
