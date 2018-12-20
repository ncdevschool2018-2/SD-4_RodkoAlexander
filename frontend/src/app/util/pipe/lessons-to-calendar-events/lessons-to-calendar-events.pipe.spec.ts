import { LessonsToCalendarEventsPipe } from './lessons-to-calendar-events.pipe';

describe('LessonsToCalendarEventsPipe', () => {
  it('create an instance', () => {
    const pipe = new LessonsToCalendarEventsPipe();
    expect(pipe).toBeTruthy();
  });
});
