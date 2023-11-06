import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.lang.reflect.Array;

public class VigenereCipher {
    public static void main(String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true); 

        if (args.length != 3) {
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

    /* Encodes provided string with the Vigenere Cipher encription in 25 different ways
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
        }

        else {
            for (int i = 0; i < lenString; i++) {
                n = i % lenKeyword;
                int x = args[1].charAt(i) + args[2].charAt(n) - base;
                if (x > 'z')
                    x = x - ('z' - 'a'); 

                char temp = (char) (x); 
                Array.set(arr, i, temp); 
            } 

            pen.println(arr); 
            pen.flush();
        }
    }//encode

    /* Decodes input provided strings with the Vigenere Cipher encription in 25 different ways
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
                x = x + ('z' - 'a'); 
            char temp = (char) (x); 
            Array.set(arr, i, temp); 
        } 
        pen.print(arr); 
        pen.print("\n");
        pen.flush();
    }//decode

}//VigenereCipher


