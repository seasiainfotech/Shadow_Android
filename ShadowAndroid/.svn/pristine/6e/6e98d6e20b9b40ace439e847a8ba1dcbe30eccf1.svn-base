package com.android.shadow.dialog;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.android.shadow.R;
import com.android.shadow.adapter.CompanyListAdapter;
import com.android.shadow.model.output.GetAvailableCompanyListResponse;
import com.android.shadow.presenter.CompanyListPresenter;
import com.android.shadow.presenter.ProfilePresenter;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.core.BaseActivity;

import java.util.ArrayList;

/**
 * Created by singhgharjyot on 7/21/2017.
 */

public class CompanyListDialog extends BaseDialog implements
        CompanyListAdapter.OnItemClick, CompanyListPresenter.CompanyCallback, View.OnClickListener {

    private final CompanyNameCallback companyNameCallback;
    private final int screenName;
    private BaseActivity mBaseActivity;
    private AutoCompleteTextView mSchool;
    ArrayList<GetAvailableCompanyListResponse.Data> schoolList;
    private ArrayList<String> mSchoolist;
    private ProfilePresenter profilePresenter;
    private EditText mSchoolEditText;
    private RecyclerView recyclerView;
    //private SchoolAdapter mSchoolAdapter;
    private CompanyListAdapter mCompanyListAdapter;

    @Override
    public void onCompanySuccess(GetAvailableCompanyListResponse response) {
        if (response != null && response.getStatus() != null && response.getStatus().equals("200")) {
            if (mCompanyListAdapter == null) {
                setAdapter(response.getData().getCompanyList());
            } else {
                mCompanyListAdapter.notifyAdapter(response.getData().getCompanyList());
            }
        } else {
            showToast(R.string.no_data_found_msg);
        }
    }


    public interface CompanyNameCallback {
        void getCompanyName(String companyName);
    }

    /**
     * parametrized constructor
     *
     * @param baseActivity:Context        of {@link BaseActivity}
     * @param companyNameCallback:context of interface
     * @param screenName:0                for {@link com.android.shadow.views.profile.editprofile.EditProfileUserActivity}
     *                                    1 for {@link com.android.shadow.views.auth.school.SchoolActivity}
     */
    public CompanyListDialog(BaseActivity baseActivity, CompanyNameCallback companyNameCallback, int screenName) {
        this.screenName = screenName;
        mBaseActivity = baseActivity;
        this.companyNameCallback = companyNameCallback;
    }


    public void showSchoolDialog(ArrayList<GetAvailableCompanyListResponse.CompanyList> schoolList) {
        super.showBaseDialog();
        //this.schoolList = schoolList;
    }

    @Override
    protected AppCompatActivity getActivity() {
        return mBaseActivity;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_company;
    }

    @Override
    protected void initViews(View dialogView) {
        mSchoolEditText = (EditText) dialogView.findViewById(R.id.edit_text_search);
        mSchoolEditText.setHint("search company");
        recyclerView = (RecyclerView) dialogView.findViewById(R.id.recycler_view_school);
        dialogView.findViewById(R.id.btn_done).setOnClickListener(this);
        dialogView.findViewById(R.id.btn_clear).setOnClickListener(this);

        mSchoolEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence != null && charSequence.length() > 0) {
                    if (!Utilities.checkInternet(mBaseActivity)) {
                        showToast(R.string.no_internet_msg);
                    } else {
                        CompanyListPresenter companyListDialogPresenter = new CompanyListPresenter(mBaseActivity, CompanyListDialog.this);
                        companyListDialogPresenter.callCompanyAPi();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void setAdapter(ArrayList<GetAvailableCompanyListResponse.CompanyList> companyList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mBaseActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        mCompanyListAdapter = new CompanyListAdapter(mBaseActivity, companyList, this);
        recyclerView.setAdapter(mCompanyListAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_done:
                mDialogName.dismiss();
                companyNameCallback.getCompanyName(mSchoolEditText.getText().toString());
                break;

            case R.id.btn_clear:
                mDialogName.dismiss();
                companyNameCallback.getCompanyName("");
                break;
        }
    }


    @Override
    public void onItemClick(String schoolName) {
        mDialogName.dismiss();
        companyNameCallback.getCompanyName(schoolName);
    }
}
