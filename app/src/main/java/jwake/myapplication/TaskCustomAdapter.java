package jwake.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adrianvazquez on 4/23/15.
 */
class TaskCustomAdapter extends ArrayAdapter<Tasks> {

    public TaskCustomAdapter(Context context, ArrayList<Tasks> task) {
        super(context, R.layout.task_custom_row, task);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.task_custom_row, parent, false);

        Tasks singleTask = getItem(position);
        TextView TaskDescription = (TextView) customView.findViewById(R.id.customTaskDescription);
        ImageView TaskImage = (ImageView) customView.findViewById(R.id.customTaskImage);

        TaskDescription.setText(singleTask.getTask());
        TaskImage.setImageResource(singleTask.getImage_Path());

        return customView;
    }
}
