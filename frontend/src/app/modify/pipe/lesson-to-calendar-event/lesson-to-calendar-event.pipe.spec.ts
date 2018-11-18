import { LessonToCalendarEventPipe } from './lesson-to-calendar-event.pipe';

describe('LessonToCalendarEventPipe', () => {
  it('create an instance', () => {
    const pipe = new LessonToCalendarEventPipe();
    expect(pipe).toBeTruthy();
  });
});
