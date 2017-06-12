package Datenmanagement_Aufgabe5.Datenmanagement_Aufgabe5;
import com.arangodb.entity.BaseDocument;
public class CollectionCreator {
	
	public static BaseDocument createAdresse(int nummer,String plz,String stadt, String strasse){
		BaseDocument ret = new BaseDocument();
		ret.addAttribute("Nummer", nummer);
		ret.addAttribute("PLZ", plz);
		ret.addAttribute("Stadt", stadt);
		ret.addAttribute("Straße", strasse);
		return ret;
	}
	
	public static BaseDocument createBesucht(String _from,String _to){
		BaseDocument ret = new BaseDocument();
		ret.addAttribute("_from", _from);
		ret.addAttribute("_to", _to);
		return ret;
	}
	
	public static BaseDocument createHaelt(String _from, String _to){
		BaseDocument ret = new BaseDocument();
		ret.addAttribute("_from", _from);
		ret.addAttribute("_to", _to);
		return ret;
	}
	
	public static BaseDocument createKnows(String _from, String _to){
		BaseDocument ret = new BaseDocument();
		ret.addAttribute("_from", _from);
		ret.addAttribute("_to", _to);
		return ret;
	}
	
	public static BaseDocument createProfessoren(String fachbereich, String name){
		BaseDocument ret = new BaseDocument();
		ret.addAttribute("Fachbereich", fachbereich);
		ret.addAttribute("Name", name);
		return ret;
	}
	
	public static BaseDocument createStudenten(String adresse, String geschlecht,
			String nachname, String vorname){
		BaseDocument ret = new BaseDocument();
		ret.addAttribute("Adresse", adresse);
		ret.addAttribute("Geschlecht", geschlecht);
		ret.addAttribute("Nachname", nachname);
		ret.addAttribute("Vorname", vorname);
		return ret;
	}
	
	public static BaseDocument createVorlesung(String fach, String semester){
		BaseDocument ret = new BaseDocument();
		ret.addAttribute("Fach", fach);
		ret.addAttribute("Semester", semester);
		return ret;
	}

}
