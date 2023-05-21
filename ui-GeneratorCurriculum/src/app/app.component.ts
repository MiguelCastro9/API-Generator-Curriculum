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

  constructor() { }

  ngOnInit(): void {

  }

  adicionarLinksContato(link: string) {
    this.curriculum.links_contato.push(link);
  }
}


