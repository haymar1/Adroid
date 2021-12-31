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

public class ThuNgeDaw_Disability extends ActionBarActivity {
	TextView txtThu1,txtThu2,txtThu3,txtThu4,txtThu5,txtThu6,txtThu7,txtThu11;
	Typeface myTypeface;
	ViewPager viewPager;
	LinearLayout sliderdotspanel;
	private int dotcount;
	private ImageView[] dots;
	ImageView phone,message;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thu_nge_daw__disability);
		sliderdotspanel=(LinearLayout) findViewById(R.id.sliderdot);
			
		phone=(ImageView) findViewById(R.id.phone);
		message=(ImageView) findViewById(R.id.message);
		//facebook=(ImageView) findViewById(R.id.facebook);
		
		 
		message.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String phoneNumber = "+09428168225";
		        String message = "Welcome to sms";
		        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "09428168225"));
		        intent.putExtra("sms_body", message);
		        startActivity(intent);
				
			}
		});
		phone.setOnClickListener(new OnClickListener() {
			

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    try {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"09428168225"));
        startActivity(intent);
    }
    catch (android.content.ActivityNotFoundException e){

        Toast.makeText(getApplicationContext(),"App failed",Toast.LENGTH_LONG).show();
    }

			}
			
			});		
		

		viewPager = (ViewPager) findViewById(R.id.viewPager);

		ThungedawView thuview = new ThungedawView(this);
		
		viewPager.setAdapter(thuview);	
		
		dotcount=thuview.getCount();
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
		
		txtThu1=(TextView)findViewById(R.id.txtThu1);
		txtThu2=(TextView)findViewById(R.id.txtThu2);
		txtThu3=(TextView)findViewById(R.id.txtThu3);
		txtThu4=(TextView)findViewById(R.id.txtThu4);
		txtThu5=(TextView)findViewById(R.id.txtThu5);
		txtThu6=(TextView)findViewById(R.id.txtThu6);
		txtThu7=(TextView)findViewById(R.id.txtThu7);
		txtThu11=(TextView)findViewById(R.id.txtThu11);
		
		myTypeface=Typeface.createFromAsset(getAssets(), "fonts/ZAWGYI-ONE-20051130.TTf");
		txtThu1.setTypeface(myTypeface);
		txtThu2.setTypeface(myTypeface);
		txtThu3.setTypeface(myTypeface);
		txtThu4.setTypeface(myTypeface);
		txtThu5.setTypeface(myTypeface);
		txtThu6.setTypeface(myTypeface);
		txtThu7.setTypeface(myTypeface);
		txtThu11.setTypeface(myTypeface);
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.thu_nge_daw__disability, menu);
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
