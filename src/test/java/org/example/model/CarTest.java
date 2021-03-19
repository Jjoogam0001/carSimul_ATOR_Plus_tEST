package org.example.model;

import junit.framework.TestCase;
import org.junit.Assert;

public class CarTest extends TestCase {

    Car testObject = new Car(10,7,'L');

    @Override
    public void setUp() throws Exception {

    }

    public void testGetX() {
    int actual = 10;
    Assert.assertEquals(actual,testObject.getX());


    }

    public void testGetY() {
        int actual = 7;
        Assert.assertEquals(actual,testObject.getY());


    }

    public void testGetDirection() {
        char actual = 'L';
        Assert.assertEquals(actual,testObject.getDirection());

    }

    public void testSetX() {
       testObject.setX(2);
       assertTrue(testObject.getX()== 2);
    }

    public void testSetY() {
        testObject.setY(4);
        assertTrue(testObject.getY()== 4);
    }

    public void testSetDirection() {
        testObject.setDirection('F');
        assertTrue(testObject.getDirection() == 'F');
    }
}