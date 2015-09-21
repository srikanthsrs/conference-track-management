package srikanth.tw.ctm.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

import srikanth.tw.ctm.DurationUnit;

public final class Config {
	private Config() {}

	public static final Pattern INPUT_LINE_PATTERN = Pattern.compile(
			"^(.+)\\s(\\d+)?\\s?((min)|(lightning))$");
	public static final int EVENT_NAME_INDEX = 1;
	public static final int EVENT_DURATION_INDEX = 2;
	public static final int EVENT_DURATION_UNIT_INDEX = 3;

	public static final int MORNING_SLOT_DURATION = 180;
	public static final int LUNCH_SLOT_DURATION = 60;
	public static final int AFTERNOON_SLOT_DURATION = 240;

	public static final int MORNING_SLOT_START_TIME = 9 * 60;
	public static final int LUNCH_SLOT_START_TIME = MORNING_SLOT_START_TIME + MORNING_SLOT_DURATION;
	public static final int AFTERNOON_SLOT_START_TIME = LUNCH_SLOT_START_TIME + LUNCH_SLOT_DURATION;

	public static final int MAX_EVENT_DURATION = Collections.max(Arrays.asList(
			MORNING_SLOT_DURATION, LUNCH_SLOT_DURATION, AFTERNOON_SLOT_DURATION));

	public static final DurationUnit LUNCH_SLOT_DURATION_UNIT = DurationUnit.MINUTES;
	public static final String LUNCH_SLOT_NAME = "Lunch";
	public static final String NETWORKING_EVENT_NAME = "Networking Event";
	public static final int NETWORKING_EVENT_DURATION = 60;
	public static final DurationUnit NETWORKING_EVENT_DURATION_UNIT = DurationUnit.MINUTES;
	public static final int NETWORKING_EVENT_MIN_START_TIME = (12 * 60) + (4 * 60); // 4 PM.
}
