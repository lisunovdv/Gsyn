package com.syn.phrase;

import com.syn.ISynonymizer;
import entities.Phrase;

import java.util.LinkedList;


public class PhraseSynonymizer implements ISynonymizer {

    @Override
    public String synonymize(String text) {
        ITextSplitter splitter = new PunctTextSplitter();
        LinkedList<Phrase> phrases = splitter.decomposeForMultiTreading(text);
        return text;
    }
}
