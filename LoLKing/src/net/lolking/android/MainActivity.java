package net.lolking.android;

import net.lolking.android.R;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.widget.SearchView;
import android.support.v4.app.FragmentActivity;


public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        actionBar.addTab(actionBar.newTab().setText(R.string.tab0Tag).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(R.string.tab1Tag).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(R.string.tab2Tag).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(R.string.tab3Tag).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(R.string.tab4Tag).setTabListener(this));
        
        
    }
    
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getActionBar().setSelectedNavigationItem(
                    savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM,
                getActionBar().getSelectedNavigationIndex());
    }
    
    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
    
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        
    	DummySectionFragment dummyFragment;
    	ChampSelectFragment champFragment;
    	Bundle args = new Bundle();   	
    	
    	android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
    	transaction.addToBackStack(null);
    	
    	// When the given tab is selected, show the tab contents in the container
        switch(tab.getPosition()) {               
        
        /*case 0: //home
        	dummyFragment = new DummySectionFragment();       	
        	break;
        case 1: //summoners
        	//Within the summoners fragment, call the layout for each summoner and set a Parser
        	//So basically (in very bad code),
        	SummonerFragment {
        	
        	Summoner searchedSummoner;
        	
        	if(sumParser.summonerExists())
        	
        		summonerLayout.setSummoner(LKParser);
        	else
        		summonerLayout.setThisChampionDoesNotExist();
        	summonerLayout.displayLayout
        	}
        	//dummyFragment = new DummySectionFragment();
        	//break;
        */
        case 2: //champions
        	champFragment = new ChampSelectFragment();
        	transaction.replace(R.id.container, champFragment);
        	break;
        /*case 3: //items
        	dummyFragment = new DummySectionFragment();
        	break;
        case 4: //streams
        	dummyFragment = new DummySectionFragment();
        	break;
        	*/
        default:
        	dummyFragment = new DummySectionFragment();
        	args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
        	dummyFragment.setArguments(args);
        	transaction.replace(R.id.container, dummyFragment);
        	break;
        }          	                
    	
        transaction.commit();

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
    
    @Override
    public void onBackPressed() {
    	//TODO: Make the highlighted tab the currently selected one
    }   

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);        
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        //TODO:Eventually implement a search function that will autodetect whether the search term is a summoner/champion/item/etc.
        return true;
    }
}