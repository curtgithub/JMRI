package jmri.jmrit.roster;

import junit.framework.*;

/**
 * Tests for the jmrit.roster.RosterEntryPane class
 * @author	Bob Jacobsen     Copyright (C) 2001, 2002
 * @version	$Revision: 1.4 $
 */
public class RosterEntryPaneTest extends TestCase {

    // statics for test objects
    org.jdom.Element e = null;
    RosterEntry r = null;

    public void setUp() {
        // create Element
        e = new org.jdom.Element("locomotive")
            .addAttribute("id","id info")
            .addAttribute("fileName","file here")
            .addAttribute("roadNumber","431")
            .addAttribute("roadName","SP")
            .addAttribute("mfg","Athearn")
            .addAttribute("dccAddress","1234")
            .addContent(new org.jdom.Element("decoder")
                        .addAttribute("family","91")
                        .addAttribute("model","33")
                        )
            ; // end create element

        r = new RosterEntry(e);
    }

    public void testCreate() {
        RosterEntryPane p = new RosterEntryPane(r);
        // check for field text contents
        Assert.assertEquals("file name ", "file here", p.filename.getText());
        Assert.assertEquals("DCC Address ", "1234", p.dccAddress.getText());
        Assert.assertEquals("road name ", "SP", p.roadName.getText());
        Assert.assertEquals("road number ", "431", p.roadNumber.getText());
        Assert.assertEquals("manufacturer ", "Athearn", p.mfg.getText());
        Assert.assertEquals("model ", "33",p.decoderModel.getText());
        Assert.assertEquals("family ", "91", p.decoderFamily.getText());

    }

    // from here down is testing infrastructure

    public RosterEntryPaneTest(String s) {
        super(s);
    }

    // Main entry point
    static public void main(String[] args) {
        String[] testCaseName = {RosterEntryPane.class.getName()};
        junit.swingui.TestRunner.main(testCaseName);
    }

    // test suite from all defined tests
    public static Test suite() {
        TestSuite suite = new TestSuite(RosterEntryPaneTest.class);
        return suite;
    }

}
