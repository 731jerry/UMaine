package org.umece.android.umaine;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class AthleticsFeeds extends ListActivity {
	ListView myListView;
	String[] titles;
	String[] urls;
	ListAdapter myAdapter;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		myListView = getListView();
		setContentView(myListView);
		titles = getResources().getStringArray(R.array.athletics_feeds);
		urls = getResources().getStringArray(R.array.athletics_links);
		setListAdapter(ArrayAdapter.createFromResource(getApplicationContext(), R.array.athletics_feeds, R.layout.newslistitem));
		
		myListView.setOnItemClickListener(new OnItemClickListener() {
			 
		    @Override
		    public void onItemClick(AdapterView<?> parent, View view,
		            int position, long id) {
			    Intent intent = new Intent().setClass(getApplicationContext(), PopulateRSS.class);
			    intent.putExtra("URL", urls[position]);
			    intent.putExtra("caption", "UMaine Athletics");
			    intent.putExtra("contentOn", false);
			    startActivity(intent);
		    }
		});
	}
}