package org.umece.android.umaine;

import android.app.TabActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class RSSActivity extends TabActivity {
	String campusURL = "http://www.umaine.edu/news/feed/";

    /** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.newslist);
	    
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Reusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, PopulateRSS.class);
	    intent.putExtra("URL", campusURL);
	    intent.putExtra("caption", "Campus News");
	    intent.putExtra("contentOn", true);

	    // Initialize a TabSpec for each tab and add it to the TabHost 
	    spec = tabHost.newTabSpec("campus").setIndicator("Campus").setContent(intent);
	    tabHost.addTab(spec);
	    

	    intent = new Intent().setClass(this, AthleticsFeeds.class);
	    spec = tabHost.newTabSpec("athletics").setIndicator("Athletics").setContent(intent);
	    tabHost.addTab(spec);

	    tabHost.setCurrentTab(0);
	}
}