import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 10.03.2016.
 */
public class MainTest {

    @Test
    public void someTests() {
        String p = "(?miu)"+ Pattern.quote("В России");
        String str = "Тест в России запретили, да В России всё запрещают, в России";
        Pattern pat = Pattern.compile(p);
        Matcher m = pat.matcher(str);

        //String res = str.replaceAll(p,"in USSR");
        System.out.println(m.groupCount());
        //
    }
}
