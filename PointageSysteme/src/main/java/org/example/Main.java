package org.example;

import org.example.model.employe.salaire.Salaire;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Salaire debutant = new Salaire(1000);

        LocalDate debut_du_mois = LocalDate.of(2024,6,1);
        LocalDate fin_du_mois = debut_du_mois.withDayOfMonth(debut_du_mois.lengthOfMonth());
        System.out.println(fin_du_mois);
        }
    }
