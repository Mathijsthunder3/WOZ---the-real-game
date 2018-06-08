import java.util.Scanner;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */


public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Levelbuilder lvls;
    private Player player;
    private Personage personage;
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        lvls = new Levelbuilder();
        currentRoom = lvls.buildLevel1();
        parser = new Parser();
    }

    /**
     * Creates a new player.
     */
    public void createPlayer(String naam)
    {
        int hp = 10;
        int xp = 0;
        player = new Player(naam, currentRoom, hp, xp);
    }
    
    /**
      *  Main play routine.  Loops until end of play.
      */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    
    {
        String naam = naamGetter();
        if(naam == null){
            printWelcome();
            return;
        }
        System.out.println();
        System.out.println("Welcome "+naam+" to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
        return;
    }
    
    /**
     * kijkt of je 2 maal dezelfde naam invoert zodat je niet met een typfout speelt
     */
    private String naamGetter(){
        System.out.println("what is your name?");
        String naam = vraagNaam();
        System.out.println("enter name again please");
        String naam2 = vraagNaam();
        if(naam.equals(naam2)){
            return naam;
        }
        else{
            return null;
        }
    }
    
    /**
     * vraag de naam van de autistische gebruiker lol
     */
    private String vraagNaam(){
        Scanner reader;
        reader = new Scanner(System.in);
        String inputLine;   // will hold the full input line
        System.out.print("> ");     // print prompt
        inputLine = reader.nextLine();
        return inputLine;
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        
        String commandWord = command.getCommandWord();
        
        switch(commandWord)
        {
            case "help" : printHelp();
                          break;
            case "go" : goRoom(command);
                          break;
            case "quit" : wantToQuit = quit(command);
                          break;
            case "look" : lookInRoom();
                          break;
            case "stats" : getStats();
                           break;
            case "attack" : attackMonster(command);
                            break;
            case "superAttack" : superAttackMonster(command);
                                 break;
        }
        return wantToQuit;
    }
     
    public void attackMonster(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what we need to attack...
            System.out.println("Attack what?");
            return;
        }
        
        String monsterAttacked = command.getSecondWord();
        
        int health = personage.getHP();
        personage.setHP(health - player.getAttack());
    }
    
    public void superAttackMonster(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know what we need to attack...
            System.out.println("SuperAttack what?");
            return;
        }
        
        String monsterSupperAttacked = command.getSecondWord();
        
        int healthPoints = personage.getHP();
        personage.setHP(healthPoints - player.getSuperAttack());
    }
    
    public void getStats()
    {
        System.out.println("HP" + player.getHp());
        System.out.println("XP" + player.getXp());
    }
    
    public void lookInRoom()
    {
        System.out.println(currentRoom.getLongDescription());
    }
    
    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to in to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            if (!nextRoom.getKeyroom()){
                currentRoom = nextRoom;
                System.out.println(currentRoom.getLongDescription());
            }
            else 
            {
                
            }
        }
        
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
