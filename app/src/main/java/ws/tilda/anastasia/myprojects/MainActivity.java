package ws.tilda.anastasia.myprojects;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] projectList = {"Project1", "Project2", "Project3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setProjectList();
    }

    private void setProjectList() {
        ListView projectListView = findViewById(R.id.listview);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, projectList);
        projectListView.setAdapter(arrayAdapter);
    }
}
