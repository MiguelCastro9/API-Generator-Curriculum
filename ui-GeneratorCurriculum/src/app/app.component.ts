import { Component } from '@angular/core';
import { Curriculum } from './model/curriculum';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

  //QUANDO FOR REALIZAR A REQUISAO AI PASSA (this.curriculum.experiencia_profissional = this.experienciasProfissionais)

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

  constructor() { }

  ngOnInit(): void {

    this.totalProfissao = 1;
    this.totalFormacao = 1;

  }

  adicionarLinksContato(link: string) {
    this.curriculum.links_contato.push(link);
  }

  adicionarProfissao() {
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

  adicionarConhecimentos(conhecimento: string) {
    this.curriculum.conhecimentos.push(conhecimento);
  }

  adicionarFormacao() {
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
}


