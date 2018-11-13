import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Group} from "../../model/group";
import {forEach} from "@angular/router/src/utils/collection";
import {stringDistance} from "codelyzer/util/utils";

@Injectable({
  providedIn: 'root'
})
export class GroupService {

  constructor(private http: HttpClient) {
  }

  getGroups(): Observable<Group[]> {
    return this.http.get<Group[]>('/api/groups');
  }
  getGroupNumbers(): Observable<number[]> {
    return this.http.get<number[]>('/api/groups/numbers');
  }

  saveGroup(group: Group): Observable<Group> {
    return this.http.post<Group>('/api/groups', group);
  }

  deleteGroup(groupId: string): Observable<void> {
    return this.http.delete<void>('/api/groups/' + groupId);
  }
  getDescriptions(): Observable<Group[]> {
    return this.http.get<Group[]>('/api/groups/descriptions');
  }
}
