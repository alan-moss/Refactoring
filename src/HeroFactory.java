/**
 * MonsterFactory is used for creating monsters
 */
public class HeroFactory 
{
	/**
	 * Creates a hero based on the given number
	 * @param num 1: Warrior, 2: Sorceress, 3: Thief. Thief is used if an invalid number is given
	 * @return the created hero
	 */
	public DungeonCharacter makeHero(int num)
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
