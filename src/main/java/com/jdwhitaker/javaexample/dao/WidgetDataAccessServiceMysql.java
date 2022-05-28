package com.jdwhitaker.javaexample.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdwhitaker.javaexample.model.Widget;

import org.springframework.stereotype.Repository;

@Repository("mysql")
public class WidgetDataAccessServiceMysql implements WidgetDao {

   @Override
   public int insertWidget(int id, Widget widget){
       try {
           String connectionString = String.format(
               "jdbc:mysql://%s/%s?user=%s&password=%s", 
               System.getenv("MYSQL_HOSTNAME"),
               System.getenv("MYSQL_DATABASE"),
               System.getenv("MYSQL_USER"),
               System.getenv("MYSQL_PASSWORD"));
           Connection connection = DriverManager.getConnection(connectionString);
           PreparedStatement statement = connection.prepareStatement("UPDATE widgets SET name=?, value=? where id=?");
           statement.setString(0, widget.getName());
           statement.setString(1, widget.getValue());
           statement.setInt(2, id);
           statement.execute();
           return 1;
       } catch (SQLException ex) {
           return 0;
       }
   }

   @Override
   public int addWidget(Widget widget){
        try {
           String connectionString = String.format(
               "jdbc:mysql://%s/%s?user=%s&password=%s", 
               System.getenv("MYSQL_HOSTNAME"),
               System.getenv("MYSQL_DATABASE"),
               System.getenv("MYSQL_USER"),
               System.getenv("MYSQL_PASSWORD"));
           Connection connection = DriverManager.getConnection(connectionString);
           PreparedStatement statement = connection.prepareStatement("INSERT INTO widgets(name,value) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
           statement.setString(1, widget.getName());
           statement.setString(2, widget.getValue());
           statement.executeUpdate();
           return 1;
       } catch (SQLException ex) {
           return 0;
       }
   }

   @Override
   public List<Widget> listWidgets(){
        try {
           String connectionString = String.format(
               "jdbc:mysql://%s/%s?user=%s&password=%s", 
               System.getenv("MYSQL_HOSTNAME"),
               System.getenv("MYSQL_DATABASE"),
               System.getenv("MYSQL_USER"),
               System.getenv("MYSQL_PASSWORD"));
           Connection connection = DriverManager.getConnection(connectionString);
           PreparedStatement statement = connection.prepareStatement("SELECT * FROM widgets;", Statement.RETURN_GENERATED_KEYS);
           ResultSet results = statement.executeQuery();
           List<Widget> widgets = new ArrayList<Widget>();
           while(results.next()){
               widgets.add(new Widget(results.getInt("id"), results.getString("name"), results.getString("value")));
           }
           return widgets;
       } catch (SQLException ex) {
           return new ArrayList<Widget>(); 
       }
   }
}
