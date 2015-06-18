package com.recharge.recharge;

import com.privatis.recharge.R;
import com.recharge.fragment.Help_Account;
import com.recharge.fragment.Help_AddMoney;
import com.recharge.fragment.Help_Issue_fragment;
import com.recharge.fragment.Help_Offer;
import com.recharge.fragment.Help_Past_Fragment;
import com.recharge.fragment.Help_Recharge;
import com.recharge.fragment.Help_Transfer;
import com.recharge.recharge.Help_Activity.GoogleMusicAdapter;
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

public class Help_sub_Activity extends FragmentActivity {
	public FragmentPagerAdapter adapterViewPager;

	private static final String[] CONTENT = new String[] { "Recharge/Bill",
			"Add Money", "Offer/Shopping", "Transfer Money", "Account" };
	private int index = 0;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);

		setContentView(R.layout.transfermoneyloginactivity);

		Bundle bdl = getIntent().getExtras();
		if (bdl != null) {
			index = bdl.getInt("index");
		}
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
				Help_sub_Activity.this.finish();
			}
		});

		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);

		// =======================
		FragmentPagerAdapter adapter = new GoogleMusicAdapter(
				getSupportFragmentManager());

		ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);
		// pager.setCurrentItem(2);

		TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
		indicator.setViewPager(pager);
		indicator.setCurrentItem(index);
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
				return Help_Recharge.newInstance(0, "");
			} else if (position == 1) {
				return Help_AddMoney.newInstance(1, "");
			} else if (position == 2) {
				return Help_Offer.newInstance(1, "");
			} else if (position == 3) {
				return Help_Transfer.newInstance(1, "");
			} else if (position == 4) {
				return Help_Account.newInstance(1, "");
			} else {
				return Help_Recharge.newInstance(0, "");
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
