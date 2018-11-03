package br.com.celsoandre.clinica;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class DataBaseMongoDB {
	
	private final  String  URL = "mongodb://gotic285:wtp102030@ds033317.mlab.com:33317/teste";
	private final String  DB_NAME = "teste";
	
	private MongoDatabase mongoDatabase;
	private MongoClient mongoClient;

	public MongoDatabase mongoOn() {

		try {
			
			MongoClientURI mongoClientURI = new MongoClientURI(URL, 
					MongoClientOptions.builder().cursorFinalizerEnabled(false));
			
			mongoClient = new MongoClient(mongoClientURI);
			
			mongoDatabase = mongoClient.getDatabase(DB_NAME);
			
			System.out.println("Bando aberto com sucesso!!");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return mongoDatabase;
	}

	public void mongoOff() {

		mongoClient.close();
	}

}
