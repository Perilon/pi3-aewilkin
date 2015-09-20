import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import type.Token;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenAnnotator extends JCasAnnotator_ImplBase {
  
  private Pattern mtokenPattern = 
          Pattern.compile("[\\w]");
  
  public void process(JCas aJCas) {
    
    String docText = aJCas.getDocumentText(); 
    
    Matcher matcher = mtokenPattern.matcher(docText);
    int pos = 0;
    while (matcher.find(pos)) {
      // match found - create the match as annotation in 
      // the JCas with some additional meta information
      Token annotation = new Token(aJCas);
      annotation.setBegin(matcher.start());
      annotation.setEnd(matcher.end());
      annotation.addToIndexes();
      pos = matcher.end();
    }
      
  }

}