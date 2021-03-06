package entities.helpers;

import java.util.regex.Pattern;

/**
 * Created by mit_OK! on 18.03.2016.
 */
public class SyntaxHelper {
    public static final String COMMA = ",";
    public static String[] punctuationMarks = {
            "!",
            "\"",
            "#",
            "$",
            "%",
            "&",
            "'",
            "(",
            ")",
            "*",
            "+",
            "-",
            ".",
            "/",
            ":",
            ";",
            "<",
            "=",
            ">",
            "?",
            "@",
            "[",
            "\\",
            "]",
            "^",
            "_",
            "`",
            "{",
            "|",
            "}",
            "~",
            "\n",
            "\t"
    };
    public static String [] wordCanBegin = {"(", "\"", "\'","\\{", "\\["};
    public static String [] worCanEnd = {")", "\"", "\'","\\}", "\\]"};
    public static String [] dividers = {
            "\\.\\.\\.",
            "!\\.\\.",
            "\\?\\.\\.",
            "!!!",
            "\\?\\?\\?",
            "!",
            "\\?",
            "\\.",
            ":",
            ";",
            "\\|\\|",
            "\\|",
            "/"
    };
    public static final Pattern PUNCTUATION_PATTERN_RU = Pattern.compile(String.join("|",dividers));

    //Messages
    public static final String IllegalPunctuationMark="The word should not contain punctuations marks!";
    public static final String NO_SYNONYM_MSG ="Synonym does not set or initialize";

    public static String [] getExtendedSentenceDividers(){
        String [] resultArray = new String [dividers.length * 2];
        String [] dividersWithSpaces = dividers.clone();
        String [] dividersWithNewLine = dividers.clone();
        for (int i = 0; i < dividers.length; i++) {
            dividersWithSpaces[i] += "\\s";
            dividersWithNewLine[i] += "\n";
        }
        System.arraycopy(dividersWithSpaces, 0, resultArray, 0, dividersWithSpaces.length);
        System.arraycopy(dividersWithNewLine, 0, resultArray, dividersWithSpaces.length, dividersWithNewLine.length);
        return resultArray;
    }

}
