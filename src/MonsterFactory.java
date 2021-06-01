/*
Monster Factory creates a monster with given attributes
Args: integer number between 1-3
Returns: DungeonCharacter with attributes of Ogre, Gremlin, or Skeleton
Note: Defaults to return Skeleton if given invalid input. Includes random generator method.
*/
public class MonsterFactory 
{
	public DungeonCharacter makeMonster(int num)
	{
		switch(num)
		{
			case 1: return new Monster("Oscar the Ogre", 200, 2, 0.6, 0.1, 30, 50, 30, 50);
			case 2: return new Monster("Gnarltooth the Gremlin", 70, 5, 0.8, 0.4, 15, 30, 20, 40);
			case 3: return new Monster("Sargath the Skeleton", 100, 3, 0.8, 0.3, 30, 50, 30, 50);
			default: return new Monster("Sargath the Skeleton", 100, 3, 0.8, 0.3, 30, 50, 30, 50);
		}
	}

	//Method returns Monster using MonsterFactory
	public Monster makeRandomMonster()
	{
		int num = (int)(Math.random() * 3) + 1;
		return (Monster)makeMonster(num);
	}
}