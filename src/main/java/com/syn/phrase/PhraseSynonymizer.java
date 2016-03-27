package com.syn.phrase;

import com.syn.ISynonymizer;
import com.syn.phrase.config.DefaultPhraseSynConfig;
import com.syn.phrase.config.PhraseSynConfig;
import entities.Phrase;

import java.util.LinkedList;


public class PhraseSynonymizer implements ISynonymizer {
    private PhraseSynConfig phraseSynConfig;

    public PhraseSynonymizer() {
        this.phraseSynConfig = new DefaultPhraseSynConfig();
    }

    public PhraseSynonymizer(PhraseSynConfig phraseSynConfig) {
        this.phraseSynConfig = phraseSynConfig;
    }

    /** === GETTERS AND SETTERS === */
    public PhraseSynConfig getPhraseSynConfig() {
        return phraseSynConfig;
    }
    public void setPhraseSynConfig(PhraseSynConfig phraseSynConfig) {
        this.phraseSynConfig = phraseSynConfig;
    }
    /** =========================== */

    @Override
    public String synonymize(String text) {
        ITextSplitter splitter = new PunctuationTextSplitter();
        LinkedList<Phrase> phrases = splitter.decomposeForMultiTreading(text);

        /* TODO Insert MultiTreading*/
        phrases.forEach(Phrase::initWords);

        return text;
    }
}
