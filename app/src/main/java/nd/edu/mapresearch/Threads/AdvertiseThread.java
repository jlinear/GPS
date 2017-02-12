package nd.edu.mapresearch.Threads;

import android.app.IntentService;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Intent;
import android.util.Log;

import nd.edu.mapresearch.Application.Application;
import nd.edu.mapresearch.MainActivity;

/**
 * Created by johnpconsidine on 5/5/16.
 */
public class AdvertiseThread extends IntentService {
    private static final String TAG = AdvertiseThread.class.getSimpleName();
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothLeAdvertiser mBluetoothLeAdvertiser;
    public static final String PARAM_OUT_MSG = "omsg";

    public AdvertiseThread() {
        super("AdvertiseThread");
        Log.v(TAG, "Created advertise thread");
        //BluetoothManager manager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
        BluetoothManager manager = (BluetoothManager) Application.mBluetoothManager;
        mBluetoothAdapter = manager.getAdapter();
        if (mBluetoothAdapter == null) {
            Log.v(TAG, "Adapter is null");
        }
        mBluetoothLeAdvertiser = mBluetoothAdapter.getBluetoothLeAdvertiser();
        if (mBluetoothLeAdvertiser == null) {
            Log.v(TAG, "Advertiser is null s");
        }
        setIntentRedelivery(true);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        String resultTxt = "BTReception";
        long endTime = System.currentTimeMillis() + 1 * 1000;
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(MainActivity.MyReceiver.ACTION_RESP);


        Log.v(TAG, "Sent broadcast!");
        Log.v(TAG, MainActivity.MyReceiver.ACTION_RESP);
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sendBroadcast(broadcastIntent);

            //Log.v(TAG, "I is " + i++);

        }
//        while (System.currentTimeMillis() < endTime) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//
//
//
//
//        }
    }


}