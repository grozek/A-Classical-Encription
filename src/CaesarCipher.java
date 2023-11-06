import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.lang.reflect.Array;

/*
 * Encodes and decodes messages using the Caesar cipher encryption. The CaeserCipher program
 * typically takes two parameters on the command line. An instruction, contained in args[0], should
 * be either encode or decode. The parameter, contained in args[1], should be the string to encode
 * or decode.
 */
public class CaesarCipher {
    public static void main(String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);

        if (args.length != 2) {
            System.err.println("Incorrect number of parameters\n");
        } else if (args[0].equals("encode")) {
            encode(args);
        }

        else if (args[0].equals("decode")) {
            decode(args);
        }

        else {
            pen.print("Valid options are 'encode' and 'decode' \n");
        }

        pen.flush();
    }

    /*
     * Encodes provided string with the Ceasar Cipher encription in 25 different ways
     */
    public static void encode(String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);
        int len = args[1].length();
        char[] arr = new char[len];
        int n = 0;
        for (n = 0; n < ('z' - 'a'); n++) {
            for (int i = 0; i < len; i++) {
                int x = args[1].charAt(i) + n;
                if (x > 'z') {
                    x = x - ('z' - 'a');
                }

                char temp = (char) (x);
                Array.set(arr, i, temp);
            }

            pen.print("n = " + n + ": ");
            pen.print(arr);
            pen.print("\n");
            pen.flush();
        }
    }// encode

    /*
     * Decodes input provided strings with the Caesar Cipher encription in 25 different ways
     */
    public static void decode(String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);
        int len = args[1].length();
        char[] arr = new char[len];
        int n = 0;

        for (n = 0; n < 26; n++) {
            for (int i = 0; i < len; i++) {
                int x = args[1].charAt(i) - n;
                if (x < 97) {
                    x = x + 26;
                }

                char temp = (char) (x);
                Array.set(arr, i, temp);
            }

            pen.print("n = " + n + ": ");
            pen.print(arr);
            pen.print("\n");
            pen.flush();
        }
    }// decode
} // CaesarCipher
