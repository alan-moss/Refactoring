public class SurpriseAttack implements SpecialAttack
{
	protected static final double DEFAULT_MIN = 0.4;
	protected static final double DEFAULT_MAX = 0.9;

	protected String attackName;
	protected double min;
	protected double max;

	public SurpriseAttack(String attackName, double min, double max)
	{
		this.attackName = attackName;
		this.min = min;
		this.max = max;
	}

	public SurpriseAttack(String attackName)
	{
		this.attackName = attackName;
		this.min = DEFAULT_MIN;
		this.max = DEFAULT_MAX;
	}

	public String getAttackName()
	{
		return this.attackName;
	}

	public void doAttack(Hero attacker, DungeonCharacter target)
	{
		double surprise = Math.random();
		if (surprise <= 0.4) {
			// attacker.getName()
			System.out.printf("Surprise attack was successful! %s gets an additional turn.\n", attacker.getName());
			attacker.numTurnsIncrement();
		} else if (surprise >= .9) {
			System.out.println("Uh oh! " + target.getName() + " saw you and" + " blocked your attack!");
		} else {
			attacker.attack(target);
		}
	}
}
