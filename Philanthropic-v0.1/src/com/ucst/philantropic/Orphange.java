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

public class Orphange extends ActionBarActivity {
Typeface myTypeface;
Button btnDama,btnPin,btnDaw,btnhand,btnGirl,btnNyein,btnNext,btnHome;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_orphange);
		btnDama=(Button)findViewById(R.id.btnDama);
		btnPin=(Button)findViewById(R.id.btnPin);
		btnDaw=(Button)findViewById(R.id.btnDaw);
		btnhand=(Button)findViewById(R.id.btnhand);
		btnGirl=(Button)findViewById(R.id.btnGirl);
		btnNyein=(Button)findViewById(R.id.btnNyein);
		
		myTypeface=Typeface.createFromAsset(getAssets(), "fonts/ZAWGYI-ONE-20051130.TTF");
		btnDama.setTypeface(myTypeface);
		btnPin.setTypeface(myTypeface);
		btnDaw.setTypeface(myTypeface);
		btnhand.setTypeface(myTypeface);
		btnGirl.setTypeface(myTypeface);
		btnNyein.setTypeface(myTypeface);
		btnDaw.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent orphange=new Intent(Orphange.this,DawGyiDawNge.class);
				startActivity(orphange);
				
			}
			
		});
		btnhand.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent hamsee=new Intent(Orphange.this,HamSee_Orphange.class);
				startActivity(hamsee);
				
			}
			
		});
		btnNyein.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent nyein=new Intent(Orphange.this,NyeinChan_Orphange.class);
				startActivity(nyein);
				
			}
			
		});
		btnPin.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent pyin=new Intent(Orphange.this,PyinyarOoYin.class);
				startActivity(pyin);
				
			}
			
		});
		btnGirl.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent girl=new Intent(Orphange.this,Laday_Orphange.class);
				startActivity(girl);
				
			}
			
		});
		btnDama.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent dama=new Intent(Orphange.this,Damawidu_Orphange.class);
				startActivity(dama);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.orphange, menu);
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
