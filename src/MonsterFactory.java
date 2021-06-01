/**
 * MonsterFactory is used for creating monsters
 */
public class MonsterFactory 
{
	public static final int ogre = 1;
	public static final int gremlin = 2;
	public static final int skeleton = 3;
	/**
	 * Creates a monster based on the given number
	 * @param num 1: Ogre, 2: Gremlin, 3: Skeleton. Skeleton is used if an invalid number is given
	 * @return the created monster
	 */
	public static DungeonCharacter makeMonster(int num)
	{
		switch(num)
		{
			case MonsterFactory.ogre: return new Monster("Oscar the Ogre", 200, 2, 0.6, 0.1, 30, 50, 30, 50);
			case MonsterFactory.gremlin: return new Monster("Gnarltooth the Gremlin", 70, 5, 0.8, 0.4, 15, 30, 20, 40);
			case MonsterFactory.skeleton: return new Monster("Sargath the Skeleton", 100, 3, 0.8, 0.3, 30, 50, 30, 50);
			default: return new Monster("Sargath the Skeleton", 100, 3, 0.8, 0.3, 30, 50, 30, 50);
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