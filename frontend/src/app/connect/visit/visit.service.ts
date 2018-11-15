import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Visit} from "../../model/visit";

@Injectable({
  providedIn: 'root'
})
export class VisitService {

  constructor(private http: HttpClient) {
  }

  getVisits(): Observable<Visit[]> {
    return this.http.get<Visit[]>('/api/svisits');
  }

  saveVisits(stl: Visit): Observable<Visit> {
    return this.http.post<Visit>('/api/svisits', stl);
  }

}
