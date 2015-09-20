import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import type.Answer;
import type.Question;
import type.Token;


public class TokenAnnotator extends JCasAnnotator_ImplBase {
  
  private Pattern mTokenPattern = 
          Pattern.compile("[\\S]+");

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    

    FSIndex answerIndex = aJCas.getAnnotationIndex(Answer.type);
    FSIndex questionIndex = aJCas.getAnnotationIndex(Question.type);

    
    Iterator answerIter = answerIndex.iterator();
    
    while (answerIter.hasNext()) {
      Answer answer = (Answer) answerIter.next();
      
      Matcher matcher = mTokenPattern.matcher(answer.getSentence());
      int pos = 0;
      while (matcher.find(pos)) {
//        System.out.println(matcher);
        Token token = new Token(aJCas);
        token.setBegin(answer.getBegin() + matcher.start());
        token.setEnd(answer.getBegin() + matcher.end());
        token.addToIndexes();
        pos = matcher.end();
      }
    }
    
    Iterator questionIter = questionIndex.iterator();
    
    while (questionIter.hasNext()) {
      Question question = (Question) questionIter.next();
      
      Matcher matcher = mTokenPattern.matcher(question.getSentence());
      int pos = 0;
      while (matcher.find(pos)) {
//        System.out.println(matcher);
        Token token = new Token(aJCas);
        token.setBegin(question.getBegin() + matcher.start());
        token.setEnd(question.getBegin() + matcher.end());
        token.addToIndexes();
        pos = matcher.end();
      }
    }
  }
}

//public void process(JCas aJCas) {
//  
//  String docText = aJCas.getDocumentText(); 
//  
//  Matcher matcher = mAnswerPattern.matcher(docText);
//  int pos = 0;
//  while (matcher.find(pos)) {
//    // match found - create the match as annotation in 
//    // the JCas with some additional meta information
//    Answer annotation = new Answer(aJCas);
//    annotation.setBegin(matcher.start());
//    annotation.setEnd(matcher.end());
//    
//    if (matcher.group(2).equals("0")) {
//      annotation.setLabel(false);
//    } else if (matcher.group(2).equals("1")) {
//      annotation.setLabel(true);
//    }
//    
//    annotation.setId(matcher.group(1));
//    
//    annotation.setSentence(matcher.group(3));
//    
//    
//    annotation.addToIndexes();
//    pos = matcher.end();
//  }
//    
//}



//public void process(JCas aJCas) {
//  // get annotation indexes
//  FSIndex roomNumberIndex = aJCas.getAnnotationIndex(RoomNumber.type);
//  FSIndex dateIndex = aJCas.getAnnotationIndex(DateAnnot.type);
//  FSIndex timeIndex = aJCas.getAnnotationIndex(TimeAnnot.type);
//
//  // store end position of last meeting we identified, to prevent multiple
//  // annotations over same span
//  int lastMeetingEnd = -1;
//
//  // iterate over all combinations
//  Iterator roomNumberIter = roomNumberIndex.iterator();
//  while (roomNumberIter.hasNext()) {
//    RoomNumber room = (RoomNumber) roomNumberIter.next();
//
//    Iterator dateIter = dateIndex.iterator();
//    while (dateIter.hasNext()) {
//      DateAnnot date = (DateAnnot) dateIter.next();
//
//      Iterator time1Iter = timeIndex.iterator();
//      while (time1Iter.hasNext()) {
//        TimeAnnot time1 = (TimeAnnot) time1Iter.next();
//
//        Iterator time2Iter = timeIndex.iterator();
//        while (time2Iter.hasNext()) {
//          TimeAnnot time2 = (TimeAnnot) time2Iter.next();
//
//          // times must be different annotations
//          if (time1 != time2) {
//            // compute the begin and end of the span
//            int minBegin = Math.min(Math.min(time1.getBegin(), time2.getBegin()), Math.min(date
//                    .getBegin(), room.getBegin()));
//            int maxEnd = Math.max(Math.max(time1.getEnd(), time2.getEnd()), Math.max(date
//                    .getEnd(), room.getEnd()));