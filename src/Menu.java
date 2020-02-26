import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Function fun = new Function();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(" 1.添加   2.修改   3.删除");
            System.out.println(" 4.显示   5.查询   6.排序");
            String strFountion = sc.nextLine();

            if (strFountion.equals("1")) { // 添加
                System.out.print("名字:");
                String name = sc.nextLine();
                System.out.print("电话:");
                String adr = sc.nextLine();
                System.out.print("住址:");
                String num = sc.nextLine();
                System.out.print("邮政编码:");
                String post = sc.nextLine();
                System.out.print("电子邮箱:");
                String e = sc.nextLine();
                System.out.print("家庭电话:");
                String phone= sc.nextLine();
                fun.add(name,adr,num,post,e,phone);
            } else if (strFountion.equals("2")) {// 修改
                System.out.println("输入修改的联系人姓名是：");
                String name = sc.nextLine();
                if(fun.selectName(name)==null){
                    System.out.println("提示：修改失败！");
                }else{
                    System.out.println("输入修改后的电话");
                    String phone= sc.nextLine();
                    System.out.print("输入修改后的住址:");
                    String adr = sc.nextLine();
                    System.out.print("输入修改后的邮政编码:");
                    String post = sc.nextLine();
                    System.out.print("输入修改后的电子邮箱:");
                    String e = sc.nextLine();
                    System.out.print("输入修改后的家庭电话:");
                    String phoneHome= sc.nextLine();
                    fun.update(name,phone,adr,post,e,phoneHome);
                }
            } else if (strFountion.equals("3")) {// 删除
                System.out.print("请输入删除的联系人的姓名：");
                String name1 = sc.nextLine();
                if(fun.selectName(name1) == null){
                    System.out.println("提示：删除失败");
                }else{
                    fun.remove(name1);
                }
            } else if (strFountion.equals("4")) {// 显示
                fun.show();
            } else if (strFountion.equals("5")) {// 查询
                System.out.println("请输入您要查询的名字");
                String name = sc.nextLine();
                Person contactPerson = fun.selectName(name);
                if (contactPerson == null) {
                    System.out.println("查询无此人");
                    continue;
                } else {
                    System.out.println("查询有此人");
                    System.out.println(contactPerson);
                }
            } else if (strFountion.equals("6")){//退出
                fun.sort();
                System.out.println("排序完成");
            }else {// 删除
                System.out.println("此功能不存在");
            }
        }
    }
}

