/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.creations;

import com.creations.db.DBCon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author yku
 */
public class login {
    public String match(String acct,String pwd){
        Connection con = null;
        try
        {
            con = DBCon.getConnnection2();
            String sql = "select * from users where acct = ? and pwd = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            int idx = 0 ;
            pst.setString(++idx,acct);
            pst.setString(++idx,pwd);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getString("acct");
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(con!=null)
                try{
                con.close();
                }catch(SQLException e){}
        }
        return null;
    }
    
    
}
