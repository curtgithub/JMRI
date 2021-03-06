package jmri.util.swing;

import jmri.util.JUnitUtil;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 *
 * @author Paul Bender Copyright (C) 2017
 */
public class ExceptionContextTest {
        
    protected ExceptionContext ec; 

    @Test
    public void testCTor() {
        Assert.assertNotNull("exists",ec);
    }

    @Test
    public void testGetTitle() {
        Assert.assertEquals("Title",Exception.class.getSimpleName(),ec.getTitle());
    }

    @Test
    public void testGetOperation() {
        Assert.assertEquals("Operation","Test Op",ec.getOperation());
    }

    @Test
    public void testGetHint() {
        Assert.assertEquals("Hint","Test Hint",ec.getHint());
    }

    @BeforeEach
    public void setUp() {
        JUnitUtil.setUp();
        ec = new ExceptionContext(new Exception("Test"),"Test Op","Test Hint");
    }

    @AfterEach
    public void tearDown() {
        ec = null;
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(ExceptionContextTest.class);

}
