package music_player;

import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Albums {
	
	private String name;
	private String artist;
	private ArrayList<Songs> songs;
	
	public Albums(String name, String artist) {
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Songs>();//initialize array list
	}
	
	//methods to add functionality
	//add to array list
	public boolean addSong(String name, double duration) {
		if(findSong(name) == null) {
			this.songs.add(new Songs(name, duration));
			return true;
		}
		return false;
	}
	
	private Songs findSong(String name) {
		for(Songs checkedSong: this.songs) {//for each.  alternative to a for loop
			if(checkedSong.getName().equals(name)) {
				return checkedSong;
			}
		}
		return null;
	}
	
	public boolean addToPlaylist(int trackNumber, LinkedList<Songs> playlist) {
		int  index = trackNumber - 1;
		if((index >= 0) && (index <= this.songs.size())){
			playlist.add(this.songs.get(index));
			return true;
		}
		System.out.println("This album does not have a track "+ trackNumber);
		return false;
	}
	
	
	public boolean addToPlaylist(String name, LinkedList<Songs> playlist) {
		Songs checkedSong = findSong(name);
		if(checkedSong != null) {
			playlist.add(checkedSong);
			return true;
		}
		System.out.println("Song is not in the album");
		return false;
	}

}
