/**
 * A GeoPosition object, which contains a latitude and a longitude. GeoPosition private variable names must match
 * their equivalent data labels in the location JSON structure.
 */

public class GeoPosition {

    /*
     * Private class variable declarations.
     */
    private Float latitude;
    private Float longitude;

    /**
     * Default constructor
     */
    public GeoPosition(){
        this.latitude = null;
        this.longitude = null;
    }

    /**
     * Constructer with latitude and longitude parameters.
     * @param latitude the latitude for this GeoPosition
     * @param longitude the longitude for this GeoPosition
     */
    public GeoPosition(Float latitude, Float longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Getter method for latitude
     * @return the latitude stored in this GeoPosition object
     */
    public Float getLatitude(){
        return this.latitude;
    }


    /**
     * Setter method for latitude
     * @param latitude the latitude for this GeoPosition
     */
    public void setLatitude(Float latitude){
        this.latitude = latitude;
    }

    /**
     * Getter method for longitude
     * @return
     */
    public Float getLongitude(){
        return this.longitude;
    }

    /**
     * Setter method for longitude
     * @param longitude the longitude for this GeoPosition object
     */
    public void setLongitude(Float longitude){
        this.longitude = longitude;
    }

    /**
     * Returns a string representation of a GeoPosition object
     * @return
     */
    @Override
    public String toString(){
        return ("longitude: " + Float.toString(this.longitude) + ", latitude: " + Float.toString(this.latitude));
    }
}
