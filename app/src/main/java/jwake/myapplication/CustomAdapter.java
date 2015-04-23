package jwake.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


class CustomAdapter extends ArrayAdapter<SurveyQuestions> {

    public CustomAdapter(Context context, ArrayList<SurveyQuestions> question) {
        super(context, R.layout.survey_custom_row, question);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.survey_custom_row, parent, false);

        SurveyQuestions singleQuestion = getItem(position);
        TextView questionText = (TextView) customView.findViewById(R.id.customTextBoxQuestion);
        RadioGroup radioGroup = (RadioGroup) customView.findViewById(R.id.customRadioGroup);
        RadioButton yesButton = (RadioButton) customView.findViewById(R.id.customYesRadioButton);
        RadioButton noButton = (RadioButton) customView.findViewById(R.id.customNoRadioButton);

        questionText.setText(singleQuestion.getQuestion());

        return customView;
    }
}

