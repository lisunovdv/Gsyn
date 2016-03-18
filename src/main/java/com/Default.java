package com;

import entities.Sentence;
import entities.Word;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by mit_OK! on 17.03.2016.
 */
public class Default {

    private String fetchText(){
        return null;
    }

    private ArrayList<Sentence> splitIntoSentences(String text) {
        return null;
    }

    private LinkedList<String> splitIntoWords(String sentence) {
        return null;
    }
   /* private boolean init (String partOfSentence){
        return true;
    }*/

    private Word canonicalizeWord (Word word) {
        return word;
    }

    private String fetchSynonym (Word word) {
        return null;
    }

    private boolean comparePhrases (String s) {
        return false;
    }

}
