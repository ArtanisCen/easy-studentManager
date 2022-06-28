package com.itheima.test;

import com.itheima.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        //创建一个集合容器，用于管理多个学生对象
        ArrayList<Student> list = new ArrayList<Student>();
        Student stu1 = new Student("heima001", "汉三", 25, "1999-02-02");
        Student stu2 = new Student("heima002", "汉一", 25, "1999-02-02");
        Student stu3 = new Student("heima003", "汉二", 25, "1999-02-02");

        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查找的学号");
        String id = sc.next();

        int index = getIndex(list,id);

        System.out.println(index);
    }

    private static int getIndex(ArrayList<Student> list, String id) {
        int index = -1;
        for(int i =0 ; i<list.size() ; i++) {
            Student stu = list.get(i);
            if(stu.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }
}
