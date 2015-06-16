package com.recharge.recharge;

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

import com.privatis.recharge.R;
import com.recharge.common.constant;
import com.recharge.fragment.TransferViaEmail;
import com.recharge.fragment.TransferViaMobile;
import com.viewpagerindicator.TabPageIndicator;

public class TransferMoneyActivity extends FragmentActivity {
	public FragmentPagerAdapter adapterViewPager;

	private static final String[] CONTENT = new String[] { "Send Money",
			"Request Money" };

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		if (constant.get_emailid(getApplicationContext()).equals("")) {
			setContentView(R.layout.transfermoneyactivity);
			// ===Action Bar===
			ActionBar mActionBar = getActionBar();
			mActionBar.setDisplayShowHomeEnabled(false);
			mActionBar.setDisplayShowTitleEnabled(false);
			LayoutInflater mInflater = LayoutInflater.from(this);

			View mCustomView = mInflater.inflate(
					R.layout.action_bar_recharge_pay, null);

			mActionBar.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.action_bar));

			TextView mTitleTextView = (TextView) mCustomView
					.findViewById(R.id.txt_title);
			mTitleTextView.setText("Transfer Money");

			mActionBar.setCustomView(mCustomView);
			mActionBar.setDisplayShowCustomEnabled(true);
			// =======================
		} else {
			setContentView(R.layout.transfermoneyloginactivity);
			// ===Action Bar===
			ActionBar mActionBar = getActionBar();
			mActionBar.setDisplayShowHomeEnabled(false);
			mActionBar.setDisplayShowTitleEnabled(false);
			LayoutInflater mInflater = LayoutInflater.from(this);

			View mCustomView = mInflater.inflate(
					R.layout.action_bar_recharge_pay, null);

			mActionBar.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.action_bar));

			TextView mTitleTextView = (TextView) mCustomView
					.findViewById(R.id.txt_title);
			mTitleTextView.setText("Transfer Money");

			LinearLayout ll_header = (LinearLayout) mCustomView
					.findViewById(R.id.ll_header);
			ll_header.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					TransferMoneyActivity.this.finish();
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
				return TransferViaMobile.newInstance(1, "Send Money");
			} else if (position == 1) {
				return TransferViaEmail.newInstance(1, "Request Money");
			} else {
				return TransferViaMobile.newInstance(1, "Send Money");
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
