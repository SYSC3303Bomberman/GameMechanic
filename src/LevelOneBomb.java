
public class LevelOneBomb extends Bomb{

	public LevelOneBomb(Board board, Player player, int x, int y) {
		super(board, player, x, y);
	}

	@Override
	public void explode(){
		this.burn((x + 1), y);
		this.burn((x - 1), y);
		this.burn(x, y);
		this.burn(x, (y + 1));
		this.burn(x, (y - 1));
		player.loadBomb();	// player loads one bomb at the time his bomb explodes
		board.bombs.remove(this);
	}
}
