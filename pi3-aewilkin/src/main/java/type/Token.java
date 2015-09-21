

/* First created by JCasGen Sun Sep 20 00:30:07 EDT 2015 */
package type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;



/** Stores a token annotation.
 * Updated by JCasGen Mon Sep 21 04:02:53 EDT 2015
 * XML source: /home/perilon/git/pi3-aewilkin/pi3-aewilkin/src/main/resources/typeSystem.xml
 * @generated */
public class Token extends ComponentAnnotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Token.class);
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
  protected Token() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Token(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Token(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Token(JCas jcas, int begin, int end) {
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
  //* Feature: toStringValue

  /** getter for toStringValue - gets the token as a string
   * @generated
   * @return value of the feature 
   */
  public String getToStringValue() {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_toStringValue == null)
      jcasType.jcas.throwFeatMissing("toStringValue", "type.Token");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Token_Type)jcasType).casFeatCode_toStringValue);}
    
  /** setter for toStringValue - sets the token as a string 
   * @generated
   * @param v value to set into the feature 
   */
  public void setToStringValue(String v) {
    if (Token_Type.featOkTst && ((Token_Type)jcasType).casFeat_toStringValue == null)
      jcasType.jcas.throwFeatMissing("toStringValue", "type.Token");
    jcasType.ll_cas.ll_setStringValue(addr, ((Token_Type)jcasType).casFeatCode_toStringValue, v);}    
  }

    