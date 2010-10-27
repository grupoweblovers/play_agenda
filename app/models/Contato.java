package models;

import play.*;
import play.db.jpa.*;
import javax.persistence.*;
import java.util.*;

@Entity
public class Contato extends Model {
	
	public String nome;
	public String email;
	
	public String telefone;
	public String twitter;
	public String skype;
	
	public Contato(String nome, String email, String telefone, String twitter, String skype)  {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.twitter = twitter;
		this.skype = skype;
	}
	
}

