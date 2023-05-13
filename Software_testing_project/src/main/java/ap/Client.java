package ap;
import java.util.List;

public class Client {

    // creates a client with the given name and level
    public Client(String name, ClientLevel level) {/*....*/}

    // changes the level of this client
    void setLevel(ClientLevel level) { /* .... */ } 
    
    // gets the level of this client
    public ClientLevel getLevel() {
        /* .... */
        return null;  
    }

    // returns the name of this client
    public String getName() {
        /* .... */
        return null;  
    } 

    // adds a terminal to this client
    void addTerminal(Terminal t) { /* .... */ }

    // returns the terminals of this client
    List<Terminal> getTerminals() {
        /* .... */
        return null;  
    } 

    // returns the unpaid communications made by terminals of this client
    List<Communication> getUnpaidCommunications() {
        /* .... */ 
        return null;
    }

    // computes the unit call of voice communications made by these client
    public int computeCallUnitCost() {
        /* .... */
        return 0;  
    }
}


