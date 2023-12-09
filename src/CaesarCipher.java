import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.lang.reflect.Array;

/*
 * Encodes and decodes messages using the Caesar cipher encryption. The CaeserCipher program
 * typically takes two parameters on the command line. An instruction, contained in args[0], should
 * be either encode or decode. The parameter, contained in args[1], should be the string to encode
 * or decode.
 * 
 * CaesarCipher 
 * Author: Gabriela Roznawska 
 * CSC207-Fall 2023 
 * Acknowledgements: Prof. Rebelsky and his resources on the CSC-207 website.
 */

public class CaesarCipher {
    public static void main(String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);
        if (args.length != 2) {
            System.err.println("Incorrect number of parameters\n");
        } else if (args[0].equals("encode")) {
            encode(args);
            pen.print("\n");
        } // else if

        else if (args[0].equals("decode")) {
            decode(args);
            pen.print("\n");
        } // else if

        else {
            pen.print("Valid options are 'encode' and 'decode' \n \n");
        } // else

        pen.flush();
    }// main(String[] args)

    /*
     * Encodes provided string with the Ceasar Cipher encription in 25 different ways
     */
    public static void encode(String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);
        int len = args[1].length();
        char[] arr = new char[len];
        int n = 0;
        for (n = 0; n < ('z' - 'a' + 1); n++) {
            for (int i = 0; i < len; i++) {
                int x = args[1].charAt(i) + n;
                if (x > 'z') {
                    x = x - ('z' - 'a' + 1);
                }
                char temp = (char) (x);
                Array.set(arr, i, temp);
            } // for

            pen.print("n = " + n + ": ");
            pen.print(arr);
            pen.print("\n");
            pen.flush();
        } // for
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
                } // if
                char temp = (char) (x);
                Array.set(arr, i, temp);
            } // for
            pen.print("n = " + n + ": ");
            pen.print(arr);
            pen.print("\n");
            pen.flush();
        } // for
    }// decode
} // CaesarCipher
