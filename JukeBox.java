import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class JukeBox {
    private ArrayList<Song> songList = new ArrayList<Song>();
    public static void main(String[] args) {
	new JukeBox().go();
    }
    class TitleCompare implements Comparator<Song> {
	public int compare(Song one, Song two) {
	    return one.getTitle().compareTo(two.getTitle());
	}
    }
    class ArtistCompare implements Comparator<Song> {
	public int compare(Song one, Song two) {
	    return one.getArtist().compareTo(two.getArtist());
	}
    }
    class RatingCompare implements Comparator<Song> {
	public int compare(Song one, Song two) {
	    return one.getRating() < two.getRating() ? -1
		    : one.getRating() == two.getRating() ? 0 : 1;
	}
    }
    class BpmCompare implements Comparator<Song> {
	public int compare(Song one, Song two) {
	    return one.getBpm() < two.getBpm() ? -1
		    : one.getBpm() == two.getBpm() ? 0 : 1;
	}
    }
    public void go() {
	getSongs();
	
	Collections.sort(songList, new TitleCompare());
	System.out.println("Title compare:\t" + songList);
	
	Collections.sort(songList, new ArtistCompare());
	System.out.println("Artist compare:\t" + songList);
	
	Collections.sort(songList, new RatingCompare());
	System.out.println("Rating compare:\t" + songList);
	
	Collections.sort(songList, new BpmCompare());
	System.out.println("Bpm compare:\t" + songList);
	
	HashSet<Song> songSet = new HashSet<Song>();
	songSet.addAll(songList);
	System.out.println(songSet);
	
	TreeSet<Song> songTree = new TreeSet<Song>();
	songTree.addAll(songList);
	System.out.println(songTree);
    }
    private void getSongs() {
	try {
	    File file = new File("SongList.txt");
	    BufferedReader reader = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = reader.readLine()) != null) {
		addSong(line);
	    }
	} catch (Exception ex) {ex.printStackTrace();}
    }
    private void addSong(String lineToParse) {
	String[] tokens = lineToParse.split("/");
	Song nextSong = new Song(tokens[0], tokens[1], Byte.parseByte(tokens[2]), Integer.parseInt(tokens[3]));
	songList.add(nextSong);
    }
}
