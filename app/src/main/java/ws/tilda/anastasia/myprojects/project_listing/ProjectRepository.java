package ws.tilda.anastasia.myprojects.project_listing;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

public class ProjectRepository {

    @Inject
    ProjectListingModel projectListingModel;

    @Inject
    public ProjectRepository() {
    }

    public LiveData<List<ProjectModel>> getProjectList() {

        final MutableLiveData<List<ProjectModel>> data = new MutableLiveData<>();

        projectListingModel.getProjectListObservable().subscribe(s -> {
            data.setValue(s);
        }, throwable -> {
            handleThrowable(throwable);
        });

        return data;
    }

    private void handleThrowable(Throwable throwable) {
        //Handle Error
    }

}

