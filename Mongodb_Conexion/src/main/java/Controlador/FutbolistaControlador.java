package Controlador;

import java.util.ArrayList;

import com.mongodb.*;

import Mongo_Futbolista.*;
import Modelo.ConexionMongoDB;

public class FutbolistaControlador {
	
	ConexionMongoDB mConn = new ConexionMongoDB();
	DB db = mConn.getConnection();
	DBCollection collection = db.getCollection("Futbolistas");
	
	public void create(ArrayList<Futbolista> futbolistas)
	{
	     for (Futbolista fut : futbolistas)
	    	collection.insert(fut.toDBObjectFutbolista());
	}
	
	public void read()
	{
		int numDocumentos = (int) collection.getCount();
	    System.out.println("Numero de documentos en la coleccion Futbolistas: " + numDocumentos + "\n");
	
	    DBCursor cursor = collection.find();
	    try
	    {
			while (cursor.hasNext())
				System.out.println(cursor.next().toString());
			
		}
		finally
		{
			cursor.close();
		}

		System.out.println("\n Futbolistas que juegan en la posicion -Delantero- ");
		DBObject query = new BasicDBObject("Demarcacion", new BasicDBObject("$regex", "Delantero"));
		cursor = collection.find(query);
		try
		{
			while (cursor.hasNext())
			{
				Futbolista futbolista = new Futbolista((BasicDBObject) cursor.next());
				System.out.println(futbolista.toString());
			}
		}
		finally
		{
			cursor.close();
		}
	}
	
	public void update()
	{
		DBObject find = new BasicDBObject("edad", new BasicDBObject("$gt", 30));
		DBObject updated = new BasicDBObject().append("$inc", new BasicDBObject().append("edad", 100));
		collection.update(find, updated, false, true);
	}
	
	public void delete()
	{
		DBObject findDoc = new BasicDBObject("internacional", true);
		collection.remove(findDoc);
	}
}