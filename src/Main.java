import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * A command line tool that can be used to query GoEuro's position API.
 * Usage: java -jar GoEuroTest.jar <QUERYSTRING>
 */


public class Main {

    /**
     * Private constants
     */
    //Change this constant to the file path for the folder in which the location output files should be saved.
    private static String OUTPUT_FILE_DIRECTORY = ".";

    /**
     * This method, given a query string, appends it to the end of the GoEuro API call, parses the returned JSON
     * string into a list of Location objects, and returns this list.
     * @param query the string with which to query the GoEuro service
     * @return a list of Location objects with all JSON information stored within
     */
    private static List<Location> fetchJSONFromGoEuro(String query) {
        List<Location> locationList = new ArrayList();
        try {
            URL url = new URL("http://api.goeuro.com/api/v2/position/suggest/en/" + query);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            while ((line = reader.readLine()) != null) {
                Gson gson = new GsonBuilder().create();
                Location[] locations = gson.fromJson(line, Location[].class);
                for (int i = 0; i < locations.length; i++) {
                    locationList.add(locations[i]);
                }
            }
            reader.close();

        }
        catch (MalformedURLException e) {
            System.out.println("URL was malformed. Please try again.");
        }
        catch (IOException e) {
            System.out.println("Please enter a string with no slashes or periods for your query.");
            System.exit(1);
        }

        return locationList;
    }

    /**
     * Creates a CSV file from a list of location objects at the file location specified by the fileName parameter.
     * @param locationList a List containing Location objects
     * @param fileName a String used to define the final location of the produced CSV file.
     */
    private static void createCSVFile (List<Location> locationList, String fileName) {
        PrintWriter writer;

        try {
            //Create the file in which to store the location object information
            writer = new PrintWriter(fileName, "UTF-8");
            //Create headers for file
            writer.append("_type,_id,name,type,latitude,longitude\n");
            for (Location location : locationList) {
                writer.append(location.get_type() + "," + location.get_id() + "," + location.getName() + "," + location.getType() + "," + location.getGeo_position().getLatitude() + "," + location.getGeo_position().getLongitude() + "\n");
            }
            writer.close();
        }
        catch (FileNotFoundException fe) {
            fe.printStackTrace();
        }
        catch (UnsupportedEncodingException ue) {
            ue.printStackTrace();
        }
    }

    /**
     * Main class, accepts user input for the GoEuro query parameter and generates a file containing response data.
     * @param args
     */
    public static void main(String[] args) {

        //Check to ensure the number of arguments is correct.
        if (args.length != 1) {
            System.out.println("Usage: java -jar GoEuroTest.jar <QUERYSTRING>");
        }
        else {
            String query = args[0];

            List<Location> locationList = fetchJSONFromGoEuro(query);

            //Generate filename, removing characters from query that could be interpreted as directory signal in filename.
            String vettedQuery = query.replace("/", "U2F").replace(".", "U2E");
            String outputFileName = OUTPUT_FILE_DIRECTORY + "/locations_" + vettedQuery + ".csv";

            if (locationList.size() == 0) {
                System.out.println("No locations were found using the query string '" + query + "'.\nEnsure your spelling is correct.");
            }
            else {
                if (locationList.size() == 1) {
                    System.out.println(locationList.size() + " location was found using the query string '" + query + "'.");
                }
                else {
                    System.out.println(locationList.size() + " locations were found using the query string '" + query + "'.");
                }
                createCSVFile(locationList, outputFileName);
                System.out.println("Output CSV file can be found at " + outputFileName);
            }
        }
    }

}


