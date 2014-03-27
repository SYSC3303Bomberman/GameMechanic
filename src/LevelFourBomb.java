
public class LevelFourBomb extends Bomb{

	public LevelFourBomb(Board board, Player player, int x, int y) {
		super(board, player, x, y);
	}

	@Override
	public void explode(){
		this.burn((x + 1), y);
		this.burn((x + 2), y);
		this.burn((x + 3), y);
		this.burn((x + 4), y);
		this.burn((x - 1), y);
		this.burn((x - 2), y);
		this.burn((x - 3), y);
		this.burn((x - 4), y);
		this.burn(x, y);
		this.burn(x, (y + 1));
		this.burn(x, (y + 2));
		this.burn(x, (y + 3));
		this.burn(x, (y + 4));
		this.burn(x, (y - 1));
		this.burn(x, (y - 2));
		this.burn(x, (y - 3));
		this.burn(x, (y - 4));
		player.loadBomb();	// player loads one bomb at the time his bomb explodes
		board.bombs.remove(this);
		this.stop();
	}
}
