package entities;

import entities.helpers.SyntaxHelper;

/**
 * Created by mit_OK! on 17.03.2016.
 */
public class Word extends Lexeme{
    private String prefixSymbols = "";
    private String postfixSymbols = "";
    private Boolean capitalize = false;
    private String canonical = null;
    private String synonym = null;

    public Word() {
    }

    public Word(String rawWord) {
        init(rawWord);
    }

    public String getCanonical() {
        return canonical;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    public String getFormattedSynonym(String synonym) {
        String readySynonym = synonym;
        if (capitalize) readySynonym = firstUpperCase(readySynonym);
        return prefixSymbols+readySynonym+postfixSymbols;
    }

    public void init (String rawWord) {
        rawValue = rawWord;
        rawValue = rawWord.substring(createPrefix(),rawValue.length()-createPostfix());
        if (rawValue.charAt(0)==rawValue.toUpperCase().charAt(0)) capitalize = true;
        canonical = rawValue;
        synonym = rawValue;
    }

    public int createPrefix () {
        for (int i = 0; i < SyntaxHelper.wordCanBegin.length; i++) {
            if (rawValue.startsWith(SyntaxHelper.wordCanBegin[i])){
                prefixSymbols = SyntaxHelper.wordCanBegin[i];
                return prefixSymbols.length();
            }
        }
        return 0;
    }

    public int createPostfix () {
        for (int i = 0; i < SyntaxHelper.worCanEnd.length; i++) {
            if (rawValue.startsWith(SyntaxHelper.worCanEnd[i])){
                postfixSymbols = SyntaxHelper.worCanEnd[i];
                return postfixSymbols.length();
            }
        }
        return 0;
    }

    public static String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
