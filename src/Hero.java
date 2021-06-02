/**
 * Hero superclass for Warrior, Thief, and Sorceress
 */
public class Hero implements DungeonCharacter
{
	//Hero data fields
	protected String classType;
	protected String name;
	protected int hitPoints;
	protected int attackSpeed;
	protected String attackString;
	protected double chanceToHit;
	protected int damageMin, damageMax;
	protected double chanceToBlock;
	protected SpecialAttack special;
	protected int numTurns;
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

	
	//Hero Constructor
	public Hero(String classType, int hitPoints, int attackSpeed, String attackString, double chanceToHit, int damageMin, int damageMax,
			double chanceToBlock, SpecialAttack special) {

		this.name = readName();
		this.classType = classType;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.chanceToBlock = chanceToBlock;
		this.special = special;
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

	public int numTurnsIncrement() {
		return ++this.numTurns;
	}

	public int numTurnsDecrement()
	{
		return --this.numTurns;
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
				
				System.out.printf("%s was hit for %d points of damage (%d HP remaining)\n", getName(), hitPoints, getHitPoints());
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
	public SpecialAttack specialAttack()
	{
		return special;
	}
	
	// class-exclusive attack.
	public void specialAttack(DungeonCharacter opponent) {
		this.special.doAttack(this, opponent);
	}

	public void heal()
	{
		int addedHP;

		addedHP = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(addedHP);
		System.out.printf("%s added %d HP. Total hit points remaining are: %d\n\n", name, addedHP, hitPoints);
	}

	/**
	 * Battle options for the hero character
	 */
	public void battleChoices(DungeonCharacter opponent)
	{
		int choice;

		do {
			System.out.println("1. Attack Opponent");
			System.out.printf("2. Special (%s)\n", special.getAttackName());
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