import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DiseaseAnalysis {
	  public static void main(String[] args) {
	      int val[]={0,1};
	       String n=DiseaseAnalysis.sympptomAnalyze(val);   
	       System.out.println(n);
	     }
	public static String sympptomAnalyze(int[] input) {
        HashMap<String, ArrayList<String>> sympwithdise = new HashMap<>();//contain for each disease symptom pair
        try {
            //FileInputStream file = new FileInputStream(new File("C:\\Users\\Public\\eclipse\\sdk\\Disease identify based on symptom\\File\\Testing.xlsx"));
        	  FileInputStream file = new FileInputStream(new File("C:\\Users\\SE\\Desktop\\Atn\\Testing.xlsx"));

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            String n = "itching	skin_rash	nodal_skin_eruptions	continuous_sneezing	shivering	chills	joint_pain	stomach_pain	acidity	ulcers_on_tongue	muscle_wasting	vomiting	burning_micturition	spotting_ urination	fatigue	weight_gain	anxiety	cold_hands_and_feets	mood_swings	weight_loss	restlessness	lethargy	patches_in_throat	irregular_sugar_level	cough	high_fever	sunken_eyes	breathlessness	sweating	dehydration	indigestion	headache	yellowish_skin	dark_urine	nausea	loss_of_appetite	pain_behind_the_eyes	back_pain	constipation	abdominal_pain	diarrhoea	mild_fever	yellow_urine	yellowing_of_eyes	acute_liver_failure	fluid_overload	swelling_of_stomach	swelled_lymph_nodes	malaise	blurred_and_distorted_vision	phlegm	throat_irritation	redness_of_eyes	sinus_pressure	runny_nose	congestion	chest_pain	weakness_in_limbs	fast_heart_rate	pain_during_bowel_movements	pain_in_anal_region	bloody_stool	irritation_in_anus	neck_pain	dizziness	cramps	bruising	obesity	swollen_legs	swollen_blood_vessels	puffy_face_and_eyes	enlarged_thyroid	brittle_nails	swollen_extremeties	excessive_hunger	extra_marital_contacts	drying_and_tingling_lips	slurred_speech	knee_pain	hip_joint_pain	muscle_weakness	stiff_neck	swelling_joints	movement_stiffness	spinning_movements	loss_of_balance	unsteadiness	weakness_of_one_body_side	loss_of_smell	bladder_discomfort	foul_smell_of urine	continuous_feel_of_urine	passage_of_gases	internal_itching	toxic_look_(typhos)	depression	irritability	muscle_pain	altered_sensorium	red_spots_over_body	belly_pain	abnormal_menstruation	dischromic _patches	watering_from_eyes	increased_appetite	polyuria	family_history	mucoid_sputum	rusty_sputum	lack_of_concentration	visual_disturbances	receiving_blood_transfusion	receiving_unsterile_injections	coma	stomach_bleeding	distention_of_abdomen	history_of_alcohol_consumption	fluid_overload	blood_in_sputum	prominent_veins_on_calf	palpitations	painful_walking	pus_filled_pimples	blackheads	scurring	skin_peeling	silver_like_dusting	small_dents_in_nails	inflammatory_nails	blister	red_sore_around_nose	yellow_crust_ooze	prognosis	";
            ArrayList<Integer> symptomNum = new ArrayList<Integer>();//symptom name to number 

            ArrayList<String> disease, map;//Symprom enteredby user 
            ArrayList<Integer> symptomInput = new ArrayList<>();//Symprom enteredby user 

            for (int j = 0; j < input.length; j++) {
                symptomInput.add(input[j]);
            }

            boolean have = false;
            Row row;
            int count = 0, k = 0;

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            row = rowIterator.next();//first row symptom name
            while (rowIterator.hasNext()) {
                have = false;
                //This is first of the row to be read
                row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                disease = new ArrayList<>();//for all disease from row
                map = new ArrayList<>();//after disease is specified store on hash map
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_NUMERIC:
                            //System.out.print(" wich case l  "+cell.getNumericCellValue() + "\t");
                            disease.add("" + cell.getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            //System.out.print(" wich case 233232  "+cell.getStringCellValue() + "\t");
                            disease.add("" + cell.getStringCellValue());
                            break;
                    }

                }
                System.out.println(disease);
                System.out.println(Collections.frequency(disease, "1.0"));
                for (int i = 0; i < symptomInput.size(); i++) {
                    count = symptomInput.get(i);
                    if (disease.get(count).contains("1.0")) {
                        have = true;
                      //  System.out.println(i + " index= " + disease.get(symptomInput.get(i)).contains("1.0"));
                        map.add("" + count);
                    }
                }
                if (have == true) {
                    System.out.println(map);
                    sympwithdise.put(disease.get(132), map);
                }
                k++;
                if (k == 41) {
                    break;
                }
            }
            System.out.println(sympwithdise);

            file.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        double max = 0, predicted = 0;
        String disease = "No disease";
        int fsamedisease = sympwithdise.size(), totalsymptomofparticular, totalsym = input.length;
 ArrayList<String> value;
 String key ;
 int length=sympwithdise.size();
     for (Map.Entry<String, ArrayList<String>> entry : sympwithdise.entrySet()) {
     key = entry.getKey();
   value = entry.getValue();
    max = value.size()/input.length;
   if(max>predicted)
   {
      
       predicted=max;
       disease=key;
   }
   
}
        
        
       
        if (disease.equals("No disease")) {
            return "You May not Affected By Disease \n Thank you for using this system."+predicted
                    + "";
        } else {
            return "You May Affected By Disease \n"
                    + "\n\t\t\t\t" + disease + "\n\n please take care for this disease!\n resent health station for more treatment.\n"+predicted+"\n\n"+DiseaseDiscription.discription(disease);
        }
    }
}
