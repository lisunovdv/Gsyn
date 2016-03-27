package entities;

/**
 * Created by mit_OK! on 18.03.2016.
 */
public class Lexeme extends Morpheme{
    protected String rawValue;
    protected boolean excluded = false;

    public Lexeme() {
    }

    public String getRawValue() {
        return rawValue;
    }
    public void setRawValue(String rawValue) {
        this.rawValue = rawValue;
    }

    public boolean isExcluded() {
        return excluded;
    }
    public void setExcluded(boolean excluded) {
        this.excluded = excluded;
    }
}
