package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.testng.Assert.assertEquals;

public class UtilsTest {
    @Test
    public void checkHighwayLegalspeed_test1() {
        Utils sp = new Utils();
        assertEquals(true, sp.checkHighwayLegalspeed(110));

    }

    @Test
    public void checkHighwayLegalspeed_test2() {
        Utils sp1 = new Utils();
        assertEquals(false, sp1.checkHighwayLegalspeed(130));

    }

    @Test
    public void checkUrbanLegalspeed_test1() {
        Utils sp2 = new Utils();
        assertEquals(true, sp2.checkUrbanLegalspeed(85));

    }

    @Test
    public void checkUrbanLegalspeed_test2() {
        Utils sp3 = new Utils();
        assertEquals(false, sp3.checkUrbanLegalspeed(92));

    }
}