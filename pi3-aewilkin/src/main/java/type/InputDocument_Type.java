
/* First created by JCasGen Mon Sep 21 02:26:32 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** 
 * Updated by JCasGen Mon Sep 21 15:31:31 EDT 2015
 * @generated */
public class InputDocument_Type extends ComponentAnnotation_Type {
  /** @generated 
   * @return the generator for this type
   */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (InputDocument_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = InputDocument_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new InputDocument(addr, InputDocument_Type.this);
  			   InputDocument_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new InputDocument(addr, InputDocument_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = InputDocument.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("type.InputDocument");
 
  /** @generated */
  final Feature casFeat_question;
  /** @generated */
  final int     casFeatCode_question;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getQuestion(int addr) {
        if (featOkTst && casFeat_question == null)
      jcas.throwFeatMissing("question", "type.InputDocument");
    return ll_cas.ll_getRefValue(addr, casFeatCode_question);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setQuestion(int addr, int v) {
        if (featOkTst && casFeat_question == null)
      jcas.throwFeatMissing("question", "type.InputDocument");
    ll_cas.ll_setRefValue(addr, casFeatCode_question, v);}
    
  
 
  /** @generated */
  final Feature casFeat_answersArray;
  /** @generated */
  final int     casFeatCode_answersArray;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getAnswersArray(int addr) {
        if (featOkTst && casFeat_answersArray == null)
      jcas.throwFeatMissing("answersArray", "type.InputDocument");
    return ll_cas.ll_getRefValue(addr, casFeatCode_answersArray);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAnswersArray(int addr, int v) {
        if (featOkTst && casFeat_answersArray == null)
      jcas.throwFeatMissing("answersArray", "type.InputDocument");
    ll_cas.ll_setRefValue(addr, casFeatCode_answersArray, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public int getAnswersArray(int addr, int i) {
        if (featOkTst && casFeat_answersArray == null)
      jcas.throwFeatMissing("answersArray", "type.InputDocument");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answersArray), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_answersArray), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answersArray), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setAnswersArray(int addr, int i, int v) {
        if (featOkTst && casFeat_answersArray == null)
      jcas.throwFeatMissing("answersArray", "type.InputDocument");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answersArray), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_answersArray), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_answersArray), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_answer;
  /** @generated */
  final int     casFeatCode_answer;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getAnswer(int addr) {
        if (featOkTst && casFeat_answer == null)
      jcas.throwFeatMissing("answer", "type.InputDocument");
    return ll_cas.ll_getRefValue(addr, casFeatCode_answer);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAnswer(int addr, int v) {
        if (featOkTst && casFeat_answer == null)
      jcas.throwFeatMissing("answer", "type.InputDocument");
    ll_cas.ll_setRefValue(addr, casFeatCode_answer, v);}
    
  
 
  /** @generated */
  final Feature casFeat_answersList;
  /** @generated */
  final int     casFeatCode_answersList;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getAnswersList(int addr) {
        if (featOkTst && casFeat_answersList == null)
      jcas.throwFeatMissing("answersList", "type.InputDocument");
    return ll_cas.ll_getRefValue(addr, casFeatCode_answersList);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setAnswersList(int addr, int v) {
        if (featOkTst && casFeat_answersList == null)
      jcas.throwFeatMissing("answersList", "type.InputDocument");
    ll_cas.ll_setRefValue(addr, casFeatCode_answersList, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public InputDocument_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_question = jcas.getRequiredFeatureDE(casType, "question", "type.Question", featOkTst);
    casFeatCode_question  = (null == casFeat_question) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_question).getCode();

 
    casFeat_answersArray = jcas.getRequiredFeatureDE(casType, "answersArray", "uima.cas.FSArray", featOkTst);
    casFeatCode_answersArray  = (null == casFeat_answersArray) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_answersArray).getCode();

 
    casFeat_answer = jcas.getRequiredFeatureDE(casType, "answer", "type.Answer", featOkTst);
    casFeatCode_answer  = (null == casFeat_answer) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_answer).getCode();

 
    casFeat_answersList = jcas.getRequiredFeatureDE(casType, "answersList", "uima.cas.FSList", featOkTst);
    casFeatCode_answersList  = (null == casFeat_answersList) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_answersList).getCode();

  }
}



    