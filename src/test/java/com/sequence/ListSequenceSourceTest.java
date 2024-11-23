package com.sequence;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListSequenceSourceTest {

    @Test
    void get() throws Exception {
        List<String> expected = List.of("608017", "248460", "962282", "994725", "177092");
        SequenceSource source = new ListSequenceSource(expected);

        List<String> actual = source.get().toList();

        assertEquals(expected, actual);
    }

}