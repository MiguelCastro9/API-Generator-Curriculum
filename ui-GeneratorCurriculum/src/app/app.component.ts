import { Component } from '@angular/core';
import { Curriculum } from './model/curriculum';
import { CurriculumService } from './curriculum.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'ui-GeneratorCurriculum';

  curriculum: Curriculum = {
    nome_completo: '',
    cargo_atual: '',
    estado: '',
    pais: '',
    numero_contato: '',
    email_contato: '',
    links_contato: [],
    objetivo_profissional: '',
    experiencias_profissionais: [{
      nome_empresa: '',
      cargo: '',
      data_inicio: undefined,
      data_fim: undefined,
      descricao_cargo: ''
    }],
    conhecimentos: [],
    formacoes_academicas: [{
      nome_curso: '',
      data_inicio: undefined,
      data_fim: undefined,
      nome_instituicao: ''
    }],
    idiomas: [{
      nome_idioma: '',
      nivel_conversacao: 0,
      nivel_escrita_leitura: 0
    }]
  };

  link!: string;
  experienciasProfissionais: any[] = [];
  adicionaProfissao: number[] = [];
  totalProfissao!: number;
  conhecimento!: string;
  formacoesAcademicas: any[] = [];
  adicionaFormacao: number[] = [];
  totalFormacao!: number;
  idiomas: any[] = [];
  adicionaIdioma: number[] = [];
  totalIdiomas!: number;
  alertMensagem = '';

  constructor(private curriculumService: CurriculumService) { }

  ngOnInit(): void {

    this.totalProfissao = 1;
    this.totalFormacao = 1;
    this.totalIdiomas = 1;

  }

  anoAtualInputData(): string {
    const dia = new Date();
    const ano = dia.getFullYear();
    const mes = dia.getMonth() + 1;
    const mesString = mes < 10 ? '0' + mes : mes.toString();

    return `${ano}-${mesString}`;
  }

  adicionarLinksContato(link: string) {
    this.curriculum.links_contato.push(link);
  }

  removerLinksContato(index: number) {
    this.curriculum.links_contato.splice(index, 1);
  }

  adicionarConhecimentos(conhecimento: string) {
    this.curriculum.conhecimentos.push(conhecimento);
  }

  removerConhecimentos(index: number) {
    this.curriculum.conhecimentos.splice(index, 1);
  }

  adicionarProfissao(event: Event) {
    event.preventDefault();
    this.totalProfissao++;
    this.adicionaProfissao.push(this.totalProfissao);
    const novaProfissao = {
      nome_empresa: '',
      cargo: '',
      data_inicio: undefined,
      data_fim: undefined,
      descricao_cargo: ''
    };
    this.curriculum.experiencias_profissionais.push(novaProfissao);
  }

  removerProfissao(index: number) {
    this.totalProfissao--;
    this.adicionaProfissao.splice(index, 1);
    this.curriculum.experiencias_profissionais.splice(index, 1);
  }

  adicionarFormacao(event: Event) {
    event.preventDefault();
    this.totalFormacao++;
    this.adicionaFormacao.push(this.totalFormacao);
    const novaFormacao = {
      nome_curso: '',
      data_inicio: undefined,
      data_fim: undefined,
      nome_instituicao: ''
    };
    this.curriculum.formacoes_academicas.push(novaFormacao);
  }

  removerFormacao(index: number) {
    this.totalFormacao--;
    this.adicionaFormacao.splice(index, 1);
    this.curriculum.formacoes_academicas.splice(index, 1);
  }

  adicionarIdioma(event: Event) {
    event.preventDefault();
    this.totalIdiomas++;
    this.adicionaIdioma.push(this.totalIdiomas);
    const novoIdioma = {
      nome_idioma: '',
      nivel_conversacao: 0,
      nivel_escrita_leitura: 0
    };
    this.curriculum.idiomas.push(novoIdioma);
  }

  removerIdioma(index: number) {
    this.totalIdiomas--;
    this.adicionaIdioma.splice(index, 1);
    this.curriculum.idiomas.splice(index, 1);
  }

  validarFormulario() {
    if (!this.curriculum.nome_completo) {
      this.alertMensagem = 'Campo nome é obrigatório.';
      return false;
    }
    if (!this.curriculum.estado) {
      this.alertMensagem = 'Campo estado é obrigatório.';
      return false;
    }
    if (!this.curriculum.pais) {
      this.alertMensagem = 'Campo país é obrigatório.';
      return false;
    }
    if (!this.curriculum.numero_contato) {
      this.alertMensagem = 'Campo número de contato é obrigatório.';
      return false;
    }
    if (this.curriculum.numero_contato.length < 15) {
      this.alertMensagem = 'Campo número de contato inválido.';
      return false;
    }
    if (!this.curriculum.email_contato) {
      this.alertMensagem = 'Campo e-mail é obrigatório.';
      return false;
    }
    if (!this.curriculum.objetivo_profissional) {
      this.alertMensagem = 'Campo objetivo profissional é obrigatório.';
      return false;
    }
    if (this.curriculum.links_contato.length == 0) {
      this.alertMensagem = 'Campo link de contato é obrigatório.';
      return false;
    }
    if (this.curriculum.experiencias_profissionais.length === 0) {
      this.alertMensagem = 'Pelo menos uma experiência profissional é obrigatória.';
      return false;
    }
    for (let i = 0; i < this.curriculum.experiencias_profissionais.length; i++) {
      const experiencia = this.curriculum.experiencias_profissionais[i];

      if (!experiencia.nome_empresa) {
        this.alertMensagem = `Campo nome da empresa (${i + 1}) é obrigatório.`;
        return false;
      }

      if (!experiencia.cargo) {
        this.alertMensagem = `Campo cargo (${i + 1}) é obrigatório.`;
        return false;
      }

      if (!experiencia.data_inicio) {
        this.alertMensagem = `Campo data início (${i + 1}) é obrigatório.`;
        return false;
      }

      if (!experiencia.descricao_cargo) {
        this.alertMensagem = `Campo descrição de atividades (${i + 1}) é obrigatório.`;
        return false;
      }
    }
    if (this.curriculum.conhecimentos.length == 0) {
      this.alertMensagem = 'Campo conhecimentos é obrigatório.';
      return false;
    }
    if (this.curriculum.formacoes_academicas.length === 0) {
      this.alertMensagem = 'Pelo menos uma formação acadêmica é obrigatória.';
      return false;
    }
    for (let i = 0; i < this.curriculum.formacoes_academicas.length; i++) {
      const formacao = this.curriculum.formacoes_academicas[i];

      if (!formacao.nome_curso) {
        this.alertMensagem = `Campo nome do curso (${i + 1}) é obrigatório.`;
        return false;
      }

      if (!formacao.data_inicio) {
        this.alertMensagem = `Campo data início (${i + 1}) é obrigatório.`;
        return false;
      }

      if (!formacao.nome_instituicao) {
        this.alertMensagem = `Campo nome da instituição (${i + 1}) é obrigatório.`;
        return false;
      }
    }
    if (this.curriculum.idiomas.length === 0) {
      this.alertMensagem = 'Pelo menos um idioma é obrigatório.';
      return false;
    }
    for (let i = 0; i < this.curriculum.idiomas.length; i++) {
      const idioma = this.curriculum.idiomas[i];

      if (!idioma.nome_idioma) {
        this.alertMensagem = `Campo nome do idioma (${i + 1}) é obrigatório.`;
        return false;
      }

      if (!idioma.nivel_conversacao) {
        this.alertMensagem = `Campo nível de conversação (${i + 1}) é obrigatório.`;
        return false;
      }

      if (!idioma.nivel_escrita_leitura) {
        this.alertMensagem = `Campo nível de escrita/leitura (${i + 1}) é obrigatório.`;
        return false;
      }
    }
    return true;
  }

  exportPdf(curriculum: Curriculum) {
    if (!this.validarFormulario()) {
      return;
    }
    this.curriculumService.exportPdf(curriculum).subscribe(blob => {
      const downloadLink = document.createElement('a');
      const url = URL.createObjectURL(blob);
      downloadLink.href = url;
      downloadLink.download = 'curriculum.pdf';
      downloadLink.click();
      URL.revokeObjectURL(url);
    });
  }
}


