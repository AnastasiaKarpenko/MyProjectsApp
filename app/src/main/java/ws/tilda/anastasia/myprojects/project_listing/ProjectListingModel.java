package ws.tilda.anastasia.myprojects.project_listing;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class ProjectListingModel {

    @Inject
    ProjectListingModel() {

    }

    List<ProjectModel> mProjectModelList;

    Observable<List<ProjectModel>> getProjectListObservable() {


        return Observable.range(0, 5)
                .map(new Function<Integer, List<ProjectModel>>() {
                    @Override
                    public List<ProjectModel> apply(Integer integer) throws Exception {
                        ProjectModel projectModel = new ProjectModel();
                        projectModel.title = "Project " + integer;
                        mProjectModelList.add(projectModel);

                        return mProjectModelList;
                    }
                });
    }


    //Currently we are not calling any network, so this implementation is for now.

    Observable<Boolean> isNetworkAvailable() {
        return Observable.just(true);
    }


}
