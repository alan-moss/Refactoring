//The Monster superclass for Gremlin, Ogre, and Skeleton
public class Monster implements DungeonCharacter
{
	protected String name;
	protected int hitPoints, attackSpeed;
	protected double chanceToHit, chanceToHeal;
	protected int damageMin, damageMax;
	protected int minHeal, maxHeal;
	protected String attackString;

	/**
	 * Creates the monster with the given attributes
	 * @param name
	 * @param hitPoints
	 * @param attackSpeed
	 * @param chanceToHit
	 * @param chanceToHeal
	 * @param damageMin
	 * @param damageMax
	 * @param minHeal
	 * @param maxHeal
	 */
	public Monster( String name, int hitPoints, int attackSpeed, String attackString, double chanceToHit, double chanceToHeal,
		int damageMin, int damageMax,int minHeal, int maxHeal)
	{
		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.attackString = attackString;
		this.chanceToHit = chanceToHit;
		this.chanceToHeal = chanceToHeal;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;
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
	
	public void addHitPoints(int hitPoints)
	{
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		
		else {
			this.hitPoints += hitPoints;
			System.out.println("Remaining Hit Points: " + hitPoints);
		}
	}

	public void subtractHitPoints(int hitPoints)
	{
		heal();
		
		if (hitPoints <0)
			System.out.println("Hitpoint amount must be positive.");
		
		else if (hitPoints >0) {
			this.hitPoints -= hitPoints;
			if (this.hitPoints < 0)
				this.hitPoints = 0;
			System.out.printf("%s was hit for %d points of damage (%d HP remaining).\n", getName(), hitPoints, getHitPoints());
		}

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");
	}
	//End interface methods
	
	/**
	 * Monsters have a chance to heal each round
	 */ 
	public void heal()
	{
		
		boolean canHeal;
		int healPoints;

		canHeal = (Math.random() <= chanceToHeal) && (hitPoints > 0);

		if (canHeal) {
			healPoints = (int)(Math.random() * (maxHeal - minHeal + 1)) + minHeal;
			addHitPoints(healPoints);
			System.out.println(name + " healed itself for " + healPoints + " points.\n" + "Total hit points remaining are: " + hitPoints);
			System.out.println();
		}
	}
	
	/**
	 * Attempts to attack the given opponent based on random chance
	 */
	public void attack(DungeonCharacter opponent)
	{
		boolean canAttack;
		int damage;
	
		canAttack = Math.random() <= chanceToHit;
		System.out.printf(attackString, name, opponent.getName());
		
		if (canAttack) {
			damage = (int)(Math.random() * (damageMax - damageMin + 1)) + damageMin ;
			opponent.subtractHitPoints(damage);
			System.out.println();
		} else {
			System.out.printf("%s's attack on %s failed!\n\n", name, opponent.getName());
		}
	}

	public void battleChoices(DungeonCharacter opponent) {}
}