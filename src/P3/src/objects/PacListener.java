package P3.src.objects;

import P3.src.game.GameLoop;
import P3.src.utils.Direction;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// Aufgaben #2a 
public class PacListener extends KeyAdapter {
	private final PacMan pacMan;
	private final GameLoop gameLoop;


	public PacListener(GameLoop gameLoop, PacMan pacMan) {
		this.gameLoop = gameLoop;
		this.pacMan = pacMan;

	}
	private boolean hasMoved = false;
	// Aufgabe #2a Listener implementieren
	// TODO: Code hier einfügen
	private Direction getDirectionFromKey(int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_UP: return Direction.UP;
			case KeyEvent.VK_DOWN: return Direction.DOWN;
			case KeyEvent.VK_LEFT: return Direction.LEFT;
			case KeyEvent.VK_RIGHT: return Direction.RIGHT;
			default: return null;
		}
	}

	private boolean keyUnequalsDirection(KeyEvent e) {
		Direction newDir = getDirectionFromKey(e.getKeyCode());
		return newDir != null && newDir != pacMan.getDirection();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (gameLoop.paused) {
			gameLoop.resumeGame();
		}

		if (keyUnequalsDirection(e)) {
			Direction dir = getDirectionFromKey(e.getKeyCode());
			if (dir != null && pacMan.isValidMove(dir)) {
				pacMan.setDirection(dir);
				pacMan.move(dir);
				hasMoved = true;
			}
		}
	}

	public boolean hasMoved() {
		return hasMoved;
	}
	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}