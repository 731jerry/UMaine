package org.umece.android.umaine;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

public class ShowNewsItem extends Activity {

	SingleNewsItem newsItem;
	WebView webview;
	TextView title;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news);
		
		Bundle extras = getIntent().getExtras();
		
		String pubDate = extras.getString("pubDate");
		String pubTitle = extras.getString("title");
		String description = extras.getString("description");
		String link = extras.getString("link");
		boolean contentOn = extras.getBoolean("contentOn");
		
		if (contentOn){
			String content = extras.getString("content");
			newsItem = new SingleNewsItem(pubDate,
					pubTitle,
					description,
					link,
					content);
		}else{
			newsItem = new SingleNewsItem(pubDate,
					pubTitle,
					description,
					link);
		}
		
		title = (TextView) findViewById(R.id.textTitle);
		webview = (WebView) findViewById(R.id.webNews);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
		title.setText(newsItem.getTitle());
		
		if (contentOn){
			String html = "<?xml version='1.0' encoding='utf-8'?><html><body bgcolor=\"#000000\"><font color=\"#999999\">" + newsItem.getContent().toString() + "</font></body></html>";
			webview.loadData(html, "text/html", "utf-8");
		}else{
			webview.loadUrl(newsItem.getLink());
		}

//        final Button btnClose = (Button) findViewById(R.id.btnClose);
//        btnClose.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Perform action on click
//            	finish();
//            }
//        });
//
//        final Button btnMore = (Button) findViewById(R.id.btnMore);
//        btnMore.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Perform action on click
//				Intent webIntent = new Intent(Intent.ACTION_VIEW,  Uri.parse(newsItem.getLink()) );
//				startActivity(webIntent);
//            }
//        });
		
		String currTime = android.text.format.DateFormat.format(
				"yyyy-MM-dd hh:mm:ss", new java.util.Date()).toString();
		this.setTitle("UMaine News " + currTime);
	}
}
