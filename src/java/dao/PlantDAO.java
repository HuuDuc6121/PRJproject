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
import java.util.List;
import model.Categories;
import model.Plant;

/**
 *
 * @author Admin
 */
public class PlantDAO {
    
    Connection con;
    public PlantDAO(){
        DBContext dbcontext = new DBContext();
        try {
            con = dbcontext.getConnection();
            System.out.println("Successful");
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
    }
    
    public List<Plant> getPlantbyName(String name){
        String sql = "select PID, PName, price, imgPath, description, status, Plants.CateID as 'CateID', CateName from dbo.Plants, dbo.Categories\n" +
"                            where Plants.CateID = Categories.CateID and Plants.PName like '"+name+"%'";
        List<Plant> list = new ArrayList<>();
        
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                // lấy value theo từng cột
                int id = resultSet.getInt(1);
                String pname = resultSet.getString(2);
                int price = resultSet.getInt(3);
                String imgpath = resultSet.getString(4);
                String description = resultSet.getString(5);
                int status = resultSet.getInt(6);
                int cateid = resultSet.getInt(7);
                String catename = resultSet.getString(8);
                Categories cate = new Categories(cateid, catename);
                Plant plant = new Plant(id, pname, price, imgpath, description, status, cate);
                list.add(plant);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        
        return list;
    }
    
    public List<Plant> getPlantbyCateName(String catename){
        String sql = "select PID, PName, price, imgPath, description, status, Plants.CateID as 'CateID', CateName from dbo.Plants, dbo.Categories\n" +
"                            where Plants.CateID = Categories.CateID and Categories.CateName like '"+catename+"%'";
        List<Plant> list = new ArrayList<>();
        
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                // lấy value theo từng cột
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                String imgpath = resultSet.getString(4);
                String description = resultSet.getString(5);
                int status = resultSet.getInt(6);
                int cateid = resultSet.getInt(7);
                String cname = resultSet.getString(8);
                Categories cate = new Categories(cateid, cname);
                Plant plant = new Plant(id, name, price, imgpath, description, status, cate);
                list.add(plant);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        
        return list;
    }
    
    public Plant getPlant(int pid){
        Plant p = null;
        try {
            if(con != null){
                String sql = "select PID, PName, price, imgPath, description, status, Plants.CateID as CateID, CateName from Plants, Categories\n" +
                            "where Plants.CateID = Categories.CateID and PID = ?";
                PreparedStatement pre = con.prepareStatement(sql);
                pre.setInt(1, pid);
                ResultSet resultSet = pre.executeQuery();
                while(resultSet.next()){
                // lấy value theo từng cột
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int price = resultSet.getInt(3);
                String imgpath = resultSet.getString(4);
                String description = resultSet.getString(5);
                int status = resultSet.getInt(6);
                int cateid = resultSet.getInt(7);
                String cname = resultSet.getString(8);
                Categories cate = new Categories(cateid, cname);
                p = new Plant(id, name, price, imgpath, description, status, cate);
            }
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        return p;
    }
    
    public ArrayList<Plant> getPlants(){
        String sql = "select PID, PName, price, imgPath, description, status, Plants.CateID as CateID, CateName from Plants, Categories\n" +
                    "                            where Plants.CateID = Categories.CateID";
        ArrayList<Plant> list = new ArrayList<>();
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                // lấy value theo từng cột
                int pid = resultSet.getInt(1);
                String pname = resultSet.getString(2);
                int price = resultSet.getInt(3);
                String imgpath = resultSet.getString(4);
                String description = resultSet.getString(5);
                int status = resultSet.getInt(6);
                int cateid = resultSet.getInt(7);
                String catename = resultSet.getString(8);
                //tạo model hứng giữ liệu
                Categories cate = new Categories(cateid, catename);
                Plant plant = new Plant(pid, pname, price, imgpath, description, status, cate);
                list.add(plant);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        
        return list;
    }
    
}
