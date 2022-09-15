/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import model.Order;
import model.OrderDetail;

/**
 *
 * @author Admin
 */
public class OrderDAO {
    Connection con;
    public OrderDAO(){
        DBContext dbcontext = new DBContext();
        try {
            con = dbcontext.getConnection();
            System.out.println("Successful");
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
    }
    
    public ArrayList<Order> getOrder(String name){
        String sql = "select * from Orders";
        ArrayList<Order> list = new ArrayList<>();
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                // lấy value theo từng cột
                int orderid = resultSet.getInt(1);
                Date ordate = resultSet.getDate(2);
                Date shipdate = resultSet.getDate(3);
                int status = resultSet.getInt(4);
                int accid = resultSet.getInt(5);
                //tạo model hứng giữ liệu
                Order order = new Order(orderid, ordate, shipdate, status, accid);
                list.add(order);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        
        return list;
    }
    
    public ArrayList<OrderDetail> getOrderDetail(int orderID){
        String sql = "select DetailId, OrderID, PID, PName, price, imgPath, quantity \n" +
                        "from OrderDetails, Plants\n" +
                        "where OrderID = ? and OrderDetails.FID = Plants.PID";
        ArrayList<OrderDetail> list = new ArrayList<>();
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, orderID);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                // lấy value theo từng cột
                int detailid = resultSet.getInt(1);
                int pid = resultSet.getInt(3);
                String pname = resultSet.getString(4);
                int price = resultSet.getInt(5);
                String imgpath = resultSet.getString(6);
                int quantity = resultSet.getInt(7);
                //tạo model hứng giữ liệu
                OrderDetail ordetail = new OrderDetail(detailid, orderID, quantity, pname, price, imgpath, quantity);
                list.add(ordetail);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        
        return list;
    }
    
    public void updateStatus(int status, int orderID){
        String sql = "UPDATE [dbo].[Orders]\n" +
                        "   SET \n" +
                        "      [status] = ?\n" +
                        " WHERE OrderID = ?";
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            //set gia tri cho dau ? 
            pre.setInt(1, status);
            pre.setInt(2, orderID);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            pre.executeUpdate();

        } catch (Exception e) {
            System.out.println("error :  " + e);
        }
    }
    
    public boolean insertOrder(String email, HashMap<String, Integer> cart){
        boolean result = false;
        try {
            if(con != null){
                int accid = 0, orderid = 0;
                con.setAutoCommit(false);//off autocommit
                //get account id by email
                String sql = "select accID from Accounts where Accounts.email = ?";
                PreparedStatement pre = con.prepareStatement(sql);
                pre.setString(1, email);
                ResultSet resultSet = pre.executeQuery();
                if(resultSet != null && resultSet.next()) accid = resultSet.getInt("accID");
                //insert a new order
                System.out.println("Account ID: "+accid);
                Date d = new Date(System.currentTimeMillis());
                System.out.println("Order Date: "+d);
                sql ="insert Orders(OrdDate, status, AccID) values(?,?,?)";
                pre = con.prepareStatement(sql);
                pre.setDate(1, d);
                pre.setInt(2, 1);
                pre.setInt(3, accid);
                pre.executeUpdate();
                //get order id that is the largest number
                sql = "select top 1 orderID from Orders order by orderId desc";
                pre = con.prepareStatement(sql);
                resultSet = pre.executeQuery();
                if(resultSet != null && resultSet.next()) orderid = resultSet.getInt("orderID");
                //insert order details
                System.out.println("Order ID: "+orderid);
                Set<String> pids = cart.keySet();
                for(String pid : pids){
                    sql = "insert OrderDetails values(?,?,?)";
                    pre = con.prepareStatement(sql);
                    pre.setInt(1, orderid);
                    pre.setInt(2, Integer.parseInt(pid.trim()));
                    pre.setInt(3, cart.get(pid));
                    pre.executeUpdate();
                    con.commit();
                    con.setAutoCommit(true);
                }
                return true;
            }
            else{
                System.out.println("Khong chen order duoc!!!");
            }
        } catch (Exception e) {
            try {
                if(con != null) con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            result = false;
        }
        finally{ try {
                if(con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        return result;
    }
    
    public ArrayList<Order> getOrders(){
        String sql = "select * from Orders";
        ArrayList<Order> list = new ArrayList<>();
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                // lấy value theo từng cột
                int orderid = resultSet.getInt(1);
                Date ordate = resultSet.getDate(2);
                Date shipdate = resultSet.getDate(3);
                int status = resultSet.getInt(4);
                int accid = resultSet.getInt(5);
                //tạo model hứng giữ liệu
                Order order = new Order(orderid, ordate, shipdate, status, accid);
                list.add(order);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        
        return list;
    }
    
}
