import { Injectable } from '@angular/core';
import { environment } from './environments/environment.dev';
import { HttpClient } from '@angular/common/http';
import { Curriculum } from './model/curriculum';

@Injectable({
  providedIn: 'root'
})
export class CurriculumService {

  api_url = environment.api_url;

  constructor(private http: HttpClient) { }

  exportPdf(curriculum: Curriculum) {
    return this.http.post(this.api_url + '/curriculum/exportPdf', curriculum, { responseType: 'blob' });
  }
}
