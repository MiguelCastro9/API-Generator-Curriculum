import { ExperienciaProfissional } from "./experienciaProfissional";
import { FormacaoAcademica } from "./formacaoAcademica";
import { Idiomas } from "./idiomas";

export interface Curriculum {

  nome_completo: string;
  cargo_atual: string;
  estado: string;
  pais: string;
  numero_contato: string;
  email_contato: string;
  links_contato: string[];
  objetivo_profissional: string;
  experiencias_profissionais: ExperienciaProfissional[];
  conhecimentos: string[];
  formacoes_academicas: FormacaoAcademica[];
  idiomas: Idiomas[];
}
