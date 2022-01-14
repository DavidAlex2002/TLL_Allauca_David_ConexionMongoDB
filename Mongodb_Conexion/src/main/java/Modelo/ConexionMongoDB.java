package Modelo;

import com.mongodb.*;
import Configuración.DataBase;

public class ConexionMongoDB {

		private MongoClient mongo = null;
		private DataBase confDB = null;
		
		public ConexionMongoDB()
		{
			this.confDB = new DataBase(); 
		}
		
		public DB getConnection()
		{
			DB db = null;
			try
			{
				mongo = new MongoClient(confDB.getServer(), confDB.getPort());
				db = mongo.getDB(confDB.getDb());
			}
			catch (Exception e)
			{
				//
			}
			
			return db;
		}
	}

