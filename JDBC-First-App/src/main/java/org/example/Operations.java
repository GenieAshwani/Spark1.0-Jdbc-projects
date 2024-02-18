package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Operations {

    public static void fecthData(ResultSet resultSet ) throws SQLException {
        System.out.println("*************STUDENTS DETAILS***************************");
        while (resultSet.next())
        {
            System.out.println("Student id:"+resultSet.getInt("st_id"));
            System.out.println("Student name :"+resultSet.getString("name"));
            System.out.println("Student email:"+resultSet.getString("email"));
            System.out.println("Student phoneNo:"+resultSet.getString("phoneNo"));
            System.out.println("---------------------------------------------------------");

        }
    }
}
