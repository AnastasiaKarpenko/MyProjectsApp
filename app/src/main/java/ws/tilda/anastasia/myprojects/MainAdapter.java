package ws.tilda.anastasia.myprojects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import ws.tilda.anastasia.myprojects.databinding.ItemLayoutBinding;

public class MainAdapter extends BaseAdapter {

    Context mContext;
    MainViewModel mViewModel;
    LayoutInflater mLayoutInflater;
    List<ProjectModel> mProjectList = new ArrayList<>();

    public MainAdapter(Context context, MainViewModel viewModel) {
        mContext = context;
        mViewModel = viewModel;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void addItems(List<ProjectModel> list) {
        mProjectList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mProjectList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProjectList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ItemLayoutBinding mBinding = ItemLayoutBinding.inflate(mLayoutInflater, viewGroup, false);
        mBinding.tvTitle.setText(mProjectList.get(position).title);

        return mBinding.getRoot();
    }
}
