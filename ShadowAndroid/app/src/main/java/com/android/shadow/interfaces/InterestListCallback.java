package com.android.shadow.interfaces;

import com.android.shadow.model.EditSkillsList;
import com.android.shadow.model.input.EditProfileInput;

import java.util.ArrayList;

/**
 * Created by jindaldipanshu on 6/15/2017.
 */

public interface InterestListCallback {

    void onUpdate(EditProfileInput.Interest mList, int position, ArrayList<EditProfileInput.Interest> mSkillsList);

    void onUpdateInterest2(EditProfileInput.Interest mList, int position);
}
