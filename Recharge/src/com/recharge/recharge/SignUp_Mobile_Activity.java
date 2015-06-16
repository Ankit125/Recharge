package com.recharge.recharge;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.privatis.recharge.R;

public class SignUp_Mobile_Activity extends FragmentActivity {
	private EditText edt_mobile_number;
	private Button btn_next;
	private String email_id;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);

		setContentView(R.layout.signupmobilenactivity);

		Bundle bdl = getIntent().getExtras();
		if (bdl != null) {
			email_id = bdl.getString("Email");
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
		mTitleTextView.setText("Sign Up");

		LinearLayout ll_header = (LinearLayout) mCustomView
				.findViewById(R.id.ll_header);
		ll_header.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SignUp_Mobile_Activity.this.finish();
			}
		});

		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		LinearLayout ll_help = (LinearLayout) mCustomView
				.findViewById(R.id.ll_help);
		ll_help.setVisibility(View.VISIBLE);
		// =======================

		edt_mobile_number = (EditText) findViewById(R.id.edt_mobile_number);
		btn_next = (Button) findViewById(R.id.btn_next);
		btn_next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String mobile = edt_mobile_number.getText().toString().trim();
				if (mobile.length() < 10) {
					edt_mobile_number
							.setError("Please enter valid mobile number");
				} else {
					Bundle bdl = new Bundle();
					bdl.putString("Email", email_id);
					Intent intent = new Intent(SignUp_Mobile_Activity.this,
							SignUp_Password_Activity.class);
					intent.putExtras(bdl);
					startActivity(intent);
				}
			}
		});
	}
}
