package nd.edu.mapresearch.Classes;

/**
 * Created by jerry on 8/30/16.
 */
public class BLE_Marker {

    private float longitude;
    private float latitude;
    private int ROM;
    private byte event_type;

    public byte getEvent_type(){
        return event_type;
    }

    public float getLongitude(){
        return longitude;
    }

    public float getLatitude(){
        return latitude;
    }

    public int getROM(){
        return ROM;
    }

    public void setEvent_type(byte event_type){
        this.event_type = event_type;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setROM(int rom){
        this.ROM = rom;
    }
}
