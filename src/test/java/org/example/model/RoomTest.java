package org.example.model;

import junit.framework.TestCase;

public class RoomTest extends TestCase {

    Room testObject = new Room(10,10,20,20,'B');


    public void testExecuteCommand() {
        char newCommand = 'F';
        int i = testObject.executeCommand(newCommand);
        assertEquals(-1,i);
    }


    public void testIsSafe() {
    }

    public void testPrint() {
    }

    public void testPrintCarInfo() {
    }
}