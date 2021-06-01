//Sorceress subclass

public class Sorceress extends Hero {
	
	//Sorceress data fields
	protected static String classType = "Thief";
	protected static int hitPoints = 75;
	protected static int attackSpeed = 5;
	protected static double chanceToHit = 0.7;
	protected static int damageMin = 25;
	protected static int damageMax = 50;
	protected static double chanceToBlock = 0.3;
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

	protected static String specialAttack = "Increase Hit Points";
	
	public Sorceress()
	{
		super(classType, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock, specialAttack);

	}
	
	/**
	 * Returns the special attack name
	 */
	public String specialAttack() {
		return specialAttack;
	}
	
	@Override
	public void attack(Monster opponent)
	{
		System.out.println(name + " casts a spell of fireball at " + opponent.getName() + ":");
		super.attack(opponent);
	}
	
	/**
	 * Sorceress exclusive "attack" (heal). This overrides the special attack from Hero
	 */
	@Override
	public void specialAttack(Monster opponent) {
		int addedHP;

		addedHP = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(addedHP);
		System.out.printf(
			"%s added [%d] points.\n" +
			"Total hit points remaining are: %d\n\n",
			name, addedHP, hitPoints);
	}
}