package com.jdwhitaker.javaexample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Widget {
   private final int id;
   private final String name;
   private final String value; 

   public Widget(
                @JsonProperty("id") int id, 
                @JsonProperty("name") String name, 
                @JsonProperty("value") String value
            ){
       this.id = id;
       this.name = name;
       this.value = value;
   }

   public int getId(){
       return id;
   }

   public String getName(){
       return name;
   }

   public String getValue(){
       return value;
   }
}
