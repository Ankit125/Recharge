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

public class Recharge_Landline extends Fragment {
	private TextView txt_provider;

	public static Recharge_Landline newInstance(int page, String title) {
		Recharge_Landline fragmentFirst = new Recharge_Landline();
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
		View v = inflater.inflate(R.layout.recharge_landline_fragment,
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
		final CharSequence[] items = { "Tikona", "Airtel Landline",
				"MTNL Delhi", "Tata TaleServices (CDMA)",
				"Reliance Communications" };

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
