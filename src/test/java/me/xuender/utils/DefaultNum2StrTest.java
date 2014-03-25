package me.xuender.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.CharConversionException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by ender on 14-3-25.
 */
@RunWith(Parameterized.class)
public class DefaultNum2StrTest {
    private int num;
    private String str;

    public DefaultNum2StrTest(int num, String str) {
        this.num = num;
        this.str = str;
    }

    @Parameterized.Parameters
    public static Collection prepareData() {
        Object[][] object = {
                {25, "Z"},
                {1, "B"},
                {26, "AA"},
                {2000, "BXY"},
        };
        return Arrays.asList(object);
    }

    @Test
    public void testValues() throws CharConversionException {
        Num2Str sn = new Num2Str();
        assertEquals(str, str, sn.toStr(num));
        assertEquals("-" + str, "-" + str, sn.toStr(0 - num));
        assertEquals("" + num, num, sn.toInt(str));
        assertEquals("-" + num, 0 - num, sn.toInt("-" + str));
    }
}
