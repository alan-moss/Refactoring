//The Monster superclass for Gremlin, Ogre, and Skeleton
public class Monster implements DungeonCharacter
{
	protected String name;
	protected int hitPoints, attackSpeed;
	protected double chanceToHit, chanceToHeal;
	protected int damageMin, damageMax;
	protected int minHeal, maxHeal;

	public Monster( String name, int hitPoints, int attackSpeed,double chanceToHit, double chanceToHeal,
		int damageMin, int damageMax,int minHeal, int maxHeal)
	{
		
		this.name = name;
		this.hitPoints = hitPoints;
		this.attackSpeed = attackSpeed;
		this.chanceToHit = chanceToHit;
		this.chanceToHeal = chanceToHeal;
		this.damageMin = damageMin;
		this.damageMax = damageMax;
		this.maxHeal = maxHeal;
		this.minHeal = minHeal;
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
			System.out.println(getName() + " was hit for <" + hitPoints + "> points of damage.");
			System.out.println(getName() + " now has " + getHitPoints() + " hit points remaining.");
			System.out.println();
		}

		if (this.hitPoints == 0)
			System.out.println(name + " has been killed :-(");
	}
	//--------------------------------------------
	//End interface methods
	
	//Monsters have a chance to heal each round
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
	
	public void attack(Hero opponent)
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
}