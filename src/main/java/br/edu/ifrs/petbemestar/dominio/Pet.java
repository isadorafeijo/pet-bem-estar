package br.edu.ifrs.petbemestar.dominio;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Pet {

	@Id
	private Long id;
	private String nome;
	private Dono dono;
	private List<Agenda> agendamentos = new ArrayList<>();
	
	public Pet() {
	}
	
	public Pet(Long id, String nome, Dono dono) {
		this.id = id;
		this.nome = nome;
		this.dono = dono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Dono getDono() {
		return dono;
	}

	public void setDono(Dono dono) {
		this.dono = dono;
	}
	
	public List<Agenda> getAgendamentos() {
        return agendamentos;
    }

    public void adicionarAgendamento(Agenda agenda) {
        agendamentos.add(agenda);
        agenda.setPet(this);
    }
}
