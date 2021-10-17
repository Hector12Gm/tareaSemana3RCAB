package com.example.mascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.mascotas.adapters.AdapterViewPager;
import com.example.mascotas.fragmentos.feed_app;
import com.example.mascotas.fragmentos.profile_pet;
import com.example.mascotas.pojo.Datos;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView petListView;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        ///Agregar el toolbar
        Toolbar miAction = ( Toolbar ) findViewById( R.id.toolbar );
        setSupportActionBar( miAction );
        ImageButton btn= ( ImageButton ) miAction.findViewById(R.id.imageBtnStar);
        ((TextView) findViewById(R.id.tvCountFav)).setText(Integer.toString(Datos.favs.size()));
        viewPager = ( ViewPager ) findViewById( R.id.viewPager );
        tabLayout = ( TabLayout ) findViewById( R.id.tabLayout );

        inicilizarVP();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,pet_favs.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_opcciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_contacto:
                startActivity(new Intent(this,contacto.class));
                break;
            case R.id.menu_acerca:
                startActivity(new Intent(this,acercade.class));
                break;
        }
        return true;
    }

    private void inicilizarVP(){
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();


        fragments.add(new feed_app(this));
        fragments.add(new profile_pet());

        AdapterViewPager adapterViewPager = new AdapterViewPager(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(adapterViewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);


    }


}