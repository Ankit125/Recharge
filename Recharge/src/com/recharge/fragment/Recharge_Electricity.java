package com.recharge.fragment;

import com.privatis.recharge.R;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Recharge_Electricity extends Fragment {
	private TextView txt_provider;

	public static Recharge_Electricity newInstance(int page, String title) {
		Recharge_Electricity fragmentFirst = new Recharge_Electricity();
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
		View v = inflater.inflate(R.layout.recharge_electricity_fragment,
				container, false);
		// return super.onCreateView(inflater, container, savedInstanceState);

		txt_provider = (TextView) v.findViewById(R.id.txt_provider);
		txt_provider.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				open_provide_dialog();
			}
		});
		return v;
	}

	public void open_provide_dialog() {
		final CharSequence[] items = { "Jamshedpur Utilities & Services",
				"Banglore Electricity Supply", "MP Panchim Vidyut Vitaran",
				"Reliance Energe Mumbai", "BSES Rajdhani", "MSES Yamuna",
				"MSEB Mumbai", "North Delhi Power Limited",
				"Madhya Gujarat Vij Company", "Dakshin Gujarat Vij Company",
				"Paschim Gujarat Vij Company", "Uttat Gujarat Vij Company",
				"Southern Power Disribution Company", "BEST",
				"Chhattisgard Electticity Board",
				"Noida power Company Limited",
				"Jaiput Vidyut Vitran Nigam Ltd",
				"Jodhpur Vidyut Vitran Nigam Ltd" };

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("Service Provider");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				// Do something with the selection
				txt_provider.setText(items[item]);
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}
}
