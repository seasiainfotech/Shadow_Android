package com.android.shadow.dialog;

import android.app.Dialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.shadow.R;
import com.android.shadow.adapter.editprofile.EditMediaAddAdapter;
import com.android.shadow.adapter.editprofile.EditMediaSubtractAdapter;
import com.android.shadow.adapter.editprofile.EditOccupationsAddAdapter;
import com.android.shadow.adapter.editprofile.EditOccupationsSubtractAdapter;
import com.android.shadow.api.GetRestAdapter;
import com.android.shadow.interfaces.SkillsListCallback;
import com.android.shadow.interfaces.SocialListCallback;
import com.android.shadow.model.SocialMedia;
import com.android.shadow.model.input.EditProfileInput;
import com.android.shadow.model.input.GetOccupationInput;
import com.android.shadow.model.output.GetAllOccupationResponse;
import com.android.shadow.views.core.BaseActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.FACEBOOK_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.FACEBOOK_URL;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GITHUB_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GITHUB_URL;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GOOGLE_PLUS_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.GOOGLE_PLUS_URL;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.INSTAGRAM_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.INSTAGRAM_URL;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.LINKEDIN_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.LINKEDIN_URL;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.TWITTER_KEY;
import static com.android.shadow.views.profile.editprofile.EditProfileBaseActivity.TWITTER_URL;

/**
 * @author jindaldipanshu
 * @version 1.0
 */
public class SocialMediaDialog implements View.OnClickListener, SocialListCallback {

    private static final String TAG = "SocialMediaDialog";
    private final BaseActivity baseActivity;
    private Dialog mSelectionDialog;
    private RecyclerView mSkillsAddedRecyclerView;
    private RecyclerView mSkillsToAddRecyclerfView;
    public ArrayList<SocialMedia.Media> mServerList;
    private ArrayList<SocialMedia.Media> userSelectedList;
    private EditMediaSubtractAdapter editSkillsSubtractAdapter;
    private EditMediaAddAdapter editSkillsAddAdapter;

    private SocialMediaCallback mOccupationsCallback;
    private Button mDoneButton;

    public interface SocialMediaCallback {
        void getSocialList(ArrayList<SocialMedia.Media> socialList);
    }

    public SocialMediaDialog(BaseActivity baseActivity, SocialMediaCallback skillsCallback) {
        this.baseActivity = baseActivity;
        mOccupationsCallback = skillsCallback;
    }


    public void showMediaDialog(ArrayList<SocialMedia.Media> userSelectedList,
                                ArrayList<SocialMedia.Media> allSocialItems) {
        this.userSelectedList = new ArrayList<>();

        this.userSelectedList = userSelectedList;
        if (userSelectedList != null && userSelectedList.size() > 0) {
            for (int i = 0; i < userSelectedList.size(); i++) {
                String id = userSelectedList.get(i).getId();
                for (int j = 0; j < allSocialItems.size(); j++) {
                    String socialID = allSocialItems.get(j).getId();
                    if (id.equals(socialID)) {
                        allSocialItems.remove(j);
                        break;
                    }
                }
            }
        }
        mServerList = allSocialItems;

        mSelectionDialog = new Dialog(baseActivity);
        mSelectionDialog.setContentView(R.layout.dialog_socialmedia);
        mDoneButton = (Button) mSelectionDialog.findViewById(R.id.button_done_skills);
        mDoneButton.setOnClickListener(this);
        mSkillsAddedRecyclerView = (RecyclerView) mSelectionDialog.findViewById(R.id.recycler_view_skills_added);
        mSkillsToAddRecyclerfView = (RecyclerView) mSelectionDialog.findViewById(R.id.recycler_view_skills_to_add);
        mSelectionDialog.findViewById(R.id.recycler_view_skills_to_add).setOnClickListener(this);
        mSelectionDialog.show();

        setSkillsAddAdapter(allSocialItems);
        setSkillsSubtractAdapter(userSelectedList);

    }

    private void setSkillsAddAdapter(ArrayList<SocialMedia.Media> allItemsList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(baseActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mSkillsToAddRecyclerfView.setLayoutManager(linearLayoutManager);
        editSkillsAddAdapter = new EditMediaAddAdapter(baseActivity, allItemsList, this);
        mSkillsToAddRecyclerfView.setAdapter(editSkillsAddAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_done_skills:
                setUrl(userSelectedList);
                mOccupationsCallback.getSocialList(userSelectedList);
                mSelectionDialog.dismiss();
                break;
        }
    }

    private void setUrl(ArrayList<SocialMedia.Media> userSelectedList) {
        if (userSelectedList != null && userSelectedList.size() > 0) {
            for (int i = 0; i < userSelectedList.size(); i++) {
                if (userSelectedList.get(i).isMediaSelected()) {
                    continue;
                }

                switch (userSelectedList.get(i).getId()) {
                    case TWITTER_KEY:
                        userSelectedList.get(i).setUrl(TWITTER_URL);
                        break;
                    case FACEBOOK_KEY:
                        userSelectedList.get(i).setUrl(FACEBOOK_URL);
                        break;
                    case LINKEDIN_KEY:
                        userSelectedList.get(i).setUrl(LINKEDIN_URL);
                        break;
                    case GOOGLE_PLUS_KEY:
                        userSelectedList.get(i).setUrl(GOOGLE_PLUS_URL);
                        break;
                    case INSTAGRAM_KEY:
                        userSelectedList.get(i).setUrl(INSTAGRAM_URL);
                        break;
                    case GITHUB_KEY:
                        userSelectedList.get(i).setUrl(GITHUB_URL);
                        break;
                }

            }
        }
    }

    public void setSkillsSubtractAdapter(ArrayList<SocialMedia.Media> mList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(baseActivity);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mSkillsAddedRecyclerView.setLayoutManager(linearLayoutManager);
        editSkillsSubtractAdapter = new EditMediaSubtractAdapter(baseActivity, mList, this);
        mSkillsAddedRecyclerView.setAdapter(editSkillsSubtractAdapter);
    }

    @Override
    public void onUpdate(SocialMedia.Media socialMedia, int position) {
        //remove skills from server list and add to skillsselecetdList
        userSelectedList.add(socialMedia);
        mServerList.remove(position);

        editSkillsSubtractAdapter.notifyAdapter(userSelectedList);
        editSkillsAddAdapter.notifyAdapter(mServerList);
    }

    @Override
    public void onUpdateSocial(SocialMedia.Media socialMedia, int position) {
        userSelectedList.remove(position);
        mServerList.add(socialMedia);
        editSkillsSubtractAdapter.notifyAdapter(userSelectedList);
        editSkillsAddAdapter.notifyAdapter(mServerList);
    }

}
