package listFile;

import java.io.File;

public class ListFile {

    public void getLargest(File[] files){
        long largest = 0;
        String name = "";
        for (File file : files) {
            System.out.println(file.getName());
            if (file.length() > largest){
                largest = files.length;
                name = file.getName();
            }
        }
        System.out.println("最大的文件是"+name+",其大小是"+largest);
    }
    
    public void getSmallest(File[] files){
        long smallest = 9999999;
        String name = "";
        for (File file : files) {
            if(file.length() < smallest && file.length() > 0){
                smallest = file.length();
                name = file.getName();
            }
        }
        System.out.println("最小的文件是"+name+",其大小是"+smallest);
    }



    public static void main(String[] args) {
        File file = new File("c:/WINDOWS");
        File[] files = file.listFiles();
        ListFile practice1 = new ListFile();
        practice1.getLargest(files);
        practice1.getSmallest(files);

    }

}
