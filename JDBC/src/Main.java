import java.sql.DriverManager;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/college?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static  final String username = "root";
    private static final String password = "Pass@1234____";
    public  static void main(String[] args) {
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
      }catch(ClassNotFoundException e) {
          System.out.println(e.getMessage());
      }

      try{
          Connection connection = DriverManager.getConnection(url,username,password);
          Statement statement = connection.createStatement();
          String query = "SELECT * FROM studentInfo";
          ResultSet resultSet = statement.executeQuery(query);

          while (resultSet.next()) {
              int id = resultSet.getInt("id");
              String name = resultSet.getString("name");
              int age = resultSet.getInt("age");
              double marks = resultSet.getDouble("marks");

              System.out.println("Id" + id);
              System.out.println("Name" + name);
              System.out.println("Age" + age);
              System.out.println("Marks" + marks);
          }
      }catch (Exception e) {
          System.out.println(e.getMessage());
      }

    }
}