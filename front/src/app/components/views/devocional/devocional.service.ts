import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Devocional } from './devocional.model';

@Injectable({
  providedIn: 'root'
})
export class DevocionalService {
  baseUrl: String = environment.baseUrl;

  constructor(private http: HttpClient) { }

  findAll(): Observable<Devocional[]> {
    const url = `${this.baseUrl}/devocional`;
    return this.http.get<Devocional[]>(url);
  }
}
