package study;

import java.io.File;
import java.util.Scanner;

public class Rename {
    public static void main(String[] args) {
        // test

        Scanner input = new Scanner(System.in);
        System.out.println("输入需要批量重命名文件所在都目录");
        System.out.println("例如：C:/Users/Administrator/Desktop/study");
        String path = input.nextLine();
        System.out.println("输入需要替换的字符");
        String oldName = input.nextLine();
        System.out.println("输入替换后的字符");
        String newName = input.nextLine();
        File file = new File(path);
        File[] files = null;
        if(file.isDirectory()){
            files = file.listFiles();
        }
        for (File f: files) {
            File parentFile = f.getParentFile();
            String name = f.getName().replace(oldName, newName);
            File newFile = new File(parentFile, name);
            f.renameTo(newFile);
        }
        System.out.println("替换完成");
    }
}
