package petBemEstar;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Pet {

	@Id
	private Long Id;
	private String nome;
	private Dono dono;
	private List<Agenda> agendamentos = new ArrayList<>();
	
	public Pet() {
	}
	
	public Pet(Long id, String nome, Dono dono) {
		Id = id;
		this.nome = nome;
		this.dono = dono;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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
