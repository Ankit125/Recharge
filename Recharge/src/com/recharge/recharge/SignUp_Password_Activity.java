package com.recharge.recharge;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.privatis.recharge.R;
import com.recharge.common.constant;

public class SignUp_Password_Activity extends FragmentActivity {
	private Button btn_signup;
	private EditText editText1;
	private String email_id;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);

		setContentView(R.layout.signuppasswordactivity);

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
				SignUp_Password_Activity.this.finish();
			}
		});
		mActionBar.setCustomView(mCustomView);
		mActionBar.setDisplayShowCustomEnabled(true);
		LinearLayout ll_help = (LinearLayout) mCustomView
				.findViewById(R.id.ll_help);
		ll_help.setVisibility(View.VISIBLE);
		// =======================

		TextView textView = (TextView) findViewById(R.id.txt_terms);
		SpannableString content = new SpannableString("Terms and Conditions");
		content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
		textView.setText(content);
		editText1 = (EditText) findViewById(R.id.editText1);
		btn_signup = (Button) findViewById(R.id.btn_signup);

		btn_signup.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String password = editText1.getText().toString().trim();
				if (password.length() == 0) {
					editText1.setError("Please enter password");
				} else {
					SignUp_Password_Activity.this.finish();
					constant.Set_flag(email_id, password,
							getApplicationContext());
					Intent intent = new Intent(SignUp_Password_Activity.this,
							MainActivity.class);
					startActivity(intent);
				}

			}
		});
	}
}
