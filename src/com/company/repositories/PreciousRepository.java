package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.enteties.Precious;
import com.company.repositories.interfaces.IPreciousRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreciousRepository implements IPreciousRepository
{
    private final IDB db;

    public PreciousRepository(IDB db){
        this.db = db;
    }

    @Override
    public boolean createPrecious(Precious precious) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO stones(name, weight, cost,precious) VALUES (?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, precious.getName());
            st.setInt(2, precious.getWeight());
            st.setInt(3, precious.getCost());
            st.setBoolean(4, precious.isPrecious());

            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Precious getPrecious(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,weight,cost,precious FROM stones WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Precious precious = new Precious(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("weight"),
                        rs.getInt("cost"),
                        rs.getBoolean("precious"));

                return precious;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Precious> getAllPrecious() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,weight,cost, precious FROM stones";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Precious> preciouses = new ArrayList<>();
            while (rs.next()) {
                Precious precious = new Precious(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("weight"),
                        rs.getInt("cost"),
                        rs.getBoolean("precious"));

                preciouses.add(precious);
            }

            return preciouses;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
