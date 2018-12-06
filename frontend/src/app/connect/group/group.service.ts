import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Group} from "../../model/group";
import {tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class GroupService {

  constructor(private http: HttpClient) {
  }

  getGroups(page: number,size :number): Observable<Group[]> {
    return this.http.get<Group[]>('/api/groups?page='+page+'&size='+size);
  }

  getGroupsByParam(paramName: string,paramValue :number): Observable<Group[]> {
    return this.http.get<Group[]>('/api/groups?'+paramName + '=' + paramValue);
  }

  saveGroup(group: Group): Observable<Group> {
    return this.http.post<Group>('/api/groups', group);
  }

  deleteGroup(id: number): Observable<void> {
    return this.http.delete<void>('/api/groups/' + id);
  }


  count(): Observable<number> {
    return this.http.get<number>('/api/groups/count');
  }

}
