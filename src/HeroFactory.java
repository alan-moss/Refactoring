/**
 * MonsterFactory is used for creating monsters
 */
public class HeroFactory 
{
	// Warrior constants
	public static final int WARRIOR_ID = 1;
	public static final String WARRIOR_CLASS_NAME = "Warrior";
	public static final int WARRIOR_HP = 125;
	public static final int WARRIOR_ATTACK_SPEED = 4;
	public static final double WARRIOR_HIT_CHANCE = 0.8;
	public static final int WARRIOR_MIN_DAMAGE = 35;
	public static final int WARRIOR_MAX_DAMAGE = 60;
	public static final double WARRIOR_BLOCK_CHANCE = 0.2;
	public static final String WARRIOR_SPECIAL_ATTACK = "Crushing Blow";

	// Sorceress constants
	public static final int SORCERESS_ID = 2;
	public static final String SORCERESS_CLASS_NAME = "Sorceress";
	public static final int SORCERESS_HP = 75;
	public static final int SORCERESS_ATTACK_SPEED = 5;
	public static final double SORCERESS_HIT_CHANCE = 0.7;
	public static final int SORCERESS_MIN_DAMAGE = 25;
	public static final int SORCERESS_MAX_DAMAGE = 50;
	public static final double SORCERESS_BLOCK_CHANCE = 0.3;
	public static final String SORCERESS_SPECIAL_ATTACK = "Increase Hit Points";

	// Thief constants
	public static final int THIEF_ID = 3;
	public static final String THIEF_CLASS_NAME = "Thief";
	public static final int THIEF_HP = 75;
	public static final int THIEF_ATTACK_SPEED = 6;
	public static final double THIEF_HIT_CHANCE = 0.8;
	public static final int THIEF_MIN_DAMAGE = 20;
	public static final int THIEF_MAX_DAMAGE = 40;
	public static final double THIEF_BLOCK_CHANCE = 0.5;
	public static final String THIEF_SPECIAL_ATTACK = "Surprise Attack";

	/**
	 * Creates a hero based on the given number
	 * @param num 1: Warrior, 2: Sorceress, 3: Thief. Thief is used if an invalid number is given
	 * @return the created hero
	 */
	public static DungeonCharacter makeHero(int num)
	{
		switch(num)
		{
			case WARRIOR_ID: return new Hero(
				WARRIOR_CLASS_NAME,
				WARRIOR_HP,
				WARRIOR_ATTACK_SPEED,
				WARRIOR_HIT_CHANCE,
				WARRIOR_MIN_DAMAGE,
				WARRIOR_MAX_DAMAGE,
				WARRIOR_BLOCK_CHANCE,
				WARRIOR_SPECIAL_ATTACK);

			case SORCERESS_ID: return new Hero(
				SORCERESS_CLASS_NAME,
				SORCERESS_HP,
				SORCERESS_ATTACK_SPEED,
				SORCERESS_HIT_CHANCE,
				SORCERESS_MIN_DAMAGE,
				SORCERESS_MAX_DAMAGE,
				SORCERESS_BLOCK_CHANCE,
				SORCERESS_SPECIAL_ATTACK);

			case THIEF_ID: return new Hero(
				THIEF_CLASS_NAME,
				THIEF_HP,
				THIEF_ATTACK_SPEED,
				THIEF_HIT_CHANCE,
				THIEF_MIN_DAMAGE,
				THIEF_MAX_DAMAGE,
				THIEF_BLOCK_CHANCE,
				THIEF_SPECIAL_ATTACK);

			//If invalid input, return thief
			default: System.out.println("invalid choice, returning Thief");
			return new Hero(
				THIEF_CLASS_NAME,
				THIEF_HP,
				THIEF_ATTACK_SPEED,
				THIEF_HIT_CHANCE,
				THIEF_MIN_DAMAGE,
				THIEF_MAX_DAMAGE,
				THIEF_BLOCK_CHANCE,
				THIEF_SPECIAL_ATTACK);
		}
	}
}
