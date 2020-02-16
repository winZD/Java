package igrzan.beer.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;



import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import igrzan.beer.R;
import igrzan.beer.model.Beer;
import igrzan.beer.view.adapter.BeerAdapter;
import igrzan.beer.view.adapter.BeerClickListener;
import igrzan.beer.viewmodel.BeerViewModel;

public class ReadFragment extends Fragment {

    @BindView(R.id.swipeContainer)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.readList)
    ListView listView;

    BeerViewModel beerModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read,
                container, false);
        ButterKnife.bind(this,view);

        beerModel = ((MainActivity)getActivity()).getModel();

        definirajListu();
        definirajSwipe();
        osvjeziPodatke();


        return view;
    }

    private void osvjeziPodatke(){
        Log.wtf("kreuno","osvježi podatke");
        beerModel.getBeers().observe(this, new Observer<List<Beer>>() {
            @Override
            public void onChanged(@Nullable List<Beer> beers) {
                Log.wtf("završio","osvježi podatke");
                swipeRefreshLayout.setRefreshing(false);
                ((BeerAdapter)listView.getAdapter()).setPodaci(beers);
                ((BeerAdapter) listView.getAdapter()).notifyDataSetChanged();

            }
        });
    }
    private void definirajSwipe() {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                osvjeziPodatke();
            }
        });

    }

    private void definirajListu() {

        listView = (ListView)listView.findViewById(R.id.readList);
        listView.setAdapter(new BeerAdapter(getActivity(), new BeerClickListener() {
            @Override
            public void onItemClick(Beer beer) {
                beerModel.setBeer(beer);
                ((MainActivity)getActivity()).cud();
            }
        }));
    }

    @OnClick(R.id.fab)
    public void newBeer(){
        beerModel.setBeer(new Beer());
        ((MainActivity)getActivity()).cud();
    }



}