package Datenmanagement_Aufgabe5.Datenmanagement_Aufgabe5;
import java.util.Map;
import java.util.Scanner;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.CollectionEntity;
import com.arangodb.util.MapBuilder;
import com.arangodb.velocypack.VPackSlice;

/*Beispiele für gülte querys:
 * CREATE Professoren 'Fachbereich' 'Name'
 * CREATE Studenten 'adresse' 'geschlecht' 'nachname' 'vorname' (für andere Collections siehe parameter
 * in der CollectionCreator klasse)
 * 
 * DELETE_FROM Studenten _key
 * 
 * */


public class FirstProject {
	final static ArangoDB arangoDB = new ArangoDB.Builder().user("root").host("node1.arangodb.rocks", 8529).build();
	public static void main(final String[] args) {
		Scanner in = new Scanner(System.in);
		String query = "";
		while(true){
			System.out.println("Hallo, gib deine Query ein.");
			query = in.nextLine();
			queryReader(query);		
		}
	}

	/*erstellt Dokument auf der StudentenDB datenbank unter dem angegeben Collection-Namen*/
	public static void createDocument(BaseDocument bd,String collectionName){
		final BaseDocument myObject = bd;
		try {
			arangoDB.db("StudentenDB").collection(collectionName).insertDocument(myObject);
			System.out.println("Document created");
		} catch (final ArangoDBException e) {
			System.err.println("Failed to create document. " + e.getMessage());
			}
		
	}
	
	/*löscht Dokument unter angegebenen _key 
	* auf der StudentenDB datenbank unter dem angegebenen Collection-Namen*/
	private static void deleteDocument(String collectionName, String _key){
		try {
			  arangoDB.db("StudentenDB").collection(collectionName).deleteDocument(_key);
			  System.out.println("Document deleted.");
			} catch (ArangoDBException e) {
			  System.err.println("Failed to delete document. " + e.getMessage());
			}
		
	}
	
	/*liest query ein und führt diesen aus*/
	private static void queryReader(String query){
		String[]queryParams=query.split(" ");
		
		switch(queryParams[0]){
		case "CREATE":
			createQueryReader(query);
			break;
		case "DELETE_FROM":
			deleteQueryReader(query);
			break;
		}
	}
	
	/*hilfsfunktion von queryReader, verarbeitet create querys*/
	private static void createQueryReader(String query){
		String[]queryParams=query.split(" ");
		BaseDocument b = null;
		switch(queryParams[1]){
		case"Adresse":
			b = CollectionCreator.createAdresse
			(Integer.valueOf(queryParams[2]), queryParams[3],queryParams[3] ,queryParams[4]);
			break;
		case"Besucht":
			b = CollectionCreator.createBesucht(queryParams[2], queryParams[3]);
			break;
		case"Haelt":
			b = CollectionCreator.createKnows(queryParams[2], queryParams[3]);
			break;
		case"Knows":
			b = CollectionCreator.createKnows(queryParams[2], queryParams[3]);
			break;
		case"Professoren":
			b = CollectionCreator.createProfessoren(queryParams[2], queryParams[3]);
			break;
		case"Studenten":
			b = CollectionCreator.
			createStudenten(queryParams[2], queryParams[3], queryParams[4], queryParams[5]);
			break;
		case"Vorlesung":
			b = CollectionCreator.createVorlesung(queryParams[2], queryParams[3]);
			break;
		case"Person":
			b = CollectionCreator.createVorlesung(queryParams[2], queryParams[3]);
		}
		createDocument(b,queryParams[1]);	
	}
	
	/*hilfsfunktion von queryReader, verarbeitet delete querys*/
	private static void deleteQueryReader(String query){
		String[]queryParams=query.split(" ");
		deleteDocument(queryParams[1],queryParams[2]);
	}
	

	
}