package com.ucst.philantropic;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends ActionBarActivity {
	ImageView img;ViewFlipper viewflipper; ImageView img1,img2,img3,img4,img5,img6;
	Typeface myTypeface;Animation fade_in;
	TextView txtView;
private static final long SPLASH_DISPLAY_LENGTH=2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txtView=(TextView) findViewById(R.id.textView);
		img=(ImageView)findViewById(R.id.imgClick);
		img.setVisibility(0);
		fadeInFadeOut();
		myTypeface=Typeface.createFromAsset(getAssets(), "fonts/ZAWGYI-ONE-20051130.TTF");
		txtView.setTypeface(myTypeface);
	
		new Handler().postDelayed(new Runnable(){

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Intent second=new Intent(MainActivity.this,Second.class);
			startActivity(second);
			finish();
			
		}
		
	},SPLASH_DISPLAY_LENGTH);
	}
	private void fadeInFadeOut(){
		AlphaAnimation localAlphaAnimation1=new AlphaAnimation(0.0F,2.0F);
		localAlphaAnimation1.setInterpolator(new DecelerateInterpolator());
		localAlphaAnimation1.setDuration(1000L);
		AlphaAnimation localAlphaAnimation2=new AlphaAnimation(2.0F,0.0F);
		localAlphaAnimation2.setInterpolator(new AccelerateInterpolator());
		localAlphaAnimation2.setStartOffset(2000L);
		localAlphaAnimation2.setDuration(1000L);
		AnimationSet localAnimationSet=new AnimationSet(false);
		localAnimationSet.addAnimation(localAlphaAnimation1);
		localAnimationSet.addAnimation(localAlphaAnimation2);
		
		img.setAnimation(localAnimationSet);
		localAnimationSet.setAnimationListener(new Animation.AnimationListener()
		
	{
		
			
			@Override
			public void onAnimationStart(Animation paramAnonymousAnimation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation paramAnonymousAnimation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation paramAnonymousAnimation) {
				// TODO Auto-generated method stub
				MainActivity.this.img.setVisibility(4);
			}
		});
	
	}
	
		//imgClick.setTypeface(myTypeface);
		/*imgClick.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent second=new Intent(MainActivity.this,ThirdActivity.class);
				startActivity(second);
			}
		});*/
		
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
