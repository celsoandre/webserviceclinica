package br.com.celsoandre.clinica.resources;

import static spark.Spark.get;
import static spark.Spark.put;

import br.com.celsoandre.clinica.service.ProfissionalService;
import br.com.celsoandre.clinica.utils.ConversorJSON;

import static spark.Spark.post;
import static spark.Spark.delete;

public class ProfissionalResource {

	String format = "Application/json";

	private ProfissionalService profissionalService;

	public ProfissionalResource(ProfissionalService profissionalService) {
		this.profissionalService = profissionalService;
		this.verbos();
	}

	public void verbos() {
		// -- Retornar um profissional
		get("/profissionais/:id", format, (request, response) -> profissionalService.get(request.params(":id")),
				new ConversorJSON()

		);
		// -- Retornar todos os profissionais
		get("/profissionais", format, (request, response) -> profissionalService.getAll(), new ConversorJSON()

		);
		// -- Inserir um profissional
		post("/profissionais", format, (request, response) -> {
			profissionalService.insertProfissional(request.body());
			response.status(201);
			return response;
		});
		// -- Atualizar um profissional
		put("/profissionais", format, (request, response) -> {
			profissionalService.update(request.body());
			response.status(202);
			return response;
		});
		// -- Deletar profissional
		delete("/profissionais/:id", format, (request, response) -> {
			profissionalService.del(request.params(":id"));
			response.status(200);
			return response;
		});

	}

}
