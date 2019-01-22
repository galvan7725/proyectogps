/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author galva
 */
public class loginBeanTest {
    
    public loginBeanTest() {
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
     * Test of isAcceso method, of class loginBean.
     */
    @Test
    public void testIsAcceso() {
        System.out.println("isAcceso");
        loginBean instance = new loginBean();
        boolean expResult = false;
        boolean result = instance.isAcceso();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAcceso method, of class loginBean.
     */
    @Test
    public void testSetAcceso() {
        System.out.println("setAcceso");
        boolean acceso = false;
        loginBean instance = new loginBean();
        instance.setAcceso(acceso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class loginBean.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        loginBean instance = new loginBean();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class loginBean.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        loginBean instance = new loginBean();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario1 method, of class loginBean.
     */
    @Test
    public void testGetUsuario1() {
        System.out.println("getUsuario1");
        loginBean instance = new loginBean();
        String expResult = "";
        String result = instance.getUsuario1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario1 method, of class loginBean.
     */
    @Test
    public void testSetUsuario1() {
        System.out.println("setUsuario1");
        String usuario1 = "";
        loginBean instance = new loginBean();
        instance.setUsuario1(usuario1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClave1 method, of class loginBean.
     */
    @Test
    public void testGetClave1() {
        System.out.println("getClave1");
        loginBean instance = new loginBean();
        String expResult = "";
        String result = instance.getClave1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setClave1 method, of class loginBean.
     */
    @Test
    public void testSetClave1() {
        System.out.println("setClave1");
        String clave1 = "";
        loginBean instance = new loginBean();
        instance.setClave1(clave1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRol method, of class loginBean.
     */
    @Test
    public void testGetRol() {
        System.out.println("getRol");
        loginBean instance = new loginBean();
        int expResult = 0;
        int result = instance.getRol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRol method, of class loginBean.
     */
    @Test
    public void testSetRol() {
        System.out.println("setRol");
        int rol = 0;
        loginBean instance = new loginBean();
        instance.setRol(rol);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class loginBean.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        ActionEvent actionEvent = null;
        loginBean instance = new loginBean();
        instance.login(actionEvent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loggout method, of class loginBean.
     */
    @Test
    public void testLoggout() {
        System.out.println("loggout");
        loginBean instance = new loginBean();
        instance.loggout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of submit method, of class loginBean.
     */
    @Test
    public void testSubmit() {
        System.out.println("submit");
        loginBean instance = new loginBean();
        instance.submit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
