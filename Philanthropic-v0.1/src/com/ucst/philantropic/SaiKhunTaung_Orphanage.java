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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SaiKhunTaung_Orphanage extends ActionBarActivity {
	Typeface myTypeface;
	TextView txtdaw0,txtdaw1,txtdaw2,txtdaw3,txtdaw4,txtdaw5,txtdaw6,txtdaw7,txtdaw8,txtdaw9,txtdaw10;
	ViewGroup scrollViewgroup;
	ViewPager viewPager;
	LinearLayout sliderdotspanel;
	private int dotcount;
	private ImageView[] dots;
	ImageView message,phone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sai_khun_taung__orphanage);
		
		sliderdotspanel=(LinearLayout) findViewById(R.id.sliderdot);
		phone=(ImageView) findViewById(R.id.phone);
		message=(ImageView) findViewById(R.id.message);
		//facebook=(ImageView) findViewById(R.id.facebook);
		
		 
		message.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String phoneNumber = "+09766833635";
		        String message = "Welcome to sms";
		        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "09766833635"));
		        intent.putExtra("sms_body", message);
		        startActivity(intent);
				
			}
		});
		phone.setOnClickListener(new OnClickListener() {
			

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    try {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"09766833635"));
        startActivity(intent);
    }
    catch (android.content.ActivityNotFoundException e){

        Toast.makeText(getApplicationContext(),"App failed",Toast.LENGTH_LONG).show();
    }

			}
			
			});		
		

		viewPager = (ViewPager) findViewById(R.id.viewPager);

		SaiKhunView viewPagerAdapter = new SaiKhunView(this);

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

		
		
		txtdaw0=(TextView)findViewById(R.id.txtsaikhun0);
		txtdaw1=(TextView)findViewById(R.id.txtsaikhun1);
		txtdaw2=(TextView)findViewById(R.id.txtsaikhun2);
		txtdaw3=(TextView)findViewById(R.id.txtsaikhun3);
		txtdaw4=(TextView)findViewById(R.id.txtsaikhun4);
		txtdaw6=(TextView)findViewById(R.id.txtsaikhun6);
		txtdaw7=(TextView)findViewById(R.id.txtsaikhun7);
		txtdaw8=(TextView)findViewById(R.id.txtsaikhun8);
		txtdaw9=(TextView)findViewById(R.id.txtsaikhun9);
		txtdaw10=(TextView)findViewById(R.id.txtsaikhun10);
		

		myTypeface=Typeface.createFromAsset(getAssets(), "fonts/ZAWGYI-ONE-20051130.TTf");		txtdaw0.setTypeface(myTypeface);
		txtdaw1.setTypeface(myTypeface);
		txtdaw2.setTypeface(myTypeface);
		txtdaw3.setTypeface(myTypeface);
		txtdaw4.setTypeface(myTypeface);
		txtdaw6.setTypeface(myTypeface);
		txtdaw7.setTypeface(myTypeface);
		txtdaw8.setTypeface(myTypeface);
		txtdaw9.setTypeface(myTypeface);
		txtdaw10.setTypeface(myTypeface);
		

		
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sai_khun_taung__orphanage, menu);
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



