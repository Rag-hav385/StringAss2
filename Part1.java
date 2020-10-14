import edu.duke.*;
import java.io.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int FindStopCodon(String dna ,int startindex , String endindex){
       startindex = dna.indexOf("ATG");
       if (startindex == -1){
           return -1;
        }
       int currindex = dna.indexOf(endindex ,startindex + 3);
       
       while (currindex != -1){
           if ( (currindex - startindex) % 3 == 0){
               return currindex;
           }
           
           else{
               currindex = dna.indexOf(endindex , currindex + 1);
           }
       }
        
       return -1;
}


public String findGene(String dna , int where){
    int StartIndex = dna.indexOf("ATG" , where);
        if (StartIndex == -1){
            return " ";
        }
    int tagIndex = FindStopCodon( dna , StartIndex , "TAG");
    int taaIndex = FindStopCodon( dna , StartIndex , "TAA");
    int tgaIndex = FindStopCodon( dna , StartIndex , "TGA");
    
    int minindex = 0;
    
    if(taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
        minindex = tgaIndex;
    }
    else{
        minindex = taaIndex;
    }
    
    if(minindex == -1 || (tagIndex != -1 && tagIndex < minindex)){
        minindex = tagIndex;
    }
    
    if (minindex == -1){
        return " ";
    }
    
    return dna.substring(StartIndex , minindex + 3);
    
}
public void findallgenes(String dna){
    int StartIndex = 0;
    
    while (true){
        String Gene = findGene(dna,StartIndex);
        if (Gene == " "){
            break;
        }
        System.out.print(Gene);
        StartIndex = dna.indexOf(Gene , StartIndex) + Gene.length();
    }
    
    
}

 public void TestGeneAlgorithm(){
        String dna1 = "AAATGCCCTAACTAGATTAAGAAACC";
        findallgenes(dna1);
        
      
        
        
        
        String dna2 = "ATTAATGTAGTGTGTGTTAAGT";
        findallgenes(dna2);
        
        
        String dna3 = "ATATGTATGTATGTGTATGGTAGTAAGTETGFERTYHJHGD";
        findallgenes(dna3);
        
        
    }

}
    

