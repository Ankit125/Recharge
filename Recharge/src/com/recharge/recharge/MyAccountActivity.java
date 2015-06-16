package com.recharge.recharge;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.privatis.recharge.R;

public class MyAccountActivity extends FragmentActivity {

	private LinearLayout ll_transfer, ll_saveconnection,
			ll_transaction_history;
	private Button btn_add_money;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.myaccount);

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
		mTitleTextView.setText("My Account");

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
				MyAccountActivity.this.finish();
			}
		});
		ll_help.setVisibility(View.GONE);
		// =======================

		ll_transfer = (LinearLayout) findViewById(R.id.ll_transfer);
		ll_saveconnection = (LinearLayout) findViewById(R.id.ll_saveconnection);
		ll_transaction_history = (LinearLayout) findViewById(R.id.ll_transaction_history);

		ll_transfer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MyAccountActivity.this,
						TransferMoneyActivity.class);
				startActivity(intent);
			}
		});
		ll_saveconnection.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MyAccountActivity.this,
						SaveConnection.class);
				startActivity(intent);
			}
		});
		ll_transaction_history.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MyAccountActivity.this,
						TransactionHistoryActivity.class);
				startActivity(intent);
			}
		});

		btn_add_money = (Button) findViewById(R.id.btn_add_money);

		btn_add_money.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MyAccountActivity.this,
						Add_moneyActivity.class);
				startActivity(intent);
			}
		});

	}
}
