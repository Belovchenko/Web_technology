package DAO;

import entities.Auditorium;

import java.sql.Timestamp;
import java.util.List;

public interface AuditoriumDAO
{
    Auditorium findByNum(int num);
    void addAuditorium(Auditorium auditorium);
    void updateAuditorium(Auditorium auditorium);
    void deleteAuditorium(Auditorium auditorium);
    List<Auditorium> showFreeAuditoriums(Timestamp ts1, Timestamp ts2);
}
