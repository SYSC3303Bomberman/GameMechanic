
public class Balloom extends Enemy{

	public Balloom(Board board, int x, int y) {
		super(board, x, y);
		this.life = 1;
		this.wallPass = false;
	}

}
