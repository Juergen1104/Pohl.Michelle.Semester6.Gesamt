package P4.src.main;

import P4.src.server.ServerUI;

public class ServerMain {
	public static void main(String[] args) {
		ServerUI serverUI = ServerUI.getInstance();
		serverUI.setVisible(true);
	}
}