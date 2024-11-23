package com.sequence;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SequenceFinderTest {

    @Test
    void findMaxWithStaticValues() throws Exception {
        SequenceFinder finder = new SequenceFinder();
        SequenceSource source = new ListSequenceSource(List.of("608017", "248460", "962282", "994725", "177092"));
        String expected = "24846080177092";

        String actual = finder.findMax(source);

        assertEquals(expected, actual);
    }

    @Test
    void findMaxWithValuesFromFile() throws Exception {
        SequenceFinder finder = new SequenceFinder();
        SequenceSource source = new FileSequenceSource(Path.of("src/test/resources/source.txt"));
        String expected = "24846080177092";

        String actual = finder.findMax(source);

        assertEquals(expected, actual);
    }


}