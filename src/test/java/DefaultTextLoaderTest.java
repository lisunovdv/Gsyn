import com.txt_src.DefaultTextLoader;
import org.junit.Test;

/**
 * Created by mit_OK! on 18.03.2016.
 */
public class DefaultTextLoaderTest {

    @Test
    public void tryTextLoader () {
        System.out.println(new DefaultTextLoader().loadText());
    }
}
