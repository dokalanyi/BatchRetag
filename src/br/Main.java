package br;
import java.io.*;
import java.util.Scanner;

import org.blinkenlights.jid3.*;
import org.blinkenlights.jid3.v1.*;
import org.blinkenlights.jid3.v2.*;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter Folder containing files: ");
		String path = in.nextLine();
		
		System.out.println("Please enter Album name: ");
		String album = in.nextLine();
		
		File dir = new File(path);
		if(dir.isDirectory()){
			String[] files = dir.list();
			for(int i=0; i<files.length; i++){
				File source = new File(path + "\\" + files[i]);
				
				MediaFile mediafile = new MP3File(source);
				
				ID3V2_3_0Tag oID3V2_3_0Tag = new ID3V2_3_0Tag();
		        oID3V2_3_0Tag.setAlbum(album);
		        
		        mediafile.setID3Tag(oID3V2_3_0Tag);
		        mediafile.sync();
			}
		} else {
			System.out.println("Not a directory");
		}
		System.out.println("I'm Done");
	}

}
