package json.parser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class CnnAPI {
    /*
      You can get API_KEY from this below link. Once you have the API_KEY, you can fetch the top-headlines news.
      https://newsapi.org/s/cnn-api

      Fetch This following CNN API, It will return some news in Json data. Parse this data and construct
      https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=YOUR_API_KEY

      MY_API_KEY=0d9e35dfa3c140aab8bf9cdd70df957f

      After getting Json Format of the news, You can go to json validator link: https://jsonlint.com/ to see
      how it can be parsed.

      "articles": [{
		"source": {
			"id": "cnn",
			"name": "CNN"
		},
		"author": null,
		"title": "Who is affected by a shutdown? - CNN Video",
		"description": "CNN's Tom Foreman breaks down who is affected by a federal government partial shutdown.",
		"url": "http://us.cnn.com/videos/politics/2018/12/22/federal-partial-shutdown-by-the-numbers-foreman-ctn-vpx.cnn",
		"urlToImage": "https://cdn.cnn.com/cnnnext/dam/assets/181202171029-government-shutdown-capitol-file-super-tease.jpg",
		"publishedAt": "2018-12-23T01:09:50.8583193Z",
		"content": "Chat with us in Facebook Messenger. Find out what's happening in the world as it unfolds."
	   },{}]

	   Read the articles array and construct Headline news as source, author, title,description,url,urlToImage,publishedAt
	   and content. You need to design News Data Model and construct headline news.
	   You can store in Map and then into ArrayList as your choice of Data Structure.

	   You can follow How we implemented in Employee and JsonReaderUtil task.

	   Show output of all the headline news in to console.
	   Store into choice of your database and retrieve.

     */





    /*
      ToDo:API is given, This Rest API will give you a Json Array. It is parsed partially. Your task is to give the following output.

      output:

     "mrahman@gmail.com" "Matiur Rahman" "400k" "Finance"
     "mrahman@gmail.com" "Rohan Rahman" "100k" "Engineering"
     "kafil@gmail.com" "Kafil" "200k" "Backend End Team"
     "Dave@gmail.com" "David Lenard" "140k" "Engineering"
     "rivera@gmail.com" "Rivera Dupp" "150k" "Finance"
     "Anand@gmail.com" "Anand Thakkar" "120k" "SDET"
     "sumay@gmail.com" "Sumaya Akbar" "200k" "Finance"
     "mrahman@gmail.com" "Mizanur Rahman" "400k" "Finance"
     "mrahman2@gmail.com" "Mizanur Rahman" "405k" "Finance"
     "mdtaque@gmail.com" "rifat taque" "400k" "QA"
     "mdtaque@gmail.com" "rifat taque" "400k" "QA"

     */

        public static void main(String[] args)throws MalformedURLException, IOException {
            String sURL = "http://info.venturepulse.org:8080/service-webapp/api/AllEmployeeResources";
            Employee emp = null;
            List<Employee> empList = new ArrayList<>();
            URL url = new URL(sURL);
            URLConnection request = url.openConnection();
            request.connect();
            JsonArray jsonArray = null;
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            if (root instanceof JsonObject) {
                JsonObject rootObj = root.getAsJsonObject();
            } else if (root instanceof JsonArray) {
                jsonArray =  root.getAsJsonArray();
            }
            for (int i = 0; i < jsonArray.size()-1; i++) {
                try {
                    JsonObject jsonobject = jsonArray.get(i).getAsJsonObject();
                    //you code start here
                    String empEmail = jsonobject.get("empEmail").toString();
                    System.out.println(empEmail);
                    String empName = jsonobject.get("empName").toString();
                    System.out.println(empName);

                }catch(Exception ex){

                }
            }
            //Print to the console.
            for(Employee entry:empList){
                System.out.println(entry.getEmpEmail()+" "+entry.getEmpName()+" "+entry.getSalary()+" "+entry.getDepartment());
            }
        }

    }


