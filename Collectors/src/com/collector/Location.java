package com.collector;

class Location {
    private String locationName;
    private String state;

    public Location(String locationName, String state) {
        this.locationName = locationName;
        this.state = state;
    }

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Location [locationName=" + locationName + ", state=" + state + "]";
	}
    

}
