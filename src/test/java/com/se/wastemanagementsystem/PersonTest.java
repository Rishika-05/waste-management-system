package com.se.wastemanagementsystem;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void test(){
        Person p = new Person();
        int actual = p.sum(20, 30);
        int exp = 50;
        assertEquals(actual, exp);
        System.out.println("Hello");
    }

}