package com.recharge.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.privatis.recharge.R;

public class Help_Transfer extends Fragment {

	public static Help_Transfer newInstance(int page, String title) {
		Help_Transfer fragmentFirst = new Help_Transfer();
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
		View v = inflater.inflate(R.layout.help_transfer_fregment, container,
				false);

		return v;
		// return super.onCreateView(inflater, container, savedInstanceState);
	}

}
