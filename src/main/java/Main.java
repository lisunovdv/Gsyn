import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 02.03.2016.
 */
public class Main {
    private static final String DB_PATH = "C:/Users/user/Desktop/SDK Synonymizer/syn/test.txt";
    private static final String FILE_NAME = "C:/Users/user/Desktop/SDK Synonymizer/input.txt";
    private static final String DELIMITER = ";";
    private static final String HIGHLIGHT_TAG = "b";

    public static void main(String[] args) throws IOException {
        ArrayList<String> strings = (ArrayList<String>) Files.readAllLines(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
        String result = "";
        for (String s : strings) {
            result += s;
        }
        System.out.println(result);
        //result = result.replaceAll("\\.\\w",". ");
        String test = synonymaze (result);
        System.out.println(test);
        System.out.println("<b>интернет-казино Вулкан</b> поздравляет всех <b>представительниц лучшей половины человечества</b> <b>с Международным женским днём</b>! Мужчины, не забудьте поздравить своих любимых, а после поздравления возвращайтесь в наше казино, так как в честь <b>такого знаменательного события</b> у нас пройдет <b>состязание</b> «Леди Вулкан». Даты проведения <b>мероприятия</b>: 7.03.16 – 13.03.16.Принцип игры в турнире прост. Все <b>игроки</b> вначале <b>проходят отборочный этап</b> – им нужно совершить 25 квалификационных спинов на турнирных слотах. После чего за каждую ставку <b>любитель азартных игр</b> начнет получать баллы, <b>общее число баллов</b> <b>напрямую находится в зависимости</b> от размера ставки. Для победы их потребуется немало.Призовой фонд <b>состязания</b> <b>безразмерный</b> и <b>напрямую находится в зависимости</b> от ставок <b>игроков</b> – с каждой ставки, совершенной <b>завсегдатаем онлайн казино</b> в турнирном <b>игровом эмуляторе</b>, в <b>фонд выигрыша</b> будет перечисляться 0,5%. Таким образом, <b>до окончания срока</b> сумма <b>фонда выигрыша</b> <b>мероприятия</b> будет увеличиваться. Минимальный размер ставки для участия в турнире - 10 рублей. По окончанию <b>мероприятия</b> эта сумма будет <b>равномерно</b> <b>разделена</b> между 10 лучшими участниками.Список турнирных игровых автоматов: <b>Цветы</b>, <b>Лаки Леди Шарм</b>, <b>Лаки Леди Шарм</b> Deluxe, <b>Кабарэ</b>, <b>Старбёрст</b>, <b>Волшебный лес</b>, Show Girls, Queen of Hearts.В этом году 8 марта дает вам отличный шанс стать богаче. Так что не упустите его!\n");
    }
    public static String  synonymaze (String text) {
        String result = "";
        String [] sentences = text.split("\\.\\s");
        for (int i = 0; i < sentences.length; i++) {
            result = result +". "+ findAndReplace(sentences[i]);
        }
        return result;
    }

    public static String  findAndReplace (String text) {
        ArrayList<String> synonymsDB = retrieveDB();
        for (String line : synonymsDB) {
            String [] synonymsArray = line.split(DELIMITER);
            for (int i = 0; i < synonymsArray.length; i++) {
                Pattern p = createReplacementPattern(synonymsArray[i]);
                Matcher m = p.matcher(text);
                while (m.find()) {
                    text = text.replaceFirst(synonymsArray[i],"<b>"+getRandomSynonym(synonymsArray,i)+"</b>");
                }
            }
        }
        return text;
    }

    public static Pattern createReplacementPattern(String phrase) {
        String flags = "(?miu)"; //Ignore case + MultiLine + Unicode Symbols
        String openTag = "[^<"+HIGHLIGHT_TAG+">]"; // Open Tag
        String quotePhrase = Pattern.quote(phrase);
        //String endingOfTheWord = ".(\\s|\\p{Punct})";
        String endingOfTheWord = "(\\b)";
        String closeTag = "[^</"+HIGHLIGHT_TAG+">]"; // Close Tag
        Pattern pattern = Pattern.compile(flags+openTag+quotePhrase+endingOfTheWord+closeTag);
        //System.out.println(pattern);
        return pattern;
    }

    public static String getRandomSynonym (String [] synonymsArray, int synonymId ){
        ArrayList <String> variants = new ArrayList<>(Arrays.asList(synonymsArray));
        //variants.remove(synonymId);
        int random = new Random().nextInt(variants.size());
        return variants.get(random);
    }

    public static ArrayList<String> retrieveDB() {
        String result = "";
        ArrayList<String> lines = null;
        try {
            lines = (ArrayList<String>) Files.readAllLines(Paths.get(DB_PATH), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

}
