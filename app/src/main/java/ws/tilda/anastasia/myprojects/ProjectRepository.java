package ws.tilda.anastasia.myprojects;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class ProjectRepository {

    private static final ProjectRepository ourInstance = new ProjectRepository();
    List<ProjectModel> dummyProjectList = new ArrayList<>();


    public static ProjectRepository getInstance() {
        return ourInstance;
    }

    private ProjectRepository() {
    }

    public void getProjectList() {
        final MutableLiveData<List<ProjectModel>> data = new MutableLiveData<>();
        Observable.range(0,5)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public List<ProjectModel> getList() {
        for (int i = 0; i < 5; i++) {
            ProjectModel projectModel = new ProjectModel();
            projectModel.title = "Project " + i;
            dummyProjectList.add(projectModel);
        }
        return dummyProjectList;
    }
}
