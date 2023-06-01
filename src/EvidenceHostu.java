import com.engeto.hotel.Host;
import com.engeto.hotel.Pokoj;
import com.engeto.hotel.Rezervace;
import com.engeto.hotel.TypPobytu;
import java.time.format.DateTimeFormatter;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;



public class EvidenceHostu {
    //Metoda pro získaní celkového počtu rezervací
    public static void vypisPocetRezervaci(List<Rezervace> rezervaceList) {
        int pocetRezervaci = rezervaceList.size();
        System.out.println("\n////Celkový počet rezervací: " + pocetRezervaci);
    }

    //Metoda pro získání celkového počtu rezervací pro pracovní pobyt
    public static int pocetRezervaciPracovniPobyty(List<Rezervace> rezervaceList) {
        int pocetPracovnichPobytu = 0;
        for (Rezervace rezervace : rezervaceList) {
            if (rezervace.getTypPobytu() == TypPobytu.PRACOVNI) {
                pocetPracovnichPobytu++;
            }
        }
        return pocetPracovnichPobytu;
    }

    //Metoda pro výpočet průměrného počtu hostů na jednu rezervaci
    public static double prumernyPocetHostuNaRezervaci(List<Rezervace> rezervaceList) {
        int celkovyPocetHostu = 0;
        int pocetRezervaci = rezervaceList.size();
        for (Rezervace rezervace : rezervaceList) {
            celkovyPocetHostu += rezervace.getHosti().size();
        }
        return (double) celkovyPocetHostu / pocetRezervaci;
    }


