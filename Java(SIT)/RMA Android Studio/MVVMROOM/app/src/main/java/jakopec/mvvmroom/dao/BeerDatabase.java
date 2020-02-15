package jakopec.mvvmroom.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import jakopec.mvvmroom.model.Beer;

//singleton
@Database(entities = {Beer.class}, version = 1, exportSchema = false)
public abstract class BeerDatabase extends RoomDatabase {
    //abstract je zato što bi inače morala implementirate metode iz RoomDatabase koje mi ne trebaju
    public abstract BeerDao beerDAO();

    private static BeerDatabase INSTANCE;

    public static BeerDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            //.allowMainThreadQueries() omogućuje da radimo iz app thread - NIJE DOBRO, trebalo bi async task
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BeerDatabase.class, "Beer").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
