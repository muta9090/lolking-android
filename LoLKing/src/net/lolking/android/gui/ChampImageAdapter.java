package net.lolking.android.gui;

import net.lolking.lol.Champion;
import net.lolking.lol.LeagueChampions;
import net.lolking.android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class ChampImageAdapter extends BaseAdapter {
	
	private Context mContext;
	private Integer[] leagueChampIDs;
	private LeagueChampions championDb;

    public ChampImageAdapter(Context c) {   	
        mContext = c;
        championDb = new LeagueChampions();     
        leagueChampIDs = championDb.getIconAssetArray();
    }

    public int getCount() {
        return leagueChampIDs.length;
    }
    
    /**
     * Returns the champion object associated with this grid item.
     */
    public Champion getItem(int position) {
        return championDb.getChampionByIndex(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(R.dimen.champ_width, R.dimen.champ_width));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(2, 2, 2, 2);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(leagueChampIDs[position]);
        return imageView;
    }
    
}
