package com.syn.phrase;

import com.syn.ISynonymizer;
import entities.Phrase;

import java.util.LinkedList;

/**
 * Created by mit_OK! on 26.03.2016.
 */
public class PhraseSynonymizer implements ISynonymizer {

    @Override
    public String synonymize(String text) {
        ITextSplitter splitter = new PunctTextSplitter();
        LinkedList<Phrase> phrases = splitter.decomposeForMultiTreading(text);
        return text;
    }
}
