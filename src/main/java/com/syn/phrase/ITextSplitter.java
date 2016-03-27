package com.syn.phrase;

import entities.Phrase;

import java.util.LinkedList;

/**
 * Created by mit_OK! on 27.03.2016.
 */
public interface ITextSplitter {
    LinkedList<Phrase> decomposeForMultiTreading(String text);

}
