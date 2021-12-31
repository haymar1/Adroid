package com.ucst.philantropic;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class YanTieAung_Orphange extends ActionBarActivity {
	Typeface myTypeface;TextView txtyan,txtyan1,txtyan2,txtyan3,txtyan4,txtyan8,txtyan9,txtyan10;
	ViewGroup scrollViewgroup;
	ViewPager viewPager;
	LinearLayout sliderdotspanel;
	private int dotcount;
	private ImageView[] dots;
	ImageView phone,message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_yan_tie_aung__orphange);
		sliderdotspanel=(LinearLayout) findViewById(R.id.sliderdot);
		
		phone=(ImageView) findViewById(R.id.phone);
		message=(ImageView) findViewById(R.id.message);
		//facebook=(ImageView) findViewById(R.id.facebook);
		
		 
		message.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String phoneNumber = "+09254601283";
		        String message = "Welcome to sms";
		        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "09254601283"));
		        intent.putExtra("sms_body", message);
		        startActivity(intent);
				
			}
		});
		phone.setOnClickListener(new OnClickListener() {
			

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    try {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"09254601283"));
        startActivity(intent);
    }
    catch (android.content.ActivityNotFoundException e){

        Toast.makeText(getApplicationContext(),"App failed",Toast.LENGTH_LONG).show();
    }

			}
			
			});		
		

		
		viewPager = (ViewPager) findViewById(R.id.viewPager);

		YanTieAungView viewPagerAdapter = new YanTieAungView(this);

		viewPager.setAdapter(viewPagerAdapter);
		
		dotcount=viewPagerAdapter.getCount();
		dots=new ImageView[dotcount];
		for(int i=0;i<dotcount;i++)
		{
			dots[i]=new ImageView(this);
			dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
			LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
			params.setMargins(8, 0, 8, 0);
			sliderdotspanel.addView(dots[i],params);
		}
		
		dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				// TODO Auto-generated method stub
				for(int i=0;i<dotcount;i++)
				{
					dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
				}
				dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
			}
			
			@Override
			public void onPageScrolled(int positon, float positionOffset, int positionOffsetPixels) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		txtyan=(TextView)findViewById(R.id.txtyan);
		txtyan1=(TextView)findViewById(R.id.txtyan1);
		txtyan2=(TextView)findViewById(R.id.txtyan2);
		txtyan3=(TextView)findViewById(R.id.txtyan3);
		txtyan4=(TextView)findViewById(R.id.txtyan4);
		txtyan8=(TextView)findViewById(R.id.txtyan8);
		txtyan9=(TextView)findViewById(R.id.txtyan9);
		txtyan10=(TextView)findViewById(R.id.txtyan10);
		
		myTypeface=Typeface.createFromAsset(getAssets(), "fonts/ZAWGYI-ONE-20051130.TTf");
		txtyan.setTypeface(myTypeface);
		txtyan1.setTypeface(myTypeface);
		txtyan2.setTypeface(myTypeface);
		txtyan3.setTypeface(myTypeface);
		txtyan4.setTypeface(myTypeface);
		txtyan8.setTypeface(myTypeface);
		txtyan9.setTypeface(myTypeface);
		txtyan10.setTypeface(myTypeface);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.yan_tie_aung__orphange, menu);
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
