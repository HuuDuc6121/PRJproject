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
import model.Account;

/**
 *
 * @author Admin
 */
public class AccountDAO {
    Connection con;
    public AccountDAO(){
        DBContext dbcontext = new DBContext();
        try {
            con = dbcontext.getConnection();
            System.out.println("Successful");
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
    }
    
    public Account getAll(String email, String password){
        String sql = "select * from Accounts\n" +
                    "where status = 1 and email = ? and password = ? COLLATE Latin1_General_CS_AS";
        Account acc = null;
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, password);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                // lấy value theo từng cột
                int id = resultSet.getInt("accID");
                String Email = resultSet.getString("email");
                String Password = resultSet.getString("password");
                String fullname = resultSet.getString("fullname");
                String phone = resultSet.getString("phone");
                int status = resultSet.getInt("status");
                int role = resultSet.getInt("role");
                String token = resultSet.getString("token");
                //tạo model hứng giữ liệu
                acc = new Account(id, Email, Password, fullname, status, phone, role, token);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        
        return acc;
    }
    
    public ArrayList<Account> getAccount(){
        String sql = "select * from Accounts";
        ArrayList<Account> list = new ArrayList<>();
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                // lấy value theo từng cột
                int id = resultSet.getInt(1);
                String email = resultSet.getString(2);
                String password = resultSet.getString(3);
                String fullname = resultSet.getString(4);
                String phone = resultSet.getString(5);
                int status = resultSet.getInt(6);
                int role = resultSet.getInt(7);
                String token = resultSet.getString(8);
                //tạo model hứng giữ liệu
                Account account = new Account(id, email, password, fullname, status, phone, role, token);
                list.add(account);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        
        return list;
    }
    
    public Account getAccountbyid(int id){
        String sql = "select * from Accounts\n" +
                        "where accID = ?";
        Account account = new Account();
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, id);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                // lấy value theo từng cột
                String email = resultSet.getString(2);
                String password = resultSet.getString(3);
                String fullname = resultSet.getString(4);
                String phone = resultSet.getString(5);
                int status = resultSet.getInt(6);
                int role = resultSet.getInt(7);
                String token = resultSet.getString(8);
                //tạo model hứng giữ liệu
                account = new Account(id, email, password, fullname, status, phone, role, token);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        
        return account;
    }
    
    public boolean updateAccountStatus(int status, String email){
        String sql = "UPDATE [dbo].[Accounts]\n" +
                        "   SET [status] = ?\n" +
                        " WHERE email = ?";
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setString(2, email);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            pre.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        return false;
    }
    
     public boolean updateAccount(String email, String newPassword, String newFullname, String newPhone){
         String sql = "UPDATE [dbo].[Accounts]\n" +
                    "   SET [password] = ?\n" +
                    "      ,[fullname] = ?\n" +
                    "      ,[phone] = ?\n" +
                    " WHERE [email] = ?";
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            //set gia tri cho dau ? 
            pre.setString(1, newPassword);
            pre.setString(2, newFullname);
            pre.setString(3, newPhone);
            pre.setString(4, email);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            pre.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("error :  " + e);
        }
        return false;
     }
     
     public boolean insertAccount(String newEmail, String newPassword, String newFullname, String newPhone, int newStatus,int newRole){
         String sql = "INSERT INTO [dbo].[Accounts]\n" +
                    "           ([email]\n" +
                    "           ,[password]\n" +
                    "           ,[fullname]\n" +
                    "           ,[phone]\n" +
                    "           ,[status]\n" +
                    "           ,[role])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)";
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            //set gia tri cho dau ? 
            pre.setString(1, newEmail);
            pre.setString(2, newPassword);
            pre.setString(3, newFullname);
            pre.setString(4, newPhone);
            pre.setInt(5, newStatus);
            pre.setInt(6, newRole);
            
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            pre.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("error :  " + e);
        }
        return false;
     }
     
     public void editAccount(Account account){
        String sql = "UPDATE [dbo].[Accounts]\n" +
                    "   SET [email] = ?\n" +
                    "      ,[password] = ?\n" +
                    "      ,[fullname] = ?\n" +
                    "      ,[phone] = ?\n" +
                    "      ,[status] = ?\n" +
                    "      ,[role] = ?\n" +
                    " WHERE accID = ?";
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            //set gia tri cho dau ? 
            pre.setString(1, account.getEmail());
            pre.setString(2, account.getPassword());
            pre.setString(3, account.getFullname());
            pre.setString(4, account.getPhone());
            pre.setInt(5, account.getStatus());
            pre.setInt(6, account.getRole());
            pre.setInt(7, account.getAccID());
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            pre.executeUpdate();

        } catch (Exception e) {
            System.out.println("error :  " + e);
        }
    }
     
     public void updateToken(String token, String email){
        String sql = "UPDATE [dbo].[Accounts]\n" +
                        "   SET \n" +
                        "      [token] = ?\n" +
                        " WHERE email = ?";
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            //set gia tri cho dau ? 
            pre.setString(1, token);
            pre.setString(2, email);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            pre.executeUpdate();

        } catch (Exception e) {
            System.out.println("error :  " + e);
        }
    }
     
     public Account getAccount(String token){
        String sql = "select * from Accounts\n" +
                        "where token = ?";
        Account account = new Account();
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, token);
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                // lấy value theo từng cột
                int id = resultSet.getInt(1);
                String email = resultSet.getString(2);
                String password = resultSet.getString(3);
                String fullname = resultSet.getString(4);
                String phone = resultSet.getString(5);
                int status = resultSet.getInt(6);
                int role = resultSet.getInt(7);
                //tạo model hứng giữ liệu
                account = new Account(id, email, password, fullname, status, phone, role, token);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        
        return account;
    }
     
     public ArrayList<Account> getAccountbyEmail(String email){
        String sql = "select * from Accounts where email like '"+email+"%'";
        ArrayList<Account> list = new ArrayList<>();
        
        try {
            //tạo khay chứa câu lệnh
            PreparedStatement pre = con.prepareStatement(sql);
            
            //chạy câu lệnh và tạo khay chứa kết quả câu lệnh
            ResultSet resultSet = pre.executeQuery();
            while(resultSet.next()){
                // lấy value theo từng cột
                int accid = resultSet.getInt(1);
                String emails = resultSet.getString(2);
                String pass = resultSet.getString(3);
                String name = resultSet.getString(4);
                String phone = resultSet.getString(5);
                int status = resultSet.getInt(6);
                int role = resultSet.getInt(7);
                String token = resultSet.getString(8);
                Account acc = new Account(accid, emails, pass, name, status, phone, role, token);
                list.add(acc);
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
        }
        
        return list;
    }
    
//    public static void main(String[] args) {
//        AccountDAO p = new AccountDAO();
//    }
}
