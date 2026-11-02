/**
 * MusicPlaylist.java
 * Represents a music playlist implemented with a doubly linked list.
 *
 * Your Name:        Sudenaz Çakır
 * Your Student ID:  230446030
 * Your Date:        02.11.2026
 */
public class MusicPlaylist {
    private SongNode head;
    private SongNode tail;
    private SongNode current;

    // Initially, the playlist is empty and no song is selected.
    public MusicPlaylist() {
        head = null;
        tail = null;
        current = null;
    }

    // Add a song to the end of the playlist.
    public void addSong(String title) {
        SongNode newNode = new SongNode(title);

        // First node becomes head, tail, and the current song.
        if (head == null) {
            head = newNode;
            tail = newNode;
            current = newNode;
            return;
        }

        // Connect the new node after the current tail in both directions.
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    // Remove the first song whose title matches the given title.
    public void removeSong(String title) {
        SongNode node = head;

        // Search from the beginning of the playlist.
        while (node != null && !node.title.equals(title)) {
            node = node.next;
        }

        if (node == null) {
            System.out.println("The song isn't in the playlist");
            return;
        }

        // Keep the song that should become current if the current node is removed.
        if (node == current) {
            current = (node.next != null) ? node.next : node.prev;
        }

        // If there is a previous node, bypass the node being removed.
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            // The removed node was the head.
            head = node.next;
        }

        // If there is a next node, link it back to the previous node.
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            // The removed node was the tail.
            tail = node.prev;
        }

        // If the list became empty, all three references must be null.
        if (head == null) {
            tail = null;
            current = null;
        }

        // Detach the removed node from the list.
        node.prev = null;
        node.next = null;
        System.out.println("Removed: " + node.title);
    }

    // Move to the next song, if one exists.
    public void nextSong() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the last song of the playlist.");
        }
    }

    // Move to the previous song, if one exists.
    public void previousSong() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Playing: " + current.title);
        } else {
            System.out.println("Already at the first song of the playlist.");
        }
    }

    // Display the currently selected song.
    public void displayCurrentSong() {
        if (current == null) {
            System.out.println("There is no song currently playing.");
        } else {
            System.out.println("Current Song: " + current.title);
        }
    }

    // Display all songs from head to tail.
    public void displayPlaylist() {
        SongNode temp = head;

        if (temp == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        while (temp != null) {
            System.out.print(temp.title + " <-> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Extra method from the lecture slides: insert a song after a given song.
    public void addSongAfter(String existingTitle, String newTitle) {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }

        SongNode search = head;
        while (search != null && !search.title.equals(existingTitle)) {
            search = search.next;
        }

        if (search == null) {
            System.out.println("Song not found: " + existingTitle);
            return;
        }

        SongNode newNode = new SongNode(newTitle);
        newNode.prev = search;
        newNode.next = search.next;

        if (search.next != null) {
            search.next.prev = newNode;
        } else {
            // Inserting after the old tail makes the new node the tail.
            tail = newNode;
        }

        search.next = newNode;
    }
}
