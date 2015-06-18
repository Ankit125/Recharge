package com.recharge.fragment;

import com.privatis.recharge.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Help_AddMoney extends Fragment {

	public static Help_AddMoney newInstance(int page, String title) {
		Help_AddMoney fragmentFirst = new Help_AddMoney();
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
		View v = inflater.inflate(R.layout.help_addmoney_fregment, container,
				false);

		return v;
		// return super.onCreateView(inflater, container, savedInstanceState);
	}
}
