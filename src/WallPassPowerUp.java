
public class WallPassPowerUp extends PowerUp{

	public WallPassPowerUp(Board board, int x, int y) {
		super(board, x, y);
	}
	
	@Override
	public void powerUp(Player player){
		player.wallPass = true;
	}
}
