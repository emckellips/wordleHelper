package com.company;

public class Word {
    String word;
    char[] letters = new char[5];
    public Word (String word) {
        this.word = word;
        letters[0] = word.charAt(0);
        letters[1] = word.charAt(1);
        letters[2] = word.charAt(2);
        letters[3] = word.charAt(3);
        letters[4] = word.charAt(4);
    }

    public boolean contains(char letter) {
        for (char l : letters) {
            if (l == letter) return true;
        }
        return false;
    }

    public boolean hasLetterAt(char letter, int pos) {
        if (letters[pos] == letter) {
            return true;
        }
        return false;
    }

    public String toString() {
        return word;
    }
}
