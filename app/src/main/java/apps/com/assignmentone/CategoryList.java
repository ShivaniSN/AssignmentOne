package apps.com.assignmentone;

public class CategoryList {

    String stringCategoryName,stringProduct1,stringProduct2,stringProduct3,stringProduct4,stringProduct5;

    public CategoryList(){
        this.stringCategoryName = "";
    }

    public CategoryList(String stringCategoryName,String stringProduct1,String stringProduct2,String stringProduct3,
                        String stringProduct4,String stringProduct5){
        this.stringCategoryName = stringCategoryName;
        this.stringProduct1 = stringProduct1;
        this.stringProduct2 = stringProduct2;
        this.stringProduct3 = stringProduct3;
        this.stringProduct4 = stringProduct4;
        this.stringProduct5 = stringProduct5;
    }

    public CategoryList(String stringCategoryName){
        this.stringCategoryName = stringCategoryName;
    }

    public void setStringCategoryName(String stringCategoryName) {
        this.stringCategoryName = stringCategoryName;
    }

    public String getStringCategoryName() {
        return stringCategoryName;
    }

    public void setStringProduct1(String stringProduct1) {
        this.stringProduct1 = stringProduct1;
    }

    public String getStringProduct1() {
        return stringProduct1;
    }

    public void setStringProduct2(String stringProduct2) {
        this.stringProduct2 = stringProduct2;
    }

    public String getStringProduct2() {
        return stringProduct2;
    }

    public void setStringProduct3(String stringProduct3) {
        this.stringProduct3 = stringProduct3;
    }

    public String getStringProduct3() {
        return stringProduct3;
    }

    public void setStringProduct4(String stringProduct4) {
        this.stringProduct4 = stringProduct4;
    }

    public String getStringProduct4() {
        return stringProduct4;
    }

    public void setStringProduct5(String stringProduct5) {
        this.stringProduct5 = stringProduct5;
    }

    public String getStringProduct5() {
        return stringProduct5;
    }
}
