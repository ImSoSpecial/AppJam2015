package jwake.myapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context ctx;
    private HashMap<String, List<String>> taskCategory;
    private List<String> taskList;

    public ExpandableListAdapter(Context ctx, HashMap<String, List<String>> taskCategory, List<String> taskList) {
        this.ctx = ctx;
        this.taskCategory = taskCategory;
        this.taskList = taskList;
    }

    @Override
    public int getGroupCount() {
        return taskList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return taskCategory.get(taskList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return taskList.get(groupPosition);
    }

    @Override
    public Object getChild(int parent, int child) {
        return taskCategory.get(taskList.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertView, ViewGroup parentView) {
        String groupTitle = (String) getGroup(parent);
        if(convertView == null) {
            //LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LayoutInflater inflater = LayoutInflater.from(ctx);
            convertView = inflater.inflate(R.layout.activity_list_group, parentView, false);
        }
        TextView parentTextView = (TextView) convertView.findViewById(R.id.lblListHeader);
        parentTextView.setTypeface(null, Typeface.BOLD);
        parentTextView.setText(groupTitle);
        return convertView;
    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertView, ViewGroup parentView) {
        String childTitle = (String) getChild(parent, child);
        if(convertView == null) {
            //LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LayoutInflater inflater = LayoutInflater.from(ctx);
            convertView = inflater.inflate(R.layout.activity_list_item, parentView, false); //might be wrong
        }
        TextView childTextView = (TextView) convertView.findViewById(R.id.lblListItem);
        childTextView.setText(childTitle);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

}