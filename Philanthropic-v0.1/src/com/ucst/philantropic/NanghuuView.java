package com.ucst.philantropic;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
public class NanghuuView extends PagerAdapter{
	private Context context;
	private LayoutInflater layoutInflater;
	private Integer [] images = {R.drawable.n1,R.drawable.n2,R.drawable.n3,R.drawable.n4,R.drawable.n5,R.drawable.n6,R.drawable.n7};

	public NanghuuView(Context context) {
	this.context = context;
	}

	@Override
	public int getCount() {
	return images.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
	return view == object;
	}

	@Override
	public Object instantiateItem(ViewGroup container, final int position) {

	layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	View view = layoutInflater.inflate(R.layout.nanghuucustom, null);
	ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
	imageView.setImageResource(images[position]);

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
