package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

public class BlobWriteDemo {

    private static final String JDBC_URL="jdbc:mysql://localhost:3306/spark";
    private static final String USER_NAME="root";
    private static final String PASSWORD="root";


    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static void main(String[] args) {

        try {
            connection = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
            File f=new File("D:\\Kafka-Learning\\Jdbc2nd\\src\\main\\java\\res\\IMG_4035.jpg");
            FileInputStream fis = new FileInputStream(f);
            preparedStatement=connection.prepareStatement("insert into blobdemo values(?,?)");
            preparedStatement.setInt(1,3);
            preparedStatement.setBinaryStream(2,fis,(int)f.length());
            LocalDateTime now = LocalDateTime.now();
            System.out.println(now);
            preparedStatement.executeUpdate();
            LocalDateTime now1 = LocalDateTime.now();
            System.out.println(now1);
            System.out.println("Data Inserted....");
            connection.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
