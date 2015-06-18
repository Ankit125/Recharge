package com.recharge.fragment;

import com.privatis.recharge.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Help_Past_Fragment extends Fragment {

	public static Help_Past_Fragment newInstance(int page, String title) {
		Help_Past_Fragment fragmentFirst = new Help_Past_Fragment();
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
		View v = inflater
				.inflate(R.layout.help_past_fragment, container, false);

		// return super.onCreateView(inflater, container, savedInstanceState);
		return v;
	}
}
