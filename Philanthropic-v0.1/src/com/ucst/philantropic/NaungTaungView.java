package com.ucst.philantropic;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
public class NaungTaungView extends PagerAdapter{
	private Context context;
	private LayoutInflater layoutInflater;
	private Integer [] images = {R.drawable.ho1,R.drawable.ho2,R.drawable.ho3,R.drawable.ho4,R.drawable.ho5,R.drawable.ho7,R.drawable.ho8,R.drawable.ho9,R.drawable.ho10,R.drawable.ho11,R.drawable.ho12,R.drawable.ho13,R.drawable.ho14,R.drawable.ho15,R.drawable.ho16};

	public NaungTaungView(Context context) {
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
	View view = layoutInflater.inflate(R.layout.naungtaungcustom, null);
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
