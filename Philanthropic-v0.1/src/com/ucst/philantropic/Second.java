package com.ucst.philantropic;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

public class Second extends ActionBarActivity {
Typeface myTypeface;

TextView txtTgi,txtHo,txtAye,txtNyaung,txtPin,txtPhekon,txtAung,txtPing,txtYatSauk,txtLin;
ImageView imgTgi,imgHo,imgAye,imgNyaung,imgPin,imgPhekon,imgAung,imgPing,imgYatSauk,imgLin;
ViewGroup scrollViewgroup;TableLayout tableLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		txtTgi=(TextView)findViewById(R.id.txtTgi);
		txtHo=(TextView)findViewById(R.id.txtHo);
		txtAye=(TextView)findViewById(R.id.txtAye);
		txtNyaung=(TextView)findViewById(R.id.txtNyaung);
		txtPin=(TextView)findViewById(R.id.txtPin);
		txtPhekon=(TextView)findViewById(R.id.txtPhekon);
		txtAung=(TextView)findViewById(R.id.txtAung);
		txtPing=(TextView)findViewById(R.id.txtPing);
		txtYatSauk=(TextView)findViewById(R.id.txtYatSauk);
		txtLin=(TextView)findViewById(R.id.txtLin);
		
		
		imgTgi=(ImageView) findViewById(R.id.imgtgi);
		imgHo=(ImageView) findViewById(R.id.imgHo);
		imgAye=(ImageView) findViewById(R.id.imgAye);
		imgNyaung=(ImageView) findViewById(R.id.imgNyaung);
		imgPin=(ImageView) findViewById(R.id.imgPin);
		imgPhekon=(ImageView) findViewById(R.id.imgPhekon);
		imgAung=(ImageView) findViewById(R.id.imgAung);
		imgPing=(ImageView) findViewById(R.id.imgPing);
		imgYatSauk=(ImageView) findViewById(R.id.imgYatSauk);
		imgLin=(ImageView) findViewById(R.id.imgLin);
		
		
		txtTgi.setTypeface(myTypeface);txtHo.setTypeface(myTypeface);
		txtAye.setTypeface(myTypeface);txtPhekon.setTypeface(myTypeface);
		txtAung.setTypeface(myTypeface);txtPing.setTypeface(myTypeface);
		txtYatSauk.setTypeface(myTypeface);txtLin.setTypeface(myTypeface);
		txtNyaung.setTypeface(myTypeface);
		txtPin.setTypeface(myTypeface);
		
		imgTgi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent tgi=new Intent(Second.this,Third.class);
				startActivity(tgi);
				
			}
		});
		txtTgi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(Second.this,Third.class);
				startActivity(txttgi);
				
			}
		});
		
		imgAye.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent tgi=new Intent(Second.this,AyeTharYar.class);
				startActivity(tgi);
				
			}
		});
		txtAye.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(Second.this,AyeTharYar.class);
				startActivity(txttgi);
				
			}
		});
		imgHo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent tgi=new Intent(Second.this,Hopong.class);
				startActivity(tgi);
				
			}
		});
		txtHo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(Second.this,Hopong.class);
				startActivity(txttgi);
				
			}
		});
		imgNyaung.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent tgi=new Intent(Second.this,NyaunShwe.class);
				startActivity(tgi);
				
			}
		});
		txtNyaung.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(Second.this,NyaunShwe.class);
				startActivity(txttgi);
				
			}
		});
		
		imgPin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent tgi=new Intent(Second.this,PinTaYa.class);
				startActivity(tgi);
				
			}
		});
		txtPin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(Second.this,PinTaYa.class);
				startActivity(txttgi);
				
			}
		});
		
		imgAung.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent tgi=new Intent(Second.this,AungBang.class);
				startActivity(tgi);
				
			}
		});
		txtAung.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(Second.this,AungBang.class);
				startActivity(txttgi);
				
			}
		});
		
		imgPhekon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent tgi=new Intent(Second.this,PheKon.class);
				startActivity(tgi);
				
			}
		});
		txtPhekon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(Second.this,PheKon.class);
				startActivity(txttgi);
				
			}
		});
		
		imgPing.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent tgi=new Intent(Second.this,PinLong.class);
				startActivity(tgi);
				
			}
		});
		txtPing.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(Second.this,PinLong.class);
				startActivity(txttgi);
				
			}
		});
		
		
		
		imgYatSauk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent tgi=new Intent(Second.this,YatSauk.class);
				startActivity(tgi);
				
			}
		});
		txtYatSauk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(Second.this,YatSauk.class);
				startActivity(txttgi);
				
			}
		});
		

		imgLin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent tgi=new Intent(Second.this,LinKay.class);
				startActivity(tgi);
				
			}
		});
		txtLin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent txttgi=new Intent(Second.this,LinKay.class);
				startActivity(txttgi);
				
			}
		});
		
	}
	
	@Override
	public void onBackPressed(){
		final AlertDialog.Builder builder=new AlertDialog.Builder(Second.this);
		builder.setMessage("Are you sure want to exist?");
		builder.setCancelable(true);
		builder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
		
		builder.setNegativeButton("Cancel",new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				// TODO Auto-generated method stub
				dialogInterface.cancel();
			}
			
		});
		
		AlertDialog alertDialog=builder.create();
	    alertDialog.show();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
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
