package com.android.shadow.dialog;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.android.shadow.R;
import com.android.shadow.adapter.SchoolAdapter;
import com.android.shadow.model.input.GetAllSchoolInput;
import com.android.shadow.model.output.GetAllSchoolResponse;
import com.android.shadow.presenter.SchoolPresenter;
import com.android.shadow.utils.PreferenceKeys;
import com.android.shadow.utils.SharedPrefsHelper;
import com.android.shadow.utils.Utilities;
import com.android.shadow.views.core.BaseActivity;

import java.util.ArrayList;

/**
 * Created by jindaldipanshu on 6/28/2017.
 */

public class SchoolListDialog extends BaseDialog implements SchoolPresenter.SchoolCallback, SchoolAdapter.OnItemClick, View.OnClickListener {

    private final SchoolNameCallback schoolNameCallback;
    private final int screenName;
    private BaseActivity mBaseActivity;
    private AutoCompleteTextView mSchool;
    ArrayList<GetAllSchoolResponse.Data> schoolList;
    private ArrayList<String> mSchoolist;
    private SchoolPresenter schoolPresenter;
    private EditText mSchoolEditText;
    private RecyclerView recyclerView;
    private SchoolAdapter mSchoolAdapter;
    private Button mDoneButton, mClearButton;


    public interface SchoolNameCallback {
        void getSchoolName(String schoolName);
    }

    /**
     * parametrized constructor
     *
     * @param baseActivity:Context       of {@link BaseActivity}
     * @param schoolNameCallback:context of interface
     * @param screenName:0               for {@link com.android.shadow.views.profile.editprofile.EditProfileUserActivity}
     *                                   1 for {@link com.android.shadow.views.auth.school.SchoolActivity}
     */
    public SchoolListDialog(BaseActivity baseActivity, SchoolNameCallback schoolNameCallback, int screenName) {
        this.screenName = screenName;
        mBaseActivity = baseActivity;
        this.schoolNameCallback = schoolNameCallback;
    }


    public void showSchoolDialog(ArrayList<GetAllSchoolResponse.SchoolList> schoolList) {
        super.showBaseDialog();
        //this.schoolList = schoolList;
    }

    @Override
    protected AppCompatActivity getActivity() {
        return mBaseActivity;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_school;
    }

    @Override
    protected void initViews(View dialogView) {
        mSchoolEditText = (EditText) dialogView.findViewById(R.id.edit_text_search);
        recyclerView = (RecyclerView) dialogView.findViewById(R.id.recycler_view_school);
        mDoneButton = (Button) dialogView.findViewById(R.id.btn_done);
        mClearButton = (Button) dialogView.findViewById(R.id.btn_clear);

        mDoneButton.setOnClickListener(this);
        mClearButton.setOnClickListener(this);

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
                        GetAllSchoolInput getAllSchoolInput = new GetAllSchoolInput();
                        getAllSchoolInput.setSearchKeyword(charSequence.toString().trim());
                        if (schoolPresenter == null) {
                            schoolPresenter = new SchoolPresenter(mBaseActivity, SchoolListDialog.this);
                        }
                        if (screenName == 0) {  // Edit USerProfile Activty
                            SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(mBaseActivity);
                            String userid = sharedPrefsHelper.get(PreferenceKeys.PREF_USER_ID);
                            getAllSchoolInput.setUserId(userid);
                            schoolPresenter.getAllSchool(getAllSchoolInput);
                        } else {     // SchoolActivity
                            schoolPresenter.getAllAvailSchool(getAllSchoolInput);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @Override
    public void onSuccess(String lat) {

    }

    @Override
    public void onSchoolListSuccess(GetAllSchoolResponse response) {
        if (response != null && response.getStatus() != null && response.getStatus().equals("200")) {
            if (mSchoolAdapter == null) {
                setAdapter(response.getData().getSchoolList());
            } else {
                mSchoolAdapter.notifyAdapter(response.getData().getSchoolList());
            }
        } else {
            showToast(R.string.no_data_found_msg);
        }
    }

    private void setAdapter(ArrayList<GetAllSchoolResponse.SchoolList> schoolList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mBaseActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        mSchoolAdapter = new SchoolAdapter(mBaseActivity, schoolList, this);
        recyclerView.setAdapter(mSchoolAdapter);
    }

    @Override
    public void onItemClick(String schoolName) {
        mDialogName.dismiss();
        schoolNameCallback.getSchoolName(schoolName);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_done:
                mDialogName.dismiss();
                break;

            case R.id.btn_clear:
                mDialogName.dismiss();
                schoolNameCallback.getSchoolName(null);
                break;
        }
    }
}
