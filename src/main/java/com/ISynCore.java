package com;

import com.report.IReport;
import com.syn.ISynonymizer;
import com.txt_norm.ITextNormalizer;
import com.txt_src.ITextLoader;

/**
 * Created by mit_OK! on 26.03.2016.
 */
public interface ISynCore<T extends ITextLoader, N extends ITextNormalizer, S extends ISynonymizer> {
    boolean loadText(T textSrc);
    IReport normalizeText(N textNormalizer);
    IReport synonymizeText(S synonymizer);
    void launch (T textSrc, N textNormalizer, S synonymizer);
    void stop();
}
