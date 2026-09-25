package week7.assigment_problems;

import java.util.Arrays;

public class Playlist {
    private String[] songs;
    private int count;

    Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }

    void addSong(String title) {
        songs[count] = title;
        count++;
    }

    String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println(p.getSongs()[0]);
        System.out.println(p.getSongCount());
    }
}