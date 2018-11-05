package ws.tilda.anastasia.myprojects;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LifecycleOwner, MainContractor.MainView {
    MainAdapter mMainAdapter;
    @BindView(R.id.listview)
    ListView projectList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMainAdapter = new MainAdapter(this);
        projectList.setAdapter(mMainAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final MainPresenter mainPresenter = ViewModelProviders.of(this).get(MainPresenter.class);
        mainPresenter.setUpPresenter(this);
        observeMainPresenter(mainPresenter);

    }

    private void observeMainPresenter(MainPresenter mainPresenter) {
        mainPresenter.getProjectsListObservable().observe(this, new Observer<List<ProjectModel>>() {
            @Override
            public void onChanged(@Nullable List<ProjectModel> projectModels) {
                mMainAdapter.addItems(projectModels);
            }
        });
    }
}
