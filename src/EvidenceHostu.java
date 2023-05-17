import com.engeto.hotel.Host;
import com.engeto.hotel.Pokoj;
import com.engeto.hotel.Rezervace;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class EvidenceHostu {
    public static void main(String[] args) {

        System.out.println("\n===Evidence hostů v hotelu===");

        // Vytvoření hostů
        Host adela = new Host("Adéla Malíková", LocalDate.of(1993, 3, 13));
        Host jan = new Host("Jan Dvořáček", LocalDate.of(1995, 5, 5));

        // Výpis popisu hostů
        System.out.println("\nPopis hostů:");
        System.out.println(adela.toString());
        System.out.println(jan.toString());

        // Vytvoření pokojů
        Pokoj pokoj1 = new Pokoj(1, 1000, true, true);
        Pokoj pokoj2 = new Pokoj(2, 1000, true, true);
        Pokoj pokoj3 = new Pokoj(3, 2400, false, true);

        // Vypíše popis pokojů
        System.out.println("\nPopis pokojů:");
        System.out.println(pokoj1.toString());
        System.out.println(pokoj2.toString());
        System.out.println(pokoj3.toString());

        // Vytvoření rezervací
        Rezervace rezervace1 = new Rezervace(adela, pokoj1, LocalDate.of(2021, 7, 19), LocalDate.of(2021, 7, 26));
        Rezervace rezervace2 = new Rezervace(adela, pokoj3, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14));
        Rezervace rezervace3 = new Rezervace(jan, pokoj3, LocalDate.of(2021, 9, 1), LocalDate.of(2021, 9, 14));

        // Seznam rezervací
        List<Rezervace> rezervaceList = new ArrayList<>();
        rezervaceList.add(rezervace1);
        rezervaceList.add(rezervace2);
        rezervaceList.add(rezervace3);

        // Výpis rezervací
        System.out.println("\nSeznam všech rezervací:");
        for (Rezervace rezervace : rezervaceList) {
            System.out.println(rezervace.toString());
        }
    }
}
