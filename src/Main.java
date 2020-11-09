import java.io.*;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println();

//        Process process = Runtime.getRuntime().exec("cmd /c setx varManagerr 79");
//        InputStream process2 = Runtime.getRuntime().exec("cmd /c echo %varManager%").getInputStream();
//        String value =  System.getenv("varManager");

        Manager.run();
    }


}
