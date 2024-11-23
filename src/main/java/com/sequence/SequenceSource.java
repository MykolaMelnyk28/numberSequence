package com.sequence;

import java.util.stream.Stream;

public interface SequenceSource {
    Stream<String> get() throws Exception;
}