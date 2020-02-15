package jakopec.mvvmroom.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@TypeConverters(DateConverter.class)
@Getter
@Setter
@Entity(tableName = "beer")
public class Beer implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    @NonNull
    @ColumnInfo(name = "beerName")
    private String beerName;
    private String beerMadeIn;
    private Date date;
    private String price;
    private String typeOfBeer;
    private String beerPicturePath;

}


