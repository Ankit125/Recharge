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
import com.recharge.fragment.Recharge_DTH;
import com.recharge.fragment.Recharge_DataCard;
import com.recharge.fragment.Recharge_Electricity;
import com.recharge.fragment.Recharge_Gas;
import com.recharge.fragment.Recharge_Insurance;
import com.recharge.fragment.Recharge_Landline;
import com.recharge.fragment.Recharge_Postpaid;
import com.recharge.fragment.Recharge_Prepaid;
import com.recharge.fragment.TransferViaEmail;
import com.recharge.fragment.TransferViaMobile;
import com.recharge.recharge.TransferMoneyActivity.GoogleMusicAdapter;
import com.viewpagerindicator.TabPageIndicator;

public class RechargePayActivity extends FragmentActivity {
	public FragmentPagerAdapter adapterViewPager;
	private static final String[] CONTENT = new String[] { "Prepaid",
			"Postpaid", "DTH", "Data Card", "Landline", "Elecricity", "Gas",
			"Insurance" };

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);

		if (constant.get_emailid(getApplicationContext()).equals("")) {
			setContentView(R.layout.rechargepay);

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
			mTitleTextView.setText("Recharge & Pay Bills");

			LinearLayout ll_header = (LinearLayout) mCustomView
					.findViewById(R.id.ll_header);
			ll_header.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					RechargePayActivity.this.finish();
				}
			});

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
			mTitleTextView.setText("Recharge & Pay Bills");

			LinearLayout ll_header = (LinearLayout) mCustomView
					.findViewById(R.id.ll_header);
			ll_header.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					RechargePayActivity.this.finish();
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
				return Recharge_Prepaid.newInstance(position, "");
			} else if (position == 1) {
				return Recharge_Postpaid.newInstance(position, "");
			} else if (position == 2) {
				return Recharge_DTH.newInstance(position, "");
			} else if (position == 3) {
				return Recharge_DataCard.newInstance(position, "");
			} else if (position == 4) {
				return Recharge_Landline.newInstance(position, "");
			} else if (position == 5) {
				return Recharge_Electricity.newInstance(position, "");
			} else if (position == 6) {
				return Recharge_Gas.newInstance(position, "");
			} else if (position == 7) {
				return Recharge_Insurance.newInstance(position, "");
			} else {
				return Recharge_Prepaid.newInstance(position, "");
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
