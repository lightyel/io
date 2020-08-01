package pojoBuilder;

import java.io.*;
import java.util.Scanner;

/**
 * 自动创建有一个属性的类文件。
 * 通过控制台，获取类名，属性名称，属性类型，根据一个模板文件，自动创建这个类文件，
 * 并且为属性提供setter和getter
 */
public class PojoBuilder {
    String className;
    String property;
    String propertyType;
    String templateFile = "./src/pojoBuilder/Template";
    BufferedWriter bw = null;
    BufferedReader br = null;
    Scanner scanner = new Scanner(System.in);

    public void createClass(){
        try {
            className = getInfo(" className");
            property = getInfo(" property");
            propertyType = getInfo(" propertyType");
            String file = "./src/pojoBuilder/"+className+".java";
            File f = new File(file);
            if(!f.exists()){
                f.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(f));
            br = new BufferedReader(new FileReader(new File(templateFile)));
            String content = createContent(br);
            bw.write(content);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getInfo(String info){
        System.out.println("Please enter your"+info+":");
        return scanner.nextLine();
    }

    public String createContent(BufferedReader br) throws IOException {
        System.out.println("log：进入此处");
        String str = null;
        StringBuffer sb = new StringBuffer();
        while ((str=br.readLine())!=null){
            sb.append(str).append("\r\n");
        }
        String content = sb.toString();
        content = content.replaceAll("@class@", className);
        //注意替换后不改变原字符串，需要再次赋值
        content = content.replaceAll("@type@", propertyType);
        content = content.replaceAll("@property@", property);
        //将getter和setter方法中的方法名的某个字符大写
        content = content.replaceAll("@Uproperty@",
                Character.toUpperCase(property.charAt(0))+property.substring(1));

        System.out.println(content);
        return content;
    }


    public static void main(String[] args) {
        PojoBuilder pojoBuilder = new PojoBuilder();

        pojoBuilder.createClass();
    }

}
