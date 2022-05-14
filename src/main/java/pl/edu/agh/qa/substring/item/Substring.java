package pl.edu.agh.qa.substring.item;

import java.util.Objects;

public class Substring {
    private String sign;
    private int position;
    private int length;

    public Substring(String sign, int position, int length) {
        this.sign = sign;
        this.position = position;
        this.length = length;
    }

    @Override
    public String toString() {
        return "(" + sign + ", " + position + ", " + length + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Substring substring = (Substring) o;
        return position == substring.position
                && length == substring.length
                && Objects.equals(sign, substring.sign);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sign, position, length);
    }
}
