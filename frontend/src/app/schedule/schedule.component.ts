import {Component, OnInit} from '@angular/core';
import {TableData} from '../data/tableData';
import {LessonType} from '../data/lessonType';
import {WeekDay} from '@angular/common';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})

export class ScheduleComponent implements OnInit {
  public days: WeekDay[];
  public date: string;
  public header: TableData;
  public classes: TableData[];

  constructor() {
    this.days = [ WeekDay.Monday, WeekDay.Tuesday, WeekDay.Wednesday, WeekDay.Thursday, WeekDay.Friday , WeekDay.Saturday ];
    this.date = new Date().toDateString();
    this.classes = [new TableData('KIT', '13.25-15.00', 'Rusetski', '607-5', LessonType.Practical),
      new TableData('KIT', '13.25-15.00', 'Rusetski', '607-5', LessonType.Practical),
      new TableData('KIT', '13.25-15.00', 'Rusetski', '607-5', LessonType.Practical)];
    this.header = new TableData('Lesson', 'Time', 'Teacher', 'Audithorium', 'Type');
  }

  ngOnInit() {
  }
}
