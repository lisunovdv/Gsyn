package entities;

/**
 * Created by mit_OK! on 18.03.2016.
 */
public class Lexeme extends Morpheme{
    protected String rawValue;

    public Lexeme() {
    }

    public String getRawValue() {
        return rawValue;
    }
    public void setRawValue(String rawValue) {
        this.rawValue = rawValue;
    }
}
