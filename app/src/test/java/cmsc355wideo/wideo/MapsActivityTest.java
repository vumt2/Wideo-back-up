package cmsc355wideo.wideo;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import junit.framework.TestCase;

import org.junit.Test;

import static org.junit.Assert.*;

public class MapsActivityTest{
    protected GoogleMap mMap;
    protected LatLng richmond = new LatLng(37.5, -74.5);;

    public void setUp(){
        mMap.addMarker(new MarkerOptions().position(richmond).title("Marker in Richmond"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(richmond));
    }
    @Test
    public void onMapReady() throws Exception {

        assertEquals(new LatLng(37.5, -74.5), richmond);
    }

}