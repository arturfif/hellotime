package core;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Hello {

    private static Logger LOG = Logger.getLogger(Hello.class.getName());
    private static FileHandler fileHandler;

    private static final String MORNING = "morning";
    private static final String DAY = "day";
    private static final String EVENING = "evening";
    private static final String NIGHT = "night";

    private static final String MORNING_TIME_TEXT = "06:00";
    private static final String DAY_TIME_TEXT = "09:00";
    private static final String EVENING_TIME_TEXT = "19:00";
    private static final String NIGHT_TIME_TEXT = "23:00";

    private static final Date MORNING_TIME;
    private static final Date DAY_TIME;
    private static final Date EVENING_TIME;
    private static final Date NIGHT_TIME;

    private static final DateFormat PARSER = new SimpleDateFormat("HH:mm");
    private static final String BUNDLE_NAME = "hello";

    static {
        try {
            MORNING_TIME = PARSER.parse(MORNING_TIME_TEXT);
            DAY_TIME = PARSER.parse(DAY_TIME_TEXT);
            EVENING_TIME = PARSER.parse(EVENING_TIME_TEXT);
            NIGHT_TIME = PARSER.parse(NIGHT_TIME_TEXT);


        } catch (ParseException e) {
            throw new AssertionError();
        }

        try {
            fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            LOG.addHandler(fileHandler);
        } catch (IOException e) {
            throw new AssertionError();
        }
    }

    private Hello() {}

    static String getTimeKey(Date time) {
        Date parsedTime;

        try {
            parsedTime = PARSER.parse(PARSER.format(time));
        } catch (ParseException e) {
            throw new AssertionError();
        }

        if ((parsedTime.after(MORNING_TIME) || parsedTime.compareTo(MORNING_TIME) == 0) && parsedTime.before(DAY_TIME)) {
            LOG.info("Time key is " + MORNING);
            return MORNING;
        }

        if ((parsedTime.after(DAY_TIME) || parsedTime.compareTo(DAY_TIME) == 0) && parsedTime.before(EVENING_TIME)) {
            LOG.info("Time key is " + DAY);
            return DAY;
        }

        if ((parsedTime.after(EVENING_TIME) || parsedTime.compareTo(EVENING_TIME) == 0) && parsedTime.before(NIGHT_TIME)) {
            LOG.info("Time key is " + EVENING);
            return EVENING;
        }

        if ((parsedTime.after(NIGHT_TIME) || parsedTime.compareTo(NIGHT_TIME) == 0) || parsedTime.before(MORNING_TIME)) {
            LOG.info("Time key is " + NIGHT);
            return NIGHT;
        }

        throw new AssertionError();
    }

    public static String getHelloText(Date time, Locale locale) {
        LOG.info("Input: time = " + new SimpleDateFormat("HH:mm.SSS").format(time) + ", locale = " + locale.toLanguageTag());
        String text = ResourceBundle.getBundle(BUNDLE_NAME, locale).getString(getTimeKey(time));
        LOG.info("Output: " + text);
        return text;
    }

}
