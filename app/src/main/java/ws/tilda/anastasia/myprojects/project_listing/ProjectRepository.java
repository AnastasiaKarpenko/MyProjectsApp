package ws.tilda.anastasia.myprojects.project_listing;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import javax.inject.Inject;

public class ProjectRepository {

    @Inject
    ProjectListingModel mProjectListingModel;

    //@Inject
    public ProjectRepository() {

    }

    public LiveData<List<ProjectModel>> getProjectList() {
        final MutableLiveData<List<ProjectModel>> data = new MutableLiveData<>();

        mProjectListingModel.getProjectListObservable().subscribe(list -> {
            data.setValue(list);
        }, throwable -> {
            handleRxException(throwable);
        });

        return data;
    }

    private void handleRxException(Throwable throwable) {

    }

}
