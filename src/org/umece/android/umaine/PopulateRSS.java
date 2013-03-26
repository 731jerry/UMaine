package org.umece.android.umaine;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;
import android.text.Html;

public class PopulateRSS extends ListActivity {	
	ArrayList<SingleNewsItem> newsList;
	String urlAddress;
	String urlCaption;
	boolean contentOn;
	SingleNewsItem selectedNewsItem;
	Context context;
	ListView myListView;
	protected NewsListAdapter aaNews;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		myListView = getListView();
		setContentView(myListView);
		
		newsList = new ArrayList<SingleNewsItem>();
		urlAddress = getIntent().getStringExtra("URL");
		urlCaption = getIntent().getStringExtra("caption");
		contentOn = getIntent().getBooleanExtra("contentOn", false);
		context = getApplication();
	
		myListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> _av, View _v, int _index, long _id) {
				selectedNewsItem = newsList.get(_index);
				Intent intent = new Intent(PopulateRSS.this, ShowNewsItem.class);
				intent.putExtra("title", selectedNewsItem.getTitle());
				intent.putExtra("description", selectedNewsItem.getDescription());
				intent.putExtra("link", selectedNewsItem.getLink());
				intent.putExtra("pubDate", selectedNewsItem.getPubDate());
				intent.putExtra("contentOn", contentOn);
				if (contentOn){
					intent.putExtra("content", selectedNewsItem.getContent());
				}
				startActivity(intent);
			}
		});	
	}
	
	@Override
	protected void onResume() {
		//Toast.makeText(context, "onResume!", Toast.LENGTH_SHORT).show();
	
		super.onResume();
		try {
			newsList.clear();
			URL url = new URL(urlAddress);
			URLConnection connection;
			connection = url.openConnection();
			HttpURLConnection httpConnection = (HttpURLConnection) connection;
			int responseCode = httpConnection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				//Toast.makeText(context, "Got Response!", Toast.LENGTH_SHORT).show();
				InputStream in = httpConnection.getInputStream();
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document dom = builder.parse(in);
				Element root = dom.getDocumentElement();
				// NodeList properties = root.getElementsByTagName("entry");
				NodeList properties = root.getElementsByTagName("item");
				if ((properties != null) && (properties.getLength() > 0)) {
					for (int i = 0; i < properties.getLength(); i++) {
						dissectNode(properties, i);
					}// for
				}// if
			}// if
			aaNews = new NewsListAdapter(this, newsList);
			myListView.setAdapter(aaNews);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			Toast.makeText(context, "Trouble!!!", 1).show();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}// onResume
	
	public void dissectNode(NodeList properties, int i) {
		try {
			Element entry = (Element) properties.item(i);
			Element title = (Element) entry.getElementsByTagName("title").item(0);
			Element description = (Element) entry.getElementsByTagName("description").item(0);
			Element pubDate = (Element) entry.getElementsByTagName("pubDate").item(0);
			Element link = (Element) entry.getElementsByTagName("link").item(0);
			String titleValue = title.getFirstChild().getNodeValue();
			String descriptionValue = Html.fromHtml(description.getFirstChild().getNodeValue()).toString();
			String dateValue = pubDate.getFirstChild().getNodeValue();
			String linkValue = link.getFirstChild().getNodeValue();
			SingleNewsItem singleItem;
			
			if (contentOn){
				Element content = (Element) entry.getElementsByTagName("content:encoded").item(0);
				String contentValue = content.getFirstChild().getNodeValue();
				singleItem = new SingleNewsItem(dateValue,
						titleValue, descriptionValue, linkValue, contentValue);
			}else{
				singleItem = new SingleNewsItem(dateValue,
						titleValue, descriptionValue, linkValue);
			}
			
			newsList.add(singleItem);
		} catch (DOMException e) {
			e.printStackTrace();
		}
	}// dissectNode
}