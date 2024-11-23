package com.sequence;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileSequenceSourceTest {

    @Test
    void get() throws Exception {
        List<String> expected = List.of("608017", "248460", "962282", "994725", "177092");
        SequenceSource source = new FileSequenceSource(Path.of("src/test/resources/source.txt"));

        List<String> actual = source.get().toList();

        assertEquals(expected, actual);
    }

}