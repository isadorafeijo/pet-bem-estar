package br.edu.ifrs.petbemestar.dominio;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Agenda {

    @Id
    private Long id;
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
    
}