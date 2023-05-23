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
  };

  link!: string;
  experienciasProfissionais: any[] = [];
  adicionaProfissao: number[] = [];
  totalProfissao!: number;

  constructor() { }

  ngOnInit(): void {

    this.totalProfissao = 0;

  }

  adicionarLinksContato(link: string) {
    this.curriculum.links_contato.push(link);
  }

  adicionarProfissao() {
    this.totalProfissao++;
    this.experienciasProfissionais.splice(this.totalProfissao, 1);
    const novaProfissao = {
      nome_empresa: '',
      cargo: '',
      data_inicio: undefined,
      data_fim: undefined,
      descricao_cargo: ''
    };
    this.experienciasProfissionais.push(novaProfissao);
    console.log('add: ' + this.experienciasProfissionais);

  }

  removerProfissao(index: number) {
    this.totalProfissao--;
    this.adicionaProfissao.splice(index, 1);
    this.experienciasProfissionais.splice(index, 1);
    console.log('del: ' + this.experienciasProfissionais);
  }

  //QUANDO FOR REALIZAR A REQUISAO AI PASSA (this.curriculum.experiencia_profissional = this.experienciasProfissionais)

}


