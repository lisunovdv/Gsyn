package com;

import entities.helpers.TextLoader;

/**
 * Created by mit_OK! on 18.03.2016.
 */
public class Controller {

    public void run () {
        new SynCore().synonymize(new TextLoader().load());
    }
}
