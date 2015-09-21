

/* First created by JCasGen Mon Sep 21 02:26:32 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;


import org.apache.uima.jcas.cas.FSList;


/** 
 * Updated by JCasGen Mon Sep 21 15:31:31 EDT 2015
 * XML source: /home/perilon/git/pi3-aewilkin/pi3-aewilkin/desc/CasConsumerDescriptor.xml
 * @generated */
public class InputDocument extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(InputDocument.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected InputDocument() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public InputDocument(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public InputDocument(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public InputDocument(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: question

  /** getter for question - gets 
   * @generated
   * @return value of the feature 
   */
  public Question getQuestion() {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_question == null)
      jcasType.jcas.throwFeatMissing("question", "type.InputDocument");
    return (Question)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_question)));}
    
  /** setter for question - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setQuestion(Question v) {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_question == null)
      jcasType.jcas.throwFeatMissing("question", "type.InputDocument");
    jcasType.ll_cas.ll_setRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_question, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: answersArray

  /** getter for answersArray - gets 
   * @generated
   * @return value of the feature 
   */
  public FSArray getAnswersArray() {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_answersArray == null)
      jcasType.jcas.throwFeatMissing("answersArray", "type.InputDocument");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_answersArray)));}
    
  /** setter for answersArray - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setAnswersArray(FSArray v) {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_answersArray == null)
      jcasType.jcas.throwFeatMissing("answersArray", "type.InputDocument");
    jcasType.ll_cas.ll_setRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_answersArray, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for answersArray - gets an indexed value - 
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public Answer getAnswersArray(int i) {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_answersArray == null)
      jcasType.jcas.throwFeatMissing("answersArray", "type.InputDocument");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_answersArray), i);
    return (Answer)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_answersArray), i)));}

  /** indexed setter for answersArray - sets an indexed value - 
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setAnswersArray(int i, Answer v) { 
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_answersArray == null)
      jcasType.jcas.throwFeatMissing("answersArray", "type.InputDocument");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_answersArray), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_answersArray), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: answer

  /** getter for answer - gets 
   * @generated
   * @return value of the feature 
   */
  public Answer getAnswer() {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_answer == null)
      jcasType.jcas.throwFeatMissing("answer", "type.InputDocument");
    return (Answer)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_answer)));}
    
  /** setter for answer - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setAnswer(Answer v) {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_answer == null)
      jcasType.jcas.throwFeatMissing("answer", "type.InputDocument");
    jcasType.ll_cas.ll_setRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_answer, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: answersList

  /** getter for answersList - gets 
   * @generated
   * @return value of the feature 
   */
  public FSList getAnswersList() {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_answersList == null)
      jcasType.jcas.throwFeatMissing("answersList", "type.InputDocument");
    return (FSList)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_answersList)));}
    
  /** setter for answersList - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setAnswersList(FSList v) {
    if (InputDocument_Type.featOkTst && ((InputDocument_Type)jcasType).casFeat_answersList == null)
      jcasType.jcas.throwFeatMissing("answersList", "type.InputDocument");
    jcasType.ll_cas.ll_setRefValue(addr, ((InputDocument_Type)jcasType).casFeatCode_answersList, jcasType.ll_cas.ll_getFSRef(v));}    
  }

    