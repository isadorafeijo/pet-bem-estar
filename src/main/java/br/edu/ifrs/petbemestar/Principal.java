package br.edu.ifrs.petbemestar;

import java.time.LocalDateTime;

import br.edu.ifrs.petbemestar.dominio.*;

public class Principal {
	
    public static void main(String[] args) {
        Dono dono = new Dono(1L, "Isadora", "51999999999");

        Pet pet = new Pet(1L, "Luluca", dono);
        dono.adicionarPet(pet);

        Agenda agenda = new Agenda(
                1L,
                pet,
                TipoProcedimento.BANHO,          
                LocalDateTime.of(2026, 9, 1, 14, 0),
                StatusAtendimento.MARCADO       
        );
        pet.adicionarAgendamento(agenda);

        System.out.println("Dono: " + dono.getNome());
        System.out.println("Pet: " + pet.getNome());
        System.out.println("Procedimento: " + agenda.getTipoProcedimento());
        System.out.println("Status: " + agenda.getStatus());
    }
}