//Alex Silva copyright (c) 2013 
//with help from mportiz08 and bucjac

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class puzzle2Driver {

	//DRIVER FIELDS
	private static BufferedReader scn;
	private static ArrayList<Song> arrInput;
	private static String[] tokens;
	private static int nSongs;
	private static int nSelects;
	
	//MAIN METHOD
	public static void main(String[] args) throws IOException {
		
		scn = null;

        try {
        	
        	scn = new BufferedReader(new InputStreamReader(System.in));
        	
    		//accept first line of input
       		//split and parse entries; add to values to variables
        	tokens = scn.readLine().split(" ");
    		nSongs = Integer.parseInt(tokens[0].trim());
    		nSelects = Integer.parseInt(tokens[1].trim()); 
    		arrInput = new ArrayList<Song>(nSongs);
  
    		//accept and record first song info in input array
        	tokens = scn.readLine().split(" ");
    		//add first song to array
    		arrInput.add((new Song(Long.parseLong(tokens[0].trim()), tokens[1].trim(), 0)));
    		arrInput.get(0).setnQuality(arrInput.get(0).getnPlayNum());
            
            //if only one song is added
            if(nSongs==1){
            	System.out.print(arrInput.get(0).getSongName());
            }
            
            //otherwise, proceed:
            else{
            	
	    		Song songIn;
	    		long tempQ;
	    		int i=1;
	            while (i<nSongs) {
	            	tokens = scn.readLine().split(" ");
	    			//create and add song to array
	    			songIn = new Song(Long.parseLong(tokens[0].trim()), tokens[1].trim(), i+2);
	    			arrInput.add(songIn);
	    			//calculate quality using:
	    			//q(i) = song(i).plays / (1 / i+1 ) = song(i).plays * (i+1)
	    			tempQ = arrInput.get(i).getnPlayNum()*(i+1);
	    			//set Quality value of current song
	    			arrInput.get(i).setnQuality(tempQ);
	    			i++;
	            }
	            
	    		//sort array of songs by quality value
	    		Collections.sort(arrInput);
	    		
	    		//prints only the number of songs defined earlier
	    		StringBuilder outBuffer = new StringBuilder();
				for(i=0; i < nSelects; i++) {
					outBuffer.append(arrInput.get(i).getSongName());
					//no new line at the end
		            if (i < nSelects-1){
		            outBuffer.append('\n');
					}
				}

				System.out.print(outBuffer);
				
            }
        }
        
        catch(Exception e){
            System.out.println("Exception caught");
        	System.out.println(e.getStackTrace());

        } finally {
            if (scn != null) {
                scn.close();
            }
        }

	}
	
	//PRIVATE SONG UTILITY CLASS
	private static class Song implements Comparable<Song> {
		
		//Song Fields
		private long nPlayNum;
		private String songName;
		private int nTrackNum;
		private long nQuality;
		
		//Song constructor 
		public Song(long nPlayNum, String songName, int nTrackNum){
			this.nPlayNum = nPlayNum;
			this.songName = songName;
			this.nTrackNum = nTrackNum;
		}
		
		@Override
		public int compareTo(Song o) {
            
			long res = o.getnQuality() - getnQuality();

			// If two songs have the same quality, return the song with lower track number
			if (res == 0.0) {
				res = getnTrackNum() - o.getnTrackNum();
			}

			return (int)Math.signum(res);
			
			//note: no way to return 0, since songs can't have the same track number
			
		}
		
		//GETTERS SETTERS
		public long getnPlayNum() {
			return nPlayNum;
		}
		
		public String getSongName() {
			return songName;
		}
		
		public long getnQuality() {
			return nQuality;
		}

		public void setnQuality(long nQuality) {
			this.nQuality = nQuality;
		}

		public int getnTrackNum() {
			return nTrackNum;
		}
	}
}
