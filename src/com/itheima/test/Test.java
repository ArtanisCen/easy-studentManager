package com.itheima.test;

import com.itheima.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //创建一个集合容器，用于管理多个学生对象
        ArrayList<Student> list = new ArrayList<Student>();
        Student stu1 = new Student("heima001","汉三",25,"1999-02-02");
        Student stu2 = new Student("heima002","汉一",25,"1999-02-02");
        Student stu3 = new Student("heima003","汉二",25,"1999-02-02");

        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        Scanner sc = new Scanner(System.in);

        // ctrl + alt + T
        while (true) {
            System.out.println("--------欢迎来到学生管理系统--------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入您的选择:");

            int choice= sc.nextInt();

            switch(choice){
                case 1:
                    addStudent(list);
                    break;
                case 2:
                    deleteStudentById(list);
                    break;
                case 3:
                    updateStudentinfoById(list);
                    break;
                case 4:
                    quertStudentInfo(list);
                    break;
                case 5:
                    System.out.println("感谢您的使用，再见");
                    System.exit(0);
                    break ;
                default:
                    System.out.println("您的输入有误");
                    break;
            }
        }
    }
    /**
     *此方法用于添加学生
     **/
    private static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String id = "";
        while (true) {
            System.out.println("请输入学生学号");
            id = sc.next();
            int index = getIndex(list,id);
            if(index == -1){
                break;
            }else{
                System.out.println("您输入的学号已被占用，请重新输入");
            }
        }

        System.out.println("请输入学生姓名");
        String name = sc.next();;
        System.out.println("请输入学生年龄");
        int age = sc.nextInt();
        System.out.println("请输入学生生日");
        String birthday = sc.next();

        Student stu = new Student(id,name,age,birthday);
        list.add(stu);
        System.out.println("添加成功");
    }

    /**
     * 此方法根据学号，修改学生信息
     **/
    private static void updateStudentinfoById(ArrayList<Student> list) {
        //输入修改学生的学号
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要修改的学生学号");
        String updateId = sc.next();
        //调用getInd方法
        int index = getIndex(list,updateId);
        if (index == -1){
            System.out.println("查无此人，修改失败");
        }else{
            System.out.println("请输入新的学生姓名");
            String name = sc.next();
            System.out.println("请输入新的学生年龄");
            int age = sc.nextInt();
            System.out.println("请输入新的学生生日");
            String birthday = sc.next();

            Student stu = new Student(updateId,name,age,birthday);
            list.set(index,stu);
            System.out.println("修改成功");
        }
    }

    /**
     * 此方法用于根据学号删除集合中的学生
     **/
    private static void deleteStudentById(ArrayList<Student> list) {
        //1.键盘要录入删除的学号
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要查询的学生学号");
        String deleteId = sc.next();
        //2.调用getIndex方法，查找学号在集合的索引
        int index =getIndex(list, deleteId);
        //3.判断getIndex方法的返回值,是否是-1
        if(index == -1){
            //4.如果是-1，说明学号不存在，给出提示
            System.out.println("查无此人，删除失败");
        }else{
            //5.如果不是-1，学号存在，调用集合的remove的方法
            list.remove(index);
            System.out.println("删除成功");
        }
    }

    /**
    * 此方法用于查看学生
    * */
    private static void quertStudentInfo(ArrayList<Student> list) {
        if(list.size() == 0){
            System.out.println("暂无信息，请添加后重试");
        }else{
            System.out.println("学号\t\t\t姓名\t年龄\t\t生日");
            for(int i=0;i<list.size();i++){
                Student stu = list.get(i);
                System.out.println(stu.getId() +"---"+ stu.getName()+"---"+stu.getAge()+"---"+stu.getBirthday());
            }
        }
    }
    /**
    * 查找学号在集合的索引位置
    * */
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
