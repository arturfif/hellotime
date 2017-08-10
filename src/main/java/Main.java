import core.Hello;

import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        System.out.println(Hello.getHelloText(new Date(), Locale.getDefault()));
    }
}
