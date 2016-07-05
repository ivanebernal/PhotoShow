package com.ivanebernal.photoshow.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Videos implements Parcelable {

    @SerializedName("low_resolution")
    @Expose
    private LowResolution_ lowResolution;
    @SerializedName("standard_resolution")
    @Expose
    private StandardResolution_ standardResolution;
    @SerializedName("low_bandwidth")
    @Expose
    private LowBandwidth lowBandwidth;

    protected Videos(Parcel in) {
        lowResolution = in.readParcelable(LowResolution_.class.getClassLoader());
        standardResolution = in.readParcelable(StandardResolution_.class.getClassLoader());
        lowBandwidth = in.readParcelable(LowBandwidth.class.getClassLoader());
    }

    public static final Creator<Videos> CREATOR = new Creator<Videos>() {
        @Override
        public Videos createFromParcel(Parcel in) {
            return new Videos(in);
        }

        @Override
        public Videos[] newArray(int size) {
            return new Videos[size];
        }
    };

    /**
     *
     * @return
     * The lowResolution
     */
    public LowResolution_ getLowResolution() {
        return lowResolution;
    }

    /**
     *
     * @param lowResolution
     * The low_resolution
     */
    public void setLowResolution(LowResolution_ lowResolution) {
        this.lowResolution = lowResolution;
    }

    /**
     *
     * @return
     * The standardResolution
     */
    public StandardResolution_ getStandardResolution() {
        return standardResolution;
    }

    /**
     *
     * @param standardResolution
     * The standard_resolution
     */
    public void setStandardResolution(StandardResolution_ standardResolution) {
        this.standardResolution = standardResolution;
    }

    /**
     *
     * @return
     * The lowBandwidth
     */
    public LowBandwidth getLowBandwidth() {
        return lowBandwidth;
    }

    /**
     *
     * @param lowBandwidth
     * The low_bandwidth
     */
    public void setLowBandwidth(LowBandwidth lowBandwidth) {
        this.lowBandwidth = lowBandwidth;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(lowResolution, flags);
        dest.writeParcelable(standardResolution, flags);
        dest.writeParcelable(lowBandwidth, flags);
    }
}