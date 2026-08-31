package br.edu.ifrs.petbemestar.dominio;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne 
    private Pet pet;
    private TipoProcedimento tipoProcedimento;
    private LocalDateTime horario;
    private StatusAtendimento status;
    
    public Agenda() {
    }
    
    public Agenda(Long id, Pet pet, TipoProcedimento tipoProcedimento,
                  LocalDateTime horario, StatusAtendimento status) {

        this.id = id;
        this.pet = pet;
        this.tipoProcedimento = tipoProcedimento;
        this.horario = horario;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public TipoProcedimento getTipoProcedimento() {
        return tipoProcedimento;
    }

    public void setTipoProcedimento(TipoProcedimento tipoProcedimento) {
        this.tipoProcedimento = tipoProcedimento;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public StatusAtendimento getStatus() {
        return status;
    }

    public void setStatus(StatusAtendimento status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "Agenda [tipoProcedimento=" + tipoProcedimento + ", horario=" + horario + ", status=" + status + "]";
	}
    
}