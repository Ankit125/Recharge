package com.recharge.recharge;

import android.annotation.SuppressLint;
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
import android.widget.Toast;

import com.privatis.recharge.R;
import com.recharge.extra.UserEmailFetcher;

public class SignUpActivity extends FragmentActivity {

	private TextView txt_login, txt_emailid;
	private Button btn_continue;
	private EditText edt_emailid;

	@Override
	protected void onCreate(Bundle arg0) {

		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.signinactivity);

		txt_login = (TextView) findViewById(R.id.txt_login);

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
				SignUpActivity.this.finish();
			}
		});

		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		LinearLayout ll_help = (LinearLayout) mCustomView
				.findViewById(R.id.ll_help);
		ll_help.setVisibility(View.VISIBLE);
		// =======================

		txt_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SignUpActivity.this,
						LoginAcitivity.class);
				startActivity(intent);
			}
		});

		btn_continue = (Button) findViewById(R.id.btn_continue);
		edt_emailid = (EditText) findViewById(R.id.edt_emailid);
		txt_emailid = (TextView) findViewById(R.id.txt_emailid);

		btn_continue.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (edt_emailid.isShown()) {
					String st = edt_emailid.getText().toString().trim();
					if (st.length() == 0) {
						edt_emailid.setError("Please enter valid email id");
					} else if (!UserEmailFetcher.isValidEmail(st)) {
						edt_emailid.setError("Please enter valid email id");
					} else {
						open_sign_mobile_activity();
					}
				} else {
					open_sign_mobile_activity();
				}
			}
		});

		String mail = UserEmailFetcher.getEmail(getApplicationContext());
		// Toast.makeText(getApplicationContext(), mail,
		// Toast.LENGTH_LONG).show();
		if (mail.length() == 0) {
			edt_emailid.setVisibility(View.VISIBLE);
			txt_emailid.setVisibility(View.GONE);
		} else {
			edt_emailid.setVisibility(View.GONE);
			txt_emailid.setVisibility(View.VISIBLE);
			txt_emailid.setText(mail.trim());
		}
	}

	public void open_sign_mobile_activity() {
		String email = "";
		if (edt_emailid.isShown()) {
			email = edt_emailid.getText().toString().trim();
		} else {
			email = edt_emailid.getText().toString().trim();
		}
		Bundle bdl = new Bundle();
		bdl.putString("Email", email);
		Intent intent = new Intent(SignUpActivity.this,
				SignUp_Mobile_Activity.class);
		intent.putExtras(bdl);
		startActivity(intent);
	}
}
