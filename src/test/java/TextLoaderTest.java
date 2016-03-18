import entities.helpers.TextLoader;
import org.junit.Test;

/**
 * Created by mit_OK! on 18.03.2016.
 */
public class TextLoaderTest {

    @Test
    public void tryTextLoader () {
        System.out.println(new TextLoader().load());
    }
}
