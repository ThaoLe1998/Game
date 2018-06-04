
package audio;

import java.applet.*; 
import java.net.*;

public class AudioUtility { 

  public static final AudioClip getAudioClip(String filename) { 
    if (filename != null) { 
      try { 
	return Applet.newAudioClip(new URL("file:" + filename));
      } catch (MalformedURLException e) { 
	System.err.println(e.getMessage());
      }
    }
    return null;
  }
  public static void main(String[] args) {
	getAudioClip("4.au");
}

}
