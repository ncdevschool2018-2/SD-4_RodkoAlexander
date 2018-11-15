import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Group} from "../../model/group";
import {User} from "../../model/user";

@Injectable({
  providedIn: 'root'
})
export class GroupService {

  constructor(private http: HttpClient) {
  }

  getGroups(): Observable<Group[]> {
    return this.http.get<Group[]>('/api/groups');
  }

  getStudents(id: number): Observable<User[]> {
    return this.http.get<User[]>('/api/groups/' + id + '/students');
  }

  saveGroup(group: Group): Observable<Group> {
    return this.http.post<Group>('/api/groups', group);
  }

  deleteGroup(id: number): Observable<void> {
    return this.http.delete<void>('/api/groups/' + id);
  }

  getDescriptions(): Observable<Group[]> {
    return this.http.get<Group[]>('/api/groups/descriptions');
  }
}
