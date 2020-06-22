package _my_test_1.dao;

import _my_test_1.model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserDAO {
    private static final String SQL_USER_INSERT = "INSERT INTO my_test_1 (name) VALUES (?);";
    private static final String SQL_USER_ALL = "SELECT * FROM my_test_1;";
    public UserDAO() {}

    private static Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();
            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("my_dev_db2?").          //db name
                    append("user=root&").           //login
                    append("password=root123");     //password

            System.out.println("URL: " + url + "\n");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }

    public void addUserDAO(User user) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_USER_INSERT);
            preparedStatement.setString(1, user.getName());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> showAllUserDAO() {
        List<User> list = new LinkedList<>();

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_USER_ALL);

            while (resultSet.next()) {
                int idClint = resultSet.getInt("id");
                String nameString = resultSet.getString("name");
                list.add(new User(idClint, nameString));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
