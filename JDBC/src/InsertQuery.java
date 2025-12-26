import java.sql.DriverManager;
import java.sql.*;


public class InsertQuery {

    private  static final String url = "jdbc:mysql://localhost:3306/college?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
 private  static final String username = "root";
 private  static final String password = "Pass@1234____";
    public static void main(String[] args) {
        try{
   Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            Connection c = DriverManager.getConnection(url,username,password);
            Statement s = c.createStatement();
              String query = String.format("INSERT INTO studentInfo(name,age,marks) VALUES('%s','%d','%f')","Rahul" ,26,97.66);
            s.executeUpdate(query);
            int rowAffected = s.executeUpdate(query);
            if(rowAffected!=0){
                System.out.println(query+" Data inserted successfully");
            }else{
                System.out.println(query+" Data could not be inserted");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
