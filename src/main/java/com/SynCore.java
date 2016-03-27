package com;

import com.report.DefaultReport;
import com.report.IReport;
import com.syn.ISynonymizer;
import com.txt_norm.ITextNormalizer;
import com.txt_src.ITextLoader;

public class SynCore implements ISynCore{
    private String text;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean loadText(ITextLoader ITextLoader) {
        String s = ITextLoader.loadText();
        if (s != null){
            this.text = s;
            return true;
        } else return false;
    }

    @Override
    public IReport normalizeText(ITextNormalizer textNormalizer) {
        this.text = textNormalizer.normalize(this.text);
        return new DefaultReport();
    }

    @Override
    public IReport synonymizeText(ISynonymizer synonymizer) {
        return new DefaultReport();
    }

    @Override
    public void launch(ITextLoader textSrc, ITextNormalizer textNormalizer, ISynonymizer synonymizer) {
        loadText(textSrc);
        normalizeText(textNormalizer);
        synonymizeText(synonymizer);
    }

    @Override
    public void stop() {
        // TODO create implementation
    }


}
