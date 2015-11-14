package conway5;

public class WorldState {
	private String world;

	public WorldState(String world) {
		this.world = world;
	}

	public String getWorld() {
		return world;
	}

	public String getCell(int row, int col) {
		return world.split("\n")[row].substring(col, col + 1);
	}
	
	public void replaceWith(String world) {
		this.world = world;
	}
}
