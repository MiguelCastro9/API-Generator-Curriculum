import { Component } from '@angular/core';
import { Curriculum } from './model/curriculum';

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
      nivel_conversacao: '',
      nivel_escrita_leitura: ''
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

  constructor() { }

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
      nivel_conversacao: '',
      nivel_escrita_leitura: ''
    };
    this.curriculum.idiomas.push(novoIdioma);
  }

  removerIdioma(index: number) {
    this.totalIdiomas--;
    this.adicionaIdioma.splice(index, 1);
    this.curriculum.idiomas.splice(index, 1);
  }
}


