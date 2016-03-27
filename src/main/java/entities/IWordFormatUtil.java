package entities;

import entities.helpers.SyntaxHelper;

/**
 * Created by mit_OK! on 26.03.2016.
 */
public interface IWordFormatUtil<T extends Word> {

    String fetchFormattedWord(T word);

    String saveWordFormat(String crudeWord);
}
