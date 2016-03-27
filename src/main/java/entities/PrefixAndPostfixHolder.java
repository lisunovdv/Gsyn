package entities;

import entities.helpers.SyntaxHelper;

public class PrefixAndPostfixHolder {
    private String prefix = "";
    private String postfix = "";

    public PrefixAndPostfixHolder() {
    }

    public PrefixAndPostfixHolder(String prefix, String postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    public PrefixAndPostfixHolder(String rawWord) {
        init(rawWord);
    }

    /** === GETTERS AND SETTERS === */
    public String getPrefix() {
        return prefix;
    }
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPostfix() {
        return postfix;
    }
    public void setPostfix(String postfix) {
        this.postfix = postfix;
    }
    /** =========================== */

    public void init (String rawWord) {
        for (int i = 0; i < SyntaxHelper.punctuationMarks.length; i++) {
            String punctuator = SyntaxHelper.punctuationMarks[i];
            this.prefix = (rawWord.startsWith(punctuator) && this.prefix.equals(""))? punctuator : this.prefix;
            this.postfix = (rawWord.endsWith(punctuator) && this.postfix.equals(""))? punctuator : this.postfix;
        }
    }


    public static String parsePrefix(String rawWord) {
        for (int i = 0; i < SyntaxHelper.punctuationMarks.length; i++) {
            if (rawWord.startsWith(SyntaxHelper.punctuationMarks[i])){
                return SyntaxHelper.punctuationMarks[i];
            }
        }
        return "";
    }

    public static String parsePostfix(String rawWord) {
        for (int i = 0; i < SyntaxHelper.punctuationMarks.length; i++) {
            if (rawWord.endsWith(SyntaxHelper.punctuationMarks[i])){
                return SyntaxHelper.punctuationMarks[i];
            }
        }
        return "";
    }
}
