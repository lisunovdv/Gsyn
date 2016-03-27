package com.txt_src;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by mit_OK! on 18.03.2016.
 */
public class DefaultTextLoader implements ITextLoader {
    @Override
    public String loadText(String... args) {
        ArrayList<String> strings = null;
        String somePath = "src/main/resources/input.txt";
        try {
            strings = (ArrayList<String>) Files.readAllLines(Paths.get(somePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = "";
        for (String s : strings) {
            result += s+"\n";
        }
        return result;
    }

}
