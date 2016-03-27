import com.Controller;
import com.syn.phrase.PunctuationTextSplitter;
import com.txt_norm.DefaultTextNormalizer;
import entities.Phrase;
import entities.helpers.SyntaxHelper;
import org.junit.Test;

import java.util.LinkedList;

public class MainTest {

    @Test
    public void someTests() {
       String s = "А у нас..8. всё хорошо.\nFFFFFFF";
        String [] result = s.split("\\.\\.\\.\\s");
        DefaultTextNormalizer txt = new DefaultTextNormalizer();
        System.out.println(txt.normalize(s));
        //
    }

    @Test
    public void ControllerTest() {
        Controller controller = new Controller();
        controller.run();
    }

    @Test
    public void SplitterTest() {
        String s = ":А у нас всё хорошо.\nПравда? Не ??? так ведь?.. А то не|| так подумают. Что так: и есть!";
        PunctuationTextSplitter splitter = new PunctuationTextSplitter();
        LinkedList<Phrase> phraseLinkedList = splitter.decomposeForMultiTreading(s);
        for (int i = 0; i < phraseLinkedList.size(); i++) {
            System.out.println(phraseLinkedList.get(i).getRawValue()+" //"+phraseLinkedList.get(i).isExcluded());
        }
    }

    @Test
    public void syntaxHelpTest() {
        for (String s : SyntaxHelper.getExtendedSentenceDividers()){
            System.out.println(s);
        }
    }
}
