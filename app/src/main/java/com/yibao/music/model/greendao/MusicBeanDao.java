package com.yibao.music.model.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.yibao.music.model.MusicBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "MUSIC_BEAN".
*/
public class MusicBeanDao extends AbstractDao<MusicBean, Long> {

    public static final String TABLENAME = "MUSIC_BEAN";

    /**
     * Properties of entity MusicBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Title = new Property(1, String.class, "title", false, "TITLE");
        public final static Property Artist = new Property(2, String.class, "artist", false, "ARTIST");
        public final static Property Album = new Property(3, String.class, "album", false, "ALBUM");
        public final static Property AlbumId = new Property(4, long.class, "albumId", false, "ALBUM_ID");
        public final static Property AddTime = new Property(5, long.class, "addTime", false, "ADD_TIME");
        public final static Property Duration = new Property(6, long.class, "duration", false, "DURATION");
        public final static Property Time = new Property(7, String.class, "time", false, "TIME");
        public final static Property SongUrl = new Property(8, String.class, "songUrl", false, "SONG_URL");
        public final static Property FirstChar = new Property(9, String.class, "firstChar", false, "FIRST_CHAR");
        public final static Property IsFavorite = new Property(10, boolean.class, "isFavorite", false, "IS_FAVORITE");
        public final static Property PlayFrequency = new Property(11, int.class, "playFrequency", false, "PLAY_FREQUENCY");
        public final static Property SongScore = new Property(12, int.class, "songScore", false, "SONG_SCORE");
        public final static Property PlayStatus = new Property(13, int.class, "playStatus", false, "PLAY_STATUS");
        public final static Property IssueYear = new Property(14, int.class, "issueYear", false, "ISSUE_YEAR");
        public final static Property MusicQualityType = new Property(15, int.class, "musicQualityType", false, "MUSIC_QUALITY_TYPE");
        public final static Property CurrentLyrics = new Property(16, String.class, "currentLyrics", false, "CURRENT_LYRICS");
    }


    public MusicBeanDao(DaoConfig config) {
        super(config);
    }
    
    public MusicBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"MUSIC_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"TITLE\" TEXT," + // 1: title
                "\"ARTIST\" TEXT," + // 2: artist
                "\"ALBUM\" TEXT," + // 3: album
                "\"ALBUM_ID\" INTEGER NOT NULL ," + // 4: albumId
                "\"ADD_TIME\" INTEGER NOT NULL ," + // 5: addTime
                "\"DURATION\" INTEGER NOT NULL ," + // 6: duration
                "\"TIME\" TEXT," + // 7: time
                "\"SONG_URL\" TEXT," + // 8: songUrl
                "\"FIRST_CHAR\" TEXT," + // 9: firstChar
                "\"IS_FAVORITE\" INTEGER NOT NULL ," + // 10: isFavorite
                "\"PLAY_FREQUENCY\" INTEGER NOT NULL ," + // 11: playFrequency
                "\"SONG_SCORE\" INTEGER NOT NULL ," + // 12: songScore
                "\"PLAY_STATUS\" INTEGER NOT NULL ," + // 13: playStatus
                "\"ISSUE_YEAR\" INTEGER NOT NULL ," + // 14: issueYear
                "\"MUSIC_QUALITY_TYPE\" INTEGER NOT NULL ," + // 15: musicQualityType
                "\"CURRENT_LYRICS\" TEXT);"); // 16: currentLyrics
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"MUSIC_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, MusicBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String artist = entity.getArtist();
        if (artist != null) {
            stmt.bindString(3, artist);
        }
 
        String album = entity.getAlbum();
        if (album != null) {
            stmt.bindString(4, album);
        }
        stmt.bindLong(5, entity.getAlbumId());
        stmt.bindLong(6, entity.getAddTime());
        stmt.bindLong(7, entity.getDuration());
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(8, time);
        }
 
        String songUrl = entity.getSongUrl();
        if (songUrl != null) {
            stmt.bindString(9, songUrl);
        }
 
        String firstChar = entity.getFirstChar();
        if (firstChar != null) {
            stmt.bindString(10, firstChar);
        }
        stmt.bindLong(11, entity.getIsFavorite() ? 1L: 0L);
        stmt.bindLong(12, entity.getPlayFrequency());
        stmt.bindLong(13, entity.getSongScore());
        stmt.bindLong(14, entity.getPlayStatus());
        stmt.bindLong(15, entity.getIssueYear());
        stmt.bindLong(16, entity.getMusicQualityType());
 
        String currentLyrics = entity.getCurrentLyrics();
        if (currentLyrics != null) {
            stmt.bindString(17, currentLyrics);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, MusicBean entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(2, title);
        }
 
        String artist = entity.getArtist();
        if (artist != null) {
            stmt.bindString(3, artist);
        }
 
        String album = entity.getAlbum();
        if (album != null) {
            stmt.bindString(4, album);
        }
        stmt.bindLong(5, entity.getAlbumId());
        stmt.bindLong(6, entity.getAddTime());
        stmt.bindLong(7, entity.getDuration());
 
        String time = entity.getTime();
        if (time != null) {
            stmt.bindString(8, time);
        }
 
        String songUrl = entity.getSongUrl();
        if (songUrl != null) {
            stmt.bindString(9, songUrl);
        }
 
        String firstChar = entity.getFirstChar();
        if (firstChar != null) {
            stmt.bindString(10, firstChar);
        }
        stmt.bindLong(11, entity.getIsFavorite() ? 1L: 0L);
        stmt.bindLong(12, entity.getPlayFrequency());
        stmt.bindLong(13, entity.getSongScore());
        stmt.bindLong(14, entity.getPlayStatus());
        stmt.bindLong(15, entity.getIssueYear());
        stmt.bindLong(16, entity.getMusicQualityType());
 
        String currentLyrics = entity.getCurrentLyrics();
        if (currentLyrics != null) {
            stmt.bindString(17, currentLyrics);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public MusicBean readEntity(Cursor cursor, int offset) {
        MusicBean entity = new MusicBean( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // title
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // artist
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // album
            cursor.getLong(offset + 4), // albumId
            cursor.getLong(offset + 5), // addTime
            cursor.getLong(offset + 6), // duration
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // time
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // songUrl
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // firstChar
            cursor.getShort(offset + 10) != 0, // isFavorite
            cursor.getInt(offset + 11), // playFrequency
            cursor.getInt(offset + 12), // songScore
            cursor.getInt(offset + 13), // playStatus
            cursor.getInt(offset + 14), // issueYear
            cursor.getInt(offset + 15), // musicQualityType
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16) // currentLyrics
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, MusicBean entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setTitle(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setArtist(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAlbum(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setAlbumId(cursor.getLong(offset + 4));
        entity.setAddTime(cursor.getLong(offset + 5));
        entity.setDuration(cursor.getLong(offset + 6));
        entity.setTime(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setSongUrl(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setFirstChar(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setIsFavorite(cursor.getShort(offset + 10) != 0);
        entity.setPlayFrequency(cursor.getInt(offset + 11));
        entity.setSongScore(cursor.getInt(offset + 12));
        entity.setPlayStatus(cursor.getInt(offset + 13));
        entity.setIssueYear(cursor.getInt(offset + 14));
        entity.setMusicQualityType(cursor.getInt(offset + 15));
        entity.setCurrentLyrics(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(MusicBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(MusicBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(MusicBean entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
