package com.recharge.fragment;

import com.privatis.recharge.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class TransferViaEmail extends Fragment {
	private Button btn_mobile, btn_email;
	private LinearLayout ll_mobile, ll_email;

	public static TransferViaEmail newInstance(int page, String title) {
		TransferViaEmail fragmentFirst = new TransferViaEmail();
		Bundle args = new Bundle();
		args.putInt("someInt", page);
		args.putString("someTitle", title);
		fragmentFirst.setArguments(args);
		return fragmentFirst;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.requestmoney, container, false);
		btn_mobile = (Button) v.findViewById(R.id.btn_mobile);
		btn_email = (Button) v.findViewById(R.id.btn_email);

		ll_mobile = (LinearLayout) v.findViewById(R.id.ll_mobile);
		ll_email = (LinearLayout) v.findViewById(R.id.ll_email);

		ll_mobile.setVisibility(View.VISIBLE);
		ll_email.setVisibility(View.GONE);
		btn_mobile.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ll_mobile.setVisibility(View.VISIBLE);
				ll_email.setVisibility(View.GONE);
			}
		});

		btn_email.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ll_mobile.setVisibility(View.GONE);
				ll_email.setVisibility(View.VISIBLE);
			}
		});
		return v;
	}
}
