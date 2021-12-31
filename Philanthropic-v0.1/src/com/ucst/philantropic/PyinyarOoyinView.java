package com.ucst.philantropic;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
public class PyinyarOoyinView extends PagerAdapter{
	private Context context;
	private LayoutInflater layoutInflater;
	private Integer [] images = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p,R.drawable.p8,R.drawable.p9,R.drawable.p10,R.drawable.p11,R.drawable.p12,R.drawable.p13};

	public PyinyarOoyinView(Context context) {
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
	View view = layoutInflater.inflate(R.layout.pyinyarooyincustom, null);
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
