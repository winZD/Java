package jakopec.mvvmroom.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import jakopec.mvvmroom.dao.BeerDatabase;
import jakopec.mvvmroom.dao.BeerDao;
import jakopec.mvvmroom.model.Beer;

public class BeerViewModel extends AndroidViewModel {

    BeerDao BeerDAO;

    private Beer beer;

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    private LiveData<List<Beer>> beers;

    public BeerViewModel(Application application) {
        super(application);
        BeerDAO = BeerDatabase.getDatabase(application.getApplicationContext()).beerDAO();

    }

    public LiveData<List<Beer>> getBeers() {
        beers = BeerDAO.getBeers();
        return beers;
    }

    public void addNewBeer() {

        BeerDAO.addNewBeer(beer);
    }

    public void changeBeer() {

        BeerDAO.changeBeer(beer);
    }

    public void deleteBeer() {

        BeerDAO.deleteBeer(beer);
    }

}
