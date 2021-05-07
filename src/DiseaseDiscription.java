import java.util.HashMap;
import java.util.Map;

public class DiseaseDiscription {

	public static String discription (String nameOfDisease)
	{
		String d="";
	HashMap<String, String> discribe=new HashMap<String, String>();
	discribe.put("Fungal infection", "Some fungi reproduce through tiny spores in the air. \nYou can inhale the spores or they can land on you. \nAs a result, fungal infections often start in the lungs or on the skin.\n You are more likely to get a fungal infection if you have a \nweakened immune system or take antibiotics.");
	 
	
	
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

