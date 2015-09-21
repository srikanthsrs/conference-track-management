package srikanth.tw.ctm;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import srikanth.tw.ctm.util.FileUtil;

public class ConferenceTrackManagementTest {
    @Test
    public void testConferenceTrackManagement() throws IOException {
    	String[] inputFiles = { "/input_file", "/input_file_less_events" };
    	for (String inputFile : inputFiles) {
    		String expectedOutputFile = inputFile + "_expected";
        	Conference conference = new ConferenceScheduler().schedule(
        			FileUtil.getBufferedReaderForResourceFile(inputFile, this));
        	assertTrue(FileUtil.contentEquals(expectedOutputFile, conference.toString(), this));
        }
    }
}
