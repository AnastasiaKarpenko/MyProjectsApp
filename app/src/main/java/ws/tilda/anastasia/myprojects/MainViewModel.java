package ws.tilda.anastasia.myprojects;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;

public class MainViewModel extends ViewModel {

    List<ProjectModel> projectsList = new ArrayList<>();

    private Observable mObservable;
    private Observer mObserver;

    private void initializeObservable() {
        mObservable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                for (int i = 0; i < 5; i++) {
                    emitter.onNext(i);
                }

                emitter.onComplete();


            }
        });
    }



    public void setProjectList() {
        List<ProjectModel> dummyProjectList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ProjectModel projectModel = new ProjectModel();
            projectModel.title = "Project " + i;
            dummyProjectList.add(projectModel);
        }
        projectsList.addAll(dummyProjectList);
    }

    public List<ProjectModel> getProjectsList() {
        return projectsList;
    }
}
