
package br.com.berson.testeur.Models;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeldItem implements Serializable, Parcelable
{

    @SerializedName("item")
    @Expose
    private Item item;
    @SerializedName("version_details")
    @Expose
    private List<VersionDetail> versionDetails = null;
    public final static Parcelable.Creator<HeldItem> CREATOR = new Creator<HeldItem>() {


        @SuppressWarnings({
            "unchecked"
        })
        public HeldItem createFromParcel(Parcel in) {
            return new HeldItem(in);
        }

        public HeldItem[] newArray(int size) {
            return (new HeldItem[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4599556154851224628L;

    protected HeldItem(Parcel in) {
        this.item = ((Item) in.readValue((Item.class.getClassLoader())));
        in.readList(this.versionDetails, (br.com.berson.testeur.Models.VersionDetail.class.getClassLoader()));
    }

    public HeldItem() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<VersionDetail> getVersionDetails() {
        return versionDetails;
    }

    public void setVersionDetails(List<VersionDetail> versionDetails) {
        this.versionDetails = versionDetails;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(item);
        dest.writeList(versionDetails);
    }

    public int describeContents() {
        return  0;
    }

}
