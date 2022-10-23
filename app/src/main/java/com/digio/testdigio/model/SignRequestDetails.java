
package com.digio.testdigio.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignRequestDetails {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("requested_on")
    @Expose
    private String requestedOn;
    @SerializedName("expire_on")
    @Expose
    private String expireOn;
    @SerializedName("identifier")
    @Expose
    private String identifier;
    @SerializedName("requester_type")
    @Expose
    private String requesterType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequestedOn() {
        return requestedOn;
    }

    public void setRequestedOn(String requestedOn) {
        this.requestedOn = requestedOn;
    }

    public String getExpireOn() {
        return expireOn;
    }

    public void setExpireOn(String expireOn) {
        this.expireOn = expireOn;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getRequesterType() {
        return requesterType;
    }

    public void setRequesterType(String requesterType) {
        this.requesterType = requesterType;
    }

}
