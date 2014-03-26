
public class BombPowerUp extends PowerUp{

	public BombPowerUp(Board board, int x, int y) {
		super(board, x, y);
	}
	
	@Override
	public void powerUp(Player player){
		player.bombsMaxNumber++;
		player.loadBomb();
	}

}
