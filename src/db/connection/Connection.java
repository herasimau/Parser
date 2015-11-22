package db.connection;


import java.sql.SQLException;
import java.sql.*;

public class Connection {
    public java.sql.Connection conn;
    private String URL = "jdbc:mysql://localhost:3306/arenda";
    private String USERNAME = "root";
    private String PASSWORD = "root";

        public void getDbConnection(){

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Драйвер успешно зарегестрирован!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Соединение с базой установлено!");
            } catch (SQLException e) {
                e.printStackTrace();
            }





    }

}



