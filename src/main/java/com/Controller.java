package com;

import com.syn.phrase.PhraseSynonymizer;
import com.txt_norm.DefaultTextNormalizer;
import com.txt_src.DefaultTextLoader;


public class Controller {

    public void run () {
        SynCore synCore = new SynCore();
        synCore.launch(new DefaultTextLoader(),new DefaultTextNormalizer(), new PhraseSynonymizer());
        System.out.println(synCore.getText());
    }
}
