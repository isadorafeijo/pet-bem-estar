package petBemEstar;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Dono {

	@Id
	private Long id;
	private String nome;
	private String telefone;
	
	private List<Pet> pets = new ArrayList<>();
	 
	public Dono() {	
	}
	
	public Dono(Long id, String nome, String telefone) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public List<Pet> getPets() {
        return pets;
    }
	
	public void adicionarPet(Pet pet) {
        pets.add(pet);
        pet.setDono(this);
    }
	
	
	
}
