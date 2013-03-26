package org.umece.android.umaine.sports;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.umece.android.umaine.R;

import android.app.ActivityGroup;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class UMSports extends ActivityGroup {

	public static final int TEXT_SIZE = 10;

	public static TabHost tab_host;
	public static final int update = Menu.FIRST;
	public static final int help = Menu.FIRST + 1;
	String[] data;
	String rawData;
	static String SERVER_SCRIPT = "http://mainelyapps.com/umaine/android471/FetchEvents.php";

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sprots_activity_sch_main); 
		this.setTitleColor(Color.BLUE); 
		
		List<NameValuePair> postParams = new ArrayList<NameValuePair>();
		postParams.add(new BasicNameValuePair("op", "dl"));
		
	    try {
			rawData = httpRequest(postParams).toString();
			data = rawData.split(";|,");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		TabHost tab_host = (TabHost) findViewById(R.id.sports_tab_host);
		tab_host.setup(this.getLocalActivityManager());

		
		TabSpec ts1 = tab_host.newTabSpec("all_sch");
		ts1.setIndicator(("All Sch"),
			getResources().getDrawable(R.drawable.sports_all_sch));
		Intent in1 = new Intent(this, SportsDisplaySchAll.class);
		in1.putExtra("data", data);
		ts1.setContent(in1);

		TabSpec ts2 = tab_host.newTabSpec("sports_sch");
		ts2.setIndicator(("Sports"),
				getResources().getDrawable(R.drawable.sports_others_sch));
		Intent in2 = new Intent(this, SportsDisplaySchOthersNew.class);
		in2.putExtra("data", data);
		ts2.setContent(in2);
		

	    tab_host.addTab(ts1);
	    tab_host.addTab(ts2);
	    
	    tab_host.getTabWidget().getChildAt(0).setBackgroundColor(Color.parseColor("#ffb0d7ff"));
	    tab_host.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#ffb0d7ff"));
	}



	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, update, 0, "Update");
		// menu.add(0,help,1,"Help");
		return super.onCreateOptionsMenu(menu);

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case update:
			// here is the function of update
			break;
		/*
		 * case help: // here is the function of help break;
		 */
		}
		return super.onOptionsItemSelected(item);
	}
	
	public static List<String> httpRequest(List<? extends NameValuePair> postParams)
			throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpPost request = new HttpPost(SERVER_SCRIPT);
		List<String> ret = new ArrayList<String>();

		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(postParams);

		request.setEntity(formEntity);
		HttpResponse response = client.execute(request);
		BufferedReader in = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));

		String line = "";
		while ((line = in.readLine()) != null) {
			ret.add(line);
		}

		in.close();

		return ret;
	}
	
}