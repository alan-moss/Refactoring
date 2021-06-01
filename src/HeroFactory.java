/*
Hero Factory creates a hero with given attributes
Args: integer number between 1-3
Returns: DungeonCharacter with attributes of warrior, sorceress, or thief
Note: Defaults to return Thief if given invalid input
*/
public class HeroFactory 
{    
    /*
    (classType, hitPoints, attackSpeed,chanceToHit, damageMin, damageMax, chanceToBlock, specialAttack)
    */
    public static DungeonCharacter makeHero(int num)
    {
        switch(num)
        {
            case 1: return new Hero("Warrior", 125, 4, 0.8, 35, 60, 0.2, "Crushing Blow");
            case 2: return new Hero("Sorceress", 75, 5, 0.7, 25, 50, 0.3, "Increase Hit Points");
            case 3: return new Hero("Thief", 75, 6, 0.8, 20, 40, 0.5, "Surprise Attack");

            //If invalid input, return thief
            default: System.out.println("invalid choice, returning Thief");
            return new Hero("Thief", 75, 6, 0.8, 20, 40, 0.5, "Surprise Attack");
            
        }
    }
}
