/*
package com.android.shadow.dialog;

import android.app.Dialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.shadow.R;
import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.interfaces.SkillsListCallback;
import com.android.shadow.model.EditSkillsList;
import com.android.shadow.model.input.EditProfileInput;
import com.android.shadow.model.input.GetOccupationInput;
import com.android.shadow.model.output.GetAllSkillResponse;
import com.android.shadow.views.core.BaseActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

*/
/**
 * Created by singhgharjyot on 6/8/2017.
 *//*


public class SkillsDialog implements View.OnClickListener, SkillsListCallback {

    private static final String TAG = "SkillsDialog";
    private final BaseActivity baseActivity;
    private Dialog mSelectionDialog;
    private RecyclerView mSkillsAddedRecyclerView;
    private RecyclerView mSkillsToAddRecyclerfView;
    public ArrayList<EditProfileInput.Skills> mServerList, skillsSelectedlist;
    EditSkillsSubtractAdapter editSkillsSubtractAdapter;
    private EditSkillsAddAdapter editSkillsAddAdapter;
    private SkillsCallback mSkillsCallback;
    private Button mDoneButton;

    public interface SkillsCallback {
        void getSkillsList(ArrayList<EditProfileInput.Skills> skillsadded);
    }

    public SkillsDialog(BaseActivity baseActivity, SkillsCallback skillsCallback) {
        this.baseActivity = baseActivity;
        mSkillsCallback = skillsCallback;
    }


    public void getAllSkills(final ArrayList<EditProfileInput.Skills> skills) {
        baseActivity.showDialog();
        GetOccupationInput getOccupationInput = new GetOccupationInput();
        getOccupationInput.setPageIndex("0");
        getOccupationInput.setPageSize("2");
        Call<GetAllSkillResponse> responseSkillsList = GetRestAdapter.getRestAdapter(false).getAllSkills(getOccupationInput);
        responseSkillsList.enqueue(new Callback<GetAllSkillResponse>() {
            @Override
            public void onResponse(Call<GetAllSkillResponse> call, Response<GetAllSkillResponse> responseSkillsList) {
                baseActivity.hideDialog();
                if (responseSkillsList != null && responseSkillsList.body() != null) {
                    Log.e("skills list ---", responseSkillsList.body().getData() + "");
                    if (responseSkillsList.body().getData() != null &&
                            responseSkillsList.body().getData().getSkillTypes() != null &&
                            responseSkillsList.body().getData().getSkillTypes().size() > 0) {

                        // skillsSelectedlist = new ArrayList<>();
                        mServerList = new ArrayList<>();//pojo array

                        ArrayList<GetAllSkillResponse.SkillTypes> responseList = responseSkillsList.body().getData().getSkillTypes();
                          ArrayList<EditProfileInput.Skills> mTempServerList=new ArrayList<EditProfileInput.Skills>();

                        for (int i = 0; i < responseList.size(); i++) {
                            EditProfileInput.Skills skills = new EditProfileInput().new Skills();
                            skills.setName(responseList.get(i).getName());
                            skills.setSelected(false);
                            mTempServerList.add(skills);
                        }

                        skillsSelectedlist = skills;

                        //mServerList=mTempServerList;
                        mServerList.addAll(mTempServerList);

                        for (int i = 0; i < mTempServerList.size(); i++) {
                            String ski_name = mTempServerList.get(i).getName();
                            for (int j = 0; j < skillsSelectedlist.size(); j++) {
                                if (ski_name.equals(skillsSelectedlist.get(j).getName())) {
                                    EditProfileInput.Skills skills1=mTempServerList.get(i);
                                    mServerList.remove(skills1);

                                    break;
                                }
                            }
                        }


                        showSkillsDialog(mServerList, skillsSelectedlist);
                    }


                } else {
                    baseActivity.showToast(R.string.server_error_msg);
                }
            }

            @Override
            public void onFailure(Call<GetAllSkillResponse> call, Throwable t) {
                baseActivity.hideDialog();
                baseActivity.showToast(t.getMessage());
            }
        });
    }


    private void showSkillsDialog(ArrayList<EditProfileInput.Skills> serverSkillslIst,
                                  ArrayList<EditProfileInput.Skills> skillsSelectedlist) {
        mSelectionDialog = new Dialog(baseActivity);
        mSelectionDialog.setContentView(R.layout.dialog_skills);
        mDoneButton = (Button) mSelectionDialog.findViewById(R.id.button_done_skills);
        mDoneButton.setOnClickListener(this);
        mSkillsAddedRecyclerView = (RecyclerView) mSelectionDialog.findViewById(R.id.recycler_view_skills_added);
        mSkillsToAddRecyclerfView = (RecyclerView) mSelectionDialog.findViewById(R.id.recycler_view_skills_to_add);
        mSelectionDialog.findViewById(R.id.recycler_view_skills_to_add).setOnClickListener(this);
        mSelectionDialog.show();

        setSkillsSubtractAdapter(skillsSelectedlist);
        setSkillsAddAdapter(serverSkillslIst);
    }

    private void setSkillsAddAdapter(ArrayList<EditProfileInput.Skills> serverSkillslIst) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(baseActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mSkillsToAddRecyclerfView.setLayoutManager(linearLayoutManager);
        editSkillsAddAdapter = new EditSkillsAddAdapter(baseActivity, mServerList, this);
        mSkillsToAddRecyclerfView.setAdapter(editSkillsAddAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_done_skills:
                mSkillsCallback.getSkillsList(skillsSelectedlist);
                mSelectionDialog.dismiss();
                break;
        }
    }

    public void setSkillsSubtractAdapter(ArrayList<EditProfileInput.Skills> mList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(baseActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mSkillsAddedRecyclerView.setLayoutManager(linearLayoutManager);
        editSkillsSubtractAdapter = new EditSkillsSubtractAdapter(baseActivity, mList, this);
        mSkillsAddedRecyclerView.setAdapter(editSkillsSubtractAdapter);
    }

    @Override
    public void onUpdate( EditProfileInput.Skills skills,int position) {
        //remove skills from server list and add to skillsselecetdList
        skillsSelectedlist.add(skills);
        mServerList.remove(position);
        editSkillsSubtractAdapter.notifyAdapter(skillsSelectedlist);
        editSkillsAddAdapter.notifyAdapter(mServerList);
    }

    @Override
    public void onUpdateSkill2(EditProfileInput.Skills removedSkills, int posotion) {
        skillsSelectedlist.remove(posotion);
        mServerList.add(removedSkills);
        editSkillsSubtractAdapter.notifyAdapter(skillsSelectedlist);
        editSkillsAddAdapter.notifyAdapter(mServerList);
    }

}
*/
