import { ExperienciaProfissional } from "./experienciaProfissional";

export interface Curriculum {

  nome_completo: string;
  cargo_atual: string;
  estado: string;
  pais: string;
  numero_contato: string;
  email_contato: string;
  links_contato: string[];
  objetivo_profissional: string;
  experiencia_profissional: ExperienciaProfissional[];

}
