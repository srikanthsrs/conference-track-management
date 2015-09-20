package srikanth.tw.ctm.util;

public final class Time {
	private Time() {}

	public static String minutesToDisplayTime(int minutes) {
        int hours = minutes / 60;
        String hoursToDisplay = Integer.toString(hours);
        if (hours > 12) {
            hoursToDisplay = Integer.toString(hours - 12);
        }
        if (hoursToDisplay.length() == 1) {
        	hoursToDisplay = "0" + hoursToDisplay;
        }

        minutes = minutes - (hours * 60);
        String minutesToDisplay = null;
		if (minutes == 0 ) {
			minutesToDisplay = "00";
		} else if (minutes < 10) {
        	minutesToDisplay = "0" + minutes;
        } else {
        	minutesToDisplay = "" + minutes;
        }

        String displayValue = hoursToDisplay + ":" + minutesToDisplay;
        if (hours < 12) {
            displayValue = displayValue + " AM";
        } else {
            displayValue = displayValue + " PM";
        }

        return displayValue;
	}
}
