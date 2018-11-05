package ws.tilda.anastasia.myprojects;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import ws.tilda.anastasia.myprojects.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements LifecycleOwner, MainContractor.MainView {
    ActivityMainBinding mBinding;
    MainAdapter mMainAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mMainAdapter = new MainAdapter(this);
        mBinding.listview.setAdapter(mMainAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        observeViewModel(viewModel);

    }

    private void observeViewModel(MainViewModel viewModel) {
        viewModel.getProjectsListObservable().observe(this, new Observer<List<ProjectModel>>() {
            @Override
            public void onChanged(@Nullable List<ProjectModel> projectModels) {
                mMainAdapter.addItems(projectModels);
            }
        });
    }
}
