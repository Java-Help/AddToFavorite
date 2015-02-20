package ru.javahelp.addtofavorite;

public class Lesson {

	private String title;
	private String text;
	private boolean favorite;
	
	public Lesson(String title, String text) {
		this.title = title;
		this.text = text;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}
	
}