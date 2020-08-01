package listFile;

import java.io.File;

public class TestFile {

    public static void main(String[] args) {
        File file = new File("h:/Study/How2J/IO/Test");
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());

        File file1 = new File("h:/Study/How2J/IO/Test/LOL.exe");
        System.out.println(file1.getAbsolutePath());

        File file2 = new File(file, "file.txt");
        System.out.println(file2.getAbsolutePath());


    }

}
