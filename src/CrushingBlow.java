public class CrushingBlow implements SpecialAttack
{
	public CrushingBlow()
	{

	}

	public String getAttackName()
	{
		return "Crushing blow";
	}

	public void doAttack(Hero attacker, DungeonCharacter target)
	{
		if (Math.random() <= .4) {
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.printf("%s lands a CRUSHING BLOW for %d damage.\n\n", attacker.getName(), blowPoints);
			target.subtractHitPoints(blowPoints);
		} else {
			System.out.printf("%s failed to land a crushing blow.\n\n", attacker.getName());
		}
	}
}
