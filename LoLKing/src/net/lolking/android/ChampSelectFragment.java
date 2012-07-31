package net.lolking.android;

import net.lolking.android.gui.ChampImageAdapter;
import net.lolking.lol.LeagueChampions;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class ChampSelectFragment extends Fragment {
	GridView champgrid;
	ChampImageAdapter adapter;
	
	public ChampSelectFragment() {
		
	}
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	adapter = new ChampImageAdapter(getActivity());  	
    }
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.champion_grid, container, false);
        champgrid = (GridView) v.findViewById(R.id.champGrid);
        champgrid.setAdapter(adapter);                                
        
        champgrid.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {              	
            	LeagueChampions championDb = new LeagueChampions();
                Toast.makeText(getActivity(), championDb.getChampNameByIndex(position), Toast.LENGTH_SHORT).show();
            }
        });
        
        return v;
    }


    
}

