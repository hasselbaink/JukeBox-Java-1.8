
public class Song implements Comparable<Song>{
    private String title;
    private String artist;
    private byte rating;
    private int bpm;
    public int compareTo(Song s) {
	return title.compareTo(s.getTitle());
    }
    public Song(String title, String artist, byte rating, int bpm) {
	this.title = title;
	this.artist = artist;
	this.rating = rating;
	this.bpm = bpm;
    }
    public String getTitle() {
	return title;
    }
    public String getArtist() {
	return artist;
    }
    public byte getRating() {
	return rating;
    }
    public int getBpm() {
	return bpm;
    }
    public String toString() {
	return title + ":" + artist + ":" + rating + ":" + bpm;
    }
}
