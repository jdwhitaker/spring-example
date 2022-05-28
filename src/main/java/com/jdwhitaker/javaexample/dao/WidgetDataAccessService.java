package com.jdwhitaker.javaexample.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jdwhitaker.javaexample.model.Widget;

import org.springframework.stereotype.Repository;

@Repository("inMemory")
public class WidgetDataAccessService implements WidgetDao {
   private static HashMap<Integer, Widget> DB = new HashMap<Integer, Widget>();

   @Override
   public int insertWidget(int id, Widget widget){
       DB.put(id, widget);
       return 1;
   }

   @Override
   public int addWidget(Widget widget){
       DB.put(DB.size()+1, widget);
       return 1;
   }

   @Override
   public List<Widget> listWidgets(){
       return new ArrayList<Widget>(DB.values());
   }
}
