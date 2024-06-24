import org.example.model.employe.Employe;
import org.example.model.employe.calendrier.Calendrier;
import org.example.model.employe.salaire.Salaire;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PointageTests {

    public static void main(String[] args) {
        Calendrier calendrier = new Calendrier();
        calendrier.ajouterJourFerie(LocalDate.of(2024, 6, 17));
        calendrier.ajouterJourFerie(LocalDate.of(2024, 6, 25));
        calendrier.ajouterJourFerie(LocalDate.of(2024, 6, 26));

        // Ajouter les employés
        Employe rakoto = new Employe("Rakoto", 1, "1990-01-01", "2020-01-01", null, new Salaire(100000), "Gardien");
        Employe rabe = new Employe("Rabe", 2, "1990-01-01", "2020-01-01", null, new Salaire(100000), "Gardien");

        List<LocalDate> joursTravailles = new ArrayList<>();
        for (int i = 26; i <= 31; i++) {
            joursTravailles.add(LocalDate.of(2024, 5, i));
        }
        for (int i = 1; i <= 6; i++) {
            joursTravailles.add(LocalDate.of(2024, 6, i));
        }


        int heuresTravailRakoto = rakoto.calculer_heures_travail(joursTravailles, calendrier);
        double heuresMajoreesRakoto = rakoto.calculer_heures_majorees(joursTravailles, calendrier);
        double salaireBrutRakoto = rakoto.calculer_salaire_brut(heuresTravailRakoto, 100000);
        double salaireNetRakoto = rakoto.calculer_salaire_net(salaireBrutRakoto);

        int heuresTravailRabe = rabe.calculer_heures_travail(joursTravailles, calendrier);
        double heuresMajoreesRabe = rabe.calculer_heures_majorees(joursTravailles, calendrier);
        double salaireBrutRabe = rabe.calculer_salaire_brut(heuresTravailRabe, 100000 * 1.3);
        double salaireNetRabe = rabe.calculer_salaire_net(salaireBrutRabe);


        System.out.println("Rakoto: Heures de travail: " + heuresTravailRakoto + ", Heures majorées: " + heuresMajoreesRakoto + ", Salaire brut: " + salaireBrutRakoto + ", Salaire net: " + salaireNetRakoto);
        System.out.println("Rabe: Heures de travail: " + heuresTravailRabe + ", Heures majorées: " + heuresMajoreesRabe + ", Salaire brut: " + salaireBrutRabe + ", Salaire net: " + salaireNetRabe);
    }
}
