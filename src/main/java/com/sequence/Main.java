package com.sequence;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    private static final String DEFAULT_FILE = "source.txt";

    public static void main( String[] args ) {
        try {
            final Scanner scanner = new Scanner(System.in);

            System.out.println("Enter path to source file (default source.txt): ");
            String pathInput = scanner.nextLine();

            if (pathInput == null || pathInput.isBlank()) {
                pathInput = DEFAULT_FILE;
            }

            Path file = Path.of(pathInput);

            if (Files.notExists(file)) {
                System.out.println("!!! File not found: " + file + " !!!");
                System.exit(0);
            }

            final SequenceFinder finder = new SequenceFinder();
            final SequenceSource source = new FileSequenceSource(file);
            final String sequence = finder.findMax(source);

            System.out.println("Max sequence: " + sequence);
            System.out.println("Max sequence length: " + sequence.length());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
