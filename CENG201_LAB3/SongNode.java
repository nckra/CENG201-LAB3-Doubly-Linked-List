/**
 * SongNode.java
 * Represents one song in a doubly linked playlist.
 *
 * Your Name:        Sudenaz Çakır
 * Your Student ID:  230446030
 * Your Date:        24.10.2026
 */
public class SongNode {
    String title;
    SongNode prev;
    SongNode next;

    public SongNode(String title) {
        this.title = title;
        this.prev = null;
        this.next = null;
    }
}
