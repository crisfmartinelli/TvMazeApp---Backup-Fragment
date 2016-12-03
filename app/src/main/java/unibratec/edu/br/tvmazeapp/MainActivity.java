package unibratec.edu.br.tvmazeapp;

import android.content.Intent;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import unibratec.edu.br.tvmazeapp.fragment.DetailShowFragment;
import unibratec.edu.br.tvmazeapp.http.ShowsSearchTask;
import unibratec.edu.br.tvmazeapp.model.Result;
import unibratec.edu.br.tvmazeapp.model.Show;
import unibratec.edu.br.tvmazeapp.ui.ShowAdapter;

import static android.R.attr.data;


public class MainActivity extends AppCompatActivity
                          implements OnResultClick {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public void onShowClick(Result result) {
        if(getResources().getBoolean(R.bool.phone)) {
            Intent it = new Intent(MainActivity.this, DetailShowActivity.class);
            it.putExtra("idShow", String.valueOf(result.show.id));
            startActivity(it);
        }else{
            DetailShowFragment dsf = DetailShowFragment.newInstance(String.valueOf(result.show.id));

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_show_detail, dsf, "detail")
                    .commit();
        }
    }
}
