import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { OntarioRealtimeData } from './ontario-realtime-data/ontario-realtime-data.component';

@Injectable({
  providedIn: 'root'
})
export class OntarioRealtimeService {

  #baseUrl: string = environment.BASE_URL;
  constructor(private _httpClient: HttpClient) { }

  getData(): Observable<OntarioRealtimeData> {
      return this._httpClient.get<OntarioRealtimeData>(this.#baseUrl);
  }

  downloadCsv(): Observable<Blob> {
    const url = this.#baseUrl + "/export";
    return this._httpClient.get<Blob>(url);
  }
}
