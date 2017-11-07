package rollback;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;


public class rollbackEx {

	/**
	 * @param args
	 * @throws IOException 
	 */
	  public static final String ACCOUNT_SID = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
	  public static final String AUTH_TOKEN = "your_auth_token";
		public static File folder = new File("D:/Final Scripts/Final Scripts/04_Misc");
		public static String insertStatement[]={"INSERT","Insert"};
		static String temp = "";
		

		
			
			public static void main(String[] args) throws IOException {
				
				System.out.println("Reading files under the folder "+ folder.getAbsolutePath());
				String fileContent = null;
				fileContent = listFilesForFolder(folder);
				//System.out.println("*********************");
				//System.out.println(fileContent);
				fileContent =  fileContent.replace("\n", "").replace("\r", "");
				//System.out.println("*********************--------");
				//System.out.println(fileContent);
				String [] a = fileContent.split(";");
				String[] ids = new String[a.length];
				Matcher matcher = null;
				Pattern pattern = Pattern.compile("[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}");
				for(int i=0; i<a.length;i++){
					String curStatement = a[i];
					if(curStatement.toLowerCase().startsWith("insert")){
						//System.out.println(a[i]);
						matcher = pattern.matcher(curStatement);
						if (matcher.find()) {
							ids[i] = matcher.group();
								System.out.println("delete from " + StringUtils.substringBetween(a[i], "into", "(") + "where id = '"+ids[i]+"'"+";");
								//System.out.println("delete from +" );
							}
						
					}
				}
				System.out.println("Done");
				
				/*String typeofStatemnt = null;
				typeofStatemnt = checkTypeofQuery(fileContent);*/
				
		
 
		  // Find your Account Sid and Token at twilio.com/user/account
		

		    /*Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		    Message message = Message.creator(new PhoneNumber("+918796712113"),
		        new PhoneNumber("+918849597091"), 
		        "This is the ship that made the Kessel Run in fourteen parsecs?").create();

		    System.out.println(message.getSid());*/
		/*try {
			
			ProvAppEventReq provAppEventReq = new ProvAppEventReq();
			provAppEventReq.setAction("");
			JAXBContext jaxbContext = JAXBContext.newInstance(ProvAppEventReq.class);
			
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty("jaxb.encoding", "Unicode");
			
			String text = null;
			File file = new File(
					"C://Users//pratikkh//Desktop//testPortalRequest.xml");
			try {
					text= FileUtils.readFileToString(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter stringWriter = new StringWriter();
			jaxbMarshaller.marshal(provAppEventReq, stringWriter);
			String xml = stringWriter.toString();
			System.out.println(xml);
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	*/
		/*Map <String,String> m = new HashMap<String,String>();
		m.put("3","");
		m.put("3", "test");
		m.put("2","3");
		for(Entry<String, String> entry: m.entrySet()){
			System.out.println("key:" + entry.getKey() + " : value : " + entry.getValue());
			System.out.println(entry.hashCode());
			
		}*/
		
		
	}

			public static String listFilesForFolder(final File folder) throws IOException {
				String content = "";
				File[] listOfFiles = folder.listFiles();

				for (int i = 0; i < listOfFiles.length; i++) {
				  File file = listOfFiles[i];
				  if (file.isFile() && file.getName().endsWith(".sql")) {
				    content = content.concat(FileUtils.readFileToString(file));
				  } 
				}
				//System.out.println("Content of file : "+content);
				return content;
			}
			
			public static String checkTypeofQuery(String fileContent) {
				String typeofStatemnt =null;
				for(int i =0 ;i<insertStatement.length;i++){
					fileContent.startsWith(insertStatement[i]);
					typeofStatemnt = "I";
					}
				return typeofStatemnt;
					
			}
			
		public static String insertRollback(String fileContent) {
				
				String typeofStatemnt =null;
				int i =0;
				/*for(int i =0 ;i<insertStatement.length;i++){
					fileContent.startsWith(insertStatement[i]);
					
				}*/
				/*while(fileContent.length()){
					
				}*/
				while(fileContent.contains("Insert into")){
					int startPoint = fileContent.indexOf("Insert into");
					int endPoint =  fileContent.indexOf(");");
					String lineData = fileContent.substring(startPoint, endPoint);
					System.out.println(" lineData :"+lineData);
					//lineData.con
				}
				
				/*String m ="Insert\\w*;";
				 Pattern ptn = Pattern.compile("Insert\\w*;");
			        Matcher mtch = ptn.matcher(fileContent);
			        System.out.println(mtch);
			        if(mtch.find()){
			            
			        }*/
				return typeofStatemnt;
				
			}

		
	}
