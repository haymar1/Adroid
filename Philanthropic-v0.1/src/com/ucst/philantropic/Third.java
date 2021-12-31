package com.ucst.philantropic;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Third extends ActionBarActivity {
	Typeface myTypeface;
	Button btnNursing,btnDis,btnOrphange,btnHome,btnback;
	ViewFlipper viewflipper; ImageView img1,img2,img3,img4,img5;
	Animation fade_in; ViewGroup scrollViewgroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		 img1=(ImageView)findViewById(R.id.imageView1);
			img2=(ImageView)findViewById(R.id.imageView2);
			img3=(ImageView)findViewById(R.id.imageView3);
			img4=(ImageView)findViewById(R.id.imageView4);
		img5=(ImageView)findViewById(R.id.imageView5);

			viewflipper=(ViewFlipper)this.findViewById(R.id.view1);
			 fade_in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
			viewflipper.setInAnimation(fade_in);
			viewflipper.setAutoStart(true);
			viewflipper.setFlipInterval(2000);
			viewflipper.startFlipping();
		
		btnNursing=(Button) findViewById(R.id.btnNursing);
		btnDis=(Button) findViewById(R.id.btnDis);
		btnOrphange=(Button) findViewById(R.id.btnOrphange);
		myTypeface=Typeface.createFromAsset(getAssets(), "fonts/ZAWGYI-ONE-20051130.TTF");
		btnNursing.setTypeface(myTypeface);
		btnDis.setTypeface(myTypeface);
		btnOrphange.setTypeface(myTypeface);	
		btnOrphange.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent orphange=new Intent(Third.this,Orphange.class);
				startActivity(orphange);
				
			}
			
		});
		btnNursing.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent nursing=new Intent(Third.this,NursingHome.class);
				startActivity(nursing);
				
			}
		});
		btnDis.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent dis=new Intent(Third.this,DisabilitySchool.class);
				startActivity(dis);
				
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
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
