package edu.kennesaw.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/*
 * Name: Michael Pack
 * Class: Software Testing QA Section W02
 * Assignment: Assignment 4
 */

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("H3y, l3t'5 put s0me d161ts in this 5tr1n6!11!!");
        assertEquals(9, mycustomstring.countNumbers());
    }

    //One number test
    @Test
    public void testCountNumbers2() {

        mycustomstring.setString("My number is 123.");
        assertEquals(1, mycustomstring.countNumbers());
    }

    //Multiple numbers test
    @Test
    public void testCountNumbers3() {

        mycustomstring.setString("I have 12 apples and 34 oranges.");
        assertEquals(2, mycustomstring.countNumbers());
    }

    //String with no numbers test
    @Test
    public void testCountNumbers4() {

        mycustomstring.setString("There are no numbers here.");
        assertEquals(0, mycustomstring.countNumbers());
    }

    //Empty String test
    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    //Null String test
    @Test
    public void testCountNumbers6() {
        mycustomstring.setString(null);
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testReverseNCharacters1() {
        mycustomstring.setString("Peter Piper picked a peck of pickled peppers.");
        assertEquals("etePiP r repkcipa decep fo kcip delkpep srep.", mycustomstring.reverseNCharacters(4, false));
    }

    @Test
    public void testReverseNCharacters2() {
        mycustomstring.setString("Peter Piper picked a peck of pickled peppers.");
        assertEquals("etePiP r repkcipa decep fo kcip delkpep srepXXX.", mycustomstring.reverseNCharacters(4, true));
    }

    // Tests that a single-character reversal leaves the string unchanged
    @Test
    public void testReverseNCharacters3() {
        mycustomstring.setString("abcdef");
        assertEquals("abcdef", mycustomstring.reverseNCharacters(1, false));
    }

    // Tests that multiple complete groups of characters are reversed independently
    @Test
    public void testReverseNCharacters4() {
        mycustomstring.setString("abcdefghi");
        assertEquals("cbafedihg", mycustomstring.reverseNCharacters(3, false));
    }

    // Tests that an incomplete final group is reversed without adding padding
    @Test
    public void testReverseNCharacters5() {
        mycustomstring.setString("abcdefg");
        assertEquals("cbafedg", mycustomstring.reverseNCharacters(3, false));
    }

    // Tests that an incomplete final group is padded with X characters before reversal
    @Test
    public void testReverseNCharacters6() {
        mycustomstring.setString("abcdefg");
        assertEquals("cbafedXXg", mycustomstring.reverseNCharacters(3, true));
    }

    // Tests that n larger than the string length reverses the entire string
    @Test
    public void testReverseNCharacters7() {
        mycustomstring.setString("abcdef");
        assertEquals("fedcba", mycustomstring.reverseNCharacters(10, false));
    }

    // Tests that n equal to zero throws the required IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testReverseNCharacters8() {
        mycustomstring.setString("abcdef");
        mycustomstring.reverseNCharacters(0, false);
    }

    // Tests that calling reverseNCharacters with a null string throws NullPointerException
    @Test(expected = NullPointerException.class)
    public void testReverseNCharacters9() {
        mycustomstring.setString(null);
        mycustomstring.reverseNCharacters(3, false);
    }

    // Tests that reversing an empty string returns an empty string.
    @Test
    public void testReverseNCharacters10() {
        mycustomstring.setString("");
        assertEquals("", mycustomstring.reverseNCharacters(3, false));
    }

    // Tests padding behavior when n is larger than the string length.
    @Test
    public void testReverseNCharacters11() {
        mycustomstring.setString("abc");
        assertEquals("XXcba", mycustomstring.reverseNCharacters(5, true));
    }


    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        mycustomstring.convertDigitsToNamesInSubstring(17, 24);
        assertEquals("H3y, l3t'5 put 5Zerome dOnesixonets in this 5tr1n6!11!!", mycustomstring.getString());
    }

    // Tests that a sequence of digits is converted to English names with proper capitalization.
    @Test
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.setString("The number is 460.");
        mycustomstring.convertDigitsToNamesInSubstring(15, 17);
        assertEquals("The number is Foursixzero.", mycustomstring.getString());
    }

    // Tests that digits outside the selected substring remain unchanged.
    @Test
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.setString("123456");
        mycustomstring.convertDigitsToNamesInSubstring(3, 4);
        assertEquals("12Threefour56", mycustomstring.getString());
    }

    // Tests that capitalization resets when separate digit sequences are separated by non-digit characters.
    @Test
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("12-34");
        mycustomstring.convertDigitsToNamesInSubstring(1, 5);
        assertEquals("Onetwo-Threefour", mycustomstring.getString());
    }

    // Tests that a substring containing no digits remains unchanged.
    @Test
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString("hello world");
        mycustomstring.convertDigitsToNamesInSubstring(1, 5);
        assertEquals("hello world", mycustomstring.getString());
    }

    // Tests that a single digit is converted to its corresponding English name.
    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("Number: 7");
        mycustomstring.convertDigitsToNamesInSubstring(9, 9);
        assertEquals("Number: Seven", mycustomstring.getString());
    }

    // Tests that every digit from 0 through 9 is converted correctly.
    @Test
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("0123456789");
        mycustomstring.convertDigitsToNamesInSubstring(1, 10);
        assertEquals("Zeroonetwothreefourfivesixseveneightnine", mycustomstring.getString());
    }

    // Tests that a null current string causes a NullPointerException.
    @Test(expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString(null);
        mycustomstring.convertDigitsToNamesInSubstring(1, 1);
    }

    //Tests that startPosition greater than endPosition causes an IllegalArgumentException.
    @Test(expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring9() {
        mycustomstring.setString("12345");
        mycustomstring.convertDigitsToNamesInSubstring(4, 2);
    }

    // Tests that a start position less than 1 causes MyIndexOutOfBoundsException.
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring10() {
        mycustomstring.setString("12345");
        mycustomstring.convertDigitsToNamesInSubstring(0, 3);
    }

    // Tests that an end position beyond the string length causes MyIndexOutOfBoundsException.
    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertDigitsToNamesInSubstring11() {
        mycustomstring.setString("12345");
        mycustomstring.convertDigitsToNamesInSubstring(2, 6);
    }

}
