package ap;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import java.util.List;

import java.util.ArrayList;

@Test
public class TestTerminalNetwork {
    /* To complete */
    // Test cases: 1,2,3,4,6,7,10,12
    public void testTerminalNetwork1() {
        //Arrange
        TerminalNetwork tn = new TerminalNetwork("abcd", 50000);
        List<String> clientIds = new ArrayList<String>();
        List<String> terminalIds = new ArrayList<String>();
        for (int i = 0; i < 50000; i++)
        {
            //identifier is unique
            tn.addClient(new Client(String.valueOf(i), null));
            clientIds.add(String.valueOf(i));
            if (i < 10000)
            {
                // all the terminals will be associated with a client
                // but not all clients will have a terminal
                tn.addTerminal(new Terminal("terminal" + String.valueOf(i)), String.valueOf(i));
                terminalIds.add("terminal" + String.valueOf(i));
            }
        }
        
        //Act
        
        //Assert
        assertEquals(tn.getName(), "abcd");
        List<Client> listOfCLients = tn.getClients();
        assertEquals(listOfCLients.size(), 50000);
        for (Client c : tn.getClients())
        {
            assertTrue(clientIds.contains(c.getName()));
        }
        List<Terminal> listOfTerminal = tn.getTerminal();
        assertEquals(listOfTerminal.size(), 10000);
        for (Terminal t : tn.getTerminal())
        {
            assertTrue(terminalIds.contains(t.id));
        } 
    }

    public void testTerminalNetwork2() {
        assertThrows(InvalidInvocationException.class,
            ()->{ new TerminalNetwork("abcde", 50001);}); 
    }

    public void testTerminalNetwork3() {
        //Arrange
        TerminalNetwork tn = new TerminalNetwork("abcde", 500);
        List<String> clientIds = new ArrayList<String>();
        List<String> terminalIds = new ArrayList<String>();
        for (int i = 0; i < 500; i++)
        {
            //identifier is unique
            tn.addClient(new Client(String.valueOf(i), null));
            clientIds.add(String.valueOf(i));
            // all the terminals will be associated with a client
            tn.addTerminal(new Terminal("terminal" + String.valueOf(i)), String.valueOf(i));
            terminalIds.add("terminal" + String.valueOf(i));
        }
        
        //Act
        
        //Assert
        assertEquals(tn.getName(), "abcde");
        List<Client> listOfCLients = tn.getClients();
        assertEquals(listOfCLients.size(), 500);
        for (Client c : tn.getClients())
        {
            assertTrue(clientIds.contains(c.getName()));
        }
        List<Terminal> listOfTerminal = tn.getTerminal();
        assertEquals(listOfTerminal.size(), 500);
        for (Terminal t : tn.getTerminal())
        {
            assertTrue(terminalIds.contains(t.id));
        } 
    }

    public void testTerminalNetwork4() {
        //Arrange
        TerminalNetwork tn = new TerminalNetwork("abcde", 749);
        List<String> clientIds = new ArrayList<String>();
        List<String> terminalIds = new ArrayList<String>();
        for (int i = 0; i < 749; i++)
        {
            //identifier is unique
            tn.addClient(new Client(String.valueOf(i), null));
            clientIds.add(String.valueOf(i));
            // all the terminals will be associated with a client
            tn.addTerminal(new Terminal("terminal" + String.valueOf(i)), String.valueOf(i));
            terminalIds.add("terminal" + String.valueOf(i));
        }
        
        //Act
        try 
        {
            tn.addClient(new Client(String.valueOf(749), null));

            //should throw an exception before reaching here
            fail("Expected exception");
        }
        catch (InvalidInvocationException e)
        {
            
        }
        //Assert
        assertEquals(tn.getName(), "abcde");
        List<Client> listOfCLients = tn.getClients();
        assertEquals(listOfCLients.size(), 749);
        for (Client c : tn.getClients())
        {
            assertTrue(clientIds.contains(c.getName()));
        }
        List<Terminal> listOfTerminal = tn.getTerminal();
        assertEquals(listOfTerminal.size(), 749);
        for (Terminal t : tn.getTerminal())
        {
            assertTrue(terminalIds.contains(t.id));
        } 
    }

