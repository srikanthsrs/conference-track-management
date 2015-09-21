package srikanth.tw.ctm.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeTest {
    @Test
    public void testMinutesToDisplayTime() {
        assertEquals("01:00 AM", Time.minutesToDisplayTime(1 * 60));
        assertEquals("12:00 AM", Time.minutesToDisplayTime(0));
        assertEquals("12:00 PM", Time.minutesToDisplayTime(12 * 60));
        assertEquals("01:00 PM", Time.minutesToDisplayTime(13 * 60));
        assertEquals("11:59 PM", Time.minutesToDisplayTime(12 * 60 + 11 * 60 + 59));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testMinutesToDisplayTimeBoundary() {
        assertEquals("12:00 AM", Time.minutesToDisplayTime(12 * 60 + 12 * 60));
    }
}
