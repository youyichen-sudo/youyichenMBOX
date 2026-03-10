package PlaySongs;
public class Main{
    public static void main(String[] args) {
        MusicBox mbox = new MusicBox(songID: "S34TG65", premiumSong: 'Y', title: "Raindrops", artists: "Misty",
                songAlbum: "The path less traveled", genre: "Country", producer: "BZEE Music", label: "Rhythm Divine");

        System.out.println(x: "Now playing the song");
        mbox.playSong(mbox.getSongID(), mbox.getPremiumSong(), ads: 2);

        // --- TODO

        /* Repeat the above code to create another object
         * Pass different parameters to the MusicBox constructor, but initialise premiumSong to N and when calling the
         * playSong method, pass ads parameter as just 1
         *
         */

        MusicBox mbox2 = new MusicBox(songID: "S34TG99", premiumSong: 'N', title: "Rainbow", artists: "Misty",
                songAlbum: "The path more traveled", genre: "Countries", producer: "BLUEMusic", label: "Rhythm Divines");

        System.out.println(x: "Now playing the song");
        mbox2.playSong(mbox2.getSongID(), mbox2.getPremiumSong(), ads: 1);
    }
}