    public void testTerminalNetwork6() {
        //Arrange
        TerminalNetwork tn = new TerminalNetwork("abcdefg", 5000);
        List<String> clientIds = new ArrayList<String>();
        List<String> terminalIds = new ArrayList<String>();
        for (int i = 0; i < 4999; i++)
        {
            //identifier is unique
            tn.addClient(new Client(String.valueOf(i), null));
            clientIds.add(String.valueOf(i));
            // all the terminals will be associated with a client
            tn.addTerminal(new Terminal("terminal" + String.valueOf(i)), String.valueOf(i));
            terminalIds.add("terminal" + String.valueOf(i));
        }
        
        //Act
        
        //Assert
        // Repeat the last id and verify exception
        try
        {
            tn.addClient(new Client("4998", null));
            
            fail("Expected exception");
        }
        catch (InvalidInvocationException e) {}

        assertEquals(tn.getName(), "abcdefg");
        List<Client> listOfCLients = tn.getClients();
        assertEquals(listOfCLients.size(), 4999);
        for (Client c : tn.getClients())
        {
            assertTrue(clientIds.contains(c.getName()));
        }
        List<Terminal> listOfTerminal = tn.getTerminal();
        assertEquals(listOfTerminal.size(), 4999);
        for (Terminal t : tn.getTerminal())
        {
            assertTrue(terminalIds.contains(t.id));
        } 
    }

    public void testTerminalNetwork7() {
        //Arrange
        TerminalNetwork tn = new TerminalNetwork("abc", 10000);
        List<String> clientIds = new ArrayList<String>();
        List<String> terminalIds = new ArrayList<String>();
        for (int i = 0; i < 10000; i++)
        {
            //identifier is unique
            tn.addClient(new Client(String.valueOf(i), null));
            clientIds.add(String.valueOf(i));
            // all the terminals will be associated with a client
            tn.addTerminal(new Terminal("terminal" + String.valueOf(i)), String.valueOf(i));
            terminalIds.add("terminal" + String.valueOf(i));
        }
        
        //Act
        
        //Assert
        assertEquals(tn.getName(), "abc");
        List<Client> listOfCLients = tn.getClients();
        assertEquals(listOfCLients.size(), 10000);
        for (Client c : tn.getClients())
        {
            assertTrue(clientIds.contains(c.getName()));
        }
        List<Terminal> listOfTerminal = tn.getTerminal();
        assertEquals(listOfTerminal.size(), 10000);
        for (Terminal t : tn.getTerminal())
        {
            assertTrue(terminalIds.contains(t.id));
        } 
    }

    public void testTerminalNetwork10() {
        //Arrange
        TerminalNetwork tn = new TerminalNetwork("abcdefghi", 30000);
        List<String> clientIds = new ArrayList<String>();
        List<String> terminalIds = new ArrayList<String>();
        for (int i = 0; i < 30000; i++)
        {
            //identifier is unique
            tn.addClient(new Client(String.valueOf(i), null));
            clientIds.add(String.valueOf(i));
            // all the terminals will be associated with a client
            tn.addTerminal(new Terminal("terminal" + String.valueOf(i)), String.valueOf(i));
            terminalIds.add("terminal" + String.valueOf(i));
        }
        
        //Act
        
        //Assert
        assertEquals(tn.getName(), "abcdefghi");
        List<Client> listOfCLients = tn.getClients();
        assertEquals(listOfCLients.size(), 30000);
        for (Client c : tn.getClients())
        {
            assertTrue(clientIds.contains(c.getName()));
        }
        List<Terminal> listOfTerminal = tn.getTerminal();
        assertEquals(listOfTerminal.size(), 30000);
        for (Terminal t : tn.getTerminal())
        {
            assertTrue(terminalIds.contains(t.id));
        } 
    }

    public void testTerminalNetwork12() {
        //Arrange
        TerminalNetwork tn = new TerminalNetwork("abcd", 45000);
        List<String> clientIds = new ArrayList<String>();
        List<String> terminalIds = new ArrayList<String>();
        for (int i = 0; i < 45000; i++)
        {
            //identifier is unique
            tn.addClient(new Client(String.valueOf(i), null));
            clientIds.add(String.valueOf(i));

            //add some terminals that are associated with a client
            if (i < 500)
            {
                tn.addTerminal(new Terminal("terminal" + String.valueOf(i)), String.valueOf(i));
                terminalIds.add("terminal" + String.valueOf(i));
            }
        }
        
        //Act
        
        //Assert
        try
        {
            tn.addTerminal(new Terminal("TerminalWithoutClient"), null);
            
            fail("Expected exception");
        }
        catch (InvalidInvocationException e) { }
        assertEquals(tn.getName(), "abcd");
        List<Client> listOfCLients = tn.getClients();
        assertEquals(listOfCLients.size(), 45000);
        for (Client c : tn.getClients())
        {
            assertTrue(clientIds.contains(c.getName()));
        }
        List<Terminal> listOfTerminal = tn.getTerminal();
        assertEquals(listOfTerminal.size(), 500);
        for (Terminal t : tn.getTerminal())
        {
            assertTrue(terminalIds.contains(t.id));
            assertTrue(t.id != "TerminalWithoutClient");
        } 
    }
}
