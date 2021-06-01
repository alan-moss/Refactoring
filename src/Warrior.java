//Warrior subclass

public class Warrior extends Hero {
	
	//Warrior data fields
	protected static String classType = "Warrior";
	protected static int hitPoints = 125;
	protected static int attackSpeed = 4;
	protected static double chanceToHit = 0.8;
	protected static int damageMin = 35;
	protected static int damageMax = 60;
	protected static double chanceToBlock = 0.2;

	protected static String specialAttack = "Crushing Blow";

	public Warrior()
	{
		super(classType, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock, specialAttack);
	}
	
	//Return the special attack name
	public String specialAttack()
	{
		return specialAttack;
	}
	
	@Override
	public void specialAttack(Monster opponent)
	{
		if (Math.random() <= .4) {
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(name + " lands a CRUSHING BLOW for " + blowPoints + " damage!");
			opponent.subtractHitPoints(blowPoints);
		} else {
			System.out.println(name + " failed to land a crushing blow");
			System.out.println();
		}
	}
	
	@Override
	public void attack(Monster opponent)
	{
		System.out.println(name + " swings a mighty sword at " +opponent.getName() + ":");
		super.attack(opponent);
	}
}