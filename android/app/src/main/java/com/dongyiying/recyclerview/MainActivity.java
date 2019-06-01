package com.dongyiying.recyclerview;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit>fruitList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView=findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter=new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private void initFruits(){
        for(int i=0;i<2;i++){
            Fruit apple=new Fruit("Apple",R.drawable.ic_apple);
            fruitList.add(apple);
            Fruit banana=new Fruit("Banana",R.drawable.ic_banana);
            fruitList.add(banana);
            Fruit berries=new Fruit("Berries",R.drawable.ic_berries);
            fruitList.add(berries);
            Fruit pear=new Fruit("Pear",R.drawable.ic_pear);
            fruitList.add(pear);
        }
    }
}
