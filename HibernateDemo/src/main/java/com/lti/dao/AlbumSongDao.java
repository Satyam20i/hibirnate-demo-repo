package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.lti.model.Album;
import com.lti.model.Genre;
import com.lti.model.Song;

public class AlbumSongDao {
	EntityManager em;
	EntityManagerFactory emf;
	EntityTransaction tx;
	
	
	public AlbumSongDao(){
		emf = Persistence.createEntityManagerFactory("pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	 
	public Album addOrUpdateAnAlbum(Album album){
		tx.begin();
		Album albumPersisted = em.merge(album);
		tx.commit();
		return albumPersisted;
	}
	public Song addASongInAnAlbum(Song song){
		tx.begin();
		Song song1 = em.merge(song);
		tx.commit();
		return song1;
	}
	public Album findAlbumById(int albumId){
		return em.find(Album.class, albumId);
	}
	public Album getAlbumBySongId(int songId){
		Song song = em.find(Song.class, songId);
		return song.getAlbum();
	}
	public List<Song> getSongsByAlbumId1(int albumId){
		String jpql = "select s from Song s where s.album.albumId=:alnId";
		TypedQuery<Song> query =  em.createQuery(jpql,Song.class);
		query.setParameter("alnId", albumId);
		return query.getResultList();
	}
	public List<Song> getSongsByAlbumId(int albumId){
		Album album =em.find(Album.class, albumId);
		return album.getSongs();
	}
	public List<Song> getSongByGenre(Genre genre){
		String jpql ="select s from Song s where s.album.genre=:gnr";
		TypedQuery<Song> query = em.createQuery(jpql,Song.class);
		query.setParameter("gnr", genre);
		return query.getResultList();
		
	}
	
}
