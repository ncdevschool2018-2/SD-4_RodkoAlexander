import { Pipe, PipeTransform } from '@angular/core';
import {Group} from "../../../model/group";

@Pipe({
  name: 'groupsNumbers'
})
export class GroupsNumbersPipe implements PipeTransform {

  transform(value: Group[], args?: any): any {
    let result:string = "";
    value.forEach(function(valueGroup) {
      result = result.concat(valueGroup.id + ',')
    });
    return result.slice(0,result.length-1);

  }

}
