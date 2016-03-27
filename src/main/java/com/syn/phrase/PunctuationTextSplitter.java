package com.syn.phrase;

import entities.Phrase;
import entities.helpers.SyntaxHelper;

import java.util.LinkedList;

/**
 * Created by mit_OK! on 27.03.2016.
 */
public class PunctuationTextSplitter implements ITextSplitter{



    @Override
    public LinkedList<Phrase> decomposeForMultiTreading(String text) {
        LinkedList<Phrase> phrases = new LinkedList<>();
        phrases.add(new Phrase(text));
        String [] splittedText = new String[0];
        for (int i = 0; i < SyntaxHelper.dividers.length; i++) {
            for (int j = 0; j < phrases.size(); j++) {
                Phrase oneOfPhrase = phrases.get(j);
                if (!oneOfPhrase.isExcluded()) {
                    splittedText = phrases.get(j).getRawValue().split(SyntaxHelper.dividers[i]+"\\s");// TODO Why it works???
                    if (splittedText.length > 1) {
                        phrases.remove(j);
                        int orderNo = j;
                        for (int k = 0; k < splittedText.length; k++) {
                            phrases.add(orderNo,new Phrase(splittedText[k]));
                            orderNo++;

                            if (k != splittedText.length-1) {
                                phrases.add(orderNo,new Phrase(SyntaxHelper.dividers[i].replaceAll("\\\\", "")+" ", true));
                                orderNo++;
                            }
                        }
                    }
                }

            }

        }
        return phrases;
    }
}
