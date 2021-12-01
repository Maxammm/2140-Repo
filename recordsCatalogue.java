import java.util.ArrayList;

public class recordsCatalogue {
    // this class keeps all the records currently in the system
    public ArrayList<testRecord> records = new ArrayList<testRecord>();

    public recordsCatalogue()
    {

    }

    // showing all the items in the array list
    public String [] getItemList(){
		int i=0;
		String [] yourItem= new String [records.size()];
		for (testRecord a : records){
			testRecord geta = a;
			yourItem[i]= geta.toString();
            System.out.println(geta);
			i++;
		} 
		return yourItem;
	}
}
