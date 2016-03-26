package entities;

import entities.helpers.SyntaxHelper;

import java.util.ArrayList;

/**
 * Created by mit_OK! on 17.03.2016.
 */
public class Word extends Lexeme{
    private String canonical;
    private WordFormat wordFormat;
    private Grammar wordGrammar;
    private ArrayList<Synonym> synonyms;

    public Word() {
    }

    /* === GETTERS AND SETTERS === */

    public String getCanonical() {
        return canonical;
    }

    public void setCanonical(String canonical) {
        this.canonical = canonical;
    }

    public WordFormat getWordFormat() {
        return wordFormat;
    }

    public void setWordFormat(WordFormat wordFormat) {
        this.wordFormat = wordFormat;
    }

    public Grammar getWordGrammar() {
        return wordGrammar;
    }

    public void setWordGrammar(Grammar wordGrammar) {
        this.wordGrammar = wordGrammar;
    }

    public ArrayList<Synonym> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(ArrayList<Synonym> synonyms) {
        this.synonyms = synonyms;
    }
    /* =========================== */

    public void setFirstSynonym (Synonym synonym) {
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
