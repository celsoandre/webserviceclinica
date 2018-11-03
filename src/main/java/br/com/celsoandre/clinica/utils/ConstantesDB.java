package br.com.celsoandre.clinica.utils;

public class ConstantesDB {
	
	public static final String DBNAME = "profissionais";
	
	public class PropertiesDB{
		public static final String ID = "_id";
		public static final String CRM = "crm";
		public static final String NAME = "name";
		public static final String AGE = "age";
		public static final String PROFESSION = "profession";
	}
	
	public class CommandsMongo{
		public static final String SET = "$set"; //Serve para atualizar determinado campo no banco de dados
	}

}
