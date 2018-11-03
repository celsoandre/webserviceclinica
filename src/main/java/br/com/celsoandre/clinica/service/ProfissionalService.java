package br.com.celsoandre.clinica.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.util.JSON;

import br.com.celsoandre.clinica.models.Profissional;
import br.com.celsoandre.clinica.utils.ConstantesDB;
import br.com.celsoandre.clinica.utils.ConstantesDB.CommandsMongo;
import br.com.celsoandre.clinica.utils.ConstantesDB.PropertiesDB;

public class ProfissionalService {
	
	private final MongoCollection<BasicDBObject> mongoCollection;
	
	public ProfissionalService(MongoDatabase mongoDatabase) {
		mongoCollection = mongoDatabase.getCollection(ConstantesDB.DBNAME, BasicDBObject.class);
	}
	
	/**
	 * metodo para salva um registro no banco 
	 * @param jsonValue
	 */
	public void insertProfissional(String jsonValue) {
		BasicDBObject basicDBObject = (BasicDBObject) JSON.parse(jsonValue);
		mongoCollection.insertOne(basicDBObject);
		
		System.out.println("Registro salvo com suceso!");
	}
	
	public List<Profissional> getAll() {
		List<Profissional> profissionais = new ArrayList<>();
		MongoCursor<BasicDBObject> mongoCursor = mongoCollection.find().iterator();
		
		while(mongoCursor.hasNext()) {
			profissionais.add(new Profissional(mongoCursor.next()));
			
		}
		
		System.out.println("GetAll realizado com sucesso! ");
		return profissionais;
		
	}
	
	public Profissional get(String _id) {
		Profissional profissional;
		
		Bson filter = Filters.eq("_id", new ObjectId(_id));
		
		BasicDBObject basicDBObject = mongoCollection.find(filter).first();
		
		profissional = new Profissional(basicDBObject);
		
		return profissional;
	}
	
	public void del(String _id) {
		Bson filter = Filters.eq("_id", new ObjectId(_id));
		
		DeleteResult deleteResult = mongoCollection.deleteOne(filter);
		
		
	}

	public void update(String jsonValue) {
		
		BasicDBObject de  = (BasicDBObject) JSON.parse(jsonValue);
		
		BasicDBObject para = new BasicDBObject();
		
		ObjectId objectId = new ObjectId(de.getString(ConstantesDB.PropertiesDB.ID));
		
		
		para.put(ConstantesDB.PropertiesDB.ID, objectId);
		para.put(ConstantesDB.PropertiesDB.NAME, de.getString(ConstantesDB.PropertiesDB.NAME));
		para.put(ConstantesDB.PropertiesDB.CRM, de.getString(ConstantesDB.PropertiesDB.CRM));
		para.put(ConstantesDB.PropertiesDB.AGE, de.getString(ConstantesDB.PropertiesDB.AGE));
		para.put(ConstantesDB.PropertiesDB.PROFESSION, de.getString(ConstantesDB.PropertiesDB.PROFESSION));
		
		Bson bson = new Document(ConstantesDB.CommandsMongo.SET, para);
		
		Bson filter = Filters.eq("_id", objectId);
		
		BasicDBObject resultado = 
				mongoCollection.findOneAndUpdate(filter, bson, new FindOneAndUpdateOptions().upsert(true));
	}
	
	
}
