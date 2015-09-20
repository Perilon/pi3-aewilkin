import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import type.Answer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnswerAnnotator extends JCasAnnotator_ImplBase {

  private Pattern mAnswerPattern = 
          Pattern.compile("(A[0-9]+) ([0-1]) (.*).");
  
  public void process(JCas aJCas) {
    
    String docText = aJCas.getDocumentText(); 
    
    Matcher matcher = mAnswerPattern.matcher(docText);
    int pos = 0;
    while (matcher.find(pos)) {
      // match found - create the match as annotation in 
      // the JCas with some additional meta information
      Answer annotation = new Answer(aJCas);
      annotation.setBegin(matcher.start());
      annotation.setEnd(matcher.end());
      
      if (matcher.group(2).equals("0")) {
        annotation.setLabel(false);
      } else if (matcher.group(2).equals("1")) {
        annotation.setLabel(true);
      }
      
      annotation.setId(matcher.group(1));
      
      annotation.setSentence(matcher.group(3));
      
      
      annotation.addToIndexes();
      pos = matcher.end();
    }
      
  }

}