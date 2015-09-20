package type;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TokenAnnotator extends JCasAnnotator_ImplBase {

  private Pattern tokenPattern = Pattern.compile("[\\w]*");
  
  public void process(JCas aJCas) {
    
    String docText = aJCas.getDocumentText();
    
    Matcher matcher = tokenPattern.matcher(docText);
    int position = 0;
    while (matcher.find(position)) {
      
      Token annotation = new Token(aJCas);
      annotation.setBegin(matcher.start());
      annotation.setEnd(matcher.end());
      annotation.addToIndexes();
      position = matcher.end();      
    }
  
  }

}