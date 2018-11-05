package ws.tilda.anastasia.myprojects;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ws.tilda.anastasia.myprojects.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new MainViewModel();
        MainAdapter arrayAdapter = new MainAdapter(this, mViewModel);
        mBinding.projectList.setAdapter(arrayAdapter);

        mBinding.setViewModel(mViewModel);

        setProjectList();
    }

    private void setProjectList() {
        mViewModel.setProjectList();
    }


}
