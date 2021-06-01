/**
 * Dungeon is the main file for the (refactored) Heroes and Monsters project. It will do the following:
 * <p>1. Allow the user to choose a hero</p>
 * <p>2. Randomly select a monster</p>
 * <p>3. Allow the hero to battle the monster</p>
 * Once a battle concludes, the user has the option of repeating the above.
 * 
 * <p>Based on the original Heroes and Monsters project by I.M. Knurdy and Code Dogs Inc created in 2001.</p>
 * @authors Alan Moss, Joshua Merrell, Kelsey McMahon, and Jesse Anderson
 */
public class Dungeon
{
	public static void main(String[] args)
	{

		Hero theHero;
		Monster theMonster;

		do
		{
			theHero = chooseHero();
			theMonster = generateMonster();
			battle(theHero, theMonster);
		} while (playAgain());

	}//end main method

	/**
	 * Allows the user to select a hero, creates that hero, and returns it. It
	 * utilizes a polymorphic reference (Hero) to accomplish this
	 * @return the created hero
	 */
	public static Hero chooseHero()
	{
		char choice;
		// Hero theHero;

		System.out.println(
			"Choose a hero:\n" +
			"1. Warrior\n" +
			"2. Sorceress\n" +
			"3. Thief\n" +
			"Or press q to quit");
		choice = Keyboard.readChar();
		switch(choice)
		{
			case '1': return new Warrior();

			case '2': return new Sorceress();

			case '3': return new Thief();
			
			case 'q':
				System.out.println("Exiting");
				System.exit(0);

			default:
				System.out.println("invalid choice, returning Thief");
				return new Thief();
		}//end switch
	}//end chooseHero method

	/**
	 * Randomly selects a Monster and returns it. It utilizes a polymorphic
	 * reference (Monster) to accomplish this.
	 * @return the monster
	 */
	public static Monster generateMonster()
	{
		int choice;

		choice = (int)(Math.random() * 3) + 1;

		switch(choice)
		{
			case 1: return new Ogre();

			case 2: return new Gremlin();

			case 3: return new Skeleton();

			default: System.out.println("invalid choice, returning Skeleton");
					 return new Skeleton();
		}//end switch
	}//end generateMonster method

	/**
	 * Asks the player if they want to play again
	 * @return true if the player enters y or Y, false otherwise
	 */
	public static boolean playAgain()
	{
		char again;

		System.out.println("Play again (y/n)?");
		again = Keyboard.readChar();

		return (again == 'Y' || again == 'y');
	}//end playAgain method

	/**
	 * Dungeon.battle() is the actual combat portion of the game. Each 
	 * battle occurs in rounds. The Hero goes first, then the Monster. At
	 * the conclusion of each round, the user has the option of quitting.
	 * @param theHero the hero character, attacks first.
	 * @param theMonster the monster character, attacks after the hero.
	 */
	public static void battle(Hero theHero, Monster theMonster)
	{
		char pause = 'p';
		System.out.println(
			theHero.getName() + " battles " + theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
		{
			//hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
				theMonster.attack(theHero);

			//let the player bail out if desired
			System.out.print("\n-->q to quit, anything else to continue: ");
			pause = Keyboard.readChar();

		}//end battle loop

		if (!theMonster.isAlive())
			System.out.println(theHero.getName() + " was victorious!");
		else if (!theHero.isAlive())
			System.out.println(theHero.getName() + " was defeated :-(");
		else//both are alive so user quit the game
			System.out.println("Quitters never win ;-)");

	}//end battle method
}//end Dungeon class