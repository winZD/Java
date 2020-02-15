package jakopec.mvvmroom.view.adapter;

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

import jakopec.mvvmroom.R;
import jakopec.mvvmroom.model.Beer;

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

    /* @Override
     public Red onCreateViewHolder(ViewGroup roditelj, int viewType) {
         LayoutInflater layoutInflater = LayoutInflater.from(roditelj.getContext());
         View view = layoutInflater.inflate(R.layout.red_liste, roditelj, false);
         return new Red(view);
     }

     @Override
     public void onBindViewHolder(Red red, int position) {
         Beer beer = podaci.get(position);
         red.beerName.setText(beer.getBeerName() + " " + beer.getBeerMadeIn()+" "+beer.getTypeOfBeer() );








         red.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 beerClickListener.onItemClick(beer); //build.gradle compiler options VERSION_1_8
             }
         });

         // Log.wtf("Beer picture", o.getBeerPicturePath());

         if(beer.getBeerPicturePath()==null){
             Picasso.get().load(R.drawable.nepoznato).fit().centerCrop().into(red.picture);
             return;
         }
         Picasso.get().load( beer.getBeerPicturePath()).fit().centerCrop().into(red.picture);
     }

     @Override
     public int getItemCount() {
         return podaci==null ? 0 : podaci.size();
     }
 */
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
    public View getView(int position, View convertView, ViewGroup parent) {
        beer = podaci.get(position);


        if (convertView == null) {
           convertView = layoutInflater.inflate(R.layout.red_liste, null);
            holder = new ViewHolder(convertView);
            holder.beerName = convertView.findViewById(R.id.beerName);
            holder.typeOfBeer=convertView.findViewById(R.id.typeOfBeer);
            holder.picture = convertView.findViewById(R.id.pictureBeer);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.beerName.setText(beer.getBeerName());
        holder.typeOfBeer.setText(beer.getTypeOfBeer());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beerClickListener.onItemClick(podaci.get(position));
            }
        });

        if (beer.getBeerPicturePath() == null) {
            Picasso.get().load(R.drawable.nepoznato).fit().centerCrop().into(holder.picture);
            return convertView;
        }
        Picasso.get().load(beer.getBeerPicturePath()).fit().centerCrop().into(holder.picture);

        return convertView;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView picture;
        private TextView beerName;
        private TextView typeOfBeer;

        ViewHolder(View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.pictureBeer);
            beerName = itemView.findViewById(R.id.beerName);
            typeOfBeer= itemView.findViewById(R.id.typeOfBeer);
        }
    }


}
