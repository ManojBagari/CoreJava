package com.company.JAVA1_STREAM_CREATION.JAVA5_STREAM_FROM_FILES;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.jar.JarEntry;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

 /*
        java.io and java.nio.file packages from Java 8 has added many methods
        to support I/O operations using streams.

        We can read text from a file as a stream of strings.
        Each element in the stream represents one line of text.

        We can also use a stream to read JarEntry from a JarFile and
        we can read entries in a directory as a stream of Path.

        Auto close

        Calling the close() method on the stream will close the underlying file.

        Alternatively, we can create the stream in a try-with-resources statement
        so the underlying file is closed automatically.

*/

        Path path = Paths.get("./Main.java");
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        The following code shows how to read a path using stream.


        Path dir = Paths.get(".");
        System.out.printf("%nThe file tree for %s%n",
                dir.toAbsolutePath());
        try (Stream<Path> fileTree = Files.walk(dir)) {
            fileTree.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }















    }











}
