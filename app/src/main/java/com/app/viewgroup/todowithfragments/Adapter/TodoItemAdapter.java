package com.app.viewgroup.todowithfragments.Adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.viewgroup.todowithfragments.R;
import com.app.viewgroup.todowithfragments.TodoItem;
import com.app.viewgroup.todowithfragments.ViewHolder.TodoItemHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TodoItemAdapter extends RecyclerView.Adapter<TodoItemHolder> {

    private List<TodoItem> data = new ArrayList<>();
    private OnItemSelectedListener onItemSelectedListener;


    public TodoItemAdapter() {
    }

    public TodoItemAdapter(List<TodoItem> itemsData) {
        data.addAll(itemsData);
     Collections.sort((List<TodoItem>) data, TodoItem.Compare_By_Date);
    }


    @Override
    public TodoItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item_view, parent, false);
        return new TodoItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TodoItemHolder holder,  final int position) {
        final TodoItem todoItem = data.get(position);


        holder.getTitle().setText(todoItem.getTitle());
        holder.getDescription().setText(todoItem.getDescription());
        holder.getDate().setText(todoItem.getDate().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemSelectedListener != null) {
                    onItemSelectedListener.onItemSelected(todoItem, holder.getAdapterPosition());
                }
            }
        });

        holder.getDeleteBtn().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(position);
                notifyDataSetChanged();

            }
        });
    }


    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public TodoItem getItem(int position){
        return data.get(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void addItem(TodoItem item) {
        data.add(item);
    }

    public void setItem(TodoItem item, int position) {
        data.set(position, item);
    }




    public interface OnItemSelectedListener {
        void onItemSelected(TodoItem toDoItem, int position);
    }
}
