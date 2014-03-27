
public class FlamePowerUp extends PowerUp{

	public FlamePowerUp(Board board, int x, int y) {
		super(board, x, y);
	}
	
	@Override
	public void powerUp(Player player){
		player.bombsLevel++;
		player.loadBomb();
	}
	
}
