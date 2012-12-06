package edu.upc.demostp2;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MapasActivity extends MapActivity {

	private MapView mapa = null;
	private Button btnSatelite = null;
	private Button btnCentrar = null;
	private Button btnAnimar = null;
	private Button btnMover = null;
	private MapController controlMapa = null;
	private MyLocationOverlay overlay = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        
        //Obtenemos una referencia a los controles
        mapa = (MapView)findViewById(R.id.mapa);
        btnSatelite = (Button)findViewById(R.id.BtnSatelite);
        btnCentrar = (Button)findViewById(R.id.BtnCentrar);
        btnAnimar = (Button)findViewById(R.id.BtnAnimar);
        btnMover = (Button)findViewById(R.id.BtnMover);
        
        //Controlador del mapa
        controlMapa = mapa.getController();
        overlay = new MyLocationOverlay(this, mapa);
        overlay.enableMyLocation();
        mapa.getOverlays().add(overlay);
        mapa.postInvalidate();
        
        //Mostramos los controles de zoom sobre el mapa
        mapa.setBuiltInZoomControls(true);
        
        btnSatelite.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if(mapa.isSatellite())
					mapa.setSatellite(false);
				else
					mapa.setSatellite(true);
			}
		});
        
        btnCentrar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				GeoPoint loc = overlay.getMyLocation();
				
				controlMapa.setCenter(loc);
				controlMapa.setZoom(18);
			}
		});
        
        btnAnimar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				GeoPoint loc = overlay.getMyLocation();
				
				controlMapa.animateTo(loc);
				
				int zoomActual = mapa.getZoomLevel();
				for(int i=zoomActual; i<18; i++)
				{
					controlMapa.zoomIn();
				}
			}
		});
        
        btnMover.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				controlMapa.scrollBy(40, 40);
			}
		});
    }
    
    @Override
    protected boolean isRouteDisplayed() {
    	return true;
    }
}