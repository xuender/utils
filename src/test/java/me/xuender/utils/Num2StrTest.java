package me.xuender.utils;

import org.junit.Test;

import java.io.CharConversionException;

import static org.junit.Assert.assertEquals;

/**
 * Created by ender on 14-3-25.
 */
public class Num2StrTest {
    @Test
    public void testMinus() throws UniqueException, CharConversionException {
        Num2Str sn = new Num2Str("ABC", 'D');
        assertEquals("-25", "DBBB", sn.toStr(-25));
        assertEquals("DBBB", -25, sn.toInt("DBBB"));
    }
}