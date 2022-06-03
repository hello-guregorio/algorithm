import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
    private static final int R = 256;

    public static void encode() {
        char[] aux = new char[R];
        for (int i = 0; i < R; i++)
            aux[i] = (char) i;

        String input = BinaryStdIn.readString();
        boolean printChar = true;
        for (int i = 0; i < input.length(); i++)
            move(aux, input.charAt(i), printChar);

        BinaryStdOut.close();
    }

    public static void decode() {
        char[] aux = new char[R];
        for (int i = 0; i < R; i++)
            aux[i] = (char) i;

        while (!BinaryStdIn.isEmpty()) {
            int posi = BinaryStdIn.readInt(8);
            BinaryStdOut.write(aux[posi]);
            move(aux, aux[posi], false);
        }
        BinaryStdOut.close();
    }

    private static void move(char[] aux, char c, boolean printChar) {
        char before = aux[0];
        for (int j = 0; j < R; j++) {
            if (aux[j] == c) {
                aux[0] = c;
                aux[j] = before;
                if (printChar)
                    BinaryStdOut.write((char) j);
                break;
            }
            char tmp = aux[j];
            aux[j] = before;
            before = tmp;
        }
    }
}
