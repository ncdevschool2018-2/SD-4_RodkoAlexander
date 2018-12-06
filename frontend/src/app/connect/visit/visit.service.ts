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

  getVisits(lessonId: number,groupId: number): Observable<Visit[]> {
    return this.http.get<Visit[]>('/lessons/' + lessonId + '/groups/' + groupId);
  }

  saveVisits(visits: Visit[]): Observable<Visit[]> {
    return this.http.post<Visit[]>('/api/visits', visits);
  }

}
