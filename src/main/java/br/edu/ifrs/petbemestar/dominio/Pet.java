package br.edu.ifrs.petbemestar.dominio;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Especie especie;
	private Porte porte;
	
	@ManyToOne
	private Dono dono;
	
	@OneToMany(mappedBy = "pet")
	private List<Agenda> agendamentos = new ArrayList<>();
	
	public Pet() {
	}
	
	public Pet(Long id, String nome, Especie especie, Porte porte, Dono dono) {
		this.id = id;
		this.nome = nome;
		this.especie = especie;
		this.porte = porte;
		this.dono = dono;
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

	public Especie getEspecie() {
		return especie;
	}
	
	public void setEspecie(Especie especie) {
		this.especie = especie;
	}
	
	public Porte getPorte() {
		return porte;
	}
	
	public void setPorte(Porte porte) {
		this.porte = porte;
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
    
    public Agenda ultimoAgendamentoRealizado() {
    	
    	Agenda ultimo = null;
    	for(Agenda a : agendamentos) {
    		if(a.getStatus() != StatusAtendimento.REALIZADO) {
    			continue;
    		} 
    		if(ultimo == null || a.getHorario().isAfter(ultimo.getHorario())) {
    			ultimo = a;
    		}
    	}
    	return ultimo;
    	
    }
}
