package ws.tilda.anastasia.myprojects;

import android.databinding.BindingAdapter;
import android.widget.ListView;

import java.util.List;

public class BindingUtils {

    @BindingAdapter("projectItem")
    public static void populateProjectList(ListView listView, List<ProjectModel> list) {
        if (list == null) {
            return;
        }
        MainAdapter adapter = (MainAdapter) listView.getAdapter();
        adapter.addItems(list);
    }

//    @BindingAdapter("projectItem")
//    public static void populateProjectList(ListView listView, MainViewModel viewModel) {
//        List<ProjectModel> list = viewModel.projectsList;
//        if (list == null) {
//            return;
//        }
//        //MainAdapter adapter = (MainAdapter) listView.getAdapter();
//        MainAdapter adapter = new MainAdapter(listView.getContext(),viewModel);
//        adapter.addItems(list);
//    }

}
