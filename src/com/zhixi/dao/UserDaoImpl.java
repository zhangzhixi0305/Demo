package com.zhixi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhixi.domain.User;
import com.zhixi.util.DBManger;

public class UserDaoImpl implements UserDao {
    @Override
    public User login(String name, String pass) {
        System.out.println("name" + name + ":" + pass);
        User user = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBManger.getConnection();
            String sql = "select * from user where name = ? and pass = ? ";
            ps = con.prepareStatement(sql);
            //给两个占位符传值
            ps.setString(1, name);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPass(rs.getString("pass"));
                user.setLoginTime(rs.getTimestamp("logintime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流
            DBManger.dbClose(rs, ps, con);
        }
        return user;
    }

    @Override
    public boolean insert(User entity) {
        boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBManger.getConnection();
            String sql = "insert into user(name,pass) values (?,?)";
            ps = con.prepareStatement(sql);

            ps.setString(1, entity.getName());
            ps.setString(2, entity.getPass());
            int n = ps.executeUpdate();
            if (n > 0) {
                flag = true;
            }
            DBManger.dbClose1(ps, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(User entity) {
        boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBManger.getConnection();
            String name = entity.getName();
            String sql = "delete from user where name=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            int n = ps.executeUpdate();
            if (n > 0) {
                flag = true;
            }
            DBManger.dbClose1(ps, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(User entity) {
        boolean flag = false;
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBManger.getConnection();
            String pass = entity.getPass();
            String name = entity.getName();
            String sql = "update user set pass =? where name =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setString(2, name);
            int n = ps.executeUpdate();
            if (n > 0) {
                flag = true;
            }
            DBManger.dbClose1(ps, con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User findByName(String name) {
        User user = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBManger.getConnection();
            String sql = "select * from user where name =?";
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPass(rs.getString("pass"));
                user.setLoginTime(rs.getTimestamp("logintime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManger.dbClose(rs, ps, con);
        }
        return user;
    }
}
