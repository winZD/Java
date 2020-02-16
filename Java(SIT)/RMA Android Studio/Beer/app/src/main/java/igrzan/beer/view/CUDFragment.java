package igrzan.beer.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;


import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import igrzan.beer.R;
import igrzan.beer.viewmodel.BeerViewModel;

import static android.R.layout.simple_spinner_item;

public class CUDFragment extends Fragment {

    static final int TAKING_PICTURE =1;

    private String currentPicturePath;


    @BindView(R.id.currentDate_time)
    EditText currentDate_time;

    @BindView(R.id.spinner)
    Spinner dropDownMenu;

    @BindView(R.id.beerName)
    EditText beerName;
    @BindView(R.id.beerMadeIn)
    EditText beerMadeIn;
    @BindView(R.id.beerPrice)
    EditText beerPrice;
    @BindView(R.id.picture)
    ImageView picture;

    @BindView(R.id.newBeer)
    Button btnNewBeer;
    @BindView(R.id.takePicture)
    Button btnTakePicture;
    @BindView(R.id.changeBeer)
    Button btnChangeBeer;
    @BindView(R.id.deleteBeer)
    Button btnDeleteBeer;

    BeerViewModel beerModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cud,
                container, false);
        ButterKnife.bind(this, view);
        beerModel = ((MainActivity) getActivity()).getModel();

        if (beerModel.getBeer().getId() == 0) {
            defineNewBeer();
            return view;
        }
        defineChangeUpdateDelete();

        return view;
    }

    //for spinner
    private void defineSpinnerDetails(){

        List<String> typeList=new ArrayList<>();
        typeList.add("lager");
        typeList.add("crafted");
        typeList.add("0 alchocol");
        typeList.add("dark");
        typeList.add("light");
        typeList.add("premium");
        typeList.add("fruit");
        typeList.add("lambic");




        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getContext(), simple_spinner_item,typeList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDownMenu.setAdapter(adapter);

        dropDownMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSelected=adapterView.getItemAtPosition(i).toString();
                beerModel.getBeer().setTypeOfBeer(itemSelected);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void defineChangeUpdateDelete() {
        btnNewBeer.setVisibility(View.GONE);
        beerName.setText(beerModel.getBeer().getBeerName());
        beerMadeIn.setText(beerModel.getBeer().getBeerMadeIn());
        beerPrice.setText(beerModel.getBeer().getPrice());

        currentDate_time.setText(beerModel.getBeer().getDate().toString());
        currentDate_time.setEnabled(false);

        defineSpinnerDetails();


        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePicture();
            }
        });

        btnChangeBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBeer();
            }
        });

        btnDeleteBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteBeer();
            }
        });


        if(beerModel.getBeer().getBeerPicturePath()==null){
            Picasso.get().load(R.drawable.unknown_beer_picture).fit().centerCrop().into(picture);
            return;
        }
        Picasso.get().load(beerModel.getBeer().getBeerPicturePath()).fit().centerCrop().into(picture);

    }

    private void changeBeer() {
        beerModel.getBeer().setBeerName(beerName.getText().toString());
        beerModel.getBeer().setBeerMadeIn(beerMadeIn.getText().toString());
        beerModel.getBeer().setPrice(beerPrice.getText().toString());
        beerModel.changeBeer();
        back();
    }

    private void defineNewBeer() {
        btnChangeBeer.setVisibility(View.GONE);
        btnDeleteBeer.setVisibility(View.GONE);
        btnTakePicture.setVisibility(View.GONE);

        Date date= Calendar.getInstance().getTime();
        currentDate_time.setText(date.toString());
        currentDate_time.setEnabled(false);

        defineSpinnerDetails();

        btnNewBeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newBeer();
            }
        });
    }

    private void newBeer() {
        beerModel.getBeer().setBeerName(beerName.getText().toString());
        beerModel.getBeer().setBeerMadeIn(beerMadeIn.getText().toString());
        beerModel.getBeer().setPrice(beerPrice.getText().toString());
        beerModel.getBeer().setDate(Calendar.getInstance().getTime());

        beerModel.addNewBeer();


        back();
    }

    private void deleteBeer() {
        beerModel.getBeer().setBeerName(beerName.getText().toString());
        beerModel.getBeer().setBeerMadeIn(beerMadeIn.getText().toString());
        beerModel.getBeer().setPrice(beerPrice.getText().toString());

        beerModel.deleteBeer();
        back();
    }

    @OnClick(R.id.back)
    public void back() {
        ((MainActivity) getActivity()).read();
    }

    private void takePicture() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) == null) {
            Toast.makeText(getActivity(), "Problem with creating picture", Toast.LENGTH_LONG).show();
            return;

        }
        // Create the File where the photo should go
        File picture = null;
        try {
            picture = createFilePictures();
        } catch (IOException ex) {
            Toast.makeText(getActivity(), "Problem with creating picture", Toast.LENGTH_LONG).show();
            return;
        }

        if (picture == null) {
            Toast.makeText(getActivity(), "Problem with creating picture", Toast.LENGTH_LONG).show();
            return;
        }

        Uri slikaURI = FileProvider.getUriForFile(getActivity(),"igrzan.beer.provider",picture);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, slikaURI);
        startActivityForResult(takePictureIntent, TAKING_PICTURE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TAKING_PICTURE && resultCode == Activity.RESULT_OK) {

            beerModel.getBeer().setBeerPicturePath("file://" + currentPicturePath);
            beerModel.changeBeer();
            Picasso.get().load(beerModel.getBeer().getBeerPicturePath()).into(picture);

        }
    }




    private File createFilePictures() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String pictureName = "BEER_" + timeStamp + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                pictureName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPicturePath = image.getAbsolutePath();
        return image;
    }

}
