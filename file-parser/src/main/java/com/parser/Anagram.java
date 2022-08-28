package com.parser;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "silent";
        String s2 = "listen";
        anagramWithJavaBuiltInFunctions(s1, s2);

    }

    public static void anagramWithJavaBuiltInFunctions(String str1, String str2) {
        boolean status = true;

        if (str1.length() != str2.length()) {
            status = false;
        } else {
            char[] charArray1 = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();

            Arrays.sort(charArray1);
            Arrays.sort(charArray2);
            System.out.println(charArray1);
            System.out.println(charArray2);
            status = Arrays.equals(charArray1, charArray1);
        }

        if (status) {
            System.out.println(str1 + " AND " + str2 + ":" + "Is Anagram");
        } else {
            System.out.println(str1 + " AND " + str2 + ":" + "Is not a Anagram");
        }
    }

    public static void anagramWithOutFunctions(String str1, String str2){

        
    }
}
