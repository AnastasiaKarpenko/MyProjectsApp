package ws.tilda.anastasia.myprojects.project_listing;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.CountDownTimer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ProjectRepository {

    @Inject
    ProjectListingModel mProjectListingModel;

    List<ProjectModel> items;

//    @Inject
    public ProjectRepository() {

    }

    public LiveData<List<ProjectModel>> getProjectList() {
        mProjectListingModel.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                //show error
            }
        }).filter(isNetWorkAvailable -> true)
                .flatMap(isAvailable -> mProjectListingModel.getProjectListObservable())
                .subscribe(projects -> {
                    items  = (ArrayList<ProjectModel>) projects;
                });
        final MutableLiveData<List<ProjectModel>> data = new MutableLiveData<>();

        // CountDownTimer will be called every 30 seconds and update the view with the new data
        CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                data.setValue(items);
            }
        }.start();

        return data;
    }

}
