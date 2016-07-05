package com.ivanebernal.photoshow.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRecentMedia implements Parcelable {

    @SerializedName("pagination")
    @Expose
    private Pagination pagination;
    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();

    public UserRecentMedia(){

    }
    protected UserRecentMedia(Parcel in) {
        pagination = in.readParcelable(Pagination.class.getClassLoader());
        meta = in.readParcelable(Meta.class.getClassLoader());
        data = in.createTypedArrayList(Datum.CREATOR);
    }

    public static final Creator<UserRecentMedia> CREATOR = new Creator<UserRecentMedia>() {
        @Override
        public UserRecentMedia createFromParcel(Parcel in) {
            return new UserRecentMedia(in);
        }

        @Override
        public UserRecentMedia[] newArray(int size) {
            return new UserRecentMedia[size];
        }
    };

    /**
     *
     * @return
     * The pagination
     */
    public Pagination getPagination() {
        return pagination;
    }

    /**
     *
     * @param pagination
     * The pagination
     */
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    /**
     *
     * @return
     * The meta
     */
    public Meta getMeta() {
        return meta;
    }

    /**
     *
     * @param meta
     * The meta
     */
    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    /**
     *
     * @return
     * The data
     */
    public List<Datum> getData() {
        return data;
    }

    /**
     *
     * @param data
     * The data
     */
    public void setData(List<Datum> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(pagination, flags);
        dest.writeParcelable(meta, flags);
        dest.writeTypedList(data);
    }
}