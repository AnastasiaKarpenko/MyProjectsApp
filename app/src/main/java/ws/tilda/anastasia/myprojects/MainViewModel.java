package ws.tilda.anastasia.myprojects;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainViewModel extends ViewModel {

    List<ProjectModel> projectsList = new ArrayList<>();
    List<ProjectModel> dummyProjectList = new ArrayList<>();

    private Observable<Integer> mObservable;
    private Observer<Integer> mObserver;

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

    private void initializeObserver() {
        mObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                ProjectModel projectModel = new ProjectModel();
                projectModel.title = "Project " + integer;
                dummyProjectList.add(projectModel);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                projectsList.addAll(dummyProjectList);
            }
        };
    }

    public void setProjectList() {
        initializeObservable();
        initializeObserver();

        mObservable.subscribe(mObserver);
    }

    public List<ProjectModel> getProjectsList() {
        return projectsList;
    }
}
