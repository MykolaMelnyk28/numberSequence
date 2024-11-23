package com.sequence;

import java.util.*;

public class SequenceFinder {

    public static final int SEQUENCE_LEN = 6;

    public String findMax(SequenceSource source) throws Exception {
        final List<String> sequences = extractSequence(source);
        final Set<String> visited = new HashSet<>();
        String max = "";
        if (!sequences.isEmpty()) {
            final StringBuilder builder = new StringBuilder();
            for (int i = 0; i < sequences.size(); i++) {
                builder.append(sequences.get(i));
                if (builder.isEmpty()) {
                    break;
                }
                for (int j = 0; j < sequences.size(); j++) {
                    String s2 = sequences.get(j);
                    if (i == j || visited.contains(s2)) continue;

                    if (isAfter(builder, s2)) {
                        builder.insert(0, s2.substring(0, SEQUENCE_LEN - 2));
                        visited.add(s2);
                    } else if (isBefore(builder, s2)) {
                        builder.append(s2.substring(2));
                        visited.add(s2);
                    }
                }
                if (builder.length() > max.length()) {
                    max = builder.toString();
                }
                builder.setLength(0);
                visited.clear();
            }
        }
        return max;
    }


    private boolean isAfter(StringBuilder s, String t) {
        return s.charAt(0) == t.charAt(t.length() - 2) && s.charAt(1) == t.charAt(t.length() - 1);
    }

    private boolean isBefore(StringBuilder s, String t) {
        return s.charAt(s.length() - 2) == t.charAt(0) && s.charAt(s.length()-1) == t.charAt(1);
    }

    private List<String> extractSequence(SequenceSource source) throws Exception {
        return source.get().toList();
    }

}