package igrzan.beer.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.List;

import igrzan.beer.R;
import igrzan.beer.model.Beer;

public class BeerAdapter extends BaseAdapter {

    private List<Beer> podaci;
    private BeerClickListener beerClickListener;
    private LayoutInflater layoutInflater;
    ViewHolder holder;
    Beer beer;


    public BeerAdapter(FragmentActivity activity, BeerClickListener beerClickListener) {
        this.beerClickListener = beerClickListener;
        layoutInflater = LayoutInflater.from(activity);
    }


    public void setPodaci(List<Beer> osobe) {
        this.podaci = osobe;
    }

    @Override
    public int getCount() {
        return podaci == null ? 0 : podaci.size();
    }

    @Override
    public Object getItem(int position) {
        return podaci.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        beer = podaci.get(position);


        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.row_list, null);
            holder = new ViewHolder(convertView);
            holder.beerName = convertView.findViewById(R.id.beerName);
            holder.typeOfBeer=convertView.findViewById(R.id.typeOfBeer);
            holder.picture = convertView.findViewById(R.id.pictureBeer);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.beerName.setText(beer.getBeerName().toUpperCase());
        holder.typeOfBeer.setText(beer.getTypeOfBeer().toUpperCase());
        holder.madeIn.setText(beer.getBeerMadeIn().toUpperCase());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beerClickListener.onItemClick(podaci.get(position));
            }
        });

        if (beer.getBeerPicturePath() == null) {
            Picasso.get().load(R.drawable.unknown_beer_picture).fit().centerCrop().into(holder.picture);
            return convertView;
        }
        Picasso.get().load(beer.getBeerPicturePath()).fit().centerCrop().into(holder.picture);

        return convertView;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView picture;
        private TextView beerName;
        private TextView typeOfBeer;
        private TextView madeIn;

        ViewHolder(View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.pictureBeer);
            beerName = itemView.findViewById(R.id.beerName);
            typeOfBeer= itemView.findViewById(R.id.typeOfBeer);
            madeIn=itemView.findViewById(R.id.countryOfOrigin);
        }
    }


}

