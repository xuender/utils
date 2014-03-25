package me.xuender.utils;

import java.io.CharConversionException;
import java.util.HashSet;
import java.util.Set;

/**
 * Number conversion to a string.
 * Created by ender on 14-3-25.
 * <p/>
 * code:
 * Num2Str ns=new Num2Str("ABC", 'D');
 * System.out.println("-25="+ns.toStr(-15));
 * <p/>
 * out:
 * -25=DBBB
 * <p/>
 * code:
 * Num2Str ns=new Num2Str();
 * System.out.println("-27="+ns.toStr(-15));
 * System.out.println("BXY="+ns.toInt("BXZ"));
 * <p/>
 * out:
 * -27=-AB
 * BXY=2000
 */
public class Num2Str {
    private char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();


    private char minus = '-';

    /**
     * Default display string is "ABCDEFGHIJKLMNOPQRSTUVWXYZ".
     * minus is '-'.
     */
    public Num2Str() {

    }

    public Num2Str(String displayString) throws UniqueException {
        setDisplayCharacters(displayString.toCharArray());
    }

    public Num2Str(String displayString, char minus) throws UniqueException {
        setDisplayCharacters(displayString.toCharArray());
        setMinus(minus);
    }

    public Num2Str(char[] displayCharacters) throws UniqueException {
        setDisplayCharacters(displayCharacters);
    }

    public Num2Str(char[] displayCharacters, char minus) throws UniqueException {
        setDisplayCharacters(displayCharacters);
        setMinus(minus);
    }

    /**
     * String conversion to integer.
     *
     * @param str
     * @return
     * @throws CharConversionException
     */
    public int toInt(String str) throws CharConversionException {
        return Long.valueOf(str2num(str)).intValue();
    }

    /**
     * String conversion to long.
     *
     * @param str
     * @return
     * @throws CharConversionException
     */
    public long toLong(String str) throws CharConversionException {
        return str2num(str);
    }

    /**
     * Integer converted to string.
     *
     * @param num
     * @return
     */
    public String toStr(int num) {
        return num2str(num);
    }

    /**
     * Long converted to string.
     *
     * @param num
     * @return
     */
    public String toStr(long num) {
        return num2str(num);
    }

    /**
     * Set the display string
     *
     * @param displayString
     * @throws UniqueException
     */
    public void setDisplayString(String displayString) throws UniqueException {
        setDisplayCharacters(displayString.toCharArray());
    }

    /**
     * Set the display characters.
     *
     * @param displayCharacters
     * @throws UniqueException
     */
    public void setDisplayCharacters(char[] displayCharacters) throws UniqueException {
        Set<Integer> set = new HashSet<Integer>();
        for (char c : displayCharacters) {
            set.add((int) c);
        }
        if (set.size() < displayCharacters.length || set.size() == 0) {
            throw new UniqueException();
        }
        for (char c : displayCharacters) {
            if (c == minus) {
                throw new UniqueException();
            }
        }
        this.chars = displayCharacters.clone();
    }

    /**
     * Set then minus char.
     *
     * @param minus
     * @throws UniqueException
     */
    public void setMinus(char minus) throws UniqueException {
        for (char c : chars) {
            if (c == minus) {
                throw new UniqueException();
            }
        }
        this.minus = minus;
    }

    private String num2str(long num) {
        StringBuilder sb = new StringBuilder();
        if (num < 0) {
            sb.append(minus);
            num = 0 - num;
        }
        long c = num / chars.length;
        int y = Long.valueOf(num % chars.length).intValue();
        if (c > 0) {
            sb.append(num2str(c - 1));
        }
        sb.append(chars[y]);
        return sb.toString();
    }

    private static long pow(long x, int n) {
        if (n == 1) {
            return x;
        }
        return x * pow(x, n - 1);
    }

    private long toLong(char c, int w) throws CharConversionException {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                if (w == 0) {
                    return i;
                }
                return (i + 1) * pow(chars.length, w);
            }
        }
        throw new CharConversionException();
    }

    private long str2num(String str) throws CharConversionException {
        if (str == null || str.length() == 0) {
            throw new CharConversionException();
        }
        char[] cs = str.toCharArray();
        long ret = 0;
        boolean f = cs[0] == minus;
        for (int i = 0; i < cs.length; i++) {
            char c = cs[cs.length - i - 1];
            if (c != minus) {
                ret += toLong(c, i);
            }
        }
        if (f) {
            return 0 - ret;
        }
        return ret;
    }
}