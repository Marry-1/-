import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Function {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet res;

    public void add(String pname, String telephone, String address, String postalCode, String Email, String homePhone) {
        try {
            conn = (Connection) Util.getConn();
            String sql = "insert into a_contact  values (?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql); // 预编译sql语句
            //repareStatement这个方法会将SQL语句加载到驱动程序conn集成程序中
            //但是并不直接执行,而是当它调用execute()方法的时候才真正执行
            pst.setString(1,pname); //给第1个占位符赋值
            pst.setString(2,telephone);
            pst.setString(3,address);
            pst.setString(4,postalCode);
            pst.setString(5,Email);
            pst.setString(6,homePhone);
            pst.executeUpdate(); // 执行SQL语句
        } catch (SQLException e) {
        } catch (ClassNotFoundException e) {
        }finally {
            Util.close(pst,conn,res);
        }
    }

    //
    public void remove(String name)  {
        try {
            conn = (Connection) Util.getConn();
            String sql = "delete from a_contact where pname=?";
            pst=conn.prepareStatement(sql);// 预编译sql语句
            pst.setString(1,name);
            pst.executeUpdate();// 执行SQL语句
            //System.out.println("删除成功！");
        } catch (SQLException e) {
        } catch (ClassNotFoundException e) {
        }finally {
            Util.close(pst,conn,res);
        }
    }

    public void update(String pname, String telephone, String address, String postalCode, String Email, String homePhone) {
        Function contactFunction = new Function();
        contactFunction.remove(pname);
        contactFunction.add(pname,telephone,address,postalCode,Email,homePhone);
    }


    public Person selectName(String name)  {
        Person person = null;
        try{
            conn = (Connection) Util.getConn();
            String sql = "select * from a_contact where pname = ?";
            pst=conn.prepareStatement(sql);// 预编译sql语句
            pst.setString(1,name);
            res = pst.executeQuery();// 执行SQL语句
            if(res.next()){
                person = new Person();
                person.setPname(res.getString("pname"));
                person.setTelephone(res.getString("telephone"));
                person.setAddress(res.getString("address"));
                person.setPostalCode(res.getString("postalCode"));
                person.setEmail(res.getString("Email"));
                person.setHomePhone(res.getString("homePhone"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }finally {
            Util.close(pst,conn,res);
            return person;
        }
    }

    public void sort() {
        List<Person> list = new ArrayList<>();
        try {
            conn = (Connection) Util.getConn();
            String sql = "SELECT * FROM a_contact ORDER BY CONVERT(pname USING GB2312)";
            pst = conn.prepareStatement(sql);
            res = pst.executeQuery();
            while(res.next()){
                Person person = new Person();
                person.setPname(res.getString("pname"));
                person.setTelephone(res.getString("telephone"));
                person.setAddress(res.getString("address"));
                person.setPostalCode(res.getString("postalCode"));
                person.setEmail(res.getString("Email"));
                person.setHomePhone(res.getString("homePhone"));
                list.add(person);
            }
            for(Person c:list){
                System.out.println(c.toString());
            }
        } catch (SQLException e) {
        } catch (ClassNotFoundException e) {
        }finally {
            Util.close(pst,conn,res);
        }
    }

    public void show() {
        List<Person> list = new ArrayList<>();
        try {
            conn = (Connection) Util.getConn();
            String sql = "select * from a_contact";
            pst=conn.prepareStatement(sql);
            res = pst.executeQuery();
            while(res.next()){
                Person person = new Person();
                person.setPname(res.getString("pname"));
                person.setTelephone(res.getString("telephone"));
                person.setAddress(res.getString("address"));
                person.setPostalCode(res.getString("postalCode"));
                person.setEmail(res.getString("Email"));
                person.setHomePhone(res.getString("homePhone"));
                list.add(person);
            }
            for(Person c:list){
                System.out.println(c.toString());
            }
        } catch (SQLException e) {
        } catch (ClassNotFoundException e) {
        }finally {
            Util.close(pst,conn,res);
        }
    }
}

