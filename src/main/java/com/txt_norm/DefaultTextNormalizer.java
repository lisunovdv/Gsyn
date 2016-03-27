package com.txt_norm;

import entities.helpers.SyntaxHelper;

import java.util.regex.Pattern;

/**
 * Created by mit_OK! on 26.03.2016.
 */
public class DefaultTextNormalizer implements ITextNormalizer{

    @Override
    public String normalize(String text) {
        return text;
    }
}
