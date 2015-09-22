import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.impl.XmiCasSerializer;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.XMLSerializer;
import org.xml.sax.SAXException;

import type.Question;
import type.Answer;
import type.InputDocument;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CasConsumer extends CasConsumer_ImplBase {
    
  
  /**
   * Name of configuration parameter that must be set to the path of a directory into which the
   * output files will be written.
   */
  public static final String PARAM_OUTPUTDIR = "OutputDirectory";
  
  public static final String PARAM_INPUTDIR = "InputDirectory";
  
//  public static final String VALUE_OF_N = "nValue";
//  
//  String N = (String) getConfigParameterValue(VALUE_OF_N);
//  
//  int n = Integer.parseInt(N);
  
  int n = 1;
  
//  public static final int N_VALUE = Integer.parseInt("valueForN");


  private File mOutputDir;

  private int mDocNum;

  public void initialize() throws ResourceInitializationException {
    mDocNum = 0;
    mOutputDir = new File((String) getConfigParameterValue(PARAM_OUTPUTDIR));
//    mOutputDir = new File("/home/perilon/git/pi3-aewilkin/pi3-aewilkin/src/main/resources/outputData");
    if (!mOutputDir.exists()) {
      mOutputDir.mkdirs();
    }
    
        
  }


  public void processCas(CAS aCAS) throws ResourceProcessException {
    
    String modelFileName = null;

    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    
    String writeToFileName = "";

 // retreive the filename of the input file from the CAS
    FSIterator it = jcas.getAnnotationIndex(SourceDocumentInformation.type).iterator();
    File outFile = null;
    if (it.hasNext()) {
      SourceDocumentInformation fileLoc = (SourceDocumentInformation) it.next();
      File inFile;
      try {
        inFile = new File(new URL(fileLoc.getUri()).getPath());
        String outFileName = inFile.getName();
        if (fileLoc.getOffsetInSource() > 0) {
          outFileName += ("_" + fileLoc.getOffsetInSource());
        }
        
//        We have a name for an output file based on the sample code above, that is based on the input file name.
//        Now we tweak it a bit to conform to requirements.
        
        int len = outFileName.length();
        String temp = 'a' + outFileName.substring(1,len);
        writeToFileName += temp;
        
        outFile = new File(mOutputDir, outFileName);
        modelFileName = mOutputDir.getAbsolutePath() + "/" + inFile.getName() + ".ecore";
      } catch (MalformedURLException e1) {
        // invalid URL, use default processing below
      }
    }
    
    
    if (outFile == null) {
      outFile = new File(mOutputDir, "doc" + mDocNum++);
    }
    
    FSIndex inputDocumentIndex = jcas.getAnnotationIndex(InputDocument.type);
    
    FSIterator inputDocumentIter = inputDocumentIndex.iterator();
    
   
    
    while (inputDocumentIter.hasNext()) {
      
      System.out.println("\n\n\n\n");
                  
      InputDocument inputDocument = new InputDocument(jcas);
      inputDocument = (InputDocument) inputDocumentIter.next();
      
      FSArray unsortedAnswersArray = inputDocument.getAnswersArray();
      int arrayLen = unsortedAnswersArray.size();
      
      System.out.println("arrayLen = " + arrayLen);
      
      FSArray sortedAnswersArray = new FSArray(jcas, arrayLen);

//      A crude way of sorting a list by Answer score.

      int nextIndex = 0;
      int counter = 0;
      
      for (double maxScore = (n+10); maxScore >= 0; maxScore--) {
        for (int i = 0; i < arrayLen; i++) {
          if (((Answer) unsortedAnswersArray.get(i)).getScore() == maxScore) {
            sortedAnswersArray.set(counter, (Answer) unsortedAnswersArray.get(i));
            counter++;
          }
        }
      }
      
//    Count the number of correct sentences in an input document, in order to calculate precision.
      
      int totalNumCorrect = 0;
      
      int sortedAnswersArrayLen = sortedAnswersArray.size();
      
      System.out.println("sortedAnswersArrayLen = " + sortedAnswersArrayLen);
      
      for (int i = 0; i < arrayLen; i++) {
        System.out.println( (((Answer) sortedAnswersArray.get(i)).getSentence()));
        }
      
      System.out.println("arrayLen = " + arrayLen);
      
      for (int i = 0; i < arrayLen; i++) {
        System.out.println("i = " + i);
        if (((Answer) sortedAnswersArray.get(i)).getLabel() == true) {
          totalNumCorrect++;
        }
      }
      
      System.out.println("totalNumCorrect: " + totalNumCorrect);
      
//      Count the number of sentences within the top n sentences, as ranked in the sorted array, that are correct.
      
      int numCorrectAtN = 0;
      
      for (int i = 0; i < totalNumCorrect; i++) {
        if (((Answer) sortedAnswersArray.get(i)).getLabel() == true) {
          numCorrectAtN++;
        }
      }
      
      System.out.println("numCorrectAtN: " + numCorrectAtN);

      
      double precision = (double) numCorrectAtN / (double) totalNumCorrect;
      
      String precisionString = Double.toString(precision);
      
//      Print stuff (?).
      
      System.out.println("Precision is: " + precisionString);
      
      for (int i = 0; i < totalNumCorrect; i++) {
        System.out.println(   (((Answer) sortedAnswersArray.get(i)).getId()) + " " +
                (((Answer) sortedAnswersArray.get(i)).getScore())   );
      }
      
//     String filenameString = "/home/perilon/git/pi3-aewilkin/pi3-aewilkin/src/main/resources/outputData/" + writeToFileName;
          
     String filenameString = (String) getConfigParameterValue(PARAM_OUTPUTDIR) + writeToFileName;

     
     try {
       File file = new File(filenameString);
  
        // if file doesnt exists, then create it
        if (!file.exists()) {
          file.createNewFile();
        }
  
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(precisionString + "\n");
        
        for (int i = 0; i < totalNumCorrect; i++) {
          bw.write(   (((Answer) sortedAnswersArray.get(i)).getId()) + " " + 
        (((Answer) sortedAnswersArray.get(i)).getScore()) + "\n"  );     
        } 
       
        bw.close();
  
        System.out.println("Done");
        }
        catch (IOException e) {
          e.printStackTrace();
        }

      }
    }
  }

