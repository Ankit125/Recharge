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
import android.widget.RadioButton;
import android.widget.TextView;

import com.privatis.recharge.R;
import com.recharge.common.constant;

public class LoginAcitivity extends FragmentActivity {
	private RadioButton rdb_sign;
	private TextView txt_forgetpass;
	private Button btn_login;
	private EditText edt_emailid, edt_password;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		setContentView(R.layout.loginactivity);

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
		mTitleTextView.setText("Login");

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
				LoginAcitivity.this.finish();
			}
		});
		ll_help.setVisibility(View.VISIBLE);
		// =======================

		btn_login = (Button) findViewById(R.id.btn_login);
		edt_emailid = (EditText) findViewById(R.id.edt_emailid);
		edt_password = (EditText) findViewById(R.id.edt_password);

		btn_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String email = edt_emailid.getText().toString().trim();
				String pass = edt_password.getText().toString().trim();
				if (email.length() == 0) {
					edt_emailid.setError("Please enter valid email id");
				} else if (pass.length() == 0) {
					edt_password.setError("Please enter password");
				} else {
					constant.Set_flag(email, pass, getApplicationContext());
					// Intent intent=new
					// Intent(LoginAcitivity.this,TransferMoneyActivity.class);
					LoginAcitivity.this.finish();
				}
			}
		});

		rdb_sign = (RadioButton) findViewById(R.id.rdb_sign);
		rdb_sign.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				LoginAcitivity.this.finish();
				Intent intent = new Intent(LoginAcitivity.this,
						SignUpActivity.class);
				startActivity(intent);
			}
		});

		txt_forgetpass = (TextView) findViewById(R.id.txt_forgetpass);
		txt_forgetpass.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LoginAcitivity.this,
						ForgetPasswordActivity.class);
				startActivity(intent);
			}
		});
	}

}
