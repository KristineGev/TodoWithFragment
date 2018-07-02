package com.app.viewgroup.todowithfragments;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import com.app.viewgroup.todowithfragments.Fragment.TodoListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.app.FragmentTransaction tx = getFragmentManager().beginTransaction();
        tx.replace(R.id.container_for_fragment, new TodoListFragment());
        tx.commit();

        setContentView(R.layout.activity_main);
    }
}
