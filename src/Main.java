public class Main {
    public static void main(String[] args) {
        
        // First Object
        MusicBox mbox = new MusicBox("S34TG65", 'Y', "Raindrops", "Misty", 
        "The path less traveled", "Country", "BZEE Music", "Rhythm Divine");

        PlaySongs playsong = new PlaySongs();
        
        playsong.playSong(mbox.getSongID(), mbox.getPremiumSong(), 2);

        
        // --- TODO
        /* * Repeat the above code to create another object.
         * Pass 'N' for premiumSong and 1 for the ads parameter.
        */
        
        // Creating the second object using the same constructor format
        MusicBox anotherBox = new MusicBox("S98RT21", 'N', "Starry Night", "Vincent", 
        "Midnight Sketches", "Jazz", "Blue Note", "Smooth Records");

        // Calling playSong with 1 for the ads parameter as requested
        playsong.playSong(anotherBox.getSongID(), anotherBox.getPremiumSong(), 1);

    }
}
