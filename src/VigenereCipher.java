import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.lang.reflect.Array;


/*
 * Encodes and decodes messages using the Vigenere Cipher encryption. The VigenereCipher program
 * uses keyword to shift the text. It takes three parameters: an instruction, contained in args[0],
 * should be either encode or decode; the string to encode or decode, and the keyword.
 * 
 * VigenereCipher 
 * Author: Gabriela Roznawska 
 * CSC207-Fall 2023 
 * Acknowledgements: Prof. Rebelsky and his resources on the CSC-207 website.
 */
public class VigenereCipher {
    public static void main(String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);

        if (args.length != 3) {
            System.err.println("Incorrect number of parameters\n");
        } else if (args[0].equals("encode")) {
            encode(args);
            pen.print("\n");
        } else if (args[0].equals("decode")) {
            decode(args);
            pen.print("\n");
        } else {
            pen.print("Valid options are 'encode' and 'decode' \n \n");
        }
        pen.flush();
    }// main

    /*
     * Encodes provided string with the Vigenere Cipher encription in 25 different ways
     */
    public static void encode(String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);
        int lenString = args[1].length();
        int lenKeyword = args[2].length();
        char[] arr = new char[lenString];
        int n = 0;
        int base = 97;

        if (lenKeyword == 0) {
            pen.println(args[1]);
        } else {
            for (int i = 0; i < lenString; i++) {
                n = i % lenKeyword;
                int x = args[1].charAt(i) + args[2].charAt(n) - base;
                if (x > 'z') {
                    x = x - ('z' - 'a' + 1);
                } // if
                char temp = (char) (x);
                Array.set(arr, i, temp);
            } // for

            pen.println(arr);
            pen.flush();
        } // else
    }// encode(String[] args)

    /*
     * Decodes input provided strings with the Vigenere Cipher encription in 25 different ways
     */
    public static void decode(String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);
        int lenString = args[1].length();
        int lenKeyword = args[2].length();
        char[] arr = new char[lenString];
        int n = 0;
        int x = 0;
        int base = 97;
        for (int i = 0; i < lenString; i++) {
            n = i % lenKeyword;
            x = args[1].charAt(i) - args[2].charAt(n) + base;
            if (x < base)
                x = x + ('z' - 'a' + 1);
            char temp = (char) (x);
            Array.set(arr, i, temp);
        } // for
        pen.print(arr);
        pen.print("\n");
        pen.flush();
    }// decode (String[] args)

}// VigenereCipher


