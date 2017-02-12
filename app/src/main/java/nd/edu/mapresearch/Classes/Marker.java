package nd.edu.mapresearch.Classes;

/**
 * Created by johnpconsidine on 5/4/16.
 */
public class Marker {
    public float getLat() {
        return (float)lat;
    }

    public float getLongitude() {
        return (float)longitude;
    }

    private double lat;
    private double longitude;

    public double getDistanceFrom() {
        return distanceFrom;
    }

    public void setDistanceFrom(double distanceFrom) {
        this.distanceFrom = distanceFrom;
    }

    private double distanceFrom; //the user's distance to this marker


    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    private int iconId;
    private boolean multihop; //first advertise or repeat?

    public boolean isMultihop() {
        return multihop;
    }

    public Marker (double lat, double longitude, double distanceFrom, boolean multihop) {
        this.lat = lat;
        this.longitude = longitude;
        this.distanceFrom = distanceFrom;
        this.multihop = multihop;
    }




}
