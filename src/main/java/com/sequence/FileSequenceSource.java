package com.sequence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FileSequenceSource implements SequenceSource {

    private final Path file;

    public FileSequenceSource(Path file) {
        this.file = file;
    }

    @Override
    public Stream<String> get() throws Exception {
        try {
            return Files.lines(file).filter(Predicate.not(String::isBlank));
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw new RuntimeException("Error reading data from file: " + file);
        }
    }

}