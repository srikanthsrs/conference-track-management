package srikanth.tw.ctm;

import static srikanth.tw.ctm.util.Constant.NEW_LINE;

import java.util.ArrayList;
import java.util.List;

import srikanth.tw.ctm.util.Time;

public class Slot {
	private List<Event> events;
	private int remainingDuration;
	private int startTime;
	private Slot supplement;

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

	public void addSupplementSlot(Slot slot) {
		this.supplement = slot;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		int nextEventStartTime = addEventsSchedule(events, startTime, str);
		if (supplement != null) {
			int supplementStartTime = supplement.startTime;
			if (nextEventStartTime > supplement.startTime) {
				supplementStartTime = nextEventStartTime;
			}
			nextEventStartTime = addEventsSchedule(supplement.events, supplementStartTime, str);
		}
		return str.toString();
	}

	/**
	 * Adds events to be added to the StringBuilder with their starting time and their duration.
	 *
	 * @param events the events to be added to the StringBuilder.
	 * @param startTime the start time of the first event.
	 * @param str the StringBuilder object to which the schedule must be added.
	 * @return the time at which the events end.
	 */
	private int addEventsSchedule(List<Event> events, int startTime, StringBuilder str) {
		int nextEventStartTime = startTime;
		for (Event event : events) {
			str.append(Time.minutesToDisplayTime(nextEventStartTime) + " " + event + NEW_LINE);
			nextEventStartTime += event.getDurationInMinutes();
		}

		return nextEventStartTime;
	}
}
