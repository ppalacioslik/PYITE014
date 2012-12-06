package com.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends Activity {

	Button btnDividir;
	Button btnMultiplicar;
	Button btnRestar;
	Button btnSumar;
	EditText edt1;
	EditText edt2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calculator);
		edt1 = (EditText) findViewById(R.id.edtNumber1);
		edt2 = (EditText) findViewById(R.id.edtNumber2);
		btnDividir = (Button) findViewById(R.id.btnDividir);
		btnMultiplicar = (Button) findViewById(R.id.btnMultiplicar);
		btnRestar= (Button) findViewById(R.id.btnRestar);
		btnSumar = (Button) findViewById(R.id.btnSumar);
	}
	
	public void onClick(View v) {
		String s1 = edt1.getText().toString();
		String s2 = edt2.getText().toString();
		if(s1.equals("") || s2.equals("")) {
			Toast.makeText(this, "Debe ingresar los 2 valores a operar.", Toast.LENGTH_SHORT).show();
			return;
		}
		double n1 = Integer.parseInt(s1);
		double n2 = Integer.parseInt(s2);
		double m = 0;
		if(v.getId() == btnDividir.getId()) {
			if(n2 == 0) {
				Toast.makeText(this, "No se puede realizar una divisi—n entre cero.", Toast.LENGTH_SHORT).show();
				return;
			}
			m = n1 / n2;
		}
		if(v.getId() == btnMultiplicar.getId()) {
			m = n1 * n2;
		}
		if(v.getId() == btnRestar.getId()) {
			m = n1 - n2;
		}
		if(v.getId() == btnSumar.getId()) {
			m = n1 + n2;
		}
		TextView txtResultado = (TextView) findViewById(R.id.txtResult);
		txtResultado.setText(String.valueOf(m));
	}

}
