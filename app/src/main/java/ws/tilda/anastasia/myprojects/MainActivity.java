package ws.tilda.anastasia.myprojects;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ws.tilda.anastasia.myprojects.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    String[] projectList = {"Project1", "Project2", "Project3"};

    ActivityMainBinding mBinding;
    MainViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mViewModel = new MainViewModel();


        setProjectList();
    }

    private void setProjectList() {
        ListView projectListView = findViewById(R.id.listview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, projectList);
        projectListView.setAdapter(arrayAdapter);
    }
}
