package com.execube.elantra.model;

import java.util.UUID;

/**
 * Created by Prateek Phoenix on 4/16/2016.
 */
public class Events {


    private UUID id;
    private String mEvent;
    private String mVenue;
    private String mDetails;
    private String mTime;
    private boolean mFavourite;
    private String mPhoneNumber;


    public Events() {
        id=UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getEvent() {
        return mEvent;
    }

    public String getVenue() {
        return mVenue;
    }

    public String getDetails() {
        return mDetails;
    }

    public String getTime() {
        return mTime;
    }

    public boolean isFavourite() {
        return mFavourite;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }


    public void setEvent(String mEvent) {
        this.mEvent = mEvent;
    }

    public void setVenue(String mVenue) {
        this.mVenue = mVenue;
    }

    public void setDetails(String mDetails) {
        this.mDetails = mDetails;
    }

    public void setTime(String mCoordinator) {
        this.mTime = mCoordinator;
    }

    public void setFavourite(boolean favourite) {
        this.mFavourite = favourite;
    }

    public void setPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }
}
