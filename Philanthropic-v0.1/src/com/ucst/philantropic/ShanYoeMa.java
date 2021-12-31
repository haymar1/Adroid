package com.ucst.philantropic;


import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Gallery;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.BaseAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class ShanYoeMa extends ActionBarActivity {
	TextView txtShan,txtShan1,txtShan2,txtShan3,txtShan4,txtShan5,txtShan6,txtShan7,txtShan8,txtShan11;
	ViewGroup scrollViewGroup;
	Typeface myTypeface;
	 ViewPager viewPager;
	 LinearLayout sliderdotspanel;
		private int dotcount;
		private ImageView[] dots;
		ImageView message,phone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shan_yoe_ma);
		
		sliderdotspanel=(LinearLayout) findViewById(R.id.sliderdot);
		phone=(ImageView) findViewById(R.id.phone);
		message=(ImageView) findViewById(R.id.message);
		//facebook=(ImageView) findViewById(R.id.facebook);
		
		 
		message.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String phoneNumber = "+09254103960";
		        String message = "Welcome to sms";
		        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "09254103960"));
		        intent.putExtra("sms_body", message);
		        startActivity(intent);
				
			}
		});
		phone.setOnClickListener(new OnClickListener() {
			

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    try {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"09254103960"));
        startActivity(intent);
    }
    catch (android.content.ActivityNotFoundException e){

        Toast.makeText(getApplicationContext(),"App failed",Toast.LENGTH_LONG).show();
    }

			}
			
			});		
		

		viewPager = (ViewPager) findViewById(R.id.viewPager);

		ShanView viewPagerAdapter = new ShanView(this);
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
		
		txtShan=(TextView) findViewById(R.id.txtShan);
		txtShan1=(TextView) findViewById(R.id.txtShan1);
		txtShan2=(TextView) findViewById(R.id.txtShan2);
		txtShan3=(TextView) findViewById(R.id.txtShan3);
		txtShan4=(TextView) findViewById(R.id.txtShan4);
		txtShan5=(TextView) findViewById(R.id.txtShan5);
		txtShan6=(TextView) findViewById(R.id.txtShan6);
		txtShan7=(TextView) findViewById(R.id.txtShan7);
		txtShan8=(TextView) findViewById(R.id.txtShan8);
		txtShan11=(TextView) findViewById(R.id.txtShan11);
		
		myTypeface=Typeface.createFromAsset(getAssets(), "fonts/ZAWGYI-ONE-20051130.TTf");		txtShan.setTypeface(myTypeface);
		txtShan1.setTypeface(myTypeface);
		txtShan2.setTypeface(myTypeface);
		txtShan3.setTypeface(myTypeface);
		txtShan4.setTypeface(myTypeface);
		txtShan5.setTypeface(myTypeface);
		txtShan6.setTypeface(myTypeface);
		txtShan7.setTypeface(myTypeface);
		txtShan8.setTypeface(myTypeface);
		txtShan11.setTypeface(myTypeface);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.shan_yoe_ma, menu);
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
