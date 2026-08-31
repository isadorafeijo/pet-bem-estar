package br.edu.ifrs.petbemestar;

import java.time.LocalDateTime;

import br.edu.ifrs.petbemestar.dominio.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Principal {
	
	public static void main(String[] args) {

        Dono isadora = new Dono(null, "Isadora", "51999999999");

        Pet luluca = new Pet(null, "Luluca", Especie.CACHORRO, Porte.GRANDE, isadora);
        Pet rex = new Pet(null, "Rex", Especie.CACHORRO, Porte.MEDIO, isadora);

        isadora.adicionarPet(luluca);
        isadora.adicionarPet(rex);

        luluca.adicionarAgendamento(new Agenda(null, luluca, TipoProcedimento.BANHO_TOSA,
                LocalDateTime.of(2026, 9, 1, 14, 0), StatusAtendimento.MARCADO));
        luluca.adicionarAgendamento(new Agenda(null, luluca, TipoProcedimento.BANHO_TOSA,
                LocalDateTime.of(2026, 8, 20, 10, 0), StatusAtendimento.REALIZADO));
        rex.adicionarAgendamento(new Agenda(null, rex, TipoProcedimento.BANHO_TOSA,
                LocalDateTime.of(2026, 9, 3, 9, 0), StatusAtendimento.MARCADO));

        System.out.println("Dono: " + isadora);
        System.out.println("Pets: " + isadora.getPets());
        System.out.println();

        for (Pet pet : isadora.getPets()) {
            System.out.println(pet + " | agendamentos: " + pet.getAgendamentos());
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pet-bem-estar-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(isadora);

        for (Pet pet : isadora.getPets()) {
            em.persist(pet);
        }

        for (Pet pet : isadora.getPets()) {
            for (Agenda agenda : pet.getAgendamentos()) {
                em.persist(agenda);
            }
        }

        em.getTransaction().commit();

        em.close();
        emf.close();
	}
}