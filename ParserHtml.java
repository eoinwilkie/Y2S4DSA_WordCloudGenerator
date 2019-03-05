import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ParserHtml implements Parser{
    public void parse(String webIn, Map<String, Integer> frequencyTable){
		final String [] tagsTab = {"!doctype","a","abbr","acronym","address","applet","area","article","aside","audio","b","base","basefont","bdi","bdo","bgsound","big","blink","blockquote","body","br","button","canvas","caption","center","cite","code","col","colgroup","content","data","datalist","dd","decorator","del","details","dfn","dir","div","dl","dt","element","em","embed","fieldset","figcaption","figure","font","footer","form","frame","frameset","h1","h2","h3","h4","h5","h6","head","header","hgroup","hr","html","i","iframe","img","input","ins","isindex","kbd","keygen","label","legend","li","link","listing","main","map","mark","marquee","menu","menuitem","meta","meter","nav","nobr","noframes","noscript","object","ol","optgroup","option","output","p","param","plaintext","pre","progress","q","rp","rt","ruby","s","samp","script","section","select","shadow","small","source","spacer","span","strike","strong","style","sub","summary","sup","table","tbody","td","template","textarea","tfoot","th","thead","time","title","tr","track","tt","u","ul","var","video","wbr","xmp"};
		StringBuilder tags = new StringBuilder();
		BufferedReader br;
		String ignoreWords = new IgnoreWords("ignorewords.txt").getIgnoreWords();
        String[] words;
		String line;

		for (int i=0;i<tagsTab.length;i++) {
			tags.append(tagsTab[i].toLowerCase()).append('|').append(tagsTab[i].toUpperCase());
			if (i<tagsTab.length-1) {
				tags.append('|');
			}
		}
        String pattern = "[\\p{Punct}\\s]+";
		//String pattern = "</?("+tags.toString()+"){1}.*?/?>";

		try {
			System.out.println("Reading a webpage.");
			java.net.URL url = new java.net.URL(webIn);
			br = new BufferedReader(new InputStreamReader(url.openStream()));

			while ((line = br.readLine()) != null) {
				line = line.toLowerCase().replaceAll("\\<.*?>","");
				//System.out.println(line);
				line.replaceAll(pattern, "");
				words = line.toLowerCase().split(pattern);

				// add to Map
				for (int i = 0; i < words.length; i++) {
					if(ignoreWords != null) {
						if(ignoreWords.contains(words[i])){
							break;
						}
					}

					if (!frequencyTable.containsKey(words[i])) {
						frequencyTable.put(words[i], 1);
					} else {
						frequencyTable.put(words[i], frequencyTable.get(words[i]) + 1);
					}
				}

			}
			br.close();
		} catch (java.net.MalformedURLException e) {
			System.out.printf("Malformed URL: %s%n", e.getMessage());
		} catch (IOException e) {
			System.out.printf("I/O Error: %s%n", e.getMessage());
		}
	}// readFile()
}