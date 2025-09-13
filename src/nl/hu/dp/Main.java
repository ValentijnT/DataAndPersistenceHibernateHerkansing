package nl.hu.dp;

import nl.hu.dp.P2H.Reiziger;
import nl.hu.dp.P2H.ReizigerDAOhibernate;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        ReizigerDAOhibernate rdao = new ReizigerDAOhibernate();

        try {
            testReizigerDAO(rdao);
        } finally {
            rdao.close();
        }
    }

    private static void testReizigerDAO(ReizigerDAOhibernate rdao) throws SQLException {
        System.out.println("\n---------- Test ReizigerDAO -------------");

        // Haal alle reizigers op uit de database
        List<Reiziger> reizigers = rdao.findAll();
        System.out.println("[Test] ReizigerDAO.findAll() geeft de volgende reizigers:");
        for (Reiziger r : reizigers) {
            System.out.println(r);
        }
        System.out.println();

        // Maak een nieuwe reiziger aan en persisteer deze in de database
        String gbdatum = "1981-03-14";
        Reiziger sietske = new Reiziger(77, "S", "", "Boers", java.sql.Date.valueOf(gbdatum));
        System.out.print("[Test] Eerst " + reizigers.size() + " reizigers, na ReizigerDAO.save() ");
        rdao.save(sietske);
        reizigers = rdao.findAll();
        System.out.println(reizigers.size() + " reizigers\n");
        System.out.println();

        // Find by id
        Reiziger found = rdao.findById(77);
        System.out.println("[Test] findById(77): " + found);
        System.out.println();

        // Update reiziger naar achternaam jansen
        found.setAchternaam("Jansen");
        rdao.update(found);
        System.out.println("[Test] na update: " + rdao.findById(found.getReiziger_id()));
        System.out.println();

        // Delete reiziger Sietske
        rdao.delete(found);
        System.out.println("[Test] na delete, findAll():");
        List<Reiziger> reizigersDelete = rdao.findAll();
        for (Reiziger r : reizigersDelete) {
            System.out.println(r);
        }
        System.out.println();
    }
}
