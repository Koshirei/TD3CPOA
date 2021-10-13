package TD3;

import java.util.HashMap;

public class Normalisation {
	
	private HashMap<String,String> trad;
	
	public Normalisation() {
		
	}
	
	
	public String pays(String p) {
		
		trad = new HashMap<String, String>();
		trad.put("letzebuerg","luxembourg");
		trad.put("belgium","belgique");
		trad.put("switzerland","suisse");
		trad.put("schweiz","suisse");
		trad.put("luxembourg","luxembourg");
		trad.put("belgique","belgique");
		trad.put("suisse","suisse");
		
		p = p.toLowerCase();
		p = p.replaceAll(" ","");
		
		return this.trad.get(p);
		
	}
	
	
	public String ville(String v) {
		v = v.trim();
		
		v = v.toLowerCase();
		v = v.substring(0, 1).toUpperCase() + v.substring(1);
		
		/*v = v.replace("lès","-lès-");
		v = v.replace("les","-les-");
		v = v.replace("sous","-sous-");
		v = v.replace("sur","-sur-");
		v = v.replace("à","-à-");
		v = v.replace("aux","-aux-");
		v = v.replace("Saint","Saint-");
		v = v.replace("St","Saint-");
		v = v.replace("Ste","Saint-");
		
		v = v.replace(" ", "");*/
		
		v = v.replace("St","Saint");
		v = v.replace("Ste","Saint");
		
		v = v.replace(" ", "-");
		
		
		
		do {
			v = v.replace("--", "-");
		}while(v.contains("--"));
		
		return v;
	}
	
	public String codepos(String codepos) {
		
		
		String res = "";
		
		for (char c : codepos.toCharArray()) {
			if (Character.isDigit(c)) {
				res = res + c;
			}
		}
		
		int longueur = res.length();
		
		while(longueur<5) {
			res = "0" + res;
			longueur++;
		};	
		
		codepos = res;
		return codepos;
	}
	
	public String voie(String voie) {
		voie = voie.trim();
		String res="";
		
		String[] voiet = voie.split(" ");
		for (String s : voiet) {
			switch ( s ) {
				case "boul" : s = "boulevard"; break;
				case "boul.": s = "boulevard"; break;
				case "bd"   : s = "boulevard"; break;
				case "faub.": s = "faubourg" ; break;
				case "fg"   : s = "faubourg" ; break;
				case "av."   : s = "avenue"   ; break;
				case "pl."  : s = "place"    ; break;
			}
			
			if (s != voiet[0]) {
			res = res + " " + s;
			}
			else {
				res = res + " " + s + ",";
			}
		}
		
		voie = voie.trim();

		voie = res;
		voie = voie.trim();
		
		return voie;
	}
}
