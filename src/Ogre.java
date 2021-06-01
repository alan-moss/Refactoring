//Ogre subclass

public class Ogre extends Monster
{
	//Ogre data fields
	protected static String name = "Oscar the Ogre";
	protected static int hitPoints = 200;
	protected static int attackSpeed = 2;
	protected static double chanceToHit = 0.6;
	protected static double chanceToHeal = 0.1;
	protected static int damageMin = 30;
	protected static int damageMax = 50;
	protected static int minHeal = 30;
	protected static int maxHeal = 50;

	public Ogre()
	{
		super(name, hitPoints, attackSpeed, chanceToHit, chanceToHeal, damageMin, damageMax, minHeal, maxHeal);
	}

	@Override
	public void attack(DungeonCharacter opponent)
	{
		System.out.println(name + " slowly swings a club toward's " + opponent.getName() + ":");
		super.attack(opponent);
	}
}