package nd.edu.mapresearch.Application;

import android.bluetooth.BluetoothManager;
import android.util.Log;

import com.parse.Parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nd.edu.mapresearch.Classes.Marker;
import nd.edu.mapresearch.R;

/**
 * Created by johnpconsidine on 5/4/16.
 */
public class Application extends android.app.Application {

    private static final String TAG = Application.class.getSimpleName();
    static List<Marker> mMarkerList;
    static List<String> mMarkersUsed; //a list to be referenced to see if an exact location is already used
    static Map<Integer, Integer> drawableId;
    static public BluetoothManager mBluetoothManager;
    @Override
    public void onCreate() {
        super.onCreate();
        mMarkerList = new ArrayList<>();
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                        .applicationId("lqmx2GmYTOn8of5IM0LrrZ8bYT0ehDvzHTSdGLGA")
                        .clientKey(null)
                        .server("http://notredame.herokuapp.com/parse/") // The trailing slash is important.
                        .build()
        );
        mMarkersUsed = new ArrayList<>();
        drawableId = new HashMap<>();
        drawableId.put(0, R.drawable.ic_bear);
        drawableId.put(1, R.drawable.ic_accident);
        mBluetoothManager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);


    }

    public static void addMarker (Marker marker) {

        mMarkerList.add(marker);
        mMarkersUsed.add(marker.getLat() +"" + marker.getLongitude());
        Log.v(TAG, "THe size is  " + mMarkerList.size());
        //start broadcast service

    }

    public static boolean doesContain (float lat, float lon) {
        return mMarkersUsed.contains(lat + "" + lon);
    }

    public static void clear () {
        //when clear map called;
        mMarkersUsed.clear();
        mMarkerList.clear();
    }
    public static int getMarkersSize () {
        return mMarkerList.size();
    }
    public static Marker getMarker (int position) {
        return mMarkerList.get(position);
    }

}
