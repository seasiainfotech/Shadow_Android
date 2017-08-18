package com.android.shadow.addressvalidator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.android.shadow.R;
import com.android.shadow.views.auth.school.SchoolActivity;
import com.android.shadow.views.core.BaseActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.model.LatLng;

public class LocationActivity extends AppCompatActivity implements PlaceSelectionListener {

    private PlaceAutocompleteFragment autocompleteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(this);
    }

    @Override
    public void onPlaceSelected(Place places) {
        LatLng latlong = places.getLatLng();
        Toast.makeText(this, "" + places.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Status status) {

    }
}
