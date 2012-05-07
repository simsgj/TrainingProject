package gnt.sd;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {
	TabHost _tabHost;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        startActivity(new Intent(this, SDPlayerActivity.class));
        _tabHost = getTabHost();
        _tabHost.setup();
        TabSpec albumTabSpec = _tabHost.newTabSpec("album");
        TabSpec artistTabSpec = _tabHost.newTabSpec("artist");
        TabSpec songTabSpec = _tabHost.newTabSpec("song");
        TabSpec playlistTabSpec = _tabHost.newTabSpec("hotplaylist");
        TabSpec playlistTS = _tabHost.newTabSpec("playlist");
        playlistTS.setIndicator("Playlist", getResources().getDrawable(R.drawable.music_tab_playlists)).setContent(new Intent(this,SDPlaylistActivity.class));
        playlistTabSpec.setIndicator("HotPlaylist", getResources().getDrawable(R.drawable.music_tab_playlists)).setContent(new Intent(this,SDHotPlaylistActivity.class));
        artistTabSpec.setIndicator("Artist", getResources().getDrawable(R.drawable.music_tab_artists)).setContent(new Intent(this,SDArtistActivity.class));
        albumTabSpec.setIndicator("Album", getResources().getDrawable(R.drawable.music_tab_albums)).setContent(new Intent(this,SDAlbumActivity.class));
        songTabSpec.setIndicator("Song", getResources().getDrawable(R.drawable.music_tab_all_tracks)).setContent(new Intent(this,SDSongActivity.class));
        _tabHost.addTab(playlistTabSpec);
        _tabHost.addTab(playlistTS);
        _tabHost.addTab(artistTabSpec);
        _tabHost.addTab(albumTabSpec);
        _tabHost.addTab(songTabSpec);
        for(int i=0; i< _tabHost.getTabWidget().getChildCount(); i++)
        	_tabHost.getTabWidget().getChildAt(i).getLayoutParams().height = (int) (60*getResources().getDisplayMetrics().density);
        
        
    }
}