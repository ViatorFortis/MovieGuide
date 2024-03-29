package com.viatorfortis.popularmovies.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class Movie
        implements Parcelable {

    // for Popular movies part 2 project
    @SerializedName("id")
    private int mId;

    @SerializedName("title")
    private final String mTitle;

    @SerializedName("release_date")
    private final String mReleaseDate;

    @SerializedName("poster_path")
    private final String mPosterPath;

    @SerializedName("vote_average")
    private final float mVoteAverage;

    @SerializedName("overview")
    private final String mPlotSynopsis;

    public String getTitle() {
        return mTitle;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public float getVoteAverage() {
        return mVoteAverage;
    }

    public String getPlotSynopsis() {
        return mPlotSynopsis;
    }

    public Movie(String title, String releaseDate, String posterURL, float voteAverage, String plotSynopsis) {
        mTitle = title;
        mReleaseDate = releaseDate;
        mPosterPath = posterURL;
        mVoteAverage = voteAverage;
        mPlotSynopsis = plotSynopsis;
    }


    private Movie(Parcel in) {
        mTitle = in.readString();
        mReleaseDate = in.readString();
        mPosterPath = in.readString();
        mVoteAverage = in.readFloat();
        mPlotSynopsis = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mReleaseDate);
        dest.writeString(mPosterPath);
        dest.writeFloat(mVoteAverage);
        dest.writeString(mPlotSynopsis);
    }
}
