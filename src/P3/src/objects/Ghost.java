package P3.src.objects;

import P3.src.utils.Constants;
import P3.src.utils.GhostColor;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Aufgaben #1c 
public class Ghost extends GameEntity {

	private GhostColor color;
	private BufferedImage image;

	public Ghost(int x, int y, GhostColor color) {
		super(x, y);
		this.color = color;
		loadImage(); // Bild mit Geist in zugehöriger Farbe laden
	}

	// Lädt das entsprechende Bild für einen Geist, basierend auf dessen Farbe
	private void loadImage() {
		// Aufagbe 1 c)
		// TODO: Code hier einfügen
		String path = "";

		switch (color) {
			case GhostColor.RED:
				path = "src/P3/resources/redGhost.png";
				break;
			case GhostColor.BLUE:
				path = "src/P3/resources/blueGhost.png";
				break;
			case GhostColor.PINK:
				path = "src/P3/resources/pinkGhost.png";
				break;
			case GhostColor.ORANGE:
				path = "src/P3/resources/orangeGhost.png";
				break;
			default:
				path = "resources/ghost_default.png"; // Optionales Fallback-Bild
		}

		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void drawGhosts(Graphics2D g2) {
		// Aufagbe 1 c)
		// TODO: Code hier einfügen
		int xPixel = getX() * Constants.TILE_SIZE;
		int yPixel = getY() * Constants.TILE_SIZE;

		if (image != null) {
			g2.drawImage(image, xPixel, yPixel, Constants.TILE_SIZE, Constants.TILE_SIZE, null);
		}
	}

	// Getter und Setter
	public BufferedImage getImage() {
		return image;
	}

	public GhostColor getColor() {
		return color;
	}

	public void setColor(GhostColor color) {
		this.color = color;
	}
}