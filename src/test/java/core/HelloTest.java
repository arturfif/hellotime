package core;

import core.Hello;
import org.junit.Test;
import org.junit.runners.JUnit4;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

public class HelloTest {

    private static final Locale RU_LOCALE = new Locale("ru");
    private static final Locale EN_LOCALE = Locale.ENGLISH;

    private static final String MORNING = "morning";
    private static final String DAY = "day";
    private static final String EVENING = "evening";
    private static final String NIGHT = "night";

    private static final String BUNDLE_NAME = "hello";

    private static final DateFormat PARSER = new SimpleDateFormat("dd-MM-yyyy HH:mm.SSS");
    private static Date date1;
    private static Date date2;
    private static Date date3;
    private static Date date4;
    private static Date date5;
    private static Date date6;
    private static Date date7;
    private static Date date8;
    private static Date date9;
    private static Date date10;
    private static Date date11;
    private static Date date12;
    private static Date date13;
    private static Date date14;
    private static Date date15;
    private static Date date16;

    static {

        try {
            date1 = PARSER.parse("12-01-1990 06:05.000");
            date2 = PARSER.parse("13-02-1991 10:56.000");
            date3 = PARSER.parse("14-03-2018 22:32.000");
            date4 = PARSER.parse("15-04-1985 03:12.000");

            date5 = PARSER.parse("16-05-1993 05:59.999");
            date6 = PARSER.parse("17-06-1995 06:00.000");
            date7 = PARSER.parse("18-07-1997 06:00.001");

            date8 = PARSER.parse("19-08-1999 08:59.999");
            date9 = PARSER.parse("20-09-2001 09:00.000");
            date10 = PARSER.parse("01-01-2002 09:00.001");

            date11 = PARSER.parse("28-06-2004 18:59.999");
            date12 = PARSER.parse("24-08-2006 19:00.000");
            date13 = PARSER.parse("14-10-2008 19:00.001");

            date14 = PARSER.parse("21-12-2012 22:59.999");
            date15 = PARSER.parse("10-10-2010 23:00.000");
            date16 = PARSER.parse("11-11-2011 23:00.001");
        } catch (ParseException e) {
            throw new AssertionError();
        }

    }



    @Test
    public void test1() throws Exception {
        assertEquals(MORNING, Hello.getTimeKey(date1));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(DAY, Hello.getTimeKey(date2));
    }

    @Test
    public void test3() throws Exception {
        assertEquals(EVENING, Hello.getTimeKey(date3));
    }

    @Test
    public void test4() throws Exception {
        assertEquals(NIGHT, Hello.getTimeKey(date4));
    }

    @Test
    public void test5() throws Exception {
        assertEquals(NIGHT, Hello.getTimeKey(date5));
    }

    @Test
    public void test6() throws Exception {
        assertEquals(MORNING, Hello.getTimeKey(date6));
    }

    @Test
    public void test7() throws Exception {
        assertEquals(MORNING, Hello.getTimeKey(date7));
    }

    @Test
    public void test8() throws Exception {
        assertEquals(MORNING, Hello.getTimeKey(date8));
    }

    @Test
    public void test9() throws Exception {
        assertEquals(DAY, Hello.getTimeKey(date9));
    }

    @Test
    public void test10() throws Exception {
        assertEquals(DAY, Hello.getTimeKey(date10));
    }

    @Test
    public void test11() throws Exception {
        assertEquals(DAY, Hello.getTimeKey(date11));
    }

    @Test
    public void test12() throws Exception {
        assertEquals(EVENING, Hello.getTimeKey(date12));
    }

    @Test
    public void test13() throws Exception {
        assertEquals(EVENING, Hello.getTimeKey(date13));
    }

    @Test
    public void test14() throws Exception {
        assertEquals(EVENING, Hello.getTimeKey(date14));
    }

    @Test
    public void test15() throws Exception {
        assertEquals(NIGHT, Hello.getTimeKey(date15));
    }

    @Test
    public void test16() throws Exception {
        assertEquals(NIGHT, Hello.getTimeKey(date16));
    }

    @Test
    public void testRuLocale1() throws Exception {
        String expected = ResourceBundle.getBundle(BUNDLE_NAME, RU_LOCALE).getString(MORNING);
        String actual = Hello.getHelloText(date1, RU_LOCALE);

        assertEquals(expected, actual);
    }

    @Test
    public void testRuLocale2() throws Exception {
        String expected = ResourceBundle.getBundle(BUNDLE_NAME, RU_LOCALE).getString(DAY);
        String actual = Hello.getHelloText(date2, RU_LOCALE);

        assertEquals(expected, actual);
    }

    @Test
    public void testRuLocale3() throws Exception {
        String expected = ResourceBundle.getBundle(BUNDLE_NAME, RU_LOCALE).getString(EVENING);
        String actual = Hello.getHelloText(date3, RU_LOCALE);

        assertEquals(expected, actual);
    }

    @Test
    public void testRuLocale4() throws Exception {
        String expected = ResourceBundle.getBundle(BUNDLE_NAME, RU_LOCALE).getString(NIGHT);
        String actual = Hello.getHelloText(date4, RU_LOCALE);

        assertEquals(expected, actual);
    }

    @Test
    public void testEnLocale1() throws Exception {
        String expected = ResourceBundle.getBundle(BUNDLE_NAME, EN_LOCALE).getString(MORNING);
        String actual = Hello.getHelloText(date1, EN_LOCALE);

        assertEquals(expected, actual);
    }

    @Test
    public void testEnLocale2() throws Exception {
        String expected = ResourceBundle.getBundle(BUNDLE_NAME, EN_LOCALE).getString(DAY);
        String actual = Hello.getHelloText(date2, EN_LOCALE);

        assertEquals(expected, actual);
    }

    @Test
    public void testEnLocale3() throws Exception {
        String expected = ResourceBundle.getBundle(BUNDLE_NAME, EN_LOCALE).getString(EVENING);
        String actual = Hello.getHelloText(date3, EN_LOCALE);

        assertEquals(expected, actual);
    }

    @Test
    public void testEnLocale4() throws Exception {
        String expected = ResourceBundle.getBundle(BUNDLE_NAME, EN_LOCALE).getString(NIGHT);
        String actual = Hello.getHelloText(date4, EN_LOCALE);

        assertEquals(expected, actual);
    }

}
