package com.ucst.philantropic;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ThungedawView extends PagerAdapter{
	private Context context;
	private LayoutInflater layoutInflater;
	private Integer [] img= {R.drawable.tal2,R.drawable.tal3,R.drawable.tal4,R.drawable.tal5,R.drawable.tal6,R.drawable.tal7,R.drawable.tal8,R.drawable.tal9,R.drawable.tal10};

	public ThungedawView(Context context) {
	this.context = context;
	}

	@Override
	public int getCount() {
	return img.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
	return view == object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, final int position) {

	layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	View view = layoutInflater.inflate(R.layout.thungedawcustom, null);
	ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);
	imageView.setImageResource(img[position]);

	ViewPager vp = (ViewPager) container;
	vp.addView(view, 0);
	return view;

	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {

	ViewPager vp = (ViewPager) container;
	View view = (View) object;
	vp.removeView(view);

	}

}
