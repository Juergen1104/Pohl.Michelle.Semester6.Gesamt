package P3.src.threads;

import P3.src.game.GamePanel;
import P3.src.game.Maze;
import P3.src.utils.Constants;

//NICHT BEARBEITEN
public class ScoreThread extends Thread {
	private final GamePanel gamePanel;

	public ScoreThread(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	@Override
	public void run() {
		while (gamePanel.gameLoop.running) {
			updateScore();
			checkGameStatus();

			try {
				Thread.sleep(200); // Überprüft regelmäßig den Spielstand
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}

	// Aktualisiert den Spielstand basierend auf den eingesammelten Punkten
	private void updateScore() {
		gamePanel.gameLoop.score = Maze.calculateScore();
	}

	// Prüft, ob Pac-Man alle Leben verloren hat oder alle dots eingesammelt hat
	private void checkGameStatus() {
		// Aufgabe 4 c)
		// TODO: Code hier einfügen
		if (gamePanel.pacMan.getLives() <= 0 || gamePanel.gameLoop.score >= Constants.MAX_SCORE) {
			gamePanel.gameLoop.stopLoop();
			gamePanel.repaint();
		}
	}
}