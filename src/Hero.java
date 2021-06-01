/**
 * Hero superclass for Warrior, Thief, and Sorceress
 */
public class Hero implements DungeonCharacter
{
	//Hero data fields
	protected String classType;
	protected String name;
	protected String specialAttack;
	protected int hitPoints;
	protected int attackSpeed;
	protected double chanceToHit;
	protected int damageMin, damageMax;
	protected double chanceToBlock;
	protected int numTurns;
	
	//Hero Constructor
	public Hero(String classType, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, String specialAttack) {

		this.name = readName();
		this.classType = classType;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.chanceToBlock = chanceToBlock;
		this.specialAttack = specialAttack;
		
	}
	
	/**
	 * Get the character's name from the user
	 */
	public String readName()
	{
		System.out.print("Enter character name: ");
		name = Keyboard.readString();
		
		return name;
	}
	
	//Implement DungeonCharacter interface methods
	//--------------------------------------------
	
	public String getName()
	{
		return this.name;
	}

	public int getHitPoints()
	{
		return this.hitPoints;
	}

	public int getAttackSpeed()
	{
		return this.attackSpeed;
	}
	
	public boolean isAlive()
	{
		return (this.hitPoints > 0);
	}
	
	public void subtractHitPoints(int hitPoints)
	{
		if (defend()) {
			System.out.println(getName() + " BLOCKED the attack!");
		} else {
			if (hitPoints <0)
				System.out.println("Hitpoint amount must be positive.");
			
			else if (hitPoints >0) {
				this.hitPoints -= hitPoints;

				if (this.hitPoints < 0)
					this.hitPoints = 0;
				
				System.out.println(getName() + " was hit for <" + hitPoints + "> points of damage.");
				System.out.println(getName() + " now has " + getHitPoints() + " hit points remaining.");
				System.out.println();
			}

			if (this.hitPoints == 0)
				System.out.println(name + " has been killed :-(");
		}
	}
	
	public void addHitPoints(int hitPoints)
	{
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
			this.hitPoints += hitPoints;
	}
	
	/**
	 * Heroes have a chance to block each round
	 */
	public boolean defend()
	{
		return Math.random() <= chanceToBlock;
	}
		
	public void attack(DungeonCharacter opponent)
	{
		boolean canAttack;
		int damage;

		canAttack = Math.random() <= chanceToHit;

		if (canAttack) {
			damage = (int)(Math.random() * (damageMax - damageMin + 1)) + damageMin ;
			opponent.subtractHitPoints(damage);
			System.out.println();
		} else {
			System.out.println(getName() + "'s attack on " + opponent.getName() + " failed!");
			System.out.println();
		}
	}
	
	/**
	 * Return the special attack name
	 */
	public String specialAttack()
	{
		return specialAttack;
	}
	
	// class-exclusive attack.
	public void specialAttack(DungeonCharacter opponent) {}
	
	/**
	 * Battle options for the hero character
	 */
	public void battleChoices(DungeonCharacter opponent)
	{
		int choice;

		do {
			System.out.println("1. Attack Opponent");
			System.out.println("2. " + specialAttack());
			System.out.print("Choose an option: ");
			choice = Keyboard.readInt();

			switch (choice)
			{
				case 1: attack(opponent);
					break;
				case 2: specialAttack(opponent);
					break;
				default:
					System.out.println("invalid choice!");
			}

			numTurns--;
			if (numTurns > 0)
				System.out.println("Number of turns remaining is: " + numTurns);
		} while(numTurns > 0);
	}
}