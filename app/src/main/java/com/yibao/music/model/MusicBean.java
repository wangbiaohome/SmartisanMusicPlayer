package com.yibao.music.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author：Sid
 * Des：${音乐实体类,收藏 删除等}
 * Time:2017/9/3 14:31
 *
 * @author Stran
 */
@Entity
public class MusicBean
        implements Parcelable, Comparable<MusicBean> {
    @Id(autoincrement = true)
    private Long id;
    private String title;
    private String artist;
    private String album;
    private long albumId;
    private long addTime;
    private long duration;
    private String time;
    private String songUrl;
    private String firstChar;
    private boolean isFavorite;
    private int playFrequency;
    private int songScore;
    private int playStatus;
    private int issueYear;
    private int musicQualityType;
    /**
     * QQ bar上需要时时更新的歌词
     */
    private String currentLyrics;
    /**
     * 这个cureetPosition是给QqPagerAdapter用的，用于切换到指定的位置
     */
    @Transient
    private int cureetPosition;


    public MusicBean() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public long getAddTime() {
        return addTime;
    }

    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getPlayFrequency() {
        return playFrequency;
    }

    public void setPlayFrequency(int playFrequency) {
        this.playFrequency = playFrequency;
    }

    public int getSongScore() {
        return songScore;
    }

    public void setSongScore(int songScore) {
        this.songScore = songScore;
    }

    public int getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(int playStatus) {
        this.playStatus = playStatus;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    public int getMusicQualityType() {
        return musicQualityType;
    }

    public void setMusicQualityType(int musicQualityType) {
        this.musicQualityType = musicQualityType;
    }

    public String getCurrentLyrics() {
        return currentLyrics;
    }

    public void setCurrentLyrics(String currentLyrics) {
        this.currentLyrics = currentLyrics;
    }

    public int getCureetPosition() {
        return cureetPosition;
    }

    public void setCureetPosition(int cureetPosition) {
        this.cureetPosition = cureetPosition;
    }

    public static Creator<MusicBean> getCREATOR() {
        return CREATOR;
    }

    protected MusicBean(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        title = in.readString();
        artist = in.readString();
        album = in.readString();
        albumId = in.readLong();
        addTime = in.readLong();
        duration = in.readLong();
        time = in.readString();
        songUrl = in.readString();
        firstChar = in.readString();
        isFavorite = in.readByte() != 0;
        playFrequency = in.readInt();
        songScore = in.readInt();
        playStatus = in.readInt();
        issueYear = in.readInt();
        musicQualityType = in.readInt();
        currentLyrics = in.readString();
        cureetPosition = in.readInt();
    }


    @Generated(hash = 1772482409)
    public MusicBean(Long id, String title, String artist, String album,
            long albumId, long addTime, long duration, String time, String songUrl,
            String firstChar, boolean isFavorite, int playFrequency, int songScore,
            int playStatus, int issueYear, int musicQualityType,
            String currentLyrics) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.albumId = albumId;
        this.addTime = addTime;
        this.duration = duration;
        this.time = time;
        this.songUrl = songUrl;
        this.firstChar = firstChar;
        this.isFavorite = isFavorite;
        this.playFrequency = playFrequency;
        this.songScore = songScore;
        this.playStatus = playStatus;
        this.issueYear = issueYear;
        this.musicQualityType = musicQualityType;
        this.currentLyrics = currentLyrics;
    }

    public static final Creator<MusicBean> CREATOR = new Creator<MusicBean>() {
        @Override
        public MusicBean createFromParcel(Parcel in) {
            return new MusicBean(in);
        }

        @Override
        public MusicBean[] newArray(int size) {
            return new MusicBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(id);
        }
        dest.writeString(title);
        dest.writeString(artist);
        dest.writeString(album);
        dest.writeLong(albumId);
        dest.writeLong(addTime);
        dest.writeLong(duration);
        dest.writeString(time);
        dest.writeString(songUrl);
        dest.writeString(firstChar);
        dest.writeByte((byte) (isFavorite ? 1 : 0));
        dest.writeInt(playFrequency);
        dest.writeInt(songScore);
        dest.writeInt(playStatus);
        dest.writeInt(issueYear);
        dest.writeInt(musicQualityType);
        dest.writeString(currentLyrics);
        dest.writeInt(cureetPosition);
    }

    @Override
    public int compareTo(@NonNull MusicBean o) {
        return 0;
    }


    public boolean getIsFavorite() {
        return this.isFavorite;
    }


    public void setIsFavorite(boolean isFavorite) {
        this.isFavorite = isFavorite;
    }
}
