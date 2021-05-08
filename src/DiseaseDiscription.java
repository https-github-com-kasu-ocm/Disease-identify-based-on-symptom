import java.util.HashMap;
import java.util.Map;

public class DiseaseDiscription {

	public static String discription (String nameOfDisease)
	{
		String d="";
	HashMap<String, String> discribe=new HashMap<String, String>();
	discribe.put("Fungal infection", "Some fungi reproduce through tiny spores in the air. \nYou can inhale the spores or they can land on you. \nAs a result, fungal infections often start in the lungs or on the skin.\n You are more likely to get a fungal infection if you have a \nweakened immune system or take antibiotics.");
	discribe.put("Drug Reaction","A drug allergy is an allergic reaction \nto a medication. With an allergic reaction, \nyour immune system, which fights \ninfection and disease, reacts to the drug. \nThis reaction can cause symptoms such as rash, fever, and trouble breathing. \nTrue drug allergy is not common.");
	discribe.put("Jaundice"," Jaundice \nis a condition in which the skin,\n whites of the eyes and mucous membranes \nturn yellow because of a high level of bilirubin, \na yellow-orange bile pigment. \nJaundice has many causes, \nincluding hepatitis, gallstones and tumors. \nIn adults, jaundice usually doesn't need to be treated.");
	
	for (Map.Entry<String,String> entry : discribe.entrySet())
	 {
		 if(nameOfDisease.equalsIgnoreCase(entry.getKey().toString())) {
			 d=entry.getValue();
			 break;
		 }
	 }
        // System.out.println("Key = " + entry.getKey() +", Value = " + entry.getValue());
		return d;
	}	
}

