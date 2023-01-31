package music_player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class MAIN {
	private static ArrayList<Albums> Albums = new ArrayList<Albums>(); 

	public static void main(String[] args) {
		
		Albums album1 = new Albums("More life", "Drake");
		album1.addSong("Free Smoke", 3.3);
		album1.addSong("No long talk", 2.0);
		album1.addSong("Fake love", 2.0);	
		album1.addSong("Teenage fever", 3.0);	
		album1.addSong("Portland", 1.59);
		album1.addSong("4422", 3.00);
		
		Albums.add(album1);
		
		Albums album = new Albums("DAWN FM", "THE WEEKND");
		album.addSong("Gasoline", 3.31);
		album.addSong("take my breath", 3.34);
		album.addSong("out of time", 3.00);
		album.addSong("sacrifice", 3.0);
		album.addSong("BestFriend", 3.21);
		album.addSong("less than zero", 2.90);
		album.addSong("here we go again", 4.00);
		album.addSong("every angel is terrifying", 5.00);
		album.addSong("is there someone else", 4.53);
		album.addSong("stary eyes", 3.22);
		
		Albums.add(album);
		
		Albums album2 = new Albums("AstroWorld", "Travis Scott");
		album2.addSong("sicko mode", 3.00);
		album2.addSong("No bystanders", 4.00);
		album2.addSong("skeletons", 2.10);
		album2.addSong("Yosmite", 3.55);
		Albums.add(album2);
		
		
		LinkedList<Songs> playlist = new LinkedList<Songs>();
		Albums.get(0).addToPlaylist(2, playlist); //0 represents the first album and the song in alnum you want to add
		//albums.get(0).addToPlaylist("100", playlist);//not in album 
		Albums.get(0).addToPlaylist(5, playlist);//overloaded method in album. just a alternative
		Albums.get(0).addToPlaylist(0, playlist);
		Albums.get(0).addToPlaylist(1, playlist);
		Albums.get(0).addToPlaylist(3, playlist);
		Albums.get(0).addToPlaylist(4, playlist);
		//other album
		Albums.get(1).addToPlaylist(0, playlist);
		Albums.get(1).addToPlaylist(3, playlist);
		Albums.get(1).addToPlaylist(1, playlist);
		Albums.get(1).addToPlaylist(2, playlist);
		
		//other album
		Albums.get(2).addToPlaylist(0, playlist);
		Albums.get(2).addToPlaylist(1, playlist);
		Albums.get(2).addToPlaylist(2, playlist);
		Albums.get(2).addToPlaylist(3, playlist);
		Albums.get(2).addToPlaylist(4, playlist);
		Albums.get(2).addToPlaylist(5, playlist);
		Albums.get(2).addToPlaylist(6, playlist);
		Albums.get(2).addToPlaylist(7, playlist);
		Albums.get(2).addToPlaylist(8, playlist);
		Albums.get(2).addToPlaylist(9, playlist);
		
		
		play(playlist);

	}
	private static void play(LinkedList<Songs> playlist) {
		Scanner input = new Scanner(System.in);
		boolean quit = false;
		boolean forward = true;
		ListIterator<Songs> ListIterator = playlist.listIterator();
		if(playlist.size() == 0) {
			System.out.println("No songs in playlist");
			return ;
		}else {
			System.out.println("Now playing "+ ListIterator.next().toString());
			printMenu();
		}
		while(!quit) {
			int action = input.nextInt();
			input.nextLine();
			
			switch(action) {
			    case 0:
			    	System.out.println("Playlist complete.");
			    	quit = true;
			    	break;
			    case 1:
			    	if(!forward) {
			    		if(ListIterator.hasNext()) {
			    			ListIterator.next();
			    		}
			    		forward = true;
			    	}
			    	if(ListIterator.hasNext()) {
			    		System.out.println("Now Playing " + ListIterator.next().toString());
			    	}else {
			    		System.out.println("we at the end of list");
			    		forward = false;
			    	}
			    	break;
			    case 2:
			    	if(forward) {
			    		if(ListIterator.hasPrevious()) {
			    			ListIterator.previous();
			    			System.out.println("Now Playing "+ ListIterator.previous());
			    		}
			    		forward = false;
			    	}else {
			    		System.out.println("we at the end of the list");
			    		forward = true;
			    	}
			    	break;
			    case 3:
			    	if(forward) {
			    		if(ListIterator.hasPrevious()) {
			    			System.out.println("Now replaying" + ListIterator.previous().toString());
			    			forward = false;
			    		}else {
			    			System.out.println("we at start at list");
			    		}
			    	}else {
			    		if(ListIterator.hasNext()) {
			    			System.out.println("Now playing " + ListIterator.next().toString());
			    			forward = true;
			    		}else {
			    			System.out.println("we at the end of the list");
			    		}
			    	}
			    	break;
			    case 4:
			    	printList(playlist);
			    	break;
			    case 5:
			    	printMenu();
			    	break;
			}
			
		}
	}


private static void printMenu() {
	System.out.println("avialable actions:\npress");
	System.out.println("0 - to quit\n" + "1 - to play next song\n" + "2 - to play previous song\n" + "3 - to replay the current song\n"+ "4 - list songs in playlist\n" +"5 - print avaliable actions."); 
    }


private static void printList(LinkedList<Songs> playlist) {
	Iterator<Songs> iterator = playlist.iterator();
	System.out.println("=================");
	while(iterator.hasNext()) {
		System.out.println(iterator.next().toString());
	}
	System.out.println("=================");
}

	
}
