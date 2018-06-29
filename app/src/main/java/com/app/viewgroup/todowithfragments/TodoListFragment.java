package com.app.viewgroup.todowithfragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class TodoListFragment extends android.app.Fragment {


    private FloatingActionButton add;
    private TodoItemAdapter todoItemAdapter = new TodoItemAdapter();
    private RecyclerView recyclerView;
    private TodoItemAdapter.OnItemSelectedListener onItemSelectedListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_todo_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        add = (FloatingActionButton) view.findViewById(R.id.add);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(todoItemAdapter);
        todoItemAdapter.setOnItemSelectedListener(onItemSelectedListener);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TodoItem todoItem;
                if (getArguments() == null) {
                    return;
                }
                todoItem = (TodoItem) getArguments().getSerializable("TodoItem");
                todoItemAdapter.addItem(todoItem);
                todoItemAdapter.notifyDataSetChanged();

            }


        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.FragmentTransaction tx = getFragmentManager().beginTransaction();
                tx.replace(R.id.container_for_fragment, new TodoItemFragment());
                tx.commit();

            }
        });


    }


    public interface onitemClickedListener {
        void edititem();

    }
}


