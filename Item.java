
/**
 * class Item - Alle info in verband met items.
 *
 * @author Moens Jonas + stijn demeyere
 * @version 0.1 alpha
 */
public class Item
{
    private String Naam;
    private int Gewicht;
    private String Beschrijving;
    

    public Item(String naam , int gewicht , String beschrijving) 
    {
        this.Naam = naam;
        this.Gewicht = gewicht;
        this.Beschrijving = beschrijving;
    }
}