
/**
 * class Levelbuilder - geef hier een beschrijving van deze class
 *
 * @author (stijn demeyere)
 * @version (4/06)
 */
public class Levelbuilder
{
    public Room buildLevel1()
    {
        Room outside, theater, pub, lab, office;
        Personage trol, witch;
        
        
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        
        // create figures
        trol = new Personage("trol", "klein hyperactief ventje", 100, 15, true);
        witch = new Personage("witch", "a bitchy witchy", 70, 35, false);
        

        //createItems 


        return outside;  // start game outside
    }
}
