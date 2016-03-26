package entities;

import entities.helpers.SyntaxHelper;

/**
 * Created by mit_OK! on 26.03.2016.
 */
public class WordFormat {
    private String prefixSymbols = "";
    private String postfixSymbols = "";
    private Boolean capitalizeFlag = false;

    public WordFormat() {
    }

    public WordFormat(String crudeWord) {
        init(crudeWord);
    }

    public String init (String crudeWord){
        this.prefixSymbols = parsePrefix(crudeWord);
        this.postfixSymbols = parsePostfix(crudeWord);
        int beginIndex = prefixSymbols.length();
        int endIndex = crudeWord.length()- postfixSymbols.length();
        String clearWord = crudeWord.substring(beginIndex, endIndex);
        if (clearWord.charAt(0)==clearWord.toUpperCase().charAt(0)) {
            this.capitalizeFlag = true;
        }
        return clearWord;
    }

    public static String singleOutRawWord (String crudeWord){
        return new WordFormat().init(crudeWord);
    }

    public WordFormat(String prefixSymbols, String postfixSymbols, Boolean capitalizeFlag) {
        this.prefixSymbols = prefixSymbols;
        this.postfixSymbols = postfixSymbols;
        this.capitalizeFlag = capitalizeFlag;
    }

    public static String Capitalize(String stringWord){
        if(stringWord == null || stringWord.isEmpty()) return "";
        return stringWord.substring(0, 1).toUpperCase() + stringWord.substring(1);
    }

    public String getFormattedWord(Word word) {
        if(word == null || word.getRawValue().isEmpty()) return "";
        String readyWord = word.getRawValue();
        if (word.getCapitalizeFlag()) {
            readyWord = Capitalize(readyWord);
        }
        return word.getPrefixSymbols()+readyWord+word.getPostfixSymbols();
    }

    public static String parsePrefix(String rawWord) {
        for (int i = 0; i < SyntaxHelper.wordCanBegin.length; i++) {
            if (rawWord.startsWith(SyntaxHelper.wordCanBegin[i])){
                return SyntaxHelper.wordCanBegin[i];
            }
        }
        return "";
    }

    public static String parsePostfix(String rawWord) {
        for (int i = 0; i < SyntaxHelper.worCanEnd.length; i++) {
            if (rawValue.startsWith(SyntaxHelper.worCanEnd[i])){
                postfixSymbols = SyntaxHelper.worCanEnd[i];
                return postfixSymbols.length();
            }
        }
        return "";
    }
}
