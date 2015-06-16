package com.recharge.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.privatis.recharge.R;
import com.recharge.common.constant;
import com.recharge.recharge.Add_moneyActivity;
import com.recharge.recharge.MyAccountActivity;
import com.recharge.recharge.RechargePayActivity;
import com.recharge.recharge.SignUpActivity;
import com.recharge.recharge.TransferMoneyActivity;

public class MainFragment extends Fragment {

	private ImageView img_action_logo, imageView1;
	private TextView txt_action_title;
	private Activity mainActivity;
	private LinearLayout ll_recharge, ll_transfer, ll_wallet, ll_addmoney;
	private Button btn_add_money;
	private LinearLayout ll_login_signout, ll_login, ll_open_navigation;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		View v = inflater.inflate(R.layout.mainfragment, container, false);

		mainActivity = getActivity();

		ll_recharge = (LinearLayout) v.findViewById(R.id.ll_recharge);
		ll_transfer = (LinearLayout) v.findViewById(R.id.ll_transfer);
		ll_wallet = (LinearLayout) v.findViewById(R.id.ll_wallet);
		ll_addmoney = (LinearLayout) v.findViewById(R.id.ll_addmoney);
		imageView1 = (ImageView) v.findViewById(R.id.imageView1);
		btn_add_money = (Button) v.findViewById(R.id.btn_add_money);
		btn_add_money.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						Add_moneyActivity.class);
				startActivity(intent);
			}
		});
		if (constant.get_emailid(getActivity()).equals("")) {
			ll_addmoney.setVisibility(View.GONE);
			imageView1.setVisibility(View.VISIBLE);
		} else {
			ll_addmoney.setVisibility(View.VISIBLE);
			imageView1.setVisibility(View.GONE);
		}

		ll_recharge.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						RechargePayActivity.class);
				startActivity(intent);
			}
		});

		ll_transfer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						TransferMoneyActivity.class);
				startActivity(intent);
			}
		});

		ll_wallet.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});

		ll_open_navigation = (LinearLayout) v
				.findViewById(R.id.ll_open_navigation);
		ll_open_navigation.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (constant.NavDrawerLayout.isDrawerOpen(constant.NavList)) {
					constant.NavDrawerLayout.closeDrawer(constant.NavList);
				} else {
					constant.NavDrawerLayout.openDrawer(constant.NavList);
				}
			}
		});

		ll_login_signout = (LinearLayout) v.findViewById(R.id.ll_login_signout);

		ll_login = (LinearLayout) v.findViewById(R.id.ll_login);

		if (constant.get_emailid(getActivity()).equals("")) {
			ll_login_signout.setVisibility(View.VISIBLE);
			ll_login.setVisibility(View.GONE);
		} else {
			ll_login_signout.setVisibility(View.GONE);
			ll_login.setVisibility(View.VISIBLE);
		}
		ll_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),
						MyAccountActivity.class);
				startActivity(intent);
			}
		});
		ll_login_signout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), SignUpActivity.class);
				startActivity(intent);
			}
		});

		return v;
	}
}
