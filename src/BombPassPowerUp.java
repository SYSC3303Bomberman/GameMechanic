
public class BombPassPowerUp extends PowerUp{

	public BombPassPowerUp(Board board, int x, int y) {
		super(board, x, y);
	}
	
	@Override
	public void powerUp(Player player){
		player.bombPass = true;
	}
}
