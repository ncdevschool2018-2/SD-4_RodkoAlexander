import {Component, OnInit, TemplateRef, ViewChild} from "@angular/core";
import {CalendarEvent, CalendarEventTimesChangedEvent, CalendarView} from 'angular-calendar';
import {isSameDay, isSameMonth} from 'date-fns';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {Subject, Subscription} from "rxjs";
import {ScheduleService} from "../../connect/schedule/schedule.service";
import {LessonToCalendarEventPipe} from "../../modify/pipe/lesson-to-calendar-event/lesson-to-calendar-event.pipe";
import {Ng4LoadingSpinnerService} from "ng4-loading-spinner";

const colors: any = {
  red: {
    primary: '#ad2121',
    secondary: '#FAE3E3'
  },
  blue: {
    primary: '#1e90ff',
    secondary: '#D1E8FF'
  },
  yellow: {
    primary: '#e3bc08',
    secondary: '#FDF1BA'
  }
};

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  @ViewChild('modalContent')
  modalContent: TemplateRef<any>;

  view: CalendarView = CalendarView.Month;

  CalendarView = CalendarView;
  viewDate: Date = new Date();
  modalData: {
    action: string;
    event: CalendarEvent;
  };
  refresh: Subject<any> = new Subject();
  events: CalendarEvent[] = [];
  activeDayIsOpen: boolean = true;
  private subscriptions: Subscription[] = [];

  constructor(private modal: NgbModal,
              private lessonService: ScheduleService,
              private lessonToCalendarEventPipe: LessonToCalendarEventPipe,
              private loadingService: Ng4LoadingSpinnerService) {
  }

  dayClicked({date, events}: { date: Date; events: CalendarEvent[] }): void {
    if (isSameMonth(date, this.viewDate)) {
      this.viewDate = date;
      if (
        (isSameDay(this.viewDate, date) && this.activeDayIsOpen === true) ||
        events.length === 0
      ) {
        this.activeDayIsOpen = false;
      } else {
        this.activeDayIsOpen = true;
      }
    }
  }

  eventTimesChanged({
                      event,
                      newStart,
                      newEnd
                    }: CalendarEventTimesChangedEvent): void {
    event.start = newStart;
    event.end = newEnd;
    this.handleEvent('Dropped or resized', event);
    this.refresh.next();
  }

  handleEvent(action: string, event: CalendarEvent): void {
    this.modalData = {event, action};
    this.modal.open(this.modalContent, {size: 'lg'});
  }

  close() {
    this.modal.dismissAll()
  }

  ngOnInit(): void {
    this.loadLessons();
  }

  private loadLessons(): void {
    this.loadingService.show();
    this.subscriptions.push(this.lessonService.getLessons().subscribe(lessons => {
      this.events = this.lessonToCalendarEventPipe.transform(lessons);
      this.loadingService.hide();
    }));
  }
}
