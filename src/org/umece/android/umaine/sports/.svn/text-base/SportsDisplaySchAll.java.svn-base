package org.umece.android.umaine.sports;

import org.umece.android.umaine.R;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

public class SportsDisplaySchAll extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.sprots_activity_sch_all);
		
		Bundle extras = getIntent().getExtras();
		String[] data = (String[]) extras.get("data");
		String time = null;
		   TableLayout tl = (TableLayout) findViewById(R.id.myTableLayout);
		   int current = 0;
		   while((current + 6)<=data.length){
			   TableRow tr = new TableRow(this);
			   tr.setId(data.length+current);
			   tr.setLayoutParams(new LayoutParams(
					   LayoutParams.FILL_PARENT,
					   LayoutParams.WRAP_CONTENT));
			   
			   TextView labelDate = new TextView(this);
			   labelDate.setId(++current);
			   labelDate.setText(data[current].toString().trim() + ", " + data[++current].toString().trim());
			   labelDate.setTextColor(Color.BLACK);
			   labelDate.setTextSize(10);
			   labelDate.setLayoutParams(new LayoutParams(
					   LayoutParams.FILL_PARENT,
					   LayoutParams.WRAP_CONTENT));
			   

			   time = "\t" + data[++current].toString().trim();

			   
			   TextView labelSport = new TextView(this);
			   labelSport.setId(++current); 
			   labelSport.setText(" " + sportType(data[current]).toString().trim());
			   labelSport.setTextColor(Color.BLACK);
			   labelSport.setTextSize(10);
			   labelSport.setLayoutParams(new LayoutParams(
					   LayoutParams.FILL_PARENT,
					   LayoutParams.WRAP_CONTENT));
			   
			   TextView labelOpponent = new TextView(this);
			   labelOpponent.setId(++current);
			   labelOpponent.setText(" " + data[current].toString().trim() + time);
			   labelOpponent.setTextColor(Color.BLACK);
			   labelOpponent.setTextSize(10);
			   labelOpponent.setLayoutParams(new LayoutParams(
					   LayoutParams.FILL_PARENT,
					   LayoutParams.WRAP_CONTENT));
			   
			   tr.addView(labelDate);
			   tr.addView(labelSport);
			   tr.addView(labelOpponent);
			   
			   tl.addView(tr, new TableLayout.LayoutParams(
					   LayoutParams.FILL_PARENT,
					   LayoutParams.WRAP_CONTENT));
		   }

	}
	
	private CharSequence sportType(String string) {
		String sport = null;
		if(string.matches("m-basebl"))
			sport = "Baseball";
		else if (string.matches("m-baskbl"))
			sport = "M Basketball";
		else if (string.matches("m-xc"))
			sport = "M Cross Country";
		else if (string.matches("m-footbl"))
			sport = "Football";
		else if (string.matches("m-hockey"))
			sport = "M Ice Hockey";
		else if (string.matches("m-swimonly"))
			sport = "M Swimming";
		else if (string.matches("m-track"))
			sport = "M Track & Field";
		else if (string.matches("w-baskbl"))
			sport = "W Basketball";
		else if (string.matches("w-xc"))
			sport = "W Cross Country";
		else if (string.matches("w-fieldh"))
			sport = "W Field Hockey";
		else if (string.matches("w-hockey"))
			sport = "W Ice Hockey";
		else if (string.matches("w-soccer"))
			sport = "W Soccer";
		else if (string.matches("w-softbl"))
			sport = "Softball";
		else if (string.matches("w-swimonly"))
			sport = "W Swimming";
		else if (string.matches("w-track"))
			sport = "W Track & Field";		
			
		return sport;
	}

}
