package me.xuender.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.CharConversionException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by ender on 14-3-25.
 */
public class Num2StrErrorTest {
    @Test(expected = UniqueException.class)
    public void testUnique() throws UniqueException {
        Num2Str sn = new Num2Str("ABCC");
    }

    @Test(expected = UniqueException.class)
    public void testMinus() throws UniqueException {
        Num2Str sn = new Num2Str("ABC", 'C');
    }

    @Test(expected = CharConversionException.class)
    public void testConversion() throws CharConversionException {
        Num2Str sn = new Num2Str();
        sn.toInt("0");
    }

    @Test(expected = CharConversionException.class)
    public void testConversion2() throws CharConversionException, UniqueException {
        Num2Str sn = new Num2Str("ABC");
        sn.toInt("D");
    }

    @Test(expected = CharConversionException.class)
    public void testNull() throws CharConversionException {
        Num2Str sn = new Num2Str();
        sn.toInt(null);
    }
}