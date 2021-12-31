package com.ucst.philantropic;


import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
public class DamawiduView extends PagerAdapter{
	private Context context;
	private LayoutInflater layoutInflater;
	private Integer [] images = {R.drawable.dama1,R.drawable.dama2,R.drawable.dama3,R.drawable.dama4,R.drawable.dama5,R.drawable.dama7,R.drawable.dama8,R.drawable.dama9,R.drawable.dama10,R.drawable.dama11};

	public DamawiduView(Context context) {
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
	View view = layoutInflater.inflate(R.layout.damawiducustom, null);
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
