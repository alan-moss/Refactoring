//Skeleton subclass

public class Skeleton extends Monster {
	
	//Skeleton data fields
	protected static String name = "Sargath the Skeleton";
	protected static int hitPoints = 100;
	protected static int attackSpeed = 3;
	protected static double chanceToHit = 0.8;
	protected static double chanceToHeal = 0.3;
	protected static int damageMin = 30;
	protected static int damageMax = 50;
	protected static int minHeal = 30;
	protected static int maxHeal = 50;

	public Skeleton()
	{
		super(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal, maxHeal);
	}

	@Override
	public void attack(Hero opponent)
	{
		System.out.println(name + " slices his rusty blade at " + opponent.getName() + ":");
		super.attack(opponent);
	}
}