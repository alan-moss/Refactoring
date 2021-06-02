public class HealSpecial implements SpecialAttack
{
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;

	public HealSpecial()
	{

	}

	public String getAttackName()
	{
		return "Heal";
	}

	public void doAttack(Hero attacker, DungeonCharacter target)
	{
		int addedHP;

		addedHP = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		attacker.addHitPoints(addedHP);
		System.out.printf(
			"%s added %d points (%d points remaining)\n\n",
			attacker.getName(), addedHP, attacker.getHitPoints());
	}
}
