package ws.tilda.anastasia.myprojects;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.CountDownTimer;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {
    private static final ProjectRepository ourInstance = new ProjectRepository();

    public static ProjectRepository getInstance() {
        return ourInstance;
    }

    private ProjectRepository() {
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
                data.setValue(getList());
            }
        }.start();

        return data;
    }

    public List<ProjectModel> getList() {
        List<ProjectModel> dummyProjectList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ProjectModel projectModel = new ProjectModel();
            projectModel.title = "Project " + i;
            dummyProjectList.add(projectModel);
        }
        return dummyProjectList;
    }
}
