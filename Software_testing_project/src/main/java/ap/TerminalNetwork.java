package ap;
import java.util.List;

public class TerminalNetwork {
    
    // creates an empty TerminalNetwork with a given name and maximum number of clients
    public TerminalNetwork(String name, int maxClients) { /* .... */ }

    // changes the maximum number of clients
    public void setMaxClients(int maxClients) { /* .... */ } 

    // returns the maximum number of clients
    public int getMaxClients() {
         /* .... */
        return 0; 
    } 

    // returns the name of this network
    public String getName() {
         /* .... */
        return null; 
    } 
    
    // changes the name of this netwotk
    public String setName(String n) {
        /* .... */
        return null;  
    } 
    
    // adds a client to this network
    public void addClient(Client cl) { /* .... */ } 

    // removes a client to this network
    public void removeClient(Client cl) { /* .... */ } 

    // returns the clients of this network
    public List<Client> getClients() {
       /* .... */ 
        return null; 
    } 

    // returns the terminals of this network
    public List<Terminal> getTerminal() {
        /* .... */ 
        return null; 
    } 

    // register a terminal to this network and associates it to client cl
    public void addTerminal(Terminal t, String clientId) { /* .... */ }
}
