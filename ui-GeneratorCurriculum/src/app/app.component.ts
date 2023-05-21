import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ui-GeneratorCurriculum';

  nome!: string;
  cargo_atual!: string;
  estado!: string;
  pais!: string;
  numero_contato!: string;
  email_contato!: string;

  constructor() { }

  ngOnInit(): void {

  }
}


