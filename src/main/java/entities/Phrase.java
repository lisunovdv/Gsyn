package entities;

import java.util.LinkedList;

public class Phrase extends Lexeme implements IPhraseWordInitializer {
    private LinkedList<Word> words;
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

    public PhraseStatistic getPhraseStatistic() {
        return phraseStatistic;
    }
    public void setPhraseStatistic(PhraseStatistic phraseStatistic) {
        this.phraseStatistic = phraseStatistic;
    }


    @Override
    public void initWords() {
        if (words == null) words = new LinkedList<>();
        String [] rawWords = this.rawValue.split(" ");
        WordFactory wordFactory = new WordFactory();
        for (String s : rawWords) {
            Word w = wordFactory.factoryMethod(s);
            w.setExcluded(this.excluded);
            words.add(w);
            System.out.println("Init. "+w.getRawValue()+" //"+w.isExcluded()+
                    " ==Prefix * PostFix: "+w.getWordFormat().getPrefixPostfixObj());
        }
    }
}
