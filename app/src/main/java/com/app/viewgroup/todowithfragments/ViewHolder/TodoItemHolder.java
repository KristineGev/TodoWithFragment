package com.app.viewgroup.todowithfragments.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.viewgroup.todowithfragments.R;

public class TodoItemHolder extends RecyclerView.ViewHolder {


    private TextView title;
    private TextView description;
    private TextView date;
    private ImageView deleteBtn;

    public TodoItemHolder(View itemView) {
        super(itemView);
    }

    public TodoItemHolder(View itemView, TextView title, TextView description, TextView date, ImageView deleteBtn) {
        super(itemView);
        this.title = itemView.findViewById(R.id.titleRes);
        this.description = itemView.findViewById(R.id.descriptionRes);
        this.date = itemView.findViewById(R.id.dateRes);
        this.deleteBtn = itemView.findViewById(R.id.deleteBtn);
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public TextView getDate() {
        return date;
    }

    public void setDate(TextView date) {
        this.date = date;
    }

    public ImageView getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(ImageView deleteBtn) {
        this.deleteBtn = deleteBtn;
    }


}
