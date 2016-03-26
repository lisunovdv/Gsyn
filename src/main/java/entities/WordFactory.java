package entities;

import java.util.ArrayList;

/**
 * Created by mit_OK! on 26.03.2016.
 */
public class WordFactory extends AbstractWordCreator implements IWordUtil {



    public Word factoryMethod (String crudeWord) {
        Word wordObject = new Word();
        WordFormat wordFormat = new WordFormat();
        wordObject.setRawValue(wordFormat.init(crudeWord));
        wordObject.setWordFormat(wordFormat);
        ArrayList<Synonym> synonymsArrayLis = new ArrayList<>();
        synonymsArrayLis.set(0,new Synonym(wordObject.getRawValue()));
        wordObject.setSynonyms(synonymsArrayLis);
        wordObject.setCanonical(wordObject.getRawValue());

        return wordObject;
    }




}
