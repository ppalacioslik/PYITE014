package edu.upc.demostp2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class OpcionesActivity extends Activity {
	
	private Spinner spinner;
	private SpinnerAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.options_activity);
		spinner = (Spinner) findViewById(R.id.spinner1);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.arrayOpciones));
		spinner.setAdapter(adapter);
	}

}
