package com.recharge.recharge;

import com.privatis.recharge.R;
import com.recharge.fragment.Help_Issue_fragment;
import com.recharge.fragment.Help_Past_Fragment;
import com.viewpagerindicator.TabPageIndicator;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Help_Activity extends FragmentActivity {
	public FragmentPagerAdapter adapterViewPager;

	private static final String[] CONTENT = new String[] { "Have Issue?",
			"Past Issues" };

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.transfermoneyloginactivity);
		// ===Action Bar===
		ActionBar mActionBar = getActionBar();
		mActionBar.setDisplayShowHomeEnabled(false);
		mActionBar.setDisplayShowTitleEnabled(false);
		LayoutInflater mInflater = LayoutInflater.from(this);

		View mCustomView = mInflater.inflate(R.layout.action_bar_recharge_pay,
				null);

		mActionBar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.action_bar));

		TextView mTitleTextView = (TextView) mCustomView
				.findViewById(R.id.txt_title);
		mTitleTextView.setText("Help");

		LinearLayout ll_header = (LinearLayout) mCustomView
				.findViewById(R.id.ll_header);
		ll_header.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Help_Activity.this.finish();
			}
		});

		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);

		// =======================
		FragmentPagerAdapter adapter = new GoogleMusicAdapter(
				getSupportFragmentManager());

		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);

		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);
	}

	class GoogleMusicAdapter extends FragmentPagerAdapter {
		public GoogleMusicAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			// return TestFragment.newInstance(CONTENT[position %
			// CONTENT.length]);
			if (position == 0) {
				return Help_Issue_fragment.newInstance(1, "");
			} else if (position == 1) {
				return Help_Past_Fragment.newInstance(1, "");
			} else {
				return Help_Issue_fragment.newInstance(1, "");
			}
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return CONTENT[position % CONTENT.length];// .toUpperCase();
		}

		@Override
		public int getCount() {
			return CONTENT.length;
		}
	}
}