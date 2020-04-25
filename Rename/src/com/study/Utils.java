package com.study;

import java.io.*;
import java.util.Scanner;

public class Utils {
    public static void main(String[] args) {

        removeTrim();
    }

    /**
     * 文件空白行处理
     */
    public static void removeTrim() {
        // 删除文件中都空白行
        System.out.println("空白行开始处理");
        Scanner input = new Scanner(System.in);
        System.out.println("输入需要批量重命名文件所在都目录");
        System.out.println("例如：C:/Users/Administrator/Desktop/study");
        String path = input.nextLine();
        File file = new File(path);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            StringBuffer sb = new StringBuffer();
            while (str != null){
                if (str.length() > 0){
                    // str = new String(str.getBytes("utf-8"), "utf-8");
                    System.out.println(str);
                    sb.append(str).append("\r\n");
                }
                str = br.readLine();
            }
            br.close();
            fr.close();

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(sb.toString());
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("空白行处理完成");
        }

    }

    /**
     * 批量修改文件名称
     */
    public void rename(){
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
        System.out.printf("");
        System.out.printf("");
    }
}
