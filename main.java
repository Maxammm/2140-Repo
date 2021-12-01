public class main {
    
    public static void main(String args[]){
        testRecord rec = new testRecord("Milk", "Lasco", 87.0, 5);
        testRecord rec2 = new testRecord("Baked Beans", "Lasco", 120.0, 5);
        recordsCatalogue rc = new recordsCatalogue();
        rc.records.add(rec);
        rc.records.add(rec2);
        rec2.setBrand("Grace"); // changes the brand from Lasco to Grace which is reflected in the system
        rc.getItemList();
    }
}
