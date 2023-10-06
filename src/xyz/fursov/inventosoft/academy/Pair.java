package xyz.fursov.inventosoft.academy;

import java.util.Objects;

// A pair of integers
class Pair {
    private final int  first;
    private final int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return first == pair.first && second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    // toString method
    @Override
    public String toString() {
        return "Pair(" + first + ", " + second + ")";
    }

    // Return reversed pair
    public Pair getReversedPair() {
        return new Pair(this.second, this.first);
    }

    public boolean isDuplicate() {
        return first == second;
    }
}

