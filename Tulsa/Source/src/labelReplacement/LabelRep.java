package labelReplacement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LabelRep {

	public static void main(String[] args)
	{

		//The second parameter is the out put file
	    String outputName = args[1];
	    
	    //Modifying the encoding
	    String toBeReplacedEncoding = "ASCII";
	    String toBeReplacedByEncoding = "us-ascii";
	    
	    String toBeReplacedxmi = "xmi:version=\"2.0\"";
	    String toBeReplacedByxmi = "";	
	    
	    String toBeReplacedxmlns = "xmlns:xmi=\"http://www.omg.org/XMI\" xmlns=\"lqn-model\"";
	    String toBeReplacedByxmlns = "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"/usr/local/share/lqns/lqn.xsd\"";	
	    
	    //Adding '-' to the label
		String toBeReplaced1 = "activity1";
		String toBeReplacedBy1 = "activity";
		
		String toBereplaced2 = "entryphaseactivities";
		String toBeReplacedBy2 = "entry-phase-activities";
		
		String toBeReplaced3 = "synchcall";
		String toBeReplacedBy3 = "synch-call";
		
		String toBeReplaced4 = "taskactivities";	
		String toBeReplacedBy4 = "task-activities";
		
		String toBeReplaced5 = "boundtoentry";
		String toBeReplacedBy5 = "bound-to-entry";
		
		String toBeReplaced6 = "activityRPreOr";
		String toBeReplacedBy6 = "activity";
		String toBeReplaced7 = "activityRPostOr";
		String toBeReplacedBy7 = "activity";
		String toBeReplaced8 = "activityRPreAnd";
		String toBeReplacedBy8 = "activity";
		String toBeReplaced9 = "activityRPostAnd";
		String toBeReplacedBy9 = "activity";
		String toBeReplaced10 = "activityRPre";
		String toBeReplacedBy10 = "activity";
		String toBeReplaced11 = "activityRPost";
		String toBeReplacedBy11 = "activity";
		
		String toBeReplaced12 = "asynchcall";
		String toBeReplacedBy12 = "asynch-call";
		
		String toBeReplaced13 = "replyactivity";
		String toBeReplacedBy13 = "reply-activity";
		
		String toBeReplaced14 = "replyentry";
		String toBeReplacedBy14 = "reply-entry";
		
		String toBeReplaced15 = "lqnmodel";
		String toBeReplacedBy15 = "lqn-model";
		
		String toBeReplaced16 = "preor";
		String toBeReplacedBy16 = "pre-OR";
		
		String toBeReplaced17 = "preand";
		String toBeReplacedBy17 = "pre-AND";
		
		String toBeReplaced18 = "postor";
		String toBeReplacedBy18 = "post-OR";
		
		String toBeReplaced19 = "postand";
		String toBeReplacedBy19 = "post-AND";
		
		String toBeReplaced20 = "thinktime";
		String toBeReplacedBy20 = "think-time";
		
		String toBeReplaced21 = "callorder";
		String toBeReplacedBy21 = "call-order";
		
		String toBeReplaced22 = "callsmean";
		String toBeReplacedBy22 = "calls-mean";
		
		String toBeReplaced23 = "hostdemandmean";
		String toBeReplacedBy23 = "host-demand-mean";
		
		try {
			//Source model file which needs to be replaced its labels (reading the file into a string)
			String fileContent = TagFileUploader(args[0]);
			//Starting to replace
			String newFileContent = fileContent.replaceAll(toBeReplaced1, toBeReplacedBy1);
			newFileContent = newFileContent.replaceAll(toBereplaced2, toBeReplacedBy2);
			newFileContent = newFileContent.replaceAll(toBeReplaced3, toBeReplacedBy3);
			newFileContent = newFileContent.replaceAll(toBeReplaced4, toBeReplacedBy4);
			newFileContent = newFileContent.replaceAll(toBeReplaced5, toBeReplacedBy5);
			newFileContent = newFileContent.replaceAll(toBeReplaced6, toBeReplacedBy6);
			newFileContent = newFileContent.replaceAll(toBeReplaced7, toBeReplacedBy7);
			newFileContent = newFileContent.replaceAll(toBeReplaced8, toBeReplacedBy8);
			newFileContent = newFileContent.replaceAll(toBeReplaced9, toBeReplacedBy9);
			newFileContent = newFileContent.replaceAll(toBeReplaced10, toBeReplacedBy10);
			newFileContent = newFileContent.replaceAll(toBeReplaced11, toBeReplacedBy11);
			newFileContent = newFileContent.replaceAll(toBeReplaced12, toBeReplacedBy12);
			newFileContent = newFileContent.replaceAll(toBeReplaced13, toBeReplacedBy13);
			newFileContent = newFileContent.replaceAll(toBeReplaced14, toBeReplacedBy14);
			newFileContent = newFileContent.replaceAll(toBeReplaced15, toBeReplacedBy15);
			newFileContent = newFileContent.replaceAll(toBeReplaced16, toBeReplacedBy16);
			newFileContent = newFileContent.replaceAll(toBeReplaced17, toBeReplacedBy17);
			newFileContent = newFileContent.replaceAll(toBeReplaced18, toBeReplacedBy18);
			newFileContent = newFileContent.replaceAll(toBeReplaced19, toBeReplacedBy19);
			newFileContent = newFileContent.replaceAll(toBeReplaced20, toBeReplacedBy20);
			newFileContent = newFileContent.replaceAll(toBeReplaced21, toBeReplacedBy21);
			newFileContent = newFileContent.replaceAll(toBeReplaced22, toBeReplacedBy22);
			newFileContent = newFileContent.replaceAll(toBeReplaced23, toBeReplacedBy23);
			
			newFileContent = newFileContent.replaceAll(toBeReplacedEncoding, toBeReplacedByEncoding);
			newFileContent = newFileContent.replaceAll(toBeReplacedxmi, toBeReplacedByxmi);
			newFileContent = newFileContent.replaceAll(toBeReplacedxmlns, toBeReplacedByxmlns);
			
			//Writing the new contents into the target model file
			writeFile(newFileContent, outputName);
			System.out.print(newFileContent);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.print(e);
		}	
		
	}
	private static String TagFileUploader(String filepath) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(filepath)))
		{
			String line = br.readLine();
			while (line != null)
			{
				sb.append(line);
				line = br.readLine();
			}
		}
		return sb.toString();
	}
	
	public static void writeFile(String yourXML, String outputname) throws IOException{
	    BufferedWriter out = new BufferedWriter(new FileWriter(outputname));
	    try { 
	        out.write(yourXML);
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	}

}