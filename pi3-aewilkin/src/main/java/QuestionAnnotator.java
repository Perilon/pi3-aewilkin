import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import type.Question;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionAnnotator extends JCasAnnotator_ImplBase {

  private Pattern mQuestionPattern = 
//          Pattern.compile("Q (.*)");
//  Pattern.compile("(A[0-9]+) ([0-1])([ \t]+)(.*).");
          Pattern.compile("(Q)([ \t]+)(.*)\\?");

  
  public void process(JCas aJCas) {
    
    String docText = aJCas.getDocumentText(); 
    
    Matcher matcher = mQuestionPattern.matcher(docText);
    int pos = 0;
    while (matcher.find(pos)) {
      // match found - create the match as annotation in 
      // the JCas with some additional meta information
      Question annotation = new Question(aJCas);
      annotation.setBegin(matcher.start(3));
      annotation.setEnd(matcher.end(3));
      annotation.setSentence(matcher.group(3));
      annotation.addToIndexes();
      pos = matcher.end();
    }
      
  }

}