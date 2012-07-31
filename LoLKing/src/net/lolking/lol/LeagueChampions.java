package net.lolking.lol;

import net.lolking.android.R;

/**
 * Stores the alphabetical array of champions that exist in League of Legends
 * @author Adam
 *
 */
public class LeagueChampions {
	
	private static final int NUMBER_OF_CHAMPIONS = 60;
	
	private Champion[] leagueChamps = //Add new champions here, plus in the resources folder, in alphabetical order obviously
			{
					new Champion("Ahri", R.drawable.ahri_square_0),
					new Champion("Akali", R.drawable.akali_square_0),
					new Champion("Alistar", R.drawable.alistar_square_0),
					new Champion("Amumu", R.drawable.amumu_square_0),
					new Champion("Anivia", R.drawable.anivia_square_0),
					new Champion("Annie", R.drawable.annie_square_0),
					new Champion("Ashe", R.drawable.ashe_square_0),
					new Champion("Blitzcrank", R.drawable.blitzcrank_square_0),
					new Champion("Brand", R.drawable.brand_square_0),
					new Champion("Caitlyn", R.drawable.caitlyn_square_0),
					new Champion("Cassiopeia", R.drawable.cassiopeia_square_0), 
					new Champion("Cho’Gath", R.drawable.chogath_square_0),
					new Champion("Corki", R.drawable.corki_square_0),
					new Champion("Darius", R.drawable.darius_square_0),
					new Champion("Draven", R.drawable.draven_square_0),
					new Champion("Dr. Mundo", R.drawable.drmundo_square_0),
					new Champion("Evelynn", R.drawable.evelynn_square_0),
					new Champion("Ezreal", R.drawable.ezreal_square_0),
					new Champion("Fiddlesticks", R.drawable.fiddlesticks_square_0),
					new Champion("Fiora", R.drawable.fiora_square_0),
					new Champion("Fizz", R.drawable.fizz_square_0), 
					new Champion("Galio", R.drawable.galio_square_0),
					new Champion("Gangplank", R.drawable.gangplank_square_0),
					new Champion("Garen", R.drawable.garen_square_0),
					new Champion("Gragas", R.drawable.gragas_square_0),
					new Champion("Graves", R.drawable.graves_square_0),
					new Champion("Hecarim", R.drawable.hecarim_square_0),
					new Champion("Heimerdinger", R.drawable.heimerdinger_square_0),
					new Champion("Irelia", R.drawable.irelia_square_0),
					new Champion("Janna", R.drawable.janna_square_0),
					new Champion("Jarvan IV", R.drawable.jarvaniv_square_0), 
					new Champion("Jax", R.drawable.jax_square_0),
					new Champion("Jayce", R.drawable.jayce_square_0),
					new Champion("Karma", R.drawable.karma_square_0),
					new Champion("Karthus", R.drawable.karthus_square_0),
					new Champion("Kassadin", R.drawable.kassadin_square_0),
					new Champion("Katarina", R.drawable.katarina_square_0),
					new Champion("Kayle", R.drawable.kayle_square_0),
					new Champion("Kennen", R.drawable.kennen_square_0),
					new Champion("Kog’Maw", R.drawable.kogmaw_square_0),
					new Champion("LeBlanc", R.drawable.leblanc_square_0), 
					new Champion("Lee Sin", R.drawable.leesin_square_0),
					new Champion("Leona", R.drawable.leona_square_0),
					new Champion("Lulu", R.drawable.lulu_square_0),
					new Champion("Lux", R.drawable.lux_square_0),
					new Champion("Malphite", R.drawable.malphite_square_0),
					new Champion("Malzahar", R.drawable.malzahar_square_0),
					new Champion("Maokai", R.drawable.maokai_square_0),
					new Champion("Master Yi", R.drawable.masteryi_square_0),
					new Champion("Miss Fortune", R.drawable.missfortune_square_0),					 
					new Champion("Mordekaiser", R.drawable.mordekaiser_square_0),
					new Champion("Morgana", R.drawable.morgana_square_0),
					new Champion("Nasus", R.drawable.nasus_square_0),
					new Champion("Nautilus", R.drawable.nautilus_square_0),
					new Champion("Nidalee", R.drawable.nidalee_square_0),
					new Champion("Nocturne", R.drawable.nocturne_square_0),
					new Champion("Nunu", R.drawable.nunu_square_0),
					new Champion("Olaf", R.drawable.olaf_square_0),
					new Champion("Orianna", R.drawable.orianna_square_0),
					new Champion("Pantheon", R.drawable.pantheon_square_0)

			};
			
	public LeagueChampions() {
				
	}
	
	/**
	 * Returns the full array of champion icon IDs in alphabetical order for the gridview
	 * @return
	 */
	public Integer[] getIconAssetArray() {
		Integer[] assetArray = new Integer[NUMBER_OF_CHAMPIONS];
			
		for(int i = 0; i < NUMBER_OF_CHAMPIONS; i++)
			assetArray[i] = leagueChamps[i].getIconAssetID();			
			
		return assetArray;
	}
	
	/**
	 * Returns the name of the champion associated with the given alphabetical index.
	 * @param index
	 * @return
	 */
	public String getChampNameByIndex(int index) {
		return leagueChamps[index].getChampName();
	}
	
	/**
	 * Returns the champion object associated with the given alphabetical index.
	 * @param index
	 * @return
	 */
	public Champion getChampionByIndex(int index) {
		if((index >= 0) && (index < NUMBER_OF_CHAMPIONS))
			return leagueChamps[index];
		else
			return new Champion(); //Return non-real champion
	}
		
	/**
	 * Returns the champion object associated with the given champion name.
	 * @param champName
	 * @return
	 */
	public Champion getChampionByName(String champName) {
		for (int i = NUMBER_OF_CHAMPIONS; i < NUMBER_OF_CHAMPIONS; i++) {
			if(champName.equals(leagueChamps[i].getChampName()))
				return leagueChamps[i];				
		}			
		return new Champion();
	}
	
}

