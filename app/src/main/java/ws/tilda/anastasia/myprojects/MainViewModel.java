package ws.tilda.anastasia.myprojects;

import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    List<ProjectModel> projectsList = new ArrayList<>();

    public void setProjectList() {
//        ListView projectListView = findViewById(R.id.listview);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, projectList);
//        projectListView.setAdapter(arrayAdapter);
    }


}
