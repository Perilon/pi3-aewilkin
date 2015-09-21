import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.fit.util.JCasUtil;

import type.Answer;
import type.Question;
import type.Token;
import type.Ngram;
import type.InputDocument;

public class InputDocumentAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    
    FSIndex answerIndex = aJCas.getAnnotationIndex(Answer.type);
    FSIndex questionIndex = aJCas.getAnnotationIndex(Question.type);
    FSIndex tokenIndex = aJCas.getAnnotationIndex(Token.type);
    FSIndex ngramIndex = aJCas.getAnnotationIndex(Ngram.type);
    FSIndex inputDocumentIndex = aJCas.getAnnotationIndex(InputDocument.type);
    
    Iterator answerIter0 = answerIndex.iterator();
    
//    Find the total number of answers in order to initialize the FSArray of answers
    
    int numAnswers = 0;
    
    while (answerIter0.hasNext()) {
      Answer ans = (Answer) answerIter0.next();
      numAnswers++;
    }
    
    FSArray answersArray = new FSArray(aJCas, numAnswers);
    
    
    InputDocument inputDocument = new InputDocument(aJCas);
    

//    Get the question as an iterator in order to then loop through the answers to compare their ngram contents with those of the question.
    
    Iterator questionIter = questionIndex.iterator();
        
    while (questionIter.hasNext()) {
      
      Question question = new Question(aJCas);
      
      question = (Question) questionIter.next();
      int beginQuestion = question.getBegin();
      int endQuestion = question.getEnd();
      
      question.setBegin(beginQuestion);
      question.setEnd(endQuestion);
      question.addToIndexes();
      
      List<Ngram> ngramQuestionList = JCasUtil.selectCovered(aJCas, Ngram.class, beginQuestion - 1, endQuestion);
      
      int questionListLen = ngramQuestionList.size();
      
      FSArray ngramQuestionArray = new FSArray(aJCas, questionListLen);
       
//      Establish an array of the ngram annotations.
      
      for (int i = 0; i < questionListLen; i++) {
          ngramQuestionArray.set(i, ngramQuestionList.get(i));
      }
      
//      Establish an array of the string values of the ngrams with which to compare the string values of the ngrams of the answers.
      
      String[] ngramQuestionArrayToString = new String[questionListLen];
      
      for (int i = 0; i < questionListLen; i++) {
        ngramQuestionArrayToString[i] = ngramQuestionList.get(i).getToStringValue();
      }

      
      
      Iterator answerIter = answerIndex.iterator();
      
      int answerNum = 0;
      
      while (answerIter.hasNext()) {
        
        answerNum++;
        
        Answer answer = new Answer(aJCas);
        
        answer = (Answer) answerIter.next();
        int beginAnswer = answer.getBegin();
        int endAnswer = answer.getEnd();
        
        List<Ngram> ngramAnswerList = JCasUtil.selectCovered(aJCas, Ngram.class, beginAnswer - 1, endAnswer);
        
        int answerListLen = ngramAnswerList.size();
        
        FSArray ngramAnswerArray = new FSArray(aJCas, answerListLen);
         
        for (int i = 0; i < answerListLen; i++) {
            ngramAnswerArray.set(i, ngramAnswerList.get(i));
        }
        
        String[] ngramAnswerArrayToString = new String[answerListLen];
        
        for (int i = 0; i < answerListLen; i++) {
          ngramAnswerArrayToString[i] = ngramAnswerList.get(i).getToStringValue();
        }
        
//        Count how many matches there are between the ngrams of the answer and the ngrams of the question.
          
        int matchesCounter = 0;
        
        for (int i = 0; i < ngramAnswerArrayToString.length; i++) {
          for (int j = 0; j < ngramQuestionArrayToString.length; j++) {
            if (ngramAnswerArrayToString[i].equals(ngramQuestionArrayToString[j])) {
              matchesCounter++;
            }
          }
        }
        
        answer.setScore(matchesCounter);
        
        answersArray.set(answerNum-1, answer);
        
        inputDocument.setAnswer(answer);
        inputDocument.setAnswersArray(answersArray);
        inputDocument.setQuestion(question);;
        
        inputDocument.addToIndexes();

        
      }
      
      
    }
  }

}
