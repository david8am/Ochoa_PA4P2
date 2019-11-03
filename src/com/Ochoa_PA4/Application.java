package com.Ochoa_PA4;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        DuplicateCounter duplicateCounter = new DuplicateCounter();

        duplicateCounter.count("problem2.txt");
        duplicateCounter.write("unique_words_counts.txt");
    }
}
