package fr.unice.polytech.isa.dd.entities;


import arquillian.AbstractEntitiesTest;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.MyDate;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class MyDateTest extends AbstractEntitiesTest {

    @Test(expected = Exception.class)
    public void  testwrongdate() throws Exception {
        String adate = "31/31/2020";
        String anhour = "18h30";
        MyDate myDate = new MyDate(adate,anhour);
    }

    @Test
    public void test_good_date() throws Exception {
        String adate = "31/12/2020";
        String anhour = "00h30";
        MyDate myDate = new MyDate(adate,anhour);

        assertEquals(31,myDate.getDay());
        assertEquals(12,myDate.getMonth());
        assertEquals(2020,myDate.getYear());

        assertEquals(30*60,myDate.getDate_seconds());
    }
}
