package Model;




public class BaseDonne {
 
    private int ID;
    private String Language;
    private String BookTitle;
    private String Subtitle;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Description;
    private Boolean PublishingRights = true;
    private String[] Keywords;
    private String[] Categories;
    private Boolean LargePrint = false;
    private Boolean AdultContent = false;
    private String BookContent;
    private String BookCover;
    private Boolean Barcode = false;
    private float Price;
    private String BleedStings;
    private Boolean printISBN = true;
    private String ISBN;
    private String imprint;
    private String InkPaper;
    private String Coverfinish;
    private String Marketplace;
    private String Date;

    private String username;
    private String password;
    private String serialCode;
    private String lastNameU;
    private String firstNameU;
    private String Birthday;
    private String Email;

    public BaseDonne(){};
    public BaseDonne(int iD, String imprint, String iSBN, Boolean printISBN, String language, String bookTitle, String subtitle, String firstName, String middleName, String lastName, String description, Boolean publishingRights, String[] Keywords, String[] categories, Boolean largePrint, Boolean adultContent, String bookContent, String bookCover, Boolean barcode, float price, String bleedStings, String inkPaper, String coverfinish, String marketplace, String date, String username, String password, String serialCode, String lastNameU, String firstNameU, String birthday, String email){
        this.ID = iD;
        this.imprint = imprint;
        this.ISBN = iSBN;
        this.printISBN = printISBN;
        this.Language = language;
        this.BookTitle = bookTitle;
        this.Subtitle = subtitle;
        this.FirstName = firstName;
        this.MiddleName = middleName;
        this.LastName = lastName;
        this.Description = description;
        this.PublishingRights = publishingRights;
        this.Keywords = Keywords;
        this.Categories = categories;
        this.LargePrint = largePrint;
        this.AdultContent = adultContent;
        this.BookContent = bookContent;
        this.BookCover = bookCover;
        this.Barcode = barcode;
        this.Price = price;
        this.BleedStings = bleedStings;
        this.InkPaper = inkPaper;
        this.Coverfinish = coverfinish;
        this.Marketplace = marketplace;
        this.Date = date;

        this.username = username;
        this.password = password;
        this.serialCode = serialCode;
        this.lastNameU = lastNameU;
        this.firstNameU = firstNameU;
        this.Birthday = birthday;
        this.Email = email;

    }

    public static BaseDonneBuilder builder(){
        return new BaseDonneBuilder();
    }

    
    public String getDate() {
        return Date;
    }

    public String getImprint() {
        return imprint;
    }

    public int getID() {
        return ID;
    }

    public String getISBN() {
        return ISBN;
    }
    
    public int getPrintISBN() {
        if(printISBN == true){
            return 1;
        }else{
            return 0;
        }
    }

    public String getLanguage() {
        return Language;
    }

    public String getBookTitle() {
        return BookTitle;
    }
    
    public String getSubtitle() {
        return Subtitle;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getDescription() {
        return Description;
    }

    public int getPublishingRights() {
        if (PublishingRights == true) {
            return 1;
        }else{
            return 0;
        }
    }

    public String[] getKeywords() {
        return Keywords;
    }

    public String[] getCategories() {
        return Categories;
    }
    
    public int getLargePrint() {
        if(LargePrint == true){
            return 1;
        }else{
            return 0;
        }
    }

    public int getAdultContent() {
        if(AdultContent == true){
            return 1;
        }else{
            return 0;
        }
    }

    public String getBookContent() {
        return BookContent;
    }

    public String getBookCover() {
        return BookCover;
    }

    public int getBarcode() {
        if(Barcode == true){
            return 1;
        }else{
            return 0;
        }
    }

    public float getPrice() {
        return Price;
    }

    public String getBleedStings() {
        return BleedStings;
    }

    public String getInkPaper() {
        return InkPaper;
    }

    public String getCoverfinish() {
        return Coverfinish;
    }

    public String getMarketplace() {
        return Marketplace;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSerialCode() {
        return serialCode;
    }

    public String getLastNameU() {
        return lastNameU;
    }

    public String getFirstNameU() {
        return firstNameU;
    }

    public String getEmail() {
        return Email;
    }

    public String getBirthday() {
        return Birthday;
    }

}

