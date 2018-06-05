
/**
 * class Personage - geef hier een beschrijving van deze class
 *
 * @author (jouw naam)
 * @version (versie nummer of datum)
 */
public class Personage
{
    // instance variables - vervang deze door jouw variabelen
    private String naam;
    private String beschrijving;
    private Room currentRoom;
    private int HP;
    private int power;
    private boolean agressive;

    /**
     * Constructor voor objects van class Personage
     */
    public Personage(String naam, String beschrijving, int HP, int power, boolean agressive)
    {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.HP = HP;
        this.power = power;
        this.agressive = agressive;
    }
    
    public String getNaam()
    {
        return naam;
    }
    
    public String getBeschrijving()
    {
        return beschrijving;
    }
    
    public int getHP()
    {
        return HP;
    }
    
    public Room getCurrentRoom()
    {
        return currentRoom;
    }
    
    public int getPower()
    {
        return power;
    }
    
    public boolean getAgressive()
    {
        return agressive;
    }
    
    public void showInfo()
    {
        System.out.println(naam);
        System.out.println(beschrijving);
        System.out.println(HP);
        System.out.println(power);
        System.out.println(agressive);
    }
}
