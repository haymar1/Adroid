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

public class PheKon_Orphanage extends ActionBarActivity {
	Button btnNat,btnThan,btnSai,btnLagyi,btnSalin,btnHome,btnBack;Typeface myTypeface;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_phe_kon__orphanage);
		btnNat=(Button) findViewById(R.id.btnNat);
		btnThan=(Button) findViewById(R.id.btnThan);
		btnSai=(Button) findViewById(R.id.btnSai);
		btnLagyi=(Button) findViewById(R.id.btnLagyi);
		btnSalin=(Button) findViewById(R.id.btnSalin);
		
		myTypeface=Typeface.createFromAsset(getAssets(), "fonts/ZAWGYI-ONE-20051130.TTF");		btnNat.setTypeface(myTypeface);
		btnThan.setTypeface(myTypeface);
		btnSai.setTypeface(myTypeface);
		btnLagyi.setTypeface(myTypeface);
		btnSalin.setTypeface(myTypeface);		
  btnNat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(PheKon_Orphanage.this,NatTaw_Orphanage.class);
				startActivity(txttgi);
				
			}
		});
  btnThan.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent txttgi=new Intent(PheKon_Orphanage.this,ThanTarTaYayNa_Orphanage.class);
			startActivity(txttgi);
			
		}
	});
  btnSai.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent txttgi=new Intent(PheKon_Orphanage.this,SaiKhunTaung_Orphanage.class);
			startActivity(txttgi);
			
		}
	});
	
  btnLagyi.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent txttgi=new Intent(PheKon_Orphanage.this,Lagyinwe.class);
			startActivity(txttgi);
			
		}
	});
	
  btnSalin.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent txttgi=new Intent(PheKon_Orphanage.this,Salin_Orphanage.class);
			startActivity(txttgi);
			
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
