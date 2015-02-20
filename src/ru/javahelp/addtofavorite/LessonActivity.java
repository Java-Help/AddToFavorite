package ru.javahelp.addtofavorite;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class LessonActivity extends Activity{

	private Lesson lesson;
	private int position = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lesson);
		
		if (getIntent() != null) {
			position = getIntent().getIntExtra("position", -1);
		}
		
		lesson = MainActivity.lessonsList.get(position);
		
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		MenuItem fave = menu.findItem(R.id.menu_item_is_favorite);
		MenuItem unfave = menu.findItem(R.id.menu_item_no_favorite);

		if (lesson != null) {
			fave.setVisible(lesson.isFavorite());
			unfave.setVisible(!lesson.isFavorite());
		} else {
			fave.setVisible(false);
			unfave.setVisible(false);
		}
		return true;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.lesson, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.menu_item_no_favorite:
			setFavorite(true);
			return true;

		case R.id.menu_item_is_favorite:
			setFavorite(false);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	void setFavorite(boolean isFavorite) {
		lesson.setFavorite(isFavorite);
		invalidateOptionsMenu();
	}
	
}
