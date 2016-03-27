package entities;

public class WordFormat implements IWordFormatUtil {
    private PrefixAndPostfixHolder prefixPostfixObj;
    private Boolean capitalizeFlag = false;

    public WordFormat() {
    }

    public WordFormat(String crudeWord) {
        saveWordFormat(crudeWord);
    }

    /** === GETTERS AND SETTERS === */
    public PrefixAndPostfixHolder getPrefixPostfixObj() {
        return prefixPostfixObj;
    }
    public void setPrefixPostfixObj(PrefixAndPostfixHolder prefixPostfixObj) {
        this.prefixPostfixObj = prefixPostfixObj;
    }

    public Boolean getCapitalizeFlag() {
        return capitalizeFlag;
    }
    public void setCapitalizeFlag(Boolean capitalizeFlag) {
        this.capitalizeFlag = capitalizeFlag;
    }
    /** =========================== */

    /** Initialize WordFormat Object by crudeWord Data and return clear word without commas, brackets etc. */
    public String saveWordFormat(String crudeWord){
        this.prefixPostfixObj = new PrefixAndPostfixHolder(crudeWord);
        int beginIndex = this.prefixPostfixObj.getPrefix().length();
        int endIndex = crudeWord.length()- this.prefixPostfixObj.getPostfix().length();
        String clearWord = crudeWord.substring(beginIndex, endIndex);
        if (clearWord.charAt(0)==clearWord.toUpperCase().charAt(0)) {
            this.capitalizeFlag = true;
        }
        return clearWord;
    }

    public static String singleOutRawWord (String crudeWord){
        return new WordFormat().saveWordFormat(crudeWord);
    }

    public String fetchFormattedWord(Word word) {
        if(word == null || word.getRawValue().isEmpty()) return "";
        String readyWord = word.getRawValue();
        if (word.getWordFormat().getCapitalizeFlag()) {
            readyWord = Capitalize(readyWord);
        }
        return word.getWordFormat().getPrefixPostfixObj().getPrefix()+
                readyWord+
                    word.getWordFormat().getPrefixPostfixObj().getPostfix();
    }

    public static String Capitalize(String stringWord){
        if(stringWord == null || stringWord.isEmpty()) return "";
        return stringWord.substring(0, 1).toUpperCase() + stringWord.substring(1);
    }

}
