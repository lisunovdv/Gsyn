package entities;

import entities.gram.Grammar;
import entities.helpers.SyntaxHelper;

import java.util.ArrayList;

public class Word<W extends WordFormat,G extends Grammar, S extends Synonym> extends Lexeme{
    private String canonical;
    private W wordFormat;
    private G wordGrammar;
    private ArrayList<S> synonyms;

    public Word() {
    }

    /* === GETTERS AND SETTERS === */

    public String getCanonical() {
        return canonical;
    }
    public void setCanonical(String canonical) {
        this.canonical = canonical;
    }

    public W getWordFormat() {
        return wordFormat;
    }
    public void setWordFormat(W wordFormat) {
        this.wordFormat = wordFormat;
    }

    public G getWordGrammar() {
        return wordGrammar;
    }
    public void setWordGrammar(G wordGrammar) {
        this.wordGrammar = wordGrammar;
    }

    public ArrayList<S> getSynonyms() {
        return synonyms;
    }
    public void setSynonyms(ArrayList<S> synonyms) {
        this.synonyms = synonyms;
    }

/* =========================== */

    public void setFirstSynonym (S synonym) {
        if (synonyms == null) {
            synonyms = new ArrayList<>();
        }
        synonyms.set(0,synonym);
    }

    public Synonym getFirstSynonym (){
        if (synonyms == null) {
            if (rawValue == null) {
                throw new NullPointerException(SyntaxHelper.NO_SYNONYM_MSG);
            } else {
                return new Synonym(rawValue);
            }
        } else {
            return synonyms.get(0);
        }
    }
}
