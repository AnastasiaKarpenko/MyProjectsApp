package ws.tilda.anastasia.myprojects.project_listing;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.CountDownTimer;

import java.util.List;

public class ProjectRepository {
    List<ProjectModel> mProjectModelList;

    public ProjectRepository(List<ProjectModel> projectModelList) {
        mProjectModelList = projectModelList;
    }

    public LiveData<List<ProjectModel>> getProjectList() {
        final MutableLiveData<List<ProjectModel>> data = new MutableLiveData<>();

        // CountDownTimer will be called every 30 seconds and update the view with the new data
        CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                data.setValue(mProjectModelList);
            }
        }.start();

        return data;
    }

}
