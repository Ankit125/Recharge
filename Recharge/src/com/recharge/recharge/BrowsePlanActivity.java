package com.recharge.recharge;

import com.privatis.recharge.R;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BrowsePlanActivity extends FragmentActivity {
	private TextView txt_operator, txt_state, txt_plans;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);

		setContentView(R.layout.browse_plans_activity);

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
		mTitleTextView.setText("Browse Plans");

		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		LinearLayout ll_help = (LinearLayout) mCustomView
				.findViewById(R.id.ll_help);

		LinearLayout ll_header = (LinearLayout) mCustomView
				.findViewById(R.id.ll_header);
		ll_header.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				BrowsePlanActivity.this.finish();
			}
		});
		ll_help.setVisibility(View.GONE);
		// =======================

		txt_operator = (TextView) findViewById(R.id.txt_operator);
		txt_state = (TextView) findViewById(R.id.txt_state);
		txt_plans = (TextView) findViewById(R.id.txt_plans);

		txt_operator.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				open_provide_dialog();
			}
		});

		txt_state.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				open_state_dialog();
			}
		});
		txt_plans.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				open_plans_dialog();
			}
		});
	}

	public void open_provide_dialog() {
		final CharSequence[] items = { "Aritel", "Vodafone", "BSNL",
				"Reliance CAMA", "Relience GSM", "Aricel", "MTNL", "Idea",
				"Tata Indicom", "Tata Docomo", "MTS", "Uninor", "Videocon" };

		AlertDialog.Builder builder = new AlertDialog.Builder(
				BrowsePlanActivity.this);
		builder.setTitle("Select Mobile Operator");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				// Do something with the selection
				txt_operator.setText(items[item]);
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}

	public void open_state_dialog() {
		final CharSequence[] items = { "Andra Pradesh", "Arunachal Pradesh",
				"Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana",
				"Himachal Pradesh", "Jammu and Kashmir", "Jharkhand",
				"Karnataka", "Kerala", "Madya Pradesh", "Maharashtra",
				"Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa",
				"Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura",
				"Uttaranchal", "Uttar Pradesh", "West Bengal" };

		AlertDialog.Builder builder = new AlertDialog.Builder(
				BrowsePlanActivity.this);
		builder.setTitle("Select a Circle");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				// Do something with the selection
				txt_state.setText(items[item]);
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}

	public void open_plans_dialog() {
		final CharSequence[] items = { "Full- talktime-Plans", "Topup-Plans",
				"Validity-Recharge", "Local-SMS-Pack", "National-SMS-Pack",
				"General-SMS-Pack", "3G-Plans", "Data-Plans",
				"Lifetime-Validity", "Night-Packs", "Unlimited-TalkTime",
				"Local-Call-Plans", "STD-Plans", "ISD-Plans", "Rate-Cutter",
				"Special-Offer" };

		AlertDialog.Builder builder = new AlertDialog.Builder(
				BrowsePlanActivity.this);
		builder.setTitle("Plan Type");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				// Do something with the selection
				txt_plans.setText(items[item]);
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}

}
