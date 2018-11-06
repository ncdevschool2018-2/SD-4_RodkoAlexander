import {Teacher} from "./teacher";

export class Lesson {
  id: number;
  timeStart: string;
  timeEnd: string;
  description: string;
  room: string;
  type: string;
  teacher: Teacher;
}
