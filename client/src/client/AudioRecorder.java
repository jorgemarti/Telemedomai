package client;

import java.io.IOException;
import java.io.File;

import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.AudioFileFormat;



public class AudioRecorder
extends Thread
{
	private TargetDataLine m_line;
	private AudioFileFormat.Type m_targetType;
	private AudioInputStream m_audioInputStream;
	private File m_outputFile;



	public AudioRecorder(TargetDataLine line,
				     AudioFileFormat.Type targetType,
				     File file)
	{
		m_line = line;
		m_audioInputStream = new AudioInputStream(line);
		m_targetType = targetType;
		m_outputFile = file;
	}

        public AudioRecorder(String file)
        {
               /* For simplicity, the audio data format used for recording
		   is hardcoded here. We use PCM 44.1 kHz, 16 bit signed,
		   stereo.
		*/
		AudioFormat audioFormat = new AudioFormat(
			AudioFormat.Encoding.PCM_SIGNED,
			44100.0F, 16, 2, 4, 44100.0F, false);
                 
		/* Now, we are trying to get a TargetDataLine. The
		   TargetDataLine is used later to read audio data from it.
		   If requesting the line was successful, we are opening
		   it (important!).
		*/
		DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
		TargetDataLine	targetDataLine = null;
		try
		{
			targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
			targetDataLine.open(audioFormat);
		}
		catch (LineUnavailableException e)
		{
			out("unable to get a recording line");
			e.printStackTrace();
			System.exit(1);
		}

		/* Again for simplicity, we've hardcoded the audio file
		   type, too.
		*/
		AudioFileFormat.Type	targetType = AudioFileFormat.Type.WAVE;

		/* Now, we are creating an AudioRecorder object. It
		   contains the logic of starting and stopping the
		   recording, reading audio data from the TargetDataLine
		   and writing the data to a file.
		*/
		
                
                m_line = targetDataLine;
                m_audioInputStream = new AudioInputStream(m_line);
		m_outputFile = new File(file);
                m_targetType = targetType;
                
                //Marcamos el archivo temporal utilizado para ser eliminado al salir del programa
                m_outputFile.deleteOnExit();
            
		
        }


	/** Starts the recording.
	    To accomplish this, (i) the line is started and (ii) the
	    thread is started.
	*/
	public void start()
	{
		/* Starting the TargetDataLine. It tells the line that
		   we now want to read data from it. If this method
		   isn't called, we won't
		   be able to read data from the line at all.
		*/
		m_line.start();

		/* Starting the thread. This call results in the
		   method 'run()' (see below) being called. There, the
		   data is actually read from the line.
		*/
		super.start();
	}


	/** Stops the recording.

	    Note that stopping the thread explicitely is not necessary. Once
	    no more data can be read from the TargetDataLine, no more data
	    be read from our AudioInputStream. And if there is no more
	    data from the AudioInputStream, the method 'AudioSystem.write()'
	    (called in 'run()' returns. Returning from 'AudioSystem.write()'
	    is followed by returning from 'run()', and thus, the thread
	    is terminated automatically.

	    It's not a good idea to call this method just 'stop()'
	    because stop() is a (deprecated) method of the class 'Thread'.
	    And we don't want to override this method.
	*/
	public void stopRecording()
	{
		m_line.stop();
                m_line.close();              
	}




	/** Main working method.
	    You may be surprised that here, just 'AudioSystem.write()' is
	    called. But internally, it works like this: AudioSystem.write()
	    contains a loop that is trying to read from the passed
	    AudioInputStream. Since we have a special AudioInputStream
	    that gets its data from a TargetDataLine, reading from the
	    AudioInputStream leads to reading from the TargetDataLine. The
	    data read this way is then written to the passed File. Before
	    writing of audio data starts, a header is written according
	    to the desired audio file type. Reading continues untill no
	    more data can be read from the AudioInputStream. In our case,
	    this happens if no more data can be read from the TargetDataLine.
	    This, in turn, happens if the TargetDataLine is stopped or closed
	    (which implies stopping). (Also see the comment above.) Then,
	    the file is closed and 'AudioSystem.write()' returns.
	*/
	public void run()
	{
			try
			{
				AudioSystem.write(
					m_audioInputStream,
					m_targetType,
					m_outputFile);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
	}



	


	private static void out(String strMessage)
	{
		System.out.println(strMessage);
	}
}

