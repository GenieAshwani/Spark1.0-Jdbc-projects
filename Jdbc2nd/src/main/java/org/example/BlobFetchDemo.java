package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

public class BlobFetchDemo {

    private static final String JDBC_URL="jdbc:mysql://localhost:3306/spark";
    private static final String USER_NAME="root";
    private static final String PASSWORD="root";


    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static void main(String[] args) {

        try {
            connection = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
            preparedStatement=connection.prepareStatement("Select image from blobdemo where id = ?");
            preparedStatement.setInt(1,2);

            resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {
                //stream
                InputStream is =resultSet.getBinaryStream("image");
                        //location
                FileOutputStream fis = new FileOutputStream("D:\\Kafka-Learning\\Jdbc2nd\\src\\main\\java\\res\\rahul.jpg");

                byte[] buffer = new byte[1024];
                while (is.read(buffer)>0)
                {
                    fis.write(buffer);
                }

                fis.close();
                is.close();
                System.out.println("Data Fetched .....");
            }
            else {
                System.out.println("No Image found..........");
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
