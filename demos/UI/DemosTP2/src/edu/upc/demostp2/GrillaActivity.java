package edu.upc.demostp2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GrillaActivity extends Activity {
	
	private GridView gridView;
	private int[] imageArray = {R.drawable.android,
								R.drawable.cupcake,
								R.drawable.donut,
								R.drawable.eclair,
								R.drawable.froyo,
								R.drawable.gingerbread,
								R.drawable.honeycomb,
								R.drawable.ics,
								R.drawable.jellybean,
								R.drawable.android,
								R.drawable.cupcake,
								R.drawable.donut,
								R.drawable.eclair,
								R.drawable.froyo,
								R.drawable.gingerbread,
								R.drawable.honeycomb,
								R.drawable.ics,
								R.drawable.jellybean,
								R.drawable.android,
								R.drawable.cupcake,
								R.drawable.donut,
								R.drawable.eclair,
								R.drawable.froyo,
								R.drawable.gingerbread,
								R.drawable.honeycomb,
								R.drawable.ics,
								R.drawable.jellybean};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_activity);
		gridView = (GridView) findViewById(R.id.grilla);
		gridView.setAdapter(new ImageAdapter(this));
	}
	
	public class ImageAdapter extends BaseAdapter {

		private Context context;
		
		public ImageAdapter(Context context){
			this.context = context;
		}
		
		@Override
		public int getCount() {
			return imageArray.length;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if(convertView == null){
				imageView = new ImageView(context);
			} else {
				imageView = (ImageView) convertView;
			}
			imageView.setImageResource(imageArray[position]);
			return imageView;
		}
		
	}
}
