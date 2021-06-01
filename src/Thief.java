//Theif subclass

public class Thief extends Hero
{
	//Thief data fields
	protected static String classType = "Thief";
	protected static int hitPoints = 75;
	protected static int attackSpeed = 6;
	protected static double chanceToHit = 0.8;
	protected static int damageMin = 20;
	protected static int damageMax = 40;
	protected static double chanceToBlock = 0.5;

	protected static String specialAttack = "Suprise Attack";

	public Thief()
	{
		super(classType, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, chanceToBlock, specialAttack);
	}
	
	//Return the special attack name
	public String specialAttack()
	{
		return specialAttack;
	}
	
	@Override
	//Thief specific attack, Surprise Attack. This overrides the special attack from the super class
	public void specialAttack(Monster opponent)
	{
		double surprise = Math.random();
		if (surprise <= 0.4) {
			System.out.println("Surprise attack was successful!\n" + name + " gets an additional turn.");
			numTurns++;
			attack(opponent);
		} else if (surprise >= .9) {
			System.out.println("Uh oh! " + opponent.getName() + " saw you and" + " blocked your attack!");
		} else
			attack(opponent);
	}
}
