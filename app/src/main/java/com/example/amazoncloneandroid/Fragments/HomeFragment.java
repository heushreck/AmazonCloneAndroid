package com.example.amazoncloneandroid.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amazoncloneandroid.HomeListAdapter;
import com.example.amazoncloneandroid.HomeListData;
import com.example.amazoncloneandroid.Item;
import com.example.amazoncloneandroid.R;

@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Item nintendo = new Item("Nintendo Switch", (float) 333.99, "This is a Nintendo Switch", R.drawable.item2);
        Item tasche = new Item("Michael Cors Tasche", (float) 150, "Coole Tasche", R.drawable.item1);
        Item xbox = new Item("XBOX ONE X", (float) 299.99, "nice xbox", R.drawable.item3);
        Item kindle = new Item("Kindle Paperwhite", (float) 79.99, "Kindle", R.drawable.item4);
        Item starwars = new Item("Star Wars Jedi Fallen Order", (float) 59.99, "PS4 Game", R.drawable.item5);
        Item jacke = new Item("Yellow Jacket", (float) 250, "nice yellow jacket", R.drawable.item6);

        Item topfset = new Item("Ultra tolles Topfset", (float) 19.99, "nice xbox", R.drawable.item7);
        Item pfanne = new Item("Neue Teflonpfanne 12 Zoll", (float) 79.99, "Kindle", R.drawable.item8);
        Item ps2 = new Item("RETRO Playstation 2", (float) 59.99, "PS4 Game", R.drawable.item9);
        Item ps3 = new Item("NEW! Play Station 3 mit 2 Kontrollern", (float) 111.12, "nice yellow jacket", R.drawable.item10);


        Item[] itemlist1 = new Item[] {topfset, pfanne, ps2, ps3};
        Item[] itemlist2 = new Item[] {nintendo};
        Item[] itemlist3 = new Item[] {xbox};
        Item[] itemlist4 = new Item[] {kindle};
        Item[] itemlist5 = new Item[] {nintendo, xbox, kindle, starwars};
        Item[] itemlist6 = new Item[] {tasche, jacke, tasche};
        Item[] itemlist7 = new Item[] {tasche};
        Item[] itemlist8 = new Item[] {jacke, tasche, jacke, tasche};
        Item[] itemlist9 = new Item[] {starwars};
        Item[] itemlist10 = new Item[] {starwars, starwars, starwars};

        HomeListData[] homeListData = new HomeListData[] {
                new HomeListData("Shop Deals", "Shop deals", itemlist1),
                new HomeListData("Deals of the Day", "Shop deals", itemlist2),
                new HomeListData("Related items you've viewed", "See more & manage", itemlist3),
                new HomeListData("Trending Products", "See more & manage", itemlist4),
                new HomeListData("More items to consider", "See more & manage", itemlist5),
                new HomeListData("Shop Deals", "Shop deals", itemlist6),
                new HomeListData("Deals of the Day", "Shop deals", itemlist7),
                new HomeListData("Related items you've viewed", "See more & manage", itemlist8),
                new HomeListData("Trending Products", "See more & manage", itemlist9),
                new HomeListData("Shop Deals", "Shop deals", itemlist10)
        };

        RecyclerView recyclerView = view.findViewById(R.id.my_recycler_view);
        HomeListAdapter adapter = new HomeListAdapter(homeListData);
        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider));
        recyclerView.addItemDecoration(itemDecorator);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
