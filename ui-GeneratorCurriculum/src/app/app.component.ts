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
    experiencia_profissional: [{
      nome_empresa: '',
      cargo: '',
      data_inicio: undefined,
      data_fim: undefined,
      descricao_cargo: ''
    }],
    conhecimentos: []
  };

  link!: string;
  experienciasProfissionais: any[] = [];
  adicionaProfissao: number[] = [];
  totalProfissao!: number;
  conhecimento!: string;

  constructor() { }

  ngOnInit(): void {

    this.totalProfissao = 1;

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
    this.curriculum.experiencia_profissional.push(novaProfissao);
  }

  removerProfissao(index: number) {
    this.totalProfissao--;
    this.adicionaProfissao.splice(index, 1);
    this.curriculum.experiencia_profissional.splice(index, 1);
  }

  //QUANDO FOR REALIZAR A REQUISAO AI PASSA (this.curriculum.experiencia_profissional = this.experienciasProfissionais)
  definirProfissoes() {

  }

  adicionarConhecimentos(conhecimento: string) {
    this.curriculum.conhecimentos.push(conhecimento);
  }
}


