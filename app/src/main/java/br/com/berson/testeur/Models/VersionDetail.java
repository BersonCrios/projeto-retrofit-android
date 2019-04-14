
package br.com.berson.testeur.Models;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionDetail implements Serializable, Parcelable
{

    @SerializedName("rarity")
    @Expose
    private Integer rarity;
    @SerializedName("version")
    @Expose
    private Version_ version;
    public final static Parcelable.Creator<VersionDetail> CREATOR = new Creator<VersionDetail>() {


        @SuppressWarnings({
            "unchecked"
        })
        public VersionDetail createFromParcel(Parcel in) {
            return new VersionDetail(in);
        }

        public VersionDetail[] newArray(int size) {
            return (new VersionDetail[size]);
        }

    }
    ;
    private final static long serialVersionUID = 1657315916759314048L;

    protected VersionDetail(Parcel in) {
        this.rarity = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.version = ((Version_) in.readValue((Version_.class.getClassLoader())));
    }

    public VersionDetail() {
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public Version_ getVersion() {
        return version;
    }

    public void setVersion(Version_ version) {
        this.version = version;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(rarity);
        dest.writeValue(version);
    }

    public int describeContents() {
        return  0;
    }

}
