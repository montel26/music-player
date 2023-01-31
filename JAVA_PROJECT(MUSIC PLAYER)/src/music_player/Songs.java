package music_player;

public class Songs {
	private String name;
	private double duration;
	
	public Songs(String name, double duration) {
		this.name = name;
		this.duration = duration;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return this.name+ " : "+ this.duration;//faster way to output contents of a object.
	}

}
