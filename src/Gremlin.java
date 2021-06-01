//Gremlin subclass

public class Gremlin extends Monster
{
	//Gremlin data fields
	protected static String name = "Gnarltooth the Gremlin";
	protected static int hitPoints = 70;
	protected static int attackSpeed = 5;
	protected static double chanceToHit = 0.8;
	protected static double chanceToHeal = 0.4;
	protected static int damageMin = 15;
	protected static int damageMax = 30;
	protected static int minHeal = 20;
	protected static int maxHeal = 40;

	public Gremlin()
	{
		super(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal, maxHeal);
	}

	@Override
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " jabs his kris at " + opponent.getName() + ":");
		super.attack(opponent);
	}
}