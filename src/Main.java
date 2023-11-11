import java.sql.*;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/user";
        String myServer = "root";
        String myPassword = "Obianuju#1";

        try {
            Scanner scan = new Scanner(System.in);
            Connection connect = DriverManager.getConnection(url,myServer,myPassword);
            Statement statement = connect.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS users(name Text NOT NULL, email Text,age Int,address Text)");
            //PreparedStatement getStatement = connect.prepareStatement("INSERT INTO users(name, email, age, address) VALUES(?,?,?,?)");
            PreparedStatement updateStatement = connect.prepareStatement("UPDATE users SET name = \"Yukay\" WHERE email = ?");

            System.out.print("Enter your new email: ");
            String email1 = scan.nextLine();
            updateStatement.setString(1,email1);
            updateStatement.execute();

        /*    System.out.print("What is your name: ");
            String name = scan.nextLine();

            System.out.print("Enter your Email Address: ");
            String email = scan.nextLine();

            System.out.print("Enter your age: ");
            int age = scan.nextInt();
            scan.nextLine();

            System.out.print("Enter your address: ");
            String address = scan.nextLine();

            getStatement.setString(1,name);
            getStatement.setString(2, email);
            getStatement.setInt(3,age);
            getStatement.setString(4,address);

            getStatement.execute();*/


            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}