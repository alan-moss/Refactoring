/**
 * MonsterFactory is used for creating monsters
 */
public class MonsterFactory 
{

	// Ogre constants
	public static final int OGRE_ID = 1;
	public static final String OGRE_CLASS_NAME = "Oscar the Ogre";
	public static final int OGRE_HP = 200;
	public static final int OGRE_ATTACK_SPEED = 2;
	public static final String OGRE_ATTACK_STRING = "%s slowly swings a club toward's %s.\n";
	public static final double OGRE_HIT_CHANCE = 0.6;
	public static final double OGRE_HEAL_CHANCE = 0.1;
	public static final int OGRE_MIN_DAMAGE = 30;
	public static final int OGRE_MAX_DAMAGE = 50;
	public static final int OGRE_MIN_HEAL = 30;
	public static final int OGRE_MAX_HEAL = 50;

	// Gremlin constants
	public static final int GREMLIN_ID = 2;
	public static final String GREMLIN_CLASS_NAME = "Gnarltooth the Gremlin";
	public static final int GREMLIN_HP = 70;
	public static final int GREMLIN_ATTACK_SPEED = 5;
	public static final String GREMLIN_ATTACK_STRING = "%s jabs his kris at %s.\n";
	public static final double GREMLIN_HIT_CHANCE = 0.8;
	public static final double GREMLIN_HEAL_CHANCE = 0.4;
	public static final int GREMLIN_MIN_DAMAGE = 15;
	public static final int GREMLIN_MAX_DAMAGE = 30;
	public static final int GREMLIN_MIN_HEAL = 20;
	public static final int GREMLIN_MAX_HEAL = 40;

	// Skeleton constants
	public static final int SKELETON_ID = 3;
	public static final String SKELETON_CLASS_NAME = "Sargath the Skeleton";
	public static final int SKELETON_HP = 100;
	public static final int SKELETON_ATTACK_SPEED = 3;
	public static final String SKELETON_ATTACK_STRING = "%s slices his rusty blade at %s.\n";
	public static final double SKELETON_HIT_CHANCE = 0.8;
	public static final double SKELETON_HEAL_CHANCE = 0.3;
	public static final int SKELETON_MIN_DAMAGE = 30;
	public static final int SKELETON_MAX_DAMAGE = 50;
	public static final int SKELETON_MIN_HEAL = 30;
	public static final int SKELETON_MAX_HEAL = 50;


	/**
	 * Creates a monster based on the given number
	 * @param num 1: Ogre, 2: Gremlin, 3: Skeleton. Skeleton is used if an invalid number is given
	 * @return the created monster
	 */
	public static DungeonCharacter makeMonster(int num)
	{
		switch(num)
		{
			case OGRE_ID: return new Monster(
				OGRE_CLASS_NAME,
				OGRE_HP,
				OGRE_ATTACK_SPEED,
				OGRE_ATTACK_STRING,
				OGRE_HIT_CHANCE,
				OGRE_HEAL_CHANCE,
				OGRE_MIN_DAMAGE,
				OGRE_MAX_DAMAGE,
				OGRE_MIN_HEAL,
				OGRE_MAX_HEAL);

			case GREMLIN_ID: return new Monster(
				GREMLIN_CLASS_NAME,
				GREMLIN_HP,
				GREMLIN_ATTACK_SPEED,
				GREMLIN_ATTACK_STRING,
				GREMLIN_HIT_CHANCE,
				GREMLIN_HEAL_CHANCE,
				GREMLIN_MIN_DAMAGE,
				GREMLIN_MAX_DAMAGE,
				GREMLIN_MIN_HEAL,
				GREMLIN_MAX_HEAL);

			case SKELETON_ID: return new Monster(
				SKELETON_CLASS_NAME,
				SKELETON_HP,
				SKELETON_ATTACK_SPEED,
				SKELETON_ATTACK_STRING,
				SKELETON_HIT_CHANCE,
				SKELETON_HEAL_CHANCE,
				SKELETON_MIN_DAMAGE,
				SKELETON_MAX_DAMAGE,
				SKELETON_MIN_HEAL,
				SKELETON_MAX_HEAL);

			default: return new Monster(
				SKELETON_CLASS_NAME,
				SKELETON_HP,
				SKELETON_ATTACK_SPEED,
				SKELETON_ATTACK_STRING,
				SKELETON_HIT_CHANCE,
				SKELETON_HEAL_CHANCE,
				SKELETON_MIN_DAMAGE,
				SKELETON_MAX_DAMAGE,
				SKELETON_MIN_HEAL,
				SKELETON_MAX_HEAL);
		}
	}

	/**
	 * Uses makeMonster to return a random Monster
	 * @return an Ogre, a Gremlin, or a Skeleton
	 */
	public static Monster makeRandomMonster()
	{
		int num = (int)(Math.random() * 3) + 1;
		return (Monster)makeMonster(num);
	}
}