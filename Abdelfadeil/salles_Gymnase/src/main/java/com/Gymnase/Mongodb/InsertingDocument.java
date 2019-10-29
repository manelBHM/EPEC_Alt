package com.Gymnase.Mongodb;
import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase; 

import org.bson.Document;

import com.Gymnase.entities.Sportifs;
import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;  

public class InsertingDocument { 
   
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

      // Retrieving a collection
      MongoCollection<Document> collection = database.getCollection("Sportifs"); 
      System.out.println("Collection sampleCollection selected successfully");

      Document document = new Document("Sportifs", "MongoDB") 
      .append("id", 1)
      .append("IdSportif", Sportifs.IdSportif) 
      .append("Nom", Sportifs.Nom) 
      .append("Prenom", Sportifs.Prenom)
      .append("Sexe", Sportifs.Sexe)
      .append("Age", Sportifs.Age);  
      collection.insertOne(document); 
      System.out.println("Document inserted successfully");     
   } 
}