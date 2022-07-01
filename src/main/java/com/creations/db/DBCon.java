/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.creations.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author yku
 */
public class DBCon {
    public static Connection getConnnection()throws SQLException {
        return  DriverManager.getConnection(
            "jdbc:mariadb://127.0.0.1:3306/dashengha",
            "root", "127.0.0.1"
        );
    }
    
    
    static {
            try {
                Class.forName("org.hsqldb.jdbcDriver");
            } catch (Exception e) {}
        }
    public static boolean initdb = false;
    
    public static Connection getConnnection2()throws SQLException {
        Connection con =DriverManager.getConnection(
            "jdbc:hsqldb:mem:myDb"
        );;
        if(initdb ==false ){
            initdb = true;
            con.createStatement().executeUpdate("create table users (acct varchar(100) ,pwd varchar(100))");
            con.createStatement().executeUpdate("insert into users(acct,pwd) values ('eric','123')");
        }
        return   con;
    }
    
    public static void main(String args[])throws Exception{
        Connection con= DBCon.getConnnection2();
        ResultSet rs = con.createStatement().executeQuery("select * from users ");
        while(rs.next()){
            System.out.println(rs.getString("acct")+";"+rs.getString("pwd"));
        }
    }
}
