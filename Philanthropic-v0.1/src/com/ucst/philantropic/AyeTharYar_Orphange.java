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

public class AyeTharYar_Orphange extends ActionBarActivity {
	Button btnYan,btnOpendoor,btnMind,btnSanla,btnHome;Typeface myTypeface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aye_thar_yar__orphange);
		btnYan=(Button) findViewById(R.id.btnYan);
		btnOpendoor=(Button) findViewById(R.id.btnOpendoor);
		btnMind=(Button) findViewById(R.id.btnMind);
		btnSanla=(Button) findViewById(R.id.btnSanLa);
		
		myTypeface=Typeface.createFromAsset(getAssets(), "fonts/ZAWGYI-ONE-20051130.TTF");
		btnYan.setTypeface(myTypeface);
		btnOpendoor.setTypeface(myTypeface);
		btnMind.setTypeface(myTypeface);
		btnSanla.setTypeface(myTypeface);
		
  btnYan.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(AyeTharYar_Orphange.this,YanTieAung_Orphange.class);
				startActivity(txttgi);
				
			}
		});
  
  btnOpendoor.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent txtopen=new Intent(AyeTharYar_Orphange.this,Opendoor.class);
			startActivity(txtopen);
			
		}
	});
  btnMind.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent txtopen=new Intent(AyeTharYar_Orphange.this,SattThaThuKa.class);
		startActivity(txtopen);
		
	}
});
  btnSanla.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent txtopen=new Intent(AyeTharYar_Orphange.this,SanLaPaMar.class);
			startActivity(txtopen);
			
		}
	});
  
  
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aye_thar_yar__orphange, menu);
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
