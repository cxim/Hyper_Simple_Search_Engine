package search;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 1 && args[0].equals("--data")) {
            File file = new File(args[1]);
            Scanner scanner = new Scanner(file);
            InfoGet infoGet = new InfoGet();
            infoGet.start(scanner);
            scanner.close();
            scanner = new Scanner(System.in);
            InfoSearch infoSearch = new InfoSearch(infoGet);
            infoSearch.doOperation(scanner);
        } else {
            System.out.println("SomeThing wrong!");
        }
    }
}
