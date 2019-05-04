package com.company.JAVA1_STREAM_CREATION.JAVA4_STREAM_FROM_STRINGS;

import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {




/*
        Streams from Char Sequence

        chars() from the CharSequence interface returns an IntStream whose elements are
        int values representing the characters.

        We can use chars() method on a String, a StringBuilder, and a StringBuffer.

        The following code creates a stream of characters from a string, filters out
        all digits and whitespaces, and prints the remaining characters:

*/

        String str = "5 123,123,qwe,1,123, 25";
        str.chars()
                .filter(n ->  !Character.isDigit((char)n) &&   !Character.isWhitespace((char)n))
                .forEach(n ->  System.out.print((char)n));

 /*
        Streams from Regex

        splitAsStream(CharSequence input) method from the java.util.regex.Pattern class
        returns a stream of String whose elements match the pattern.

        The following code obtains a stream of strings by splitting a string
        using a regular expression (",").

        The matched strings are printed on the standard output.

*/

        String str2 = "XML,CSS,HTML";
        Pattern.compile(",")
                .splitAsStream(str2)
                .forEach(System.out::println);








    }







}
