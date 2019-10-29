package com.Gymnase.Mongodb;
import com.mongodb.client.MongoDatabase; 
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  

public class ListOfCollection { 
   
   public static void main( String args[] ) {  
      
      // Creating a Mongo client 
      MongoClient mongo = new MongoClient( "localhost" , 27017 ); 

      // Creating Credentials 
      MongoCredential credential; 
      credential = MongoCredential.createCredential("admin", "Gym", 
         "admin".toCharArray()); 

      System.out.println("Connected to the database successfully");  
      
      // Accessing the database 
      MongoDatabase database = mongo.getDatabase("Gym"); 
      System.out.println("Collection created successfully"); 
      for (String name : database.listCollectionNames()) { 
         System.out.println(name); 
      } 
   }
} 