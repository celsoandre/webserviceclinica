package br.com.celsoandre.clinica;

/**
 * Hello world!
 *
 */


import static spark.Spark.*;

import java.util.List;

import com.google.gson.JsonObject;
import com.mongodb.client.MongoDatabase;

import br.com.celsoandre.clinica.resources.ProfissionalResource;
import br.com.celsoandre.clinica.service.ProfissionalService;
import br.com.celsoandre.clinica.utils.ConstantesDB;

public class App 
{
    public static void main( String[] args ){
    	
    	//Ativando o Banco
    	DataBaseMongoDB dataBaseMongoDB = new DataBaseMongoDB();
    	
    	MongoDatabase mongoDatabase = dataBaseMongoDB.mongoOn();
    	
    	ProfissionalService profissionalService = new ProfissionalService(mongoDatabase);
    	
    	new ProfissionalResource(profissionalService);
    	
    	/*JsonObject jsonObject = new JsonObject();
    	jsonObject.addProperty(ConstantesDB.PropertiesDB.ID, "5bdccac7041ebc1e15d70e4a");
    	jsonObject.addProperty(ConstantesDB.PropertiesDB.CRM, "321");
    	jsonObject.addProperty(ConstantesDB.PropertiesDB.AGE, "50");
    	jsonObject.addProperty(ConstantesDB.PropertiesDB.NAME, "Dina Marta");
    	jsonObject.addProperty(ConstantesDB.PropertiesDB.PROFESSION, "Do lar");
    	
    	ProfissionalService profissionalService = new ProfissionalService(mongo);
    	//profissionalService.insertProfissional(jsonObject.toString());
    	
    	
    	//List<Profissional> result = profissionalService.getAll();
    	
    	
    	//System.out.println(profissionalService.getAll());
    	//System.out.println(profissionalService.get("5bdccac7041ebc1e15d70e4a"));
    	//profissionalService.update(jsonObject.toString());
    	profissionalService.del("5bdccac7041ebc1e15d70e4a");
    	
    	get("/hello", (req, res) -> "Hello World");	
    	
    	get("/", (req, res) -> "Bem vindo ao Spark Java");	*/
    	
    	
    	
    	
    }
}
