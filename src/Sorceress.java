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
	
	//Return the special attack name
	public String specialAttack() {
		return specialAttack;
	}
	
	@Override
	public void attack(Monster opponent)
	{
		System.out.println(name + " casts a spell of fireball at " + opponent.getName() + ":");
		super.attack(opponent);
	}
	
	@Override
	//Thief specific attack, Surprise Attack. This overrides the special attack from the super class
	public void specialAttack(Monster opponent) {
		
		int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
		System.out.println(name + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ hitPoints);
		 System.out.println();

	}
}