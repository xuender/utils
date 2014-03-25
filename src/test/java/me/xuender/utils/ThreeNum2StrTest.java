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
@RunWith(Parameterized.class)
public class ThreeNum2StrTest {
    private int num;
    private String str;

    public ThreeNum2StrTest(int num, String str) {
        this.num = num;
        this.str = str;
    }

    @Parameterized.Parameters
    public static Collection prepareData() {
        Object[][] object = {
                {3, "AA"},
                {1, "B"},
                {25, "BBB"},
                {26, "BBC"},
                {2000, "BACABCC"},
        };
        return Arrays.asList(object);
    }

    @Test
    public void testValues() throws UniqueException, CharConversionException {
        Num2Str sn = new Num2Str("ABC");
        assertEquals(str, str, sn.toStr(num));
        assertEquals("-" + str, "-" + str, sn.toStr(0 - num));
        assertEquals("" + num, num, sn.toInt(str));
        assertEquals("-" + num, 0 - num, sn.toInt("-" + str));
    }
}