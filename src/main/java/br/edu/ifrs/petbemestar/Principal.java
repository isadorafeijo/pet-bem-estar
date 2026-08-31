package br.edu.ifrs.petbemestar;

import java.time.LocalDateTime;

import br.edu.ifrs.petbemestar.dominio.*;

public class Principal {
	
    public static void main(String[] args) {
        Dono dono = new Dono(1L, "Isadora", "51999999999");

        Pet pet = new Pet(1L, "Luluca", Especie.CACHORRO, Porte.GRANDE, dono);
        dono.adicionarPet(pet);

        Agenda agenda = new Agenda(
                1L,
                pet,
                TipoProcedimento.BANHO_TOSA,          
                LocalDateTime.of(2026, 9, 1, 14, 0),
                StatusAtendimento.MARCADO       
        );
        pet.adicionarAgendamento(agenda);

        System.out.println("Dono: " + dono.getNome());
        System.out.println("Pet: " + pet.getNome());
        System.out.println("Procedimento: " + agenda.getTipoProcedimento());
        System.out.println("Status: " + agenda.getStatus());
        
        Agenda agendaAntiga = new Agenda(2L, pet, TipoProcedimento.BANHO_TOSA,
                LocalDateTime.of(2026, 8, 20, 10, 0), StatusAtendimento.REALIZADO);
        pet.adicionarAgendamento(agendaAntiga);

        System.out.println("\nUltimo realizado: " + pet.ultimoAgendamentoRealizado().getHorario());
    }
}