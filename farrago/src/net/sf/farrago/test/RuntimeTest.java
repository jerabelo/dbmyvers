/*
// Farrago is a relational database management system.
// Copyright (C) 2003-2004 John V. Sichi.
// Copyright (C) 2003-2004 Disruptive Tech
//
// This program is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public License
// as published by the Free Software Foundation; either version 2.1
// of the License, or (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/
package net.sf.farrago.test;

import junit.framework.TestCase;
import net.sf.farrago.type.runtime.CharStringComparator;

import java.util.Arrays;

/**
 * Unit tests for various classes in package
 * {@link net.sf.farrago.type.runtime}.
 *
 * @author jhyde
 * @since Nov 11, 2004
 * @version $Id$
 **/
public class RuntimeTest extends TestCase
 {
    /** Test {@link CharStringComparator}. */
    public void testCharStringComparator() {
        assertEquals(0, CharStringComparator.compareCharStrings("x ", "x"));
        assertEquals(-1, CharStringComparator.compareCharStrings("a", "b"));
        assertEquals(1, CharStringComparator.compareCharStrings("aa", "a"));
        assertEquals(0, CharStringComparator.compareCharStrings("aa  ", "aa   "));
        assertEquals(2, CharStringComparator.compareCharStrings("aa a", "aa   "));
        assertEquals(0, CharStringComparator.compareCharStrings("", ""));
        assertEquals(0, CharStringComparator.compareCharStrings("", " "));
        assertEquals(0, CharStringComparator.compareCharStrings(" ", ""));
        assertEquals(1, CharStringComparator.compareCharStrings("a", ""));
        String[] beatles = {"john", "paul", "george", "", "ringo"};
        Arrays.sort(beatles, new CharStringComparator());
        assertEquals(", george, john, paul, ringo", toString(beatles));
    }


    private String toString(String[] a) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                buf.append(", ");
            }
            buf.append(a[i]);
        }
        return buf.toString();
    }
}

// End RuntimeTest.java