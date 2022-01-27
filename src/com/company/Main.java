package com.company;

import java.io.File;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	    // Declaring variables
        File file = new File("C:\\Users\\Ethan\\eclipse-workspace\\wordleHelper\\src\\five_letter_words.txt");
        BufferedReader br =  new BufferedReader(new FileReader(file));
        String line;
        String guess = "";
        Scanner scan = new Scanner(System.in);
        ArrayList<Word> startList = new ArrayList<Word>();

        // Gathering list dataset
        while ((line = br.readLine()) != null) {
            Word word = new Word(line);
            startList.add(word);
        }
        System.out.println("How many guesses?");
        int guesses = scan.nextInt();

        // Loops for the amount of guesses indicated by user
        for (int k = 0; k < guesses; k++) {
            guess = "";

            // Enter the word
            while (guess.length() != 5) {
                System.out.println("Enter word you have guessed");
                guess = scan.next();
            }

            // Enter the associated colors w/ the word; determine what to do based on color
            System.out.println("Enter colors of the letters (green, yellow, or gray).");
            for (int i = 0; i < 5; i++) {
                String color = scan.next();
                if (color.equals("green")) {
                    char greenChar = guess.charAt(i);
                    for (int j = 0; j < startList.size(); j++) {
                            Word currWord = startList.get(j);
                            if (!currWord.hasLetterAt(greenChar, i)) {
                                startList.remove(j);
                                j--;
                            }
                    }
                } else if (color.equals("yellow")) {
                    char yellow = guess.charAt(i);
                    for (int j = 0; j < startList.size(); j++) {
                        Word currWord = startList.get(j);
                        if (!currWord.contains(yellow)) {
                            startList.remove(j);
                            j--;
                        }
                    }
                } else {
                    char gray = guess.charAt(i);
                    for (int j = 0; j < startList.size(); j++) {
                        Word currWord = startList.get(j);
                        if (currWord.contains(gray)) {
                            startList.remove(j);
                            j--;
                        }
                    }
                }
            }
        }

        for (Word word: startList) {
            System.out.println(word.toString());
        }
        scan.close();
    }


}
