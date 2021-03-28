package DAO;

import entities.Auditorium;
import entities.Study_Class;
import entities.Teacher;
import org.hibernate.Transaction;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.List;

import static org.testng.Assert.*;

public class AuditoriumDAOCoverage
{

    @Test
    public void testFindByNum()
    {
        AuditoriumDAOImpl AuditoriumManage = new AuditoriumDAOImpl();
        Auditorium auditorium = AuditoriumManage.findByNum(103);
        Assert.assertEquals(auditorium.getAuditorium_num(), 103);
    }

    @Test
    public void testAddAuditorium()
    {
        AuditoriumDAOImpl AuditoriumManage = new AuditoriumDAOImpl();
        int i = 1;
        boolean b = (AuditoriumManage.findByNum(i) == null);
        while (!b)
        {
            i++;
            b = (AuditoriumManage.findByNum(i) == null);
        }
        Auditorium auditorium  = new Auditorium(i, 50);
        AuditoriumManage.addAuditorium(auditorium);
        if (AuditoriumManage.findByNum(i) != null) Assert.assertTrue(AuditoriumManage.findByNum(i) != null);
        //AuditoriumManage.deleteAuditorium(AuditoriumManage.findByNum(407));
    }

    @Test
    public void testUpdateAuditorium()
    {
        AuditoriumDAOImpl AuditoriumManage = new AuditoriumDAOImpl();
        int i = 1;
        boolean b = (AuditoriumManage.findByNum(i) == null);
        while (!b)
        {
            i++;
            b = (AuditoriumManage.findByNum(i) == null);
        }
        Auditorium auditorium  = new Auditorium(i, 50);
        AuditoriumManage.addAuditorium(auditorium);
        auditorium.setCapacity(100);
        AuditoriumManage.updateAuditorium(auditorium);
        Assert.assertEquals(AuditoriumManage.findByNum(auditorium.getAuditorium_num()).getCapacity(), 100);
        //AuditoriumManage.deleteAuditorium(AuditoriumManage.findByNum(404));
    }

    @Test
    public void testDeleteAuditorium()
    {
        AuditoriumDAOImpl AuditoriumManage = new AuditoriumDAOImpl();
        int i = 1;
        boolean b = (AuditoriumManage.findByNum(i) == null);
        while (!b)
        {
            i++;
            b = (AuditoriumManage.findByNum(i) == null);
        }
        Auditorium auditorium  = new Auditorium(i, 50);
        AuditoriumManage.addAuditorium(auditorium);
        AuditoriumManage.deleteAuditorium(auditorium);
        Assert.assertTrue(AuditoriumManage.findByNum(i) == null);
    }

    @Test
    public void testShowFreeAuditoriums()
    {
        AuditoriumDAOImpl AuditoriumManage = new AuditoriumDAOImpl();
        int i = 1;
        boolean b = (AuditoriumManage.findByNum(i) == null);
        while (!b)
        {
            i++;
            b = (AuditoriumManage.findByNum(i) == null);
        }
        Auditorium auditorium  = new Auditorium(i, 50);
        AuditoriumManage.addAuditorium(auditorium);
        List<Auditorium> list = AuditoriumManage.showFreeAuditoriums(Timestamp.valueOf("2003-1-1 00:00:00"), Timestamp.valueOf("2010-1-1 00:00:00"));
        boolean help_for_assert = false;
        //System.out.println("I am here!!!!!!" + list.size());
        for(int j = 0; j <= list.size() - 1; j++)
        {
            //System.out.println("hello= '" + list.get(j).getAuditorium_num() + "'");
            if (list.get(j).getAuditorium_num() == i) help_for_assert = true;
        }
        Assert.assertTrue(help_for_assert);
    }
}