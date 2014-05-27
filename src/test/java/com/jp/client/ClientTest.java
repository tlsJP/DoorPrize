package com.jp.client;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: jalbert
 * Date: 5/27/14
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClientTest {

    Client c;

    @Before
    public void setup() {
        c = new Client();
        assertNotNull(c);
    }

    @Test
    public void pathA() {

    }

    @Test
    public void pathB() {

    }
}
