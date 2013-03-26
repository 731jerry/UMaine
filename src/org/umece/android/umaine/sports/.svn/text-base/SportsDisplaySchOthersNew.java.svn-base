package org.umece.android.umaine.sports;

import org.umece.android.umaine.R;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter; 
import android.widget.ListAdapter;
import android.widget.ListView;

public class SportsDisplaySchOthersNew extends ListActivity {
	
	ListView myListView;
	String[] titles;

	ListAdapter myAdapter;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		myListView = getListView();
		titles = getResources().getStringArray(R.array.sports_schedule);
		setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(), R.array.sports_schedule, R.layout.newslistitem));
	}
}
