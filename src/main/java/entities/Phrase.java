package entities;

import java.util.LinkedList;

public class Phrase extends Lexeme {
    private LinkedList<Word> words;
    private boolean excluded = false;
    private PhraseStatistic phraseStatistic;

    public Phrase() {

    }

    public Phrase(String someRawValue) {
        this.rawValue = someRawValue;
    }

    public Phrase(String someRawValue, boolean isExcluded) {
        this.excluded = isExcluded;
        this.rawValue = someRawValue;
    }

    public LinkedList<Word> getWords() {
        return words;
    }

    public void setWords(LinkedList<Word> words) {
        this.words = words;
    }

    public boolean isExcluded() {
        return excluded;
    }

    public void setExcluded(boolean excluded) {
        this.excluded = excluded;
    }

    public PhraseStatistic getPhraseStatistic() {
        return phraseStatistic;
    }

    public void setPhraseStatistic(PhraseStatistic phraseStatistic) {
        this.phraseStatistic = phraseStatistic;
    }
}
