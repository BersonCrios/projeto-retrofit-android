
package br.com.berson.testeur.Models;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
//    public final static Parcelable.Creator<Result> CREATOR = new Creator<Result>() {
//
//
//        @SuppressWarnings({
//            "unchecked"
//        })
//        public Result createFromParcel(Parcel in) {
//            return new Result(in);
//        }
//
//        public Result[] newArray(int size) {
//            return (new Result[size]);
//        }
//
//    }
//    ;
    private final static long serialVersionUID = -4988869636613237303L;

    protected Result(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Result() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(url);
    }

    public int describeContents() {
        return  0;
    }

}
