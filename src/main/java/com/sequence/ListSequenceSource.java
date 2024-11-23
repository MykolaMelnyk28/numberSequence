package com.sequence;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ListSequenceSource implements SequenceSource {

    private final List<String> list;

    public ListSequenceSource(String... sequences) {
        this.list = Arrays.asList(sequences);
    }

    public ListSequenceSource(List<String> list) {
        this.list = Collections.unmodifiableList(list);
    }

    @Override
    public Stream<String> get() {
        return list.stream();
    }

}