/**
 * A Java object which can hold the information for a location returned in JSON-format by a query of GoEuro's position API.
 * Location private variable names must match their equivalent data labels in the location JSON structure.
 */
public class Location {

    /**
     * Private Location class variable declarations.
     */
    private String _type;
    private Integer _id;
    private String key;
    private String name;
    private String type;
    private String fullName;
    private String iata_airport_code;
    private String country;
    private GeoPosition geo_position;
    private Integer location_id;
    private Boolean inEurope;
    private String countryCode;
    private Boolean coreCountry;
    private Integer distance;

    /**
     * Private default constructor method, necessary for GSON's JSON parser to correctly load object contents from JSON data.
     */
    private Location (){
        this._type = null;
        this._id = null;
        this.key = null;
        this.name = null;
        this.fullName = null;
        this.iata_airport_code = null;
        this.country = null;
        this.geo_position = null;
        this.location_id = null;
        this.inEurope = null;
        this.countryCode = null;
        this.coreCountry = null;
        this.distance = null;
    }

    /*
     * Getters and setters for all private variables in the Location object
     */
    public void set_type(String _type) {
        this._type = _type;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIata_airport_code(String iata_airport_code) {
        this.iata_airport_code = iata_airport_code;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setGeo_position(GeoPosition geo_position) {
        this.geo_position = geo_position;
    }

    public void setLocation_id(Integer location_id) {
        this.location_id = location_id;
    }

    public void setInEurope(Boolean inEurope) {
        this.inEurope = inEurope;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCoreCountry(Boolean coreCountry) {
        this.coreCountry = coreCountry;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String get_type() { return _type; }

    public Integer get_id() {
        return _id;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getFullName() {
        return fullName;
    }

    public String getIata_airport_code() {
        return iata_airport_code;
    }

    public String getCountry() {
        return country;
    }

    public GeoPosition getGeo_position() {
        return geo_position;
    }

    public Integer getLocation_id() {
        return location_id;
    }

    public Boolean getInEurope() {
        return inEurope;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Boolean getCoreCountry() {
        return coreCountry;
    }

    public Integer getDistance() {
        return distance;
    }

    /**
     * Returns a string representation of a Location object
     * @return
     */
    @Override
    public String toString(){
        return ("_type: " + this._type + ", _id: " + this._id +
                ", key: " + this.key + ", name: " + this.name +
                ", fullName: " + this.fullName + ", iata_airport_code: " +
                this.iata_airport_code + ", type: " + this.type + ", country: " +
                this.country + ", geo_position: {latitude: " +
                this.geo_position.getLatitude() + ", longitude: " + this.geo_position.getLongitude() + "}, location_id: " +
                this.location_id + ", inEurope: " + this.inEurope + ", countryCode: " + this.countryCode + ", coreCountry: " +
                this.coreCountry + ", distance: " + this.distance);
    }
}
