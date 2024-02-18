package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCApplication {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/spark";
        String username = "root";
        String password = "root";

        try {
                ///load and reg
               // Class.forName("com.mysql.cj.jdbc.Driver");
           Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement = connection.createStatement();
           //ResultSet resultSet = statement.executeQuery("select * from students");



            //1. user input ---> fetch data
            //2. user unput ---> insert data
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter 1 for fetch data \nEnter 2 for insert data\nEnter 3 for batch update\nEnter 4 for delete data");

            int choice = sc.nextInt();
            switch (choice)
            {
                //fetching data from database
                case 1:
                    ResultSet fectData = statement.executeQuery("select * from students");
                    Operations.fecthData(fectData);
                    break;
                case 2:
                    ResultSet MaxIdResultSet = statement.executeQuery("select MAX(st_id) as max_st_id from students");
                    int max_id=0;
                    while (MaxIdResultSet.next())
                    {
                        max_id=MaxIdResultSet.getInt("max_st_id");
                        System.out.println("Max Student id:"+max_id);
                    }
                    max_id++;
                    System.out.println("Enter the name:");
                    String name=sc.next();
                    System.out.println("Enter the email");
                    String email=sc.next();
                    System.out.println("Enter the phoneno");
                    String phoneNo=sc.next();



                    int rowCount = statement.executeUpdate("insert into students values("+max_id+",'"+name+"','"+email+"','"+phoneNo+"')");
                    if(rowCount>0)
                    {
                        System.out.println("Data Inserted:");
                    }
                    else {
                        System.out.println("Data Insertion failed:");
                    }
                    break;
                case 3:
                    System.out.println("Enter the detail for batch");
                    String [] bulkQruies =new String[10];


                   // statement.addBatch();
                    //statement.executeBatch();

                case 4:
                    System.out.println("Enter the id for delete record:");
                    int id = sc.nextInt();
                    int row = statement.executeUpdate("DELETE from students where st_id = " + id);
                    if(row>0)
                    {
                        System.out.println("Data Deleted:"+id);
                    }
                    else {
                        System.out.println("Data Deletion failed:");
                    }
                    break;
                default:
                    System.out.println("Enter valid input");
                    break;

            }




        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
