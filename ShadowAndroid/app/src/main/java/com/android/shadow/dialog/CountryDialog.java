package com.android.shadow.dialog;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;


import com.android.shadow.R;
import com.android.shadow.adapter.CountryCodeAdapter;
import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.interfaces.CountrySelection;
import com.android.shadow.model.output.CountryCodeOutput;
import com.android.shadow.views.auth.PhoneVerificationActivity;
import com.android.shadow.views.core.BaseActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kambojRavi on 4/24/2017.
 */

public class CountryDialog implements CountrySelection {
    private   CountrySelect mCountrySelect;
    BaseActivity mActivity;
    private RecyclerView mCountryRecyclerView;
    private AlertDialog mCountryDialog;


    public interface CountrySelect{
        void getCountryCode(String country);
    }




    /**
     * parametrized constructor 1
     *
     * @param activity:context of {@link PhoneVerificationActivity}
     */
    public CountryDialog( BaseActivity activity,CountrySelect countrySelect) {
        this.mActivity = activity;
        this.mCountrySelect=countrySelect;
    }


    /**
     * Thsi method is used to show country Dialog
     * @param country
     */
    public void showCountryDialog(ArrayList<CountryCodeOutput.Country> country) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(mActivity);
        LayoutInflater inflater = mActivity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.country_code_listview, null);
        dialogBuilder.setView(dialogView);
        mCountryRecyclerView = (RecyclerView) dialogView.findViewById(R.id.recycler_view_country_code);
        mCountryDialog = dialogBuilder.create();
        mCountryDialog.show();
        setAdapter(mCountryRecyclerView, country);
    }
    public void setAdapter(RecyclerView recyclerView, ArrayList<?> mList) {
        mActivity.setAdapter(recyclerView,mList);
        CountryCodeAdapter customAdapter = new CountryCodeAdapter(mActivity, mList, this,this);
        recyclerView.setAdapter(customAdapter);
    }

    public void hideCountryDialog() {
        mCountryDialog.dismiss();
    }

    @Override
    public void getCountrySelection(String code) {
        mCountrySelect.getCountryCode(code);

    }
}
