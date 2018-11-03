package br.com.celsoandre.clinica.models;

import java.io.Serializable;

import com.mongodb.BasicDBObject;

import br.com.celsoandre.clinica.utils.ConstantesDB;
import br.com.celsoandre.clinica.utils.ConstantesDB.PropertiesDB;

public class Profissional implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String _id;
	private String crm;
	private int age;
	private String name;
	private String profession;
	
	public Profissional(BasicDBObject basicDBObject) {
		
		this._id        = basicDBObject.getObjectId(ConstantesDB.PropertiesDB.ID).toString();
		this.name       = basicDBObject.getString(ConstantesDB.PropertiesDB.NAME);
		this.age        = Integer.parseInt(basicDBObject.getString(ConstantesDB.PropertiesDB.AGE));
		this.crm        = basicDBObject.getString(ConstantesDB.PropertiesDB.CRM);
		this.profession = basicDBObject.getString(ConstantesDB.PropertiesDB.PROFESSION);
		
	}
	
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this._id +" - "+ this.name;
	}
	
	
	
}
