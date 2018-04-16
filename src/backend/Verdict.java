package backend;

import java.io.BufferedReader;
//import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

import org.json.*;

public class Verdict {
	enum VERDICT {FAILED, OK, PARTIAL, COMPILATION_ERROR, RUNTIME_ERROR, WRONG_ANSWER, PRESENTATION_ERROR, TIME_LIMIT_EXCEEDED, MEMORY_LIMIT_EXCEEDED, IDLENESS_LIMIT_EXCEEDED, SECURITY_VIOLATED, CRASHED, INPUT_PREPARATION_CRASHED, CHALLENGED, SKIPPED, TESTING, REJECTED}

	Map<String,Integer> map=new HashMap<String,Integer>();
	public void verdict(String handle) {
		try {
			call_me(handle);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void call_me(String handle) throws Exception {
		// Get api from codeforces: 
		// String url = "http://codeforces.com/api/user.status?handle=Fefer_Ivan&from=1&count=10";
		// String url = "http://codeforces.com/api/user.status?handle=tourist";
		// String url = "http://codeforces.com/api/user.status?handle="+handle;
		String url = "http://codeforces.com/api/user.status?handle="+handle+"&from=1&count=100";

		// Send Http request:
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();



		JSONObject obj1 = new JSONObject(response.toString());

		//System.out.println(obj1.getJSONArray("result").getJSONObject(0).getInt("id")+"\n");
		JSONArray arr = obj1.getJSONArray("result");


		for (int i = 0; i < arr.length(); i++)
		{
			String ver = arr.getJSONObject(i).getString("verdict");

			if (map.containsKey(ver)) {
				map.put(ver, map.get(ver) + 1);
			} else {
				map.put(ver, 1);
			}

		}
		System.out.print("\t" + map);

	}
	public Map<String,Integer> getMap() {
		/*map.put("OK", 5);
	    map.put("TLE", 6);
		map.put("WA", 12);
		map.put("PE", 3);
		map.put("RE", 7);*/


		return map;
	}
}

