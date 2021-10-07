package com.example.madt_2_lab_wordcounter.utilis;

public class TextCounter {
    public static int getCharCount(String phrase) {
        return phrase.length();
    }

    public static int getWordsCount(String phrase) {
        String[] sentence = phrase.split("\\W");
        return sentence.length;
    }
}
