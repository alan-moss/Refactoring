public interface SpecialAttack
{
	/**
	 * Return the name of the attack to be used by Hero#battleChoices
	 */
	public String getAttackName();

	/**
	 * Called by Hero#specialAttack
	 * @param attacker the Hero that is doing the attack
	 * @param target the monster to be attacked
	 */
	public void doAttack(Hero attacker, DungeonCharacter target);
}
