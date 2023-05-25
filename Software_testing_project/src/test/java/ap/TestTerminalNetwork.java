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
        TerminalNetwork tn = new TerminalNetwork("abcd", 10000);
        List<String> clientIds = new ArrayList<String>();
        List<String> terminalIds = new ArrayList<String>();
        for (int i = 0; i < 10000; i++)
        {
            //identifier is unique
            tn.addClient(new Client(String.valueOf(i), null));
            clientIds.add(String.valueOf(i));
            if (i < 100)
            {
                // all the terminals will be associated with a client
                // but not all clients will have a terminal
                tn.addTerminal(new Terminal("terminal" + String.valueOf(i)), String.valueOf(i));
                terminalIds.add("terminal" + String.valueOf(i));
            }
        }
        
        //Act
        tn.setName("efgh");

        //Assert
        assertEquals(tn.getName(), "efgh");
        assertEquals(tn.getMaxClients(), 10000);
        List<Client> listOfCLients = tn.getClients();
        assertEquals(listOfCLients.size(), 10000);
        for (Client c : tn.getClients())
        {
            assertTrue(clientIds.contains(c.getName()));
        }
        List<Terminal> listOfTerminal = tn.getTerminal();
        assertEquals(listOfTerminal.size(), 100);
        for (Terminal t : tn.getTerminal())
        {
            assertTrue(terminalIds.contains(t.id));
        } 
    }

    public void testTerminalNetwork2() {
        //Arrange
        TerminalNetwork tn = new TerminalNetwork("abcde", 10500);
        List<String> clientIds = new ArrayList<String>();
        List<String> terminalIds = new ArrayList<String>();
        Client lastClient;
        for (int i = 0; i < 10500; i++)
        {
            //identifier is unique
            lastClient = new Client(String.valueOf(i), null);
            tn.addClient(lastClient);
            clientIds.add(String.valueOf(i));
            if (i < 100)
            {
                // all the terminals will be associated with a client
                // but not all clients will have a terminal
                tn.addTerminal(new Terminal("terminal" + String.valueOf(i)), String.valueOf(i));
                terminalIds.add("terminal" + String.valueOf(i));
            }
        }
        
        //Act
        try 
        {
            tn.addClient(new Client(String.valueOf(10500), null));

            //should throw an exception before reaching here
            fail("Expected exception");
        }
        catch (InvalidInvocationException e)
        {
            
        }
        //We can however, remove the last one and add it again
        tn.removeClient(lastClient);
        tn.addClient(lastClient);

        //Or raise the maximum number of clients
        tn.setMaxClients(10501);
        tn.addClient(new Client(String.valueOf(10500), null));
        clientIds.add(String.valueOf(10500));

        //Assert
        assertEquals(tn.getName(), "abcde");
        assertEquals(tn.getMaxClients(), 10501);
        List<Client> listOfCLients = tn.getClients();
        assertEquals(listOfCLients.size(), 10501);
        for (Client c : tn.getClients())
        {
            assertTrue(clientIds.contains(c.getName()));
        }
        List<Terminal> listOfTerminal = tn.getTerminal();
        assertEquals(listOfTerminal.size(), 100);
        for (Terminal t : tn.getTerminal())
        {
            assertTrue(terminalIds.contains(t.id));
        } 
    }
    
    public void testTerminalNetwork3() {
        //Arrange
        TerminalNetwork tn = new TerminalNetwork("abcde", 50000);
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
        assertEquals(tn.getMaxClients(), 50000);
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
        assertThrows(InvalidInvocationException.class,
            ()->{ new TerminalNetwork("abcde", 50001);}); 
    }

    public void testTerminalNetwork6() {
        //Arrange
        TerminalNetwork tn = new TerminalNetwork("abcdefg", 11000);
        List<String> clientIds = new ArrayList<String>();
        List<String> terminalIds = new ArrayList<String>();
        for (int i = 0; i < 1100; i++)
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
            tn.addClient(new Client("1099", null));
            
            fail("Expected exception");
        }
        catch (InvalidInvocationException e) {}

        assertEquals(tn.getName(), "abcdefg");
        assertEquals(tn.getMaxClients(), 11000);
        List<Client> listOfCLients = tn.getClients();
        assertEquals(listOfCLients.size(), 1100);
        for (Client c : tn.getClients())
        {
            assertTrue(clientIds.contains(c.getName()));
        }
        List<Terminal> listOfTerminal = tn.getTerminal();
        assertEquals(listOfTerminal.size(), 1100);
        for (Terminal t : tn.getTerminal())
        {
            assertTrue(terminalIds.contains(t.id));
        } 
    }

    public void testTerminalNetwork7() {
        //Arrange
        TerminalNetwork tn = new TerminalNetwork("abc", 12000);
        tn.setMaxClients(9500);
        List<String> clientIds = new ArrayList<String>();
        List<String> terminalIds = new ArrayList<String>();
        for (int i = 0; i < 1200; i++)
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
        assertEquals(tn.getMaxClients(), 9500);
        List<Client> listOfCLients = tn.getClients();
        assertEquals(listOfCLients.size(), 1200);
        for (Client c : tn.getClients())
        {
            assertTrue(clientIds.contains(c.getName()));
        }
        List<Terminal> listOfTerminal = tn.getTerminal();
        assertEquals(listOfTerminal.size(), 1200);
        for (Terminal t : tn.getTerminal())
        {
            assertTrue(terminalIds.contains(t.id));
        } 
    }

    public void testTerminalNetwork10() {
        //Arrange
        TerminalNetwork tn = new TerminalNetwork("abcdefghi", 15000);
        List<String> clientIds = new ArrayList<String>();
        List<String> terminalIds = new ArrayList<String>();
        for (int i = 0; i < 1500; i++)
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
        assertEquals(tn.getMaxClients(), 15000);
        List<Client> listOfCLients = tn.getClients();
        assertEquals(listOfCLients.size(), 1500);
        for (Client c : tn.getClients())
        {
            assertTrue(clientIds.contains(c.getName()));
        }
        List<Terminal> listOfTerminal = tn.getTerminal();
        assertEquals(listOfTerminal.size(), 1500);
        for (Terminal t : tn.getTerminal())
        {
            assertTrue(terminalIds.contains(t.id));
        } 
    }

    public void testTerminalNetwork12() {
        //Arrange
        TerminalNetwork tn = new TerminalNetwork("abcd", 17000);
        List<String> clientIds = new ArrayList<String>();
        List<String> terminalIds = new ArrayList<String>();
        for (int i = 0; i < 1700; i++)
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
        assertEquals(tn.getMaxClients(), 17000);
        List<Client> listOfCLients = tn.getClients();
        assertEquals(listOfCLients.size(), 1700);
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
