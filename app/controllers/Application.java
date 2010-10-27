package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
				List<Contato> contatos = Contato.find("order by nome asc").fetch();
        render(contatos);
    }

		public static void inserir() {
			render();
		}
		
		public static void visualizar(String email) {
			Contato contato = Contato.find("email", email).first();
			render(contato);
		}
		
		public static void editar(String email) {
			Contato contato = Contato.find("email", email).first();
			render(contato);
		}
		
		public static void excluir(String email) {
			Contato contato = Contato.find("email", email).first();
			contato.delete();
			index();
		}
		
		public static void cadastrar_contato(@Required String nome, @Required String email, String telefone, String twitter, String skype) { 
			Contato contato = new Contato(nome, email, telefone, twitter, skype);
			if (validation.hasErrors()) {
				render("Application/inserir.html", contato);
			}
			
			contato.save();
			index();
		}
		
		public static void editar_contato(long id) {
			validation.required(request.params.get("nome"));
			validation.required(request.params.get("email"));
			
			Contato contato = Contato.find("id", id).first();
			
			if (validation.hasErrors()) {
				render("Application/editar.html", contato);
			}
			
			contato.nome = request.params.get("nome");
			contato.telefone = request.params.get("telefone");
			contato.email = request.params.get("email");
			contato.twitter = request.params.get("twitter");
			contato.skype = request.params.get("skype");
			
			contato.save();
			index();
		}
		

}