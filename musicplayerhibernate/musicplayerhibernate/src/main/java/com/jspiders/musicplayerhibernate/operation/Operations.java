package com.jspiders.musicplayerhibernate.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.musicplayerhibernate.song.Song;



public class Operations {
	
	private static EntityManagerFactory factory ;
	private static EntityManager manager ;
	private static EntityTransaction transaction ;
	
	public static void openConnection() {
		factory = Persistence.createEntityManagerFactory("musichibernate");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}
	
	public static void closeConnection() {
		if(factory != null) {
			factory.close();
		}
		if(manager != null) {
			manager.close();
		}
		if(transaction.isActive()) {
			transaction.rollback();
		}
	}
	
	static Scanner sc = new Scanner(System.in);
	
	ArrayList<Song> playList = new ArrayList<Song>();
	
	List<Song> list = new ArrayList<>();
	
	public void createPlayList() {
		
		openConnection();
		transaction.begin();
		
		Song song1 = new Song();
		song1.setSongId(1);
		song1.setSongName("Tum hi ho");
		song1.setSinger("Arijit");
		song1.setDuration(4.5);
		
		Song song2 = new Song();
		song2.setSongId(2);
		song2.setSongName("Jeena Jeena");
		song2.setSinger("Atif");
		song2.setDuration(3.7);
		
		Song song3 = new Song();
		song3.setSongId(3);
		song3.setSongName("Mere Sapno ki Raani");
		song3.setSinger("Kishor Kumar");
		song3.setDuration(5.5);
		
		Song song4 = new Song();
		song4.setSongId(4);
		song4.setSongName("Calm Down");
		song4.setSinger("Rema");
		song4.setDuration(4.5);
		
		Song song5 = new Song();
		song5.setSongId(5);
		song5.setSongName("Gangster Paradise");
		song5.setSinger("Coolio");
		song5.setDuration(3.7);
		
		playList.add(song1);
		playList.add(song2);
		playList.add(song3);
		playList.add(song4);
		playList.add(song5);
		
		for(Song s : playList) {
			manager.persist(s);
		}
		transaction.commit();
	}
	
	public void playAll() {
		transaction.begin();
		
		for(Song s : playList) {
			Song song = manager.find(Song.class, s.getSongId());
			System.out.println(song.getSongName()+" is now playing");
		}
		transaction.commit();
	}
	
	public void playRandom() {
		double doubleNumber = Math.random()*10;
		int randomNumber = (int)doubleNumber;
		
		transaction.begin();
		
		for(Song s : playList) {
			if(s.getSongId() == randomNumber) {
				Song song = manager.find(Song.class , s.getSongId());
				System.out.println(song.getSongName()+" is now palying");
			}
		}
		transaction.commit();
	}
	
	public void chooseSong() {
		for(Song s : playList) {
			System.out.println(s);
		}
		transaction.begin();
		
		System.out.println("\nChoose Any Favourite..!!");
		int choice = sc.nextInt();
		for(Song s : playList) {
			if(s.getSongId() == choice) {
				Song song = manager.find(Song.class , s.getSongId());
				System.out.println(song.getSongName()+" is now palying");
			}
		}
		transaction.commit();
	}
	
	public void addSong() {
		System.out.print("Enter Song Id :");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("\nEnter Song Name :");
		String song = sc.nextLine();
		
		System.out.print("\nEnter Singer Name :");
		String singer = sc.nextLine();
		
		System.out.print("\nEnter Duration :");
		double duration = sc.nextDouble();
		
		transaction.begin();
		
		Song s = new Song();
		s.setSongId(id);
		s.setSongName(song);
		s.setSinger(singer);
		s.setDuration(duration);
		
		manager.persist(s);
		
		transaction.commit();
		
		System.out.println("Song added successfully...!!");
	}
	
	public void removeSong() {
		
		for(Song s : playList) {
			System.out.println(s);
		}
		
		transaction.begin();
		
		System.out.print("Enter Song Id to remove song :");
		int remove = sc.nextInt();
		
		for(Song song : playList) {
			if(song.getSongId() == remove) {
				Song s = manager.find(Song.class , song.getSongId());
				manager.remove(s);
				transaction.commit();
				System.out.println("Song removed");
				
			}
		}
	}
	
	public void editSong() {
		
		for(Song s : playList) {
			System.out.println(s);
		}
		
		System.out.print("Enter Song Id to Edit Song :");
		int edit = sc.nextInt();
		
		transaction.begin();
		
		boolean flag = false ;

		for(Song s : playList) {
			
			int id = s.getSongId();
			
			if(id == edit) {
				
				transaction.begin();
				
				System.out.println("What You Want to Edit \n1 .Song Name \n2. Singer Name \n3. Both Song and Singer Name");
				int choice = sc.nextInt();
				
				switch (choice) {
				
				case 1:
					System.out.println("Enter New Song Name :");
					sc.nextLine();
					String songName = sc.nextLine();
					Song song = manager.find(Song.class, id);
					song.setSongName(songName);
					manager.persist(song);
					transaction.commit();
					break;
					
				case 2:
					System.out.println("Enter New Singer Name :");
					sc.nextLine();
					String singerName = sc.nextLine();
					Song song1 = manager.find(Song.class, id);
					song1.setSinger(singerName);
					manager.persist(song1);
					transaction.commit();
					break;
					
				case 3:
					System.out.println("Enter New Song Name :");
					sc.nextLine();
					String songName1 = sc.nextLine();
			
					System.out.println("Enter New Singer Name :");
					//sc.nextLine();
					String singerName1 = sc.nextLine();
					Song song2 = manager.find(Song.class, id);
					song2.setSongName(songName1);
					song2.setSinger(singerName1);
					manager.persist(song2);
					transaction.commit();
					break;
					
				default:
					System.out.println("Enter Valid Option..!!");
					break;
				}
				flag = true ;
			}
		}
		if(flag) {
			System.out.println("Updated Successfully..!!");
		}else {
			System.out.println("Enter Valid Song Id");
		}
	}
}
		
