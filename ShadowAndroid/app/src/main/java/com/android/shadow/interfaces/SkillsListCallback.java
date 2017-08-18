package com.android.shadow.interfaces;

import com.android.shadow.model.EditSkillsList;
import com.android.shadow.model.input.EditProfileInput;

import java.util.ArrayList;

/**
 * Created by singhgharjyot on 6/9/2017.
 */

public interface SkillsListCallback {

    void onUpdate(EditProfileInput.Occupations mList, int position,ArrayList<EditProfileInput.Occupations> mServerList);

    void onUpdateSkill2(EditProfileInput.Occupations mList, int position);

}
