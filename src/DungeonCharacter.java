public interface DungeonCharacter
{
	public String getName();

	public int getHitPoints();

	public int getAttackSpeed();
	
	public boolean isAlive();
	
	public void addHitPoints(int hitPoints);
	
	public void subtractHitPoints(int hitPoints);

	public void attack(DungeonCharacter opponent);

	public void battleChoices(DungeonCharacter opponent);

}