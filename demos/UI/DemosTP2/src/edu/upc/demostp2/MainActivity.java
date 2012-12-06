package edu.upc.demostp2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listView;
	private ListAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		
		listView = (ListView) findViewById(R.id.list);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.arrayWidgets));
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long arg3) {
				Intent intent = null;
				switch (position) {
				case 0:
					intent = new Intent(getApplicationContext(), CamposTextoActivity.class);
					break;
				case 1:
					intent = new Intent(getApplicationContext(), BotonesActivity.class);
					break;
				case 2:
					intent = new Intent(getApplicationContext(), GrillaActivity.class);
					break;	
				case 3:
					intent = new Intent(getApplicationContext(), FechaHoraActivity.class);
					break;
				case 4:
					intent = new Intent(getApplicationContext(), OpcionesActivity.class);
					break;
				case 5:
					intent = new Intent(getApplicationContext(), MapasActivity.class);
					break;
				case 6:
					intent = new Intent(getApplicationContext(), CompatibilidadActivity.class);
					break;
				case 7:
					intent = new Intent(getApplicationContext(), SinCompatibilidadActivity.class);
					break;
				}
				
				startActivity(intent);
			}
		});
	}

}
