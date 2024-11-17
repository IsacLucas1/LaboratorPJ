package Teste;

import Problema2.PerecheNumere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestePb2 {

    //Fibo()
    /**
     * Acest test ar trebui sa returneze true
     */
    @Test
    public void test1_Fibo()
    {
        PerecheNumere p = new PerecheNumere(8,13);
        assertTrue(p.Fibo());
    }
    /**
     * Acest test ar trebui sa returneze false
     */
    @Test
    public void test2_Fibo()
    {
        PerecheNumere p = new PerecheNumere(6,20);
        assertFalse(p.Fibo());
    }
    /**
     * Acest test ar trebui sa returneze false
     */
    @Test
    public void test3_Fibo()
    {
        PerecheNumere p = new PerecheNumere(44,67);
        assertFalse(p.Fibo());
    }

    /**
     * Acest test ar trebui sa returneze true
     */
    @Test
    public void test4_Fibo()
    {
        PerecheNumere p = new PerecheNumere(55,89);
        assertTrue(p.Fibo());
    }




    //cmmmc()

    /**
     * De la acest test se asteapta 84
     */
    @Test
    public void test1_cmmmc()
    {
        PerecheNumere p = new PerecheNumere(12,24);
        assertEquals(24,p.cmmmc());
    }

    /**
     * De la acest test se asteapta 120
     */

    @Test
    public void test2_cmmmc()
    {
        PerecheNumere p = new PerecheNumere(20,24);
        assertEquals(120,p.cmmmc());
    }

    /**
     * De la acest test se asteapta 0
     */
    @Test
    public void test3_cmmmc()
    {
        PerecheNumere p = new PerecheNumere(20,0);
        assertEquals(0,p.cmmmc());
    }




    //sumaCifre()
    /**
     * Acest test ar trebui sa returneze true
     */
    @Test
    public void test1_sumaCifre()
    {
        PerecheNumere p = new PerecheNumere(55,82);
        assertTrue(p.sumaCifre());
    }

    /**
     * Acest test ar trebui sa returneze true
     */
    @Test
    public void test2_sumaCifre()
    {
        PerecheNumere p = new PerecheNumere(23,50);
        assertTrue(p.sumaCifre());
    }
    /**
     * Acest test ar trebui sa returneze false
     */
    @Test
    public void test3_sumaCifre()
    {
        PerecheNumere p = new PerecheNumere(54,77);
        assertFalse(p.sumaCifre());
    }
    /**
     * Acest test ar trebui sa returneze false
     */
    @Test
    public void test4_sumaCifre()
    {
        PerecheNumere p = new PerecheNumere(99,7);
        assertFalse(p.sumaCifre());
    }




    //cifPare()
    /**
     * Acest test ar trebui sa returneze false
     */
    @Test
    public void test1_cifPare()
    {
        PerecheNumere p = new PerecheNumere(56,42);
        assertFalse(p.sumaCifre());
    }
    /**
     * Acest test ar trebui sa returneze false
     */
    @Test
    public void test2_cifPare()
    {
        PerecheNumere p = new PerecheNumere(11,80);
        assertFalse(p.sumaCifre());
    }
    /**
     * Acest test ar trebui sa returneze true
     */
    @Test
    public void test3_cifPare()
    {
        PerecheNumere p = new PerecheNumere(64,82);
        assertTrue(p.cifPare());
    }
    /**
     * Acest test ar trebui sa returneze true
     */
    @Test
    public void test4_cifPare()
    {
        PerecheNumere p = new PerecheNumere(7676,28);
        assertTrue(p.cifPare());
    }


}
