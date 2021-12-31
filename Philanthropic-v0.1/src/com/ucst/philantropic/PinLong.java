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

public class PinLong extends ActionBarActivity {
 Button btnPinLongOrphanage,btnHome,btnback;Typeface myTypeface;
 ViewFlipper viewflipper; ImageView img1,img2,img3,img4,img5;
	Animation fade_in; ViewGroup scrollViewgroup;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pin_long);
		
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
			
		btnPinLongOrphanage=(Button) findViewById(R.id.btnPinLongOrphanage);
		myTypeface=Typeface.createFromAsset(getAssets(), "fonts/ZAWGYI-ONE-20051130.TTF");
		btnPinLongOrphanage.setTypeface(myTypeface);
		btnPinLongOrphanage.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent tgi=new Intent(PinLong.this,PinLong_Orphanage.class);
				startActivity(tgi);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pin_long, menu);
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
