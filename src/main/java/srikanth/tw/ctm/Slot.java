package srikanth.tw.ctm;

import static srikanth.tw.ctm.util.Constant.NEW_LINE;

import java.util.ArrayList;
import java.util.List;

import srikanth.tw.ctm.util.Time;

public class Slot {
	private List<Event> events;
	private int remainingDuration;
	private int startTime;

	public Slot(int duration, int startTime) {
		this.remainingDuration = duration;
		this.startTime = startTime;
		events = new ArrayList<Event>();
	}

	public void addEvent(Event event) {
		if (remainingDuration < event.getDurationInMinutes()) {
			throw new IllegalStateException("Not enough room in this slot to fit the event: '"
					+ event.getName() + "'");
		}
		events.add(event);
		remainingDuration -= event.getDurationInMinutes();
	}

	public boolean hasRoomFor(Event event) {
		return remainingDuration >= event.getDurationInMinutes();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		int nextEventStartTime = startTime;
		for (Event event : events) {
			// TODO(srikanth): Add the networking session no earlier than 4pm and no later than 5pm.
			str.append(Time.minutesToDisplayTime(nextEventStartTime) + " " + event + NEW_LINE);
			nextEventStartTime += event.getDurationInMinutes();
		}
		return str.toString();
	}
}
