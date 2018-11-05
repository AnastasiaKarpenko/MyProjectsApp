package ws.tilda.anastasia.myprojects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    List<ProjectModel> mProjectList = new ArrayList<>();

    public MainAdapter(Context context) {
        mContext = context;
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


    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = mLayoutInflater.inflate(R.layout.item_layout, null);
        ButterKnife.bind(this, view);
        tvTitle.setText(mProjectList.get(position).title);

        return view;
    }
}
