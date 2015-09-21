import java.io.IOException;

import org.apache.uima.UIMAFramework;
import org.apache.uima.collection.CollectionProcessingEngine;
import org.apache.uima.collection.metadata.CpeDescription;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.InvalidXMLException;
import org.apache.uima.util.XMLInputSource;

public class Main {

//  /**
//   * This method is the main program and entry point of your system for PI3. It runs a Collection
//   * Processing Engine (CPE).
//   * 
//   * @param args
//   * @throws IOException 
//   * @throws InvalidXMLException 
//   * @throws ResourceInitializationException 
//   */
//  public static void main(String[] args) throws InvalidXMLException, IOException, ResourceInitializationException {
//    // ### A guideline for implementing this method ###
//    // 1. Accept integer n (1, 2, or 3) as a positional argument, specifying the length of n-grams.
//    // 2. Initialize a CPE by loading your CPE descriptor at 'src/main/resources/cpeDescriptor.xml'.
//    // 3. Pass the parameter n to your analysis engine(s) properly.
//    // 4. Run the CPE.
//
//    // Implement your code from here.
//    
//    int n = Integer.parseInt(args[0]);
//    
//    //parse CPE descriptor in file specified on command line
//    CpeDescription cpeDesc = UIMAFramework.getXMLParser().parseCpeDescription(new XMLInputSource(args[0]));
//    
//    //instantiate CPE
//    CollectionProcessingEngine mCPE = UIMAFramework.produceCollectionProcessingEngine(cpeDesc);
//
//    //Create and register a Status Callback Listener
////    mCPE.addStatusCallbackListener(new StatusCallbackListenerImpl());
//
//    //Start Processing
//    mCPE.process();
//
//  }

}
