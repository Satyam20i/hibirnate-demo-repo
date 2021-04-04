package com.lti;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.AlbumSongDao;
import com.lti.model.Album;
import com.lti.model.Genre;
import com.lti.model.Song;

public class AlbumSongsTest {
	
	AlbumSongDao dao =new AlbumSongDao(); 
	@Test
	public void addAnAlbum() {
		Album album = new Album();
		album.setAlbumName("Rafi Ki Yaadein");
		album.setGenre(Genre.CLASSICAL);
		album.setReleaseDate(LocalDate.now());
		
		Album album1 = dao.addOrUpdateAnAlbum(album);
		System.out.println(album1.getAlbumId()+" "+album1.getGenre()+" "+album1.getReleaseDate());
		
	}
	
	@Test
	public void addASongInAnAlbum(){
		Song song =new Song();
		song.setArtist("Mohd. Fafi Saheb");
		song.setTitle("Kya Hua Tera Wada");
		song.setDuration(3.45);
		Album album = dao.findAlbumById(2021);
		song.setAlbum(album);
		dao.addASongInAnAlbum(song);
	}
	
	@Test
	public void addAnAlbumWithSongs(){
		Album album = new Album();
		album.setAlbumName("Hybrid Theory");
		album.setGenre(Genre.ROCK);
		album.setReleaseDate(LocalDate.now());
		
		List<Song> songs = new ArrayList<Song>();
		Song song1 = new Song();
		song1.setTitle("All ");
		song1.setArtist("Chester Bennigngton");
		song1.setDuration(4.5);
		songs.add(song1);
		Song song2 = new Song();
		song2.setTitle("All Time Low");
		song2.setArtist("Title and Jon Bellion");
		song2.setDuration(4.8);
		songs.add(song2);
		Song song3 = new Song();
		song3.setTitle("Shape of You");
		song3.setArtist("Ed Sheeren");
		song3.setDuration(3.6);
		songs.add(song3);
		Song song4 = new Song();
		song4.setTitle("Death Bed");
		song4.setArtist("powfu");
		song4.setDuration(3.7);
		songs.add(song4);
		album.setSongs(songs);
		song1.setAlbum(album);
		song2.setAlbum(album);
		song3.setAlbum(album);
		song4.setAlbum(album);
		Album album1 = dao.addOrUpdateAnAlbum(album);
		System.out.println(album1.getAlbumId()+" "+album1.getGenre()+" "+album1.getReleaseDate());
		
	}
	@Test
	public void getAlbumBySongId(){
		Album album1=dao.getAlbumBySongId(3021);
		System.out.println(album1.getAlbumId()+" "+album1.getGenre()+" "+album1.getReleaseDate());
		
	}
	@Test
	public void getSongsByAlbumId(){
		List<Song> songs= dao.getSongsByAlbumId1(2023);
		for(Song song:songs){
			System.out.println(song.getSongId()+" "+song.getArtist()+" "+song.getTitle()+" "+song.getDuration());
		}
	}
	@Test
	public void getSongsByGenre(){
		List<Song> songs= dao.getSongByGenre(Genre.ROCK);
		for(Song song:songs){
			System.out.println(song.getSongId()+" "+song.getArtist()+" "+song.getTitle()+" "+song.getDuration());
		}
	}
	
	

}
