package com.recharge.recharge;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.privatis.recharge.R;

public class ForgetPasswordActivity extends FragmentActivity {
	private Button btn_continue;
	private EditText edt_emailid;

	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);

		setContentView(R.layout.forgetpasseordactivity);

		btn_continue = (Button) findViewById(R.id.btn_continue);
		edt_emailid = (EditText) findViewById(R.id.edt_emailid);

		btn_continue.setOnClickListener(new OnClickListener() {

			@SuppressLint("NewApi")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String st = edt_emailid.getText().toString().trim();
				if (st.length() == 0) {
					edt_emailid.setError("Please enter valid email id");
				}
			}
		});

	}
}
