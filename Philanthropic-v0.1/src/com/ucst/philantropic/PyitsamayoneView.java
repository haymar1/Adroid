package com.ucst.philantropic;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
public class PyitsamayoneView extends PagerAdapter{
	private Context context;
	private LayoutInflater layoutInflater;
	private Integer [] images = {R.drawable.daw1,R.drawable.daw2,R.drawable.daw3,R.drawable.daw4,R.drawable.daw5,R.drawable.daw7,R.drawable.daw8,R.drawable.daw9,R.drawable.daw10,R.drawable.daw11,R.drawable.daw12,R.drawable.daw13,R.drawable.daw14,R.drawable.daw15,R.drawable.daw17};

	public PyitsamayoneView(Context context) {
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
	View view = layoutInflater.inflate(R.layout.pyitsamayonecustom, null);
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

