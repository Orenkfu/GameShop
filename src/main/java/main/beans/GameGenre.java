package main.beans;

public enum GameGenre {
	ADVENTURE, RPG, ACTION, FPS, HORROR, SANDBOX, SURVIVAL, MOBA, SPORTS, STRATEGY, PLATFORMER;

	public String getGenreAsString() {

		String firstLetter = this.toString().charAt(0) + "";
		String secondPartial = this.toString().substring(1).toLowerCase();
		return firstLetter + secondPartial;
	}

}
