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

public class PinLong_Orphanage extends ActionBarActivity {
	Button btnTi,btnNanghuu,btnHome,btnBack;Typeface myTypeface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pin_long__orphanage);
		btnTi=(Button) findViewById(R.id.btnTi);
		btnNanghuu=(Button) findViewById(R.id.btnNanghuu);	
		myTypeface=Typeface.createFromAsset(getAssets(), "fonts/ZAWGYI-ONE-20051130.TTF");
		btnTi.setTypeface(myTypeface);
		btnNanghuu.setTypeface(myTypeface);
		
  btnTi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(PinLong_Orphanage.this,Tinarkaung.class);
				startActivity(txttgi);
				
			}
		});
  
	
  btnNanghuu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(PinLong_Orphanage.this,Nanghuu.class);
				startActivity(txttgi);
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pin_long__orphanage, menu);
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
