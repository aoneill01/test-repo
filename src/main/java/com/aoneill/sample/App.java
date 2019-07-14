package com.aoneill.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class App {
    public static Optional<List<Integer>> squaresTotaling(int max, int goal) {
        if (max * max == goal) {
            return Optional.of(Arrays.asList(max));
        }

        if (goal <= 0 || max <= 0) {
            return Optional.empty();
        }

        Optional<List<Integer>> subProblem = squaresTotaling(max - 1, goal - max * max);

        if (subProblem.isPresent()) {
            List<Integer> result = new ArrayList<>();
            result.addAll(subProblem.get());
            result.add(max);
            return Optional.of(result);
        }

        return squaresTotaling(max - 1, goal);
    }

    public static Optional<List<Integer>> decompose(int value) {
        return squaresTotaling(value - 1, value * value);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            final int value = i;
            decompose(value).ifPresent(result -> System.out.println(String.format("%s: %s", value, result)));
        }
    }
}
