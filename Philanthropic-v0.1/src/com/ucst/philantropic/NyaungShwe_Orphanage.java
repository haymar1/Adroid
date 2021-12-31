package com.ucst.philantropic;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NyaungShwe_Orphanage extends ActionBarActivity {
	Button btnMine,btntana;Typeface myTypeface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_nyaung_shwe__orphanage);
		
		btnMine=(Button) findViewById(R.id.btnMine);
		btntana=(Button) findViewById(R.id.btntana);
		myTypeface=Typeface.createFromAsset(getAssets(), "fonts/ZAWGYI-ONE-20051130.TTF");
		btntana.setTypeface(myTypeface);	
        btnMine.setOnClickListener(new OnClickListener() {
 			
 			@Override
 			public void onClick(View arg0) {
 				// TODO Auto-generated method stub
 				Intent txttgi=new Intent(NyaungShwe_Orphanage.this,MineThote.class);
 				startActivity(txttgi);
 				
 			}
 		});
         
         btntana.setOnClickListener(new OnClickListener() {
  			
  			@Override
  			public void onClick(View arg0) {
  				// TODO Auto-generated method stub
  				Intent txttgi=new Intent(NyaungShwe_Orphanage.this,TharTana.class);
  				startActivity(txttgi);
  				
  			}
  		});
          
         
         
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nyaung_shwe__orphanage, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
