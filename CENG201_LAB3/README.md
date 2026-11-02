# CENG201 - Lab 3: Doubly Linked List

## Files
- `SongNode.java`: represents one song and stores `prev` and `next` references.
- `MusicPlaylist.java`: implements adding, removing, forward/backward navigation, displaying songs, and the lecture-slide extension `addSongAfter`.
- `MusicPlayerDemo.java`: runs the scenario and prints the assignment's expected playlist sequence.

## Requirements
Java JDK 8 or newer.

## Compile and run
Open a terminal in this folder and run:

```bash
javac SongNode.java MusicPlaylist.java MusicPlayerDemo.java
java MusicPlayerDemo
```

## Implementation notes
- `head`, `tail`, and `current` are private fields.
- Both directions are maintained when nodes are added or removed.
- Removing the current song selects its next song; if there is no next song, it selects the previous song.
- Removing the only song resets `head`, `tail`, and `current` to `null`.
- `addSongAfter` is included as an additional operation shown on page 12 of the lab slides.
