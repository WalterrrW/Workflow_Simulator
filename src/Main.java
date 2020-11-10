import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.out.println("Env before setting: " + System.getenv("varManager"));
//
//        Process process = Runtime.getRuntime().exec("cmd /c setx varManager 99");
//
//        System.out.println("Env after setting: " + System.getenv("varManager"));

        Manager.run();
    }


}
