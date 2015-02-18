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
    
    public RuntimeExecTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class RuntimeExec.
     */
    @Test public void testRun() throws IOException {
        System.out.println("run");
        String command = "ls -l";
        int processExitStatus= RuntimeExec.run(command);
        assertEquals(PROCESS_EXIT_STATUS_OK, processExitStatus);
    }
    
}
