package entities;

import java.util.ArrayList;

/**
 * Created by mit_OK! on 26.03.2016.
 */
public class WordFactory implements IWordCreator {



    public Word factoryMethod (String crudeWord) {
        Word wordObject = new Word();
        WordFormat wordFormat = new WordFormat();
        wordObject.setRawValue(wordFormat.saveWordFormat(crudeWord));
        wordObject.setWordFormat(wordFormat);
        ArrayList<Synonym> synonymsArrayList = new ArrayList<>();
        synonymsArrayList.set(0,new Synonym(wordObject.getRawValue()));
        wordObject.setSynonyms(synonymsArrayList);
        wordObject.setCanonical(wordObject.getRawValue());

        return wordObject;
    }




}
