public class jdbc {
    
class member {

private String userid;
private String username
private int age;

Member(String userid, String username, int age){

    this.userid = userid;
    this.username = username;
    this.age = age;
}

public String getUserid() { return userid; }
public String getUsername() {return username; }
public int getAge() {return age; } 

}

}

    



    public static void main (String[] args) {

        String ur1 = "Jdbc:mariadb://127.0.0.1:3306/webdev";
        String userid = "webmaster";
        String userpw = "12345";
        String query = "select userid, username, age from tbl test";

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        Class.forName("org.mariadb.jdbc");
        con = DriverManager.getConnection(ur1, userid, userpw);
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        


        List<Member> list = new ArrayList<>();