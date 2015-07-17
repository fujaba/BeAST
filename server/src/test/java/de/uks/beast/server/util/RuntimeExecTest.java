package de.uks.beast.server.util;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class RuntimeExecTest {
    
    public static final int PROCESS_EXIT_STATUS_OK = 0;
    public static final int PROCESS_EXIT_STATUS_NOT_OK = -1;
    
    public RuntimeExecTest() {
    }
    
    @BeforeClass public static void setUpClass() {
    }
    
    @AfterClass public static void tearDownClass() {
    }
    
    @Before public void setUp() {
    }
    
    @After public void tearDown() {
    }

    /**
     * Test of run method, of class RuntimeExec.
     * @throws java.io.IOException
     */
    @Test public void testRun() throws IOException {
        System.out.println("run");
        String command = "ls -l";
        RuntimeOutput out = RuntimeExec.run(command);
        assertEquals(PROCESS_EXIT_STATUS_OK, out.getStatusCode());
    }
    
}
