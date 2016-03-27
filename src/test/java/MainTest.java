import com.Controller;
import com.syn.phrase.PunctTextSplitter;
import entities.Phrase;
import org.junit.Test;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainTest {

    @Test
    public void someTests() {
       String s = "А у нас..8. всё хорошо";
        String [] result = s.split("\\.\\.\\.\\s");
        for (String aResult : result) {
            System.out.println(aResult);
        }
        //
    }

    @Test
    public void ControllerTest() {
        Controller controller = new Controller();
        controller.run();
    }

    @Test
    public void SplitterTest() {
        String s = ":А у нас... всё | хорошо... Правда? Не ??? так ведь?.. А то не|| так подумают. Что так: и есть!";
        PunctTextSplitter splitter = new PunctTextSplitter();
        LinkedList<Phrase> phraseLinkedList = splitter.decomposeForMultiTreading(s);
        for (int i = 0; i < phraseLinkedList.size(); i++) {
            System.out.println(phraseLinkedList.get(i).getRawValue()+" //"+phraseLinkedList.get(i).isExcluded());
        }
    }
}
