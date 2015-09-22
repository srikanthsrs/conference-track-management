package srikanth.tw.ctm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import srikanth.tw.ctm.util.Logger;

public class ConferenceSchedulerMain {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();

        if (args.length < 1) {
            logger.fatal("Input file with events must be supplied to this program.");
            System.exit(1);
        }

        File inputFile = new File(args[0]);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            Conference conference = new ConferenceScheduler().schedule(reader);
            logger.info(conference);
        } catch (IOException e) {
            logger.fatal("Cannot read from input file: " + inputFile.getAbsolutePath());
            System.exit(1);
        }
    }
}
