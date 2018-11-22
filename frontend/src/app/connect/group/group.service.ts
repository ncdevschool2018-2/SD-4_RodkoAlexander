import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Group} from "../../model/group";
import {SecurityService} from "../security/security.service";

@Injectable({
  providedIn: 'root'
})
export class GroupService {

  constructor(private http: HttpClient,private security: SecurityService) {
  }

  getGroups(): Observable<Group[]> {
    return this.http.get<Group[]>('/api/groups',{headers : this.security.getSecurityHeaders()});
  }

  saveGroup(group: Group): Observable<Group> {
    return this.http.post<Group>('/api/groups', group,{headers : this.security.getSecurityHeaders()});
  }

  deleteGroup(id: number): Observable<void> {
    return this.http.delete<void>('/api/groups/' + id,{headers : this.security.getSecurityHeaders()});
  }
}
