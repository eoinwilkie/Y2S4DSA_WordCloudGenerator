/*
Author: Eoin Wilkie
Class information:
    This Class provides the console manu for user input. Allows the user to input file/website, wordCloud size and an output name for the word cloud.
    A second menu is provided for test purposes.
*/

public class WCGmenu{
    private String fileIn;
    private int maxWords;
    private String fileOut;

    //===== Setters/Getters[START] =====//
    
    //Big-O running time: O(1): all Setter and Getter fucntions
    public void setFileIn(String fileIn){
        this.fileIn = fileIn;
    }//setFileIn()
    public String getFileIn(){
        return this.fileIn;
    }//getFileIn()
    public void setMaxWords(int maxWords){
        this.maxWords = maxWords;
    }//setMaxWords()
    public int getMaxWords(){
        return this.maxWords;
    }//getMaxWords()
    public void setFileOut(String fileOut){
        this.fileOut = fileOut;
    }//getFileOut()
    public String getFileOut(){
        return this.fileOut;
    }//setFileOut()
    //===== Setters/Getters[END] =====//

    public void displayMenu(){
        java.util.Scanner sc = new java.util.Scanner(System.in);

        //menu
        System.out.println("Command-Line-Menu");
        System.out.print("Enter filename or webpage: ");
        this.setFileIn(sc.nextLine());
        System.out.print("Enter number of words in word cloud: ");
        this.setMaxWords(sc.nextInt());
        sc.nextLine();
        System.out.println("Save file as:(Do not include .png) ");
        this.setFileOut(sc.nextLine());
    }//displayMenu()

    //TESTS
    public void displayTestMenu(){
        java.util.Scanner sc = new java.util.Scanner(System.in);

        //menu
        System.out.println("Command-Line-Menu");
        System.out.println("Enter FILENAME\nexamples: (https://www.independent.ie/news/)(DeBelloGallico.txt)");
        //this.setFileIn("DeBelloGallico.txt");
        this.setFileIn("https://www.independent.ie/news/");
        //this.setFileIn("WarAndPeace-LeoTolstoy.txt");
        //this.setFileIn("PoblachtNaHEireann.txt");
        //this.setFileIn("PoblachtNaHEireann.txt");
        //this.setFileIn("https://www.thejournal.ie/two-arrested-finglas-drugs-samurai-swords-4524379-Mar2019/");
        System.out.println("Enter MAXWORDS");
        this.setMaxWords(200);
        System.out.println("Enter SAVEAS");
        this.setFileOut("WordCloudImg");
    }//displayMenu()
}