    //Metoda pro výpočet počtu nocí mezi dvěma daty
    public static int pocetNoci(LocalDate datumOd, LocalDate datumDo) {
        return (int) ChronoUnit.DAYS.between(datumOd, datumDo) + 1;
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

    public static void main(String[] args) {


        System.out.println("\n===Evidence hostů v hotelu===");

        //Vytvoření hostů s jejich datumem narození
        Host adela = new Host("Adéla Malíková", LocalDate.of(1993, 3, 13));
        Host jan = new Host("Jan Dvořáček", LocalDate.of(1995, 5, 5));

        //Host Karel Dvořák
        Host karel = new Host("Karel Dvořák", LocalDate.of(1980, 5, 15));

        //Host jiný Karel Dvořák
        Host karel2 = new Host("Karel Dvořák", LocalDate.of(1979, 1, 3));

        //Host Cestovní Kancelář
        Host cestovniKancelar = new Host("Cestovní kancelář ABC Relax", LocalDate.of(2000, 1, 1));

        //Datum pro rezervaci v červnu pro Cestovní kancelář
        LocalDate zacatekCervna = LocalDate.of(2023, 6, 1);
        LocalDate konecCervna = LocalDate.of(2023, 6, 30);

        //Datum pro rezervaci v srpnu pro Cestovní kancelář
        LocalDate zacatekSrpna = LocalDate.of(2023, 8, 1);

        //Host Alena Krásova
        Host alena = new Host("Alena Krásová", LocalDate.of(1990, 4, 20));

        //Datum pro rezervaci vždy na prvních 5 dnů v měsíci pro Alenu Krásovovou
        LocalDate zacatekMesice = LocalDate.of(2023, 6, 1);
        LocalDate konecMesice = LocalDate.of(2023, 6, 30);
        LocalDate konecRezervace = zacatekMesice;


        //Nově seznam hostů
        List<Host> hostList = new ArrayList<>();
        hostList.add(adela);
        hostList.add(jan);
        hostList.add(karel);
        hostList.add(karel2);
        hostList.add(cestovniKancelar);
        hostList.add(alena);

        //Výpis všech hostů na obrazovku
        System.out.println("\n/// Popis hostů:");
        for (Host host : hostList) {
            System.out.println(host);
        }

        //Vytvoření nových pokojů s číslem, počtem lůžek, balkónem a výhledem na moře
        Pokoj pokoj1 = new Pokoj(1, 1, 1000, true, true);
        Pokoj pokoj2 = new Pokoj(2, 1, 1000, true, true);
        Pokoj pokoj3 = new Pokoj(3, 3, 2400, false, true);

        //Nově seznam pokojů pro snažší přidání do rezervací
        List<Pokoj> pokojList = new ArrayList<>();
        pokojList.add(pokoj1);
        pokojList.add(pokoj2);
        pokojList.add(pokoj3);

        //Vypsání popisu pokojů na obrazovku
        System.out.println("\n/// Popis pokojů:");
        for (Pokoj pokoj : pokojList) {
            System.out.println(pokoj);
        }

        //Vytvoření rezervací nově s typem pobytu
        Rezervace rezervace1 = new Rezervace(List.of(adela), List.of(pokoj1), LocalDate.of(2023, 7, 19), LocalDate.of(2023, 7, 26), TypPobytu.REKREACNI);
        Rezervace rezervace2 = new Rezervace(List.of(adela,jan), List.of(pokoj3), LocalDate.of(2023, 9, 1), LocalDate.of(2023, 9, 14), TypPobytu.REKREACNI);
        Rezervace rezervace3 = new Rezervace(List.of(karel), List.of(pokoj3), LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), TypPobytu.PRACOVNI);
        Rezervace rezervace4 = new Rezervace(List.of(karel2), List.of(pokoj2), LocalDate.of(2023, 8, 18), LocalDate.of(2023, 8, 21), TypPobytu.REKREACNI);


        //Seznam rezervací
        List<Rezervace> rezervaceList = new ArrayList<>();
        rezervaceList.add(rezervace1);
        rezervaceList.add(rezervace2);
        rezervaceList.add(rezervace3);
        rezervaceList.add(rezervace4);


        //30 jednodenní rezervace pro cestovní kancelář
        for (LocalDate date = zacatekCervna; date.isBefore(konecCervna.plusDays(1)); date = date.plusDays(1)) {
            Rezervace rezervace = new Rezervace(List.of(cestovniKancelar), List.of(pokoj2), date, date, TypPobytu.REKREACNI);
            rezervaceList.add(rezervace);
        }

        //Čtyři třídenní rezervace pro cestovní kancelář
        List<LocalDate> dataRezervaci = List.of(zacatekSrpna, zacatekSrpna.plusDays(6), zacatekSrpna.plusDays(13), zacatekSrpna.plusDays(20));
        for (LocalDate date : dataRezervaci) {
            Rezervace rezervace = new Rezervace(List.of(cestovniKancelar), List.of(pokoj2), date, date.plusDays(2), TypPobytu.REKREACNI);
            rezervaceList.add(rezervace);
        }


        //Rezervace pro Alenu od 1.6 na prvních 5 dnů v měsíci

        for (int i = 0; i < 7; i++) {
            LocalDate startDate = konecRezervace;
            konecRezervace = startDate.plusDays(4);

            if (startDate.isBefore(konecMesice.plusDays(1))) {
                Rezervace rezervace = new Rezervace(List.of(alena), List.of(pokoj1), startDate, konecRezervace, TypPobytu.PRACOVNI);
                rezervaceList.add(rezervace);
            }
        }

        //Výpis seznamu rezervací na obrazovku
        //
        //Upravený výpis seznamu rezervací podle formátu:
        // datumOd až datumDo: jméno hosta (datum narození)[počet lůžek, výhledNaMoře ano/ne]

        System.out.println("\n/// Seznam všech rezervací:");
        for (Rezervace rezervace : rezervaceList) {
            LocalDate datumOd = rezervace.getDatumOd();
            LocalDate datumDo = rezervace.getDatumDo();
            List<Host> hosti = rezervace.getHosti();
            List<Pokoj> pokoje = rezervace.getPokoje();

            StringBuilder hostiPopis = new StringBuilder();
            for (Host host : hosti) {
                String jmenoHosta = host.getJmeno();
                LocalDate datumNarozeni = host.getDatumNarozeni();
                String hostPopis = jmenoHosta + " (" + datumNarozeni.format(formatter) + ")";
                hostiPopis.append(hostPopis).append(" ");
            }

            StringBuilder pokojePopis = new StringBuilder();
            for (Pokoj pokoj : pokoje){
                int pocetLuzek = pokoj.getPocetLuzek();
                boolean vyhledNaMore = pokoj.hasVyhledNaMore();
                String vyhledText = vyhledNaMore ? "ano" : "ne";
                String pokojPopis = "[" + pocetLuzek + ", " + vyhledText + "]" ;
                pokojePopis.append(pokojPopis).append(" ");
            }
            System.out.println(datumOd.format(formatter) + " až " + datumDo.format(formatter) + ": " + hostiPopis + pokojePopis);
        }

        //Výpis celkového počtu rezervací
        vypisPocetRezervaci(rezervaceList);
        //Výpis celkového počtu pracovních rezervací
        int pocetPracovnichPobytu = pocetRezervaciPracovniPobyty(rezervaceList);
        System.out.println("/// Počet rezervací pro pracovní pobyty: " + pocetPracovnichPobytu);

        //Výpis průměru hostů na jednu rezervaci
        double prumernyPocetHostu = prumernyPocetHostuNaRezervaci(rezervaceList);
        System.out.println("/// Průměrný počet hostů na jednu rezervaci: " + prumernyPocetHostu);

        //Výpis prvních 8 rezervací pro rekreační pobyty
        System.out.println("\n/// Prvních 8 rezervací pro rekreaci:");
        int pocetRekreacnichRezervaci = 0;
        for (Rezervace rezervace : rezervaceList) {
            if (rezervace.getTypPobytu() == TypPobytu.REKREACNI) {
                System.out.println(rezervace);
                pocetRekreacnichRezervaci++;
                if (pocetRekreacnichRezervaci >= 8) {
                    break;
                }
            }
        }

        //Výpis celkového počtu jednodenních, dvoudenních a vícedenních pobytů
        int jednodenniPobyty = 0;
        int dvoudenniPobyty = 0;
        int vicedenniPobyty = 0;

        for (Rezervace rezervace : rezervaceList) {
            long pocetNoci = ChronoUnit.DAYS.between(rezervace.getDatumOd(), rezervace.getDatumDo());

            if (pocetNoci == 0) {
                jednodenniPobyty++;
            } else if (pocetNoci == 1) {
                dvoudenniPobyty++;
            } else {
                vicedenniPobyty++;
            }
        }

        System.out.println("\n/// Celkový počet jednodenních pobytů: " + jednodenniPobyty);
        System.out.println("/// Celkový počet dvoudenních pobytů: " + dvoudenniPobyty);
        System.out.println("/// Celkový počet vícedenních pobytů: " + vicedenniPobyty);

        // Výpočet ceny pro každou rezervaci
        System.out.println("\n/// Celková cena všech rezervací:");
        for (Rezervace rezervace : rezervaceList) {
            int pocetNoci = pocetNoci(rezervace.getDatumOd(), rezervace.getDatumDo());
            int celkovaCena = (int) (pocetNoci * rezervace.getPokoje().get(0).getCena());

            String hosti = rezervace.getHosti().get(0).getJmeno();
            String pokoje = "pokoj " + rezervace.getPokoje().get(0).getCislo();

            System.out.println(hosti + " (" + pokoje + "): " + pocetNoci + " nocí od " + rezervace.getDatumOd().format(formatter) + " za " + celkovaCena + " Kč");
        }
    }
}
