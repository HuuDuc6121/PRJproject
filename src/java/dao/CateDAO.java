/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Categories;

/**
 *
 * @author Admin
 */
public class CateDAO {
    Connection con;
    public CateDAO(){
        DBContext dbcontext = new DBContext();
        try {
            con = dbcontext.getConnection();
            System.out.println("Successful");
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
    }
    
    public ArrayList<Categories> getCategories(){
        String sql = "select * from Categories";
        ArrayList<Categories> list = new ArrayList<>();
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                // lấy value theo từng cột
                int cateid = resultSet.getInt(1);
                String catename = resultSet.getString(2);
                Categories cate = new Categories(cateid, catename);
                list.add(cate);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        
        return list;
    }
    
}
