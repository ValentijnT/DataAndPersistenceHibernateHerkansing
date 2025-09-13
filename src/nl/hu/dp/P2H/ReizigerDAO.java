package nl.hu.dp.P2H;

import nl.hu.dp.P2H.Reiziger;

import java.time.LocalDate;
import java.util.List;

public interface ReizigerDAO {
    public boolean save(Reiziger reiziger);
    public boolean update(Reiziger reiziger);
    public boolean delete(Reiziger reiziger);
    public Reiziger findById(int id);
    public List<Reiziger> findByGbdatum(LocalDate date);
    public List<Reiziger> findAll();

}
