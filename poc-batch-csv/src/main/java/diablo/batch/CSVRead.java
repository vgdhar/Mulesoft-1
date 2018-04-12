package diablo.batch;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.mule.api.MuleEventContext;
import org.mule.api.client.MuleClient;
import org.mule.api.lifecycle.Callable;

public class CSVRead implements Callable{

	String[] csvData;
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		 String csvFile = (String) eventContext.getMessage().getPayload();
	        String line = "";
	        String cvsSplitBy = ",";

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                csvData = line.split(cvsSplitBy);

	                

	            }

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			return (csvData[4] + csvData[5]);

	    }

	}