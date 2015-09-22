package srikanth.tw.ctm;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import srikanth.tw.ctm.util.FileUtil;

public class ConferenceTrackManagementTest {
    @Test
    public void testConferenceTrackManagementMultipleFullDayEvents() throws IOException {
    	testConferenceTrackManagement("/input_file");
    }

    @Test
    public void testConferenceTrackManagementMultipleDayLessEvents() throws IOException {
    	testConferenceTrackManagement("/input_file_less_events");
    }

    @Test
    public void testConferenceTrackManagementSingleDayEvents() throws IOException {
    	testConferenceTrackManagement("/input_file_single_day_events");
    }

    private void testConferenceTrackManagement(String inputFile) throws IOException {
    	Conference conference = new ConferenceScheduler().schedule(
    			FileUtil.getBufferedReaderForResourceFile(inputFile, this));
    	assertTrue(FileUtil.contentEquals(getExpectedOutputFile(inputFile),
    			conference.toString(), this));
    }

    private String getExpectedOutputFile(String inputFile) {
    	return inputFile + "_expected";
    }
}
