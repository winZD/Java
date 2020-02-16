package igrzan.beer.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import igrzan.beer.model.Beer;


@Dao
public interface BeerDao {

    @Query("select * from Beer order by beerName")
    LiveData<List<Beer>> getBeers();

    @Insert
    void addNewBeer(Beer beer);

    @Update
    void changeBeer(Beer beer);

    @Delete
    void deleteBeer(Beer beer);


}

