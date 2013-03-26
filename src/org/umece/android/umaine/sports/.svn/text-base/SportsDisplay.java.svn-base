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

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SportsDisplay extends Activity {
	public static String results = "bbbbbbbbbbbbb";
	TextView textView;
	ListView myListView;
	String[] titles;
	String[] fullSchedule;
	ArrayAdapter<String[]> myAdapter;
	private static final String SERVER_SCRIPT = "http://mainelyapps.com/umaine/android471/fetchevents.php";
	List<NameValuePair> postParams = new ArrayList<NameValuePair>();
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sportsdisplay);
		
		titles = getResources().getStringArray(R.array.athletics_feeds);
		
		textView = (TextView) findViewById(R.id.text_view);
		postParams.add(new BasicNameValuePair("op","dl"	));
		try {
			String string = httpRequest(postParams).toString();
			fullSchedule = string.split(";");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//textView.setText(showResults());
		textView.setText("test1");
		
	}
	
	/**
	 * Date\tEvent \t\t\tLocation\t\t\tTime Band
	 * 
	 * @param option
	 */
	public void tabChoose(String option) {
		if (option == "allSch") {
			// modifyString("allSch");
			
			results = "10/01 \tPresident's Event \t\tCCA\t\t\t6:00PM\n"
					+ "10/03 \tHockey \t\t\t\tAlfond\t\t\t4:00PM\n"
					+ "10/08 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "10/09 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "10/22 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "10/23 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "11/12 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "11/13 \tWomens Basketball \tAlfond\t\t\t12:00PM\n"
					+ "11/13 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "11/18 \tMens Basketball \t\tAlfond\t\t\tTBA\n"
					+ "11/23 \tWomens Basketball \tAlfond\t\t\t7:00PM\n"
					+ "11/27 \tWomens Basketball \tAlfond\t\t\tTBA\n"
					+ "12/04 \tMens Basketball \t\tAlfond\t\t\t2:00PM\n"
					+ "12/06 \tMens Basketball \t\tAlfond\t\t\t7:30PM\n"
					+ "12/10 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "12/12 \tMens Basketball \t\tPit\t\t\t\t12:00PM\n"
					+ "12/12 \tHockey \t\t\t\tAlfond\t\t\t4:00PM\n"
					+ "12/19 \tMens Basketball \t\tAlfond\t\t\t2:00PM\n"
					+ "01/02 \tMens Basketball \t\tAlfond\t\t\tTBA\n"
					+ "01/05 \tMens Basketball \t\tAlfond\t\t\t7:00PM\n"
					+ "01/09 \tWomens Basketball \tAlfond\t\t\t12:00PM\n"
					+ "01/12 \tWomens Basketball \tAlfond\t\t\t7:30PM\n"
					+ "01/14 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "01/15 \tWomens Basketball \tAlfond\t\t\t1:00PM\n"
					+ "01/15 \tMens Basketball \t\tAlfond\t\t\t3:00PM\n"
					+ "01/16 \tHockey \t\t\t\tAlfond \t\t\t4:00PM\n"
					+ "01/22 \tMens Basketball \t\tAlfond(Band Day)7:00PM\n"
					+ "01/23 \tWomens Basketball \tAlfond\t\t\t1:00PM\n"
					+ "01/25 \tMens Basketball \t\tAlfond\t\t\t7:00PM\n"
					+ "01/26 \tWomens Basketball \tAlfond\t\t\t7:00PM\n"
					+ "01/28 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "01/29 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "02/01 \tWomens Basketball \tAlfond\t\t\t7:00PM\n"
					+ "02/06 \tMens Basketball \t\tAlfond\t\t\t2:00PM\n"
					+ "02/08 \tWomens Basketball \tAlfond\t\t\t7:00PM\n"
					+ "02/11 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "02/12 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "02/16 \tMens Basketball \t\tAlfond\t\t\t7:30PM\n"
					+ "02/20 \tWomens Basketball \tAlfond\t\t\t1:00PM\n"
					+ "02/21 \tOpen House \t\t\tCCA \t\t\t8:30AM\n"
					+ "02/25 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "02/26 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "02/27 \tMens Basketball \t\tAlfond\t\t\t2:00PM\n"
					+ "03/11-03/13\n\t\tHockey East Quarter Finals TBD\t\tTBD\n"
					+ "03/18-03/19\n\t\tHockey East Finals\t\tBoston \t\tTBD\n"
					+ "03/25-03/27\n\t\tHockey NCAA Regionals	TBD\t\tTBD\n"
					+ "04/07-04/09\n\t\tHockey Frozen Four\tSt. Paul, MN \tTBD";
			textView.setText(results);
		} else if (option == "hockeySch") {
			// modifyString("hockeySch");
			results = "10/03 \tHockey \t\t\t\tAlfond\t\t\t4:00PM\n"
					+ "10/08 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "10/09 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "10/22 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "10/23 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "11/12 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "11/13 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "12/10 \tHockey \t\t\t\tAlfond\t\t\t7:00PM\n"
					+ "12/12 \tHockey \t\t\t\tAlfond\t\t\t4:00PM\n"
					+ "01/14 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "01/16 \tHockey \t\t\t\tAlfond \t\t\t4:00PM\n"
					+ "01/28 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "01/29 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "02/11 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "02/12 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "02/25 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "02/26 \tHockey \t\t\t\tAlfond \t\t\t7:00PM\n"
					+ "03/11-03/13\n\t\tHockey East Quarter Finals TBD\t\tTBD\n"
					+ "03/18-03/19\n\t\tHockey East Finals\t\tBoston \t\tTBD\n"
					+ "03/25-03/27\n\t\tHockey NCAA Regionals	TBD\t\tTBD\n"
					+ "04/07-04/09\n\t\tHockey Frozen Four\tSt. Paul, MN \tTBD";
			textView.setText(results);
		} else if (option == "basketballSch") {
			results = "11/13 \tWomens Basketball \tAlfond\t\t\t12:00PM\n"
					+ "11/18 \tMens Basketball \t\tAlfond\t\t\tTBA\n"
					+ "11/23 \tWomens Basketball \tAlfond\t\t\t7:00PM\n"
					+ "11/27 \tWomens Basketball \tAlfond\t\t\tTBA\n"
					+ "12/04 \tMens Basketball \t\tAlfond\t\t\t2:00PM\n"
					+ "12/06 \tMens Basketball \t\tAlfond\t\t\t7:30PM\n"
					+ "12/12 \tMens Basketball \t\tPit\t\t\t\t12:00PM\n"
					+ "12/19 \tMens Basketball \t\tAlfond\t\t\t2:00PM\n"
					+ "01/02 \tMens Basketball \t\tAlfond\t\t\tTBA\n"
					+ "01/05 \tMens Basketball \t\tAlfond\t\t\t7:00PM\n"
					+ "01/09 \tWomens Basketball \tAlfond\t\t\t12:00PM\n"
					+ "01/12 \tWomens Basketball \tAlfond\t\t\t7:30PM\n"
					+ "01/15 \tWomens Basketball \tAlfond\t\t\t1:00PM\n"
					+ "01/15 \tMens Basketball \t\tAlfond\t\t\t3:00PM\n"
					+ "01/22 \tMens Basketball \t\tAlfond(Band Day)7:00PM\n"
					+ "01/23 \tWomens Basketball \tAlfond\t\t\t1:00PM\n"
					+ "01/25 \tMens Basketball \t\tAlfond\t\t\t7:00PM\n"
					+ "01/26 \tWomens Basketball \tAlfond\t\t\t7:00PM\n"
					+ "02/01 \tWomens Basketball \tAlfond\t\t\t7:00PM\n"
					+ "02/06 \tMens Basketball \t\tAlfond\t\t\t2:00PM\n"
					+ "02/08 \tWomens Basketball \tAlfond\t\t\t7:00PM\n"
					+ "02/16 \tMens Basketball \t\tAlfond\t\t\t7:30PM\n"
					+ "02/20 \tWomens Basketball \tAlfond\t\t\t1:00PM\n"
					+ "02/27 \tMens Basketball \t\tAlfond\t\t\t2:00PM\n";
			textView.setText(results);
		} else if (option == "othersSch") {
			myListView = (ListView) findViewById(R.id.list_view);
			myAdapter.add(fullSchedule);
			myListView.setAdapter(myAdapter);
			setContentView(myListView);
			
//			results = "10/01 \tPresident's Event \t\tCCA\t\t\t6:00PM\n"
//					+ "02/21 \tOpen House \t\t\tCCA \t\t\t8:30AM\n";
			
			
//			myListView.setOnItemClickListener(new OnItemClickListener() {
//				 
//			    @Override
//			    public void onItemClick(AdapterView<?> parent, View view,
//			            int position, long id) {
//			    			//Parse sports for selected sport
//			    }
//			});
		}
		
//		textView.setText(results);
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

/*	public static String showResults() {

		return results;
	}*/
}
