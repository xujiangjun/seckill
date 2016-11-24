package org.seckill.service;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author xujiangjun
 * @version 1.0
 * @date 2016-11-23 14:37
 * http://gold.xitu.io/entry/578f11aec4c971005e0caf82
 */
public class MockitoTest {

    @Test
    public void testAssertThat(){
        assertThat("", "Hello", CoreMatchers.endsWith("llo"));
    }

    @Test
    public void testMoreThanOneReturnValue(){
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Mockito").thenReturn("rocks");
        String result = i.next() + " " + i.next();
        assertEquals("Mockito rocks", result);
    }
}
