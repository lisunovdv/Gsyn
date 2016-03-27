package entities;

import entities.helpers.SyntaxHelper;

import java.util.regex.Pattern;

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
        boolean hasAlnum = Pattern.compile("\\p{IsAlphabetic}").matcher(rawWord).find();
        if (hasAlnum) {// TODO Some troubles with IT
            for (int i = 0; i < SyntaxHelper.punctuationMarks.length; i++) {
                String punctuator = SyntaxHelper.punctuationMarks[i];
                this.prefix += (rawWord.startsWith(punctuator) && this.prefix.equals(""))? punctuator : ""; // Add singleOutRawWord
                this.postfix += (rawWord.endsWith(punctuator) && this.postfix.equals(""))? punctuator : ""; // Add singleOutRawWord
            }
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

    @Override
    public String toString() {
        return "PrefixAndPostfixHolder{" +
                "prefix='" + prefix + '\'' +
                ", postfix='" + postfix + '\'' +
                '}';
    }
}
