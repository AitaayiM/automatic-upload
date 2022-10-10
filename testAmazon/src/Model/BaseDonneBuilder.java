package Model;


public class BaseDonneBuilder {

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
    private static String[] Categories;
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

    public BaseDonneBuilder iD(int iD) {
        this.ID = iD;
        return this;
    }

    public BaseDonneBuilder imprint(String imprint) {
        this.imprint = imprint;
        return this;
    }

    public BaseDonneBuilder iSBN(String iSBN) {
        this.ISBN = iSBN;
        return this;
    }

    public BaseDonneBuilder printISBN(Boolean printISBN) {
        this.printISBN = printISBN;
        return this;
    }

    public BaseDonneBuilder language(String language) {
        this.Language = language;
        return this;
    }

    public BaseDonneBuilder bookTitle(String bookTitle) {
        this.BookTitle = bookTitle;
        return this;
    }
    
    public BaseDonneBuilder subtitle(String subtitle) {
        this.Subtitle = subtitle;
        return this;
    }

    public BaseDonneBuilder firstName(String firstName) {
        this.FirstName = firstName;
        return this;
    }

    public BaseDonneBuilder middleName(String middleName) {
        this.MiddleName = middleName;
        return this;
    }

    public BaseDonneBuilder lastName(String lastName) {
        this.LastName = lastName;
        return this;
    }

    public BaseDonneBuilder description(String description) {
        this.Description = description;
        return this;
    }

    public BaseDonneBuilder publishingRights(Boolean publishingRights) {
        this.PublishingRights = publishingRights;
        return this;
    }

    public BaseDonneBuilder keywords(String[] Keywords) {
        this.Keywords = Keywords;
        return this;
    }

    public BaseDonneBuilder categories(String[] categories) {
        Categories = categories;
        return this;
    }
    
    public BaseDonneBuilder largePrint(Boolean largePrint) {
        this.LargePrint = largePrint;
        return this;
    }

    public BaseDonneBuilder adultContent(Boolean adultContent) {
        this.AdultContent = adultContent;
        return this;
    }

    public BaseDonneBuilder bookContent(String bookContent) {
        this.BookContent = bookContent;
        return this;
    }
    public BaseDonneBuilder bookCover(String bookCover) {
        this.BookCover = bookCover;
        return this;
    }

    public BaseDonneBuilder barcode(Boolean barcode) {
        this.Barcode = barcode;
        return this;
    }

    public BaseDonneBuilder price(float price) {
        this.Price = price;
        return this;
    }

    public BaseDonneBuilder bleedStings(String bleedStings) {
        this.BleedStings = bleedStings;
        return this;
    }

    public BaseDonneBuilder inkPaper(String inkPaper) {
        this.InkPaper = inkPaper;
        return this;
    }

    public BaseDonneBuilder coverfinish(String coverfinish) {
        this.Coverfinish = coverfinish;
        return this;
    }

    public BaseDonneBuilder marketplace(String marketplace) {
        this.Marketplace = marketplace;
        return this;
    }

    public BaseDonneBuilder date(String date){
        this.Date = date;
        return this;
    }

    public BaseDonneBuilder username(String username){
        this.username = username;
        return this;
    }

    public BaseDonneBuilder password(String password){
        this.password = password;
        return this;
    }

    public BaseDonneBuilder serialCode(String serialCode){
        this.serialCode = serialCode;
        return this;
    }

    public BaseDonneBuilder lastNameU(String lastNameU){
        this.lastNameU = lastNameU;
        return this;
    }

    public BaseDonneBuilder firstNameU(String firstNameU){
        this.firstNameU = firstNameU;
        return this;
    }

    public BaseDonneBuilder Birthday(String Birthday){
        this.Birthday = Birthday;
        return this;
    }

    public BaseDonneBuilder Email(String Email){
        this.Email = Email;
        return this;
    }

    public BaseDonne build(){
        return new BaseDonne(ID, imprint, ISBN, printISBN, Language, BookTitle, Subtitle, FirstName, MiddleName, LastName, Description, PublishingRights, Keywords, Categories, LargePrint, AdultContent, BookContent, BookCover, Barcode, Price, BleedStings, InkPaper, Coverfinish, Marketplace, Date, username, password, serialCode, lastNameU, firstNameU, Birthday, Email);
    }
}
