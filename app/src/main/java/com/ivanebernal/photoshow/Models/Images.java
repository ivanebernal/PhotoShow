package com.ivanebernal.photoshow.Models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images implements Parcelable {

    @SerializedName("low_resolution")
    @Expose
    private LowResolution lowResolution;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("standard_resolution")
    @Expose
    private StandardResolution standardResolution;

    protected Images(Parcel in) {
        lowResolution = in.readParcelable(LowResolution.class.getClassLoader());
        thumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
        standardResolution = in.readParcelable(StandardResolution.class.getClassLoader());
    }

    public static final Creator<Images> CREATOR = new Creator<Images>() {
        @Override
        public Images createFromParcel(Parcel in) {
            return new Images(in);
        }

        @Override
        public Images[] newArray(int size) {
            return new Images[size];
        }
    };

    /**
     *
     * @return
     * The lowResolution
     */
    public LowResolution getLowResolution() {
        return lowResolution;
    }

    /**
     *
     * @param lowResolution
     * The low_resolution
     */
    public void setLowResolution(LowResolution lowResolution) {
        this.lowResolution = lowResolution;
    }

    /**
     *
     * @return
     * The thumbnail
     */
    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    /**
     *
     * @param thumbnail
     * The thumbnail
     */
    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     *
     * @return
     * The standardResolution
     */
    public StandardResolution getStandardResolution() {
        return standardResolution;
    }

    /**
     *
     * @param standardResolution
     * The standard_resolution
     */
    public void setStandardResolution(StandardResolution standardResolution) {
        this.standardResolution = standardResolution;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(lowResolution, flags);
        dest.writeParcelable(thumbnail, flags);
        dest.writeParcelable(standardResolution, flags);
    }
}