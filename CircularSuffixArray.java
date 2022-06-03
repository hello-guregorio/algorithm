import java.util.Arrays;
import java.util.Comparator;

public class CircularSuffixArray {
    private int length;
    private char[] value;
    private Integer[] index;

    public CircularSuffixArray(String s) {
        length = s.length();
        value = new char[length];
        index = new Integer[length];
        for (int i = 0; i < length; i++) {
            index[i] = i;
            value[i] = s.charAt(i);
        }

        Arrays.sort(index, new Comparator<Integer>() {
            public int compare(Integer idx1, Integer idx2) {
                for (int i = 0; i < length; i++) {
                    char c1 = value[(i + idx1) % length];
                    char c2 = value[(i + idx2) % length];
                    if (c1 > c2) return 1;
                    if (c1 < c2) return -1;
                }
                return 0;
            }
        });
    }

    public int length() {
        return length;
    }

    public int index(int i) {
        return index[i];
    }
}