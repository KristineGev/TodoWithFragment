package com.app.viewgroup.todowithfragments.Fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;

import com.app.viewgroup.todowithfragments.R;
import com.app.viewgroup.todowithfragments.TodoItem;

import java.util.Calendar;


public class TodoItemFragment extends android.app.Fragment {

    public TodoItemFragment() {
    }

    private Button upBtn, downBtn, saveBtn;
    private RadioGroup radioGroup;
    private RadioButton dailyBtn, weeklyBtn, monthlyBtn;
    private CheckBox reminder, repeat;
    private EditText priorityValue, title, description, date, time;
    private int counter;
    private TodoItem todoItem;
    private DatePickerDialog datePickerDialog;
    private ConstraintLayout layout;
    private OnSaveBtnClickListener onSaveBtnClickListener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_todo_item, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        //  super.onViewCreated(view, savedInstanceState);

        priorityValue = (EditText) view.findViewById(R.id.label_fragment_todo_item_priority_value);
        downBtn = (Button) view.findViewById(R.id.action_fragment_todo_item_down);
        upBtn = (Button) view.findViewById(R.id.action_fragment_todo_item_up);

        title = (EditText) view.findViewById(R.id.input_fragment_todo_item_title);
        description = (EditText) view.findViewById(R.id.input_fragment_todo_item_description);
        date = (EditText) view.findViewById(R.id.input_fragment_todo_item_date);
        time = (EditText) view.findViewById(R.id.input_fragment_todo_item_time);
        repeat = (CheckBox) view.findViewById(R.id.label_fragment_todo_item_repeat);
        radioGroup = (RadioGroup) view.findViewById(R.id.label_fragment_todo_item_radiogroup);
        layout = (ConstraintLayout) view.findViewById(R.id.label_fragment_todo_constr_lay);

        counter = Integer.parseInt(priorityValue.getText().toString());

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TodoItemFragment todoItemFragment = new TodoItemFragment();
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(
                        getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                date.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, year, month, day);
                datePickerDialog.show();
            }
        });


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TodoItemFragment todoItemFragment = new TodoItemFragment();
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);
                TimePickerDialog timePicker;
                timePicker = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                time.setText(selectedHour + ":" + selectedMinute);
                            }
                        }, hour, minute, true);
                timePicker.setTitle("Select Time");
                timePicker.show();

            }
        });


        upBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter < 5)
                    priorityValue.setText(Integer.toString(++counter));

            }

        });

        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter > 1)
                    priorityValue.setText(Integer.toString(--counter));

            }
        });

        repeat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    radioGroup.setVisibility(View.VISIBLE);
                } else {
                    radioGroup.setVisibility(View.GONE);
                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.saveBtn:
                final String titleTxt = title.getText().toString();
                final String descriptionTxt = description.getText().toString();
                final String dateTxt =  date.getText().toString();
                Bundle arguments = new Bundle();
                TodoItem toDoItem=new TodoItem(titleTxt,descriptionTxt,dateTxt);
                arguments.putSerializable("Todoitem", todoItem);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public interface OnSaveBtnClickListener {

        void onSaveBtnClicked(TodoItem todoItem);

        void onEditBtnClicked(TodoItem todoItem);
    }
}