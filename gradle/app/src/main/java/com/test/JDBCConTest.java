package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import org.checkerframework.checker.units.qual.m;

class Member {
        
    private String nam;
    private String major;
    private int studentnumber;

    Member(String nam, String major, int studentnumber){

        this.nam = nam;
        this.major = major;
        this.studentnumber = studentnumber;
    }

    public String getnam(){ return nam; }
    public String getmajor(){ return major; }
    public int getstudentnumber(){ return studentnumber; }

    static class Builder{
        private String name;
        private String major;
        private int studentnumber;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder studentnumber(int studentnumber){
            this.studentnumber = studentnumber;
            return this;
        }

        public Member build() {

            if(name == null || major == null || studentnumber == 0){
                throw new IllegalStateException("멤버클래스가 생성이 안됩니다");
            }
            return new Member(name, major, studentnumber);
        }


    }//Builder class의 끝




    }

    public class JDBCConTest {

        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            String url = "jdbc:mariadb://127.0.0.1:3306/webdev"; //url 쓰는 방식은 규칙이므로 외워야함
            String userid = "root";
            String userpw = "rlarjsdn";
            String query = "select nam, studentnumber, major from tbl_test";

            Connection con;
            Statement stmt;  
            ResultSet rs;

            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(url, userid, userpw);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            List<Member> list = new ArrayList<>();

            while(rs.next()){
                //list.add(new Member(rs.getString("name"), rs.getString("major"), rs.getInt("studentnumber")));
                list.add(new Member(rs.getString("nam"), rs.getString("major"), rs.getInt("studentnumber")));
                
             }

            for (Member member: list) {
                System.out.println("아이디 = " + member.getnam() + ", 전공 = " + member.getmajor() + ", 학번 = " + member.getstudentnumber());
            }
            
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(con != null) con.close();
          
            }
       }
    