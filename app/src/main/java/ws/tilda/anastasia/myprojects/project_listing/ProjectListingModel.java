package ws.tilda.anastasia.myprojects.project_listing;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class ProjectListingModel {

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


}
