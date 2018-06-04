
/**
 * class Player - Houdt de speler bij.
 *
 * @author Mathijs Slabbinck & ook een beetje Jonathan Dhoop
 * @version 29/05/2018
 */
public class Player
{
    private String naam;
    private Room currentRoom;
    private int hp;
    private int xp;
    
    /**
     * maakt de speler klaar
     */
    public void spelerKlaarmaken(String naam,Room currentRoom,int hp,int xp)
    {
        this.naam = naam;
        this.currentRoom = currentRoom;
        this.hp = hp;
        this.xp = xp;
    }
}